package school.sptech.hexagonalarch.application.core.usecase;

import school.sptech.hexagonalarch.application.core.domain.book.Book;
import school.sptech.hexagonalarch.application.core.ports.in.SearchBookByIdInputPort;
import school.sptech.hexagonalarch.application.core.ports.out.FindBookByIdOutputPort;

public class SearchBookByIdUseCase implements SearchBookByIdInputPort {

    private final FindBookByIdOutputPort findBookByIdOutputPort;

    public SearchBookByIdUseCase(FindBookByIdOutputPort findBookByIdOutputPort) {
        this.findBookByIdOutputPort = findBookByIdOutputPort;
    }

    @Override
    public Book execute(Long id) {
        Book book = this.findBookByIdOutputPort.execute(id);
        return book;
    }
}
