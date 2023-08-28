package school.sptech.hexagonalarch.adapters.out;

import org.springframework.stereotype.Component;

import school.sptech.hexagonalarch.adapters.out.repository.BookRepository;
import school.sptech.hexagonalarch.adapters.out.repository.entity.BookEntity;
import school.sptech.hexagonalarch.adapters.out.repository.mapper.BookEntityMapper;
import school.sptech.hexagonalarch.application.core.domain.book.Book;
import school.sptech.hexagonalarch.application.core.domain.exception.DomainNotFoundException;
import school.sptech.hexagonalarch.application.core.ports.out.FindBookByIdOutputPort;

@Component
public class SearchBookByIdAdapter implements FindBookByIdOutputPort {

    private final BookRepository bookRepository;
    private final BookEntityMapper bookEntityMapper;

    public SearchBookByIdAdapter(BookRepository bookRepository, BookEntityMapper bookEntityMapper) {
        this.bookRepository = bookRepository;
        this.bookEntityMapper = bookEntityMapper;
    }

    @Override
    public Book execute(Long id) {
        BookEntity bookEntity = this.bookRepository.findById(id)
                .orElseThrow(
                        () -> new DomainNotFoundException("Book not found"));
        return this.bookEntityMapper.toDomain(bookEntity);
    }
}
