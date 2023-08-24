package school.sptech.hexagonalarch.adapters.out;

import school.sptech.hexagonalarch.adapters.out.repository.BookRepository;
import school.sptech.hexagonalarch.adapters.out.repository.entity.BookEntity;
import school.sptech.hexagonalarch.adapters.out.repository.mapper.BookEntityMapper;
import school.sptech.hexagonalarch.application.core.domain.Book;
import school.sptech.hexagonalarch.application.core.ports.out.SaveBookOutputPort;

public class CreateBookAdapter implements SaveBookOutputPort {

    private final BookRepository bookRepository;

    private final BookEntityMapper bookEntityMapper;

    public CreateBookAdapter(BookRepository bookRepository, BookEntityMapper bookEntityMapper) {
        this.bookRepository = bookRepository;
        this.bookEntityMapper = bookEntityMapper;
    }

    @Override
    public Book execute(Book book) {
        BookEntity entity = this.bookEntityMapper.toEntity(book);
        BookEntity save = this.bookRepository.save(entity);
        return bookEntityMapper.toDomain(save);
    }
}
