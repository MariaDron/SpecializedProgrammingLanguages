package exceptions;

/**
 * @author MariaDron
 */
public class NonNumberException extends Exception {
    private static final long serialVersionUID = -897856973823710492L;

    public NonNumberException() {
        super();
    }

    public NonNumberException(String message) {
        super(message);
    }
}
