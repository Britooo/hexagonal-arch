package school.sptech.hexagonalarch.adapters.in.mapper;

import org.mapstruct.Mapper;
import school.sptech.hexagonalarch.adapters.in.request.BookRequest;
import school.sptech.hexagonalarch.adapters.in.response.BookResponse;
import school.sptech.hexagonalarch.application.core.domain.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toDomain(BookRequest bookRequest);

    BookResponse toResponse(Book book);
}
