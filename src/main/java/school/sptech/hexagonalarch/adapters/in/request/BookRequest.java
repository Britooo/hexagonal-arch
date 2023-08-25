package school.sptech.hexagonalarch.adapters.in.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class BookRequest {

    @NotBlank String name;
    @PastOrPresent LocalDate releaseDate;
    @NotBlank String isbn;
}
