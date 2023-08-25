package school.sptech.hexagonalarch.adapters.in;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.hexagonalarch.adapters.in.mapper.BookMapper;
import school.sptech.hexagonalarch.adapters.in.request.BookRequest;
import school.sptech.hexagonalarch.adapters.in.response.BookResponse;
import school.sptech.hexagonalarch.application.core.domain.Book;
import school.sptech.hexagonalarch.application.core.ports.in.CreateBookInputPort;

@RestController
@RequestMapping("/library/books")
public class BookController {

    private final BookMapper bookMapper;

    private final CreateBookInputPort createBookInputPort;

    public BookController(BookMapper bookMapper, CreateBookInputPort createBookInputPort) {
        this.bookMapper = bookMapper;
        this.createBookInputPort = createBookInputPort;
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest bookRequest) {

        Book domain = bookMapper.toDomain(bookRequest);

        Book bookSaved = createBookInputPort.execute(domain);

        BookResponse response = bookMapper.toResponse(bookSaved);

        return ResponseEntity.ok(response);
    }
}
