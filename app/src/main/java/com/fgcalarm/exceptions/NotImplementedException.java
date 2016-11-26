package com.fgcalarm.exceptions;

/**
 * Created by Biel on 25/11/2016.
 */

public class NotImplementedException extends UnsupportedOperationException {

    public NotImplementedException() {
    }

    public NotImplementedException(String message) {
        super(message);
    }

    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotImplementedException(Throwable cause) {
        super(cause);
    }
}
