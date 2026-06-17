package robertovisconti.exceptions;

public class NotFoundByIdException extends RuntimeException {
    public NotFoundByIdException(Long id) {
        super("Il record con id " + id + " non è stato trovato.");
    }
}
