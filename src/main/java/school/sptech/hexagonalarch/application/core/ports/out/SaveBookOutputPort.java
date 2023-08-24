package school.sptech.hexagonalarch.application.core.ports.out;

import school.sptech.hexagonalarch.application.core.domain.Book;

public interface SaveBookOutputPort {

    // Implementado por CreateBookAdapter
    Book execute(Book book);
}
