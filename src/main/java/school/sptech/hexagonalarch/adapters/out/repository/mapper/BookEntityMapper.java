package school.sptech.hexagonalarch.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import school.sptech.hexagonalarch.adapters.out.repository.entity.BookEntity;
import school.sptech.hexagonalarch.application.core.domain.book.Book;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {

    BookEntity toEntity(Book book);
    
    Book toDomain(BookEntity bookEntity);
}
