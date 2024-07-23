package projectTicTacToe.exception;

public class InvalidSymbolSetUpException  extends  RuntimeException{
    public InvalidSymbolSetUpException() {
    }

    public InvalidSymbolSetUpException(String message) {
        super(message);
    }

    public InvalidSymbolSetUpException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSymbolSetUpException(Throwable cause) {
        super(cause);
    }

    public InvalidSymbolSetUpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
