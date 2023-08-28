package school.sptech.hexagonalarch.application.core.ports.in;

import school.sptech.hexagonalarch.application.core.domain.book.Book;

public interface SearchBookByIdInputPort {

    Book execute(Long id);
}
