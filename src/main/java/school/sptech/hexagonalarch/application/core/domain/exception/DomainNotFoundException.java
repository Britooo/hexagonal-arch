package school.sptech.hexagonalarch.application.core.domain.exception;

public class DomainNotFoundException  extends RuntimeException {
    public DomainNotFoundException(String message) {
        super(message);
    }
}
