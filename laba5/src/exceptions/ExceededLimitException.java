package exceptions;

/**
 * @author MariaDron
 */
public class ExceededLimitException extends Exception {
    private static final long serialVersionUID = -897856973823710492L;

    public ExceededLimitException() {
        super();
    }

    public ExceededLimitException(String message) {
        super(message);
    }
}