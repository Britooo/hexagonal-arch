package school.sptech.hexagonalarch.application.core.ports.out;

import school.sptech.hexagonalarch.application.core.domain.book.Book;

public interface SaveBookOutputPort {

    Book execute(Book book);
}
