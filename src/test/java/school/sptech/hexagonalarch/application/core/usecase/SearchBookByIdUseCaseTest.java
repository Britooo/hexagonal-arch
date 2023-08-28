package school.sptech.hexagonalarch.application.core.usecase;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import school.sptech.hexagonalarch.application.core.domain.book.Book;
import school.sptech.hexagonalarch.application.core.domain.exception.DomainNotFoundException;
import school.sptech.hexagonalarch.application.core.ports.out.FindBookByIdOutputPort;

@ExtendWith(MockitoExtension.class)
public class SearchBookByIdUseCaseTest {

    @Mock
    private FindBookByIdOutputPort findBookByIdOutputPort;

    @Test
    public void testSearchBookById() {

        Book book = new Book();

        // when
        Mockito.when(findBookByIdOutputPort.execute(1L)).thenReturn(book);

        // then
        SearchBookByIdUseCase searchBookByIdUseCase = new SearchBookByIdUseCase(findBookByIdOutputPort);
        Book result = searchBookByIdUseCase.execute(1L);

        // assert
        Mockito.verify(findBookByIdOutputPort, Mockito.times(1)).execute(1L);
        assertNotNull(result);
    }

    /*
     * Crie um cenário de teste para quando o livro não for encontrado.
     * É esperado que uma exceção do tipo DomainNotFoundException seja lançada.
     * Mock o método execute do FindBookByIdOutputPort para lançar a exceção.
     * Teste a quantidade de vezes que o método execute foi chamado.
     */
    @Test
    public void testSearchBookByIdNotFound() {

        // when
        Mockito.when(findBookByIdOutputPort.execute(1L)).thenThrow(DomainNotFoundException.class);

        // then
        SearchBookByIdUseCase searchBookByIdUseCase = new SearchBookByIdUseCase(findBookByIdOutputPort);

        // assert
        assertThrows(DomainNotFoundException.class, () -> {
            searchBookByIdUseCase.execute(1L);
        });
        Mockito.verify(findBookByIdOutputPort, Mockito.times(1)).execute(1L);
    }
    
}
