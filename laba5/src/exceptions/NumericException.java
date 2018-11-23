package exceptions;

/**
 * @author MariaDron
 */
public class NumericException extends Exception {
    private static final long serialVersionUID = -897856973823710492L;

    public NumericException() {
        super();
    }

    public NumericException(String message) {
        super(message);
    }
}