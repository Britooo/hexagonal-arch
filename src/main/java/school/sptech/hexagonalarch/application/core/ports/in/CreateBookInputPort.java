package school.sptech.hexagonalarch.application.core.ports.in;

import school.sptech.hexagonalarch.application.core.domain.Book;

public interface CreateBookInputPort {

    // Implementado por UseCase
    Book execute(Book book);
}
