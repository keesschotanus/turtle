/*
 * Copyright (�) 2000 C. Schotanus
 * Kees Schotanus
 * Jan Steenlaan 9
 * 3931 LA  Woudenberg
 * kees.schotanus@tip.nl
 */

package com.schotanus.turtle.parser;


/**
 * Interpretation Exception.
 * <br>A program that has been parsed successfully can throw this exception to
 * indicate an error condition during interpretation of the Turtle code. Using
 * a parameter that does not exist and dividing by zero are examples of when
 * this exception can be thrown.
 * @author Kees Schotanus
 * @version 1.0
 */
public class InterpretationException extends Exception {

    /**
     * Constructs a Turtle language interpretation exception using the supplied
     * message.
     * @param message Message clarifying why the interpretation exception
     *  occurred.
     */
    public InterpretationException(final String message) {
        super(message);
    }

}