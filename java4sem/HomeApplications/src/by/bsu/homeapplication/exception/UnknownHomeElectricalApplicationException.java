package by.bsu.homeapplication.exception;

public class UnknownHomeElectricalApplicationException extends Exception{
    public UnknownHomeElectricalApplicationException() {
    }

    public UnknownHomeElectricalApplicationException(String message) {
        super(message);
    }

    public UnknownHomeElectricalApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownHomeElectricalApplicationException(Throwable cause) {
        super(cause);
    }

    public UnknownHomeElectricalApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
