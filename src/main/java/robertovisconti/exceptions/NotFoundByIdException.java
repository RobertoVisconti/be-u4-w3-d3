package robertovisconti.exceptions;

public class NotFoundByIdException extends RuntimeException {
    public NotFoundByIdException(String id) {
        super("Il record con id: " + id + " non è stato trovato.");
    }
}
