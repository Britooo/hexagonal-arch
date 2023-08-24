package school.sptech.hexagonalarch.adapters.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.hexagonalarch.adapters.in.request.BookRequest;
import school.sptech.hexagonalarch.adapters.in.response.BookResponse;
import school.sptech.hexagonalarch.application.core.ports.in.CreateBookInputPort;

@RestController
@RequestMapping("/library/book")
public class BookController {

    private final CreateBookInputPort createBookInputPort;

    public BookController(CreateBookInputPort createBookInputPort) {
        this.createBookInputPort = createBookInputPort;
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(BookRequest bookRequest) {
        return ResponseEntity.ok().build();
    }
}
