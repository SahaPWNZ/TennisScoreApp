package com.sahapwnz.tennisscoreapp.exceptions;

import static jakarta.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

public class DataBaseException extends CastomException {
    public DataBaseException(String message) {
        super(message, SC_INTERNAL_SERVER_ERROR);
    }
}