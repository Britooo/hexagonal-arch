package school.sptech.hexagonalarch.application.core.ports.in;

import school.sptech.hexagonalarch.application.core.domain.book.Book;

public interface CreateBookInputPort {

    Book execute(Book book);
}
