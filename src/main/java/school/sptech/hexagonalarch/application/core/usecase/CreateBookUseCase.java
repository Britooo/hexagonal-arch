package school.sptech.hexagonalarch.application.core.usecase;

import school.sptech.hexagonalarch.application.core.domain.book.Book;
import school.sptech.hexagonalarch.application.core.ports.in.CreateBookInputPort;
import school.sptech.hexagonalarch.application.core.ports.out.SaveBookOutputPort;

public class CreateBookUseCase implements CreateBookInputPort {

    private final SaveBookOutputPort saveBookOutputPort;

    public CreateBookUseCase(SaveBookOutputPort saveBookOutputPort) {
        this.saveBookOutputPort = saveBookOutputPort;
    }

    @Override
    public Book execute(Book book) {
        return this.saveBookOutputPort.execute(book);
    }
}
