package school.sptech.hexagonalarch.adapters.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import school.sptech.hexagonalarch.adapters.in.mapper.BookMapper;
import school.sptech.hexagonalarch.adapters.in.request.BookRequest;
import school.sptech.hexagonalarch.adapters.in.response.BookResponse;
import school.sptech.hexagonalarch.application.core.domain.book.Book;
import school.sptech.hexagonalarch.application.core.ports.in.CreateBookInputPort;
import school.sptech.hexagonalarch.application.core.ports.in.SearchBookByIdInputPort;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library/books")
public class BookController {

    private final BookMapper bookMapper;

    private final CreateBookInputPort createBookInputPort;

    private final SearchBookByIdInputPort searchBookByIdInputPort;

    @Operation(description = "Create a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book created"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
    })
    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest bookRequest) {

        Book domain = bookMapper.toDomain(bookRequest);

        Book bookSaved = createBookInputPort.execute(domain);

        BookResponse response = bookMapper.toResponse(bookSaved);

        return ResponseEntity.ok(response);
    }

    /*
     * GET /library/books/{id}
     * - Retrieves a book by id
     * - Expects a path variable with the book id
     */
    @Operation(description = "Get a book by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book found"),
            @ApiResponse(responseCode = "404", description = "Book not found"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Long id) {

        Book book = searchBookByIdInputPort.execute(id);

        BookResponse response = bookMapper.toResponse(book);

        return ResponseEntity.ok(response);
    }
}
