/*
 * Copyright (�) 2000 C. Schotanus
 * Kees Schotanus
 * Jan Steenlaan 9
 * 3931 LA  Woudenberg
 * kees.schotanus@tip.nl
 */

package com.schotanus.turtle.parser;

import java.util.Hashtable;


/**
 * Abstraction of a Turtle function call.
 * @author Kees Schotanus
 * @version 1.0
 */
public class FunctionCall {


    /**
     * Reference to the original function declaration.
     */
    private NodeFunctionDeclaration function;

    /**
     * Actual arguments to the function call.
     * <br>hashkey = parameter name (stored in lower case).
     * hashvalue = parameter value.
     */
    private Hashtable parameterValues;

    /**
     * Constructs a function call.
     * @param function {@link #function}.
     * @param parameterValues #parameterValues}.
     */
    public FunctionCall(
            final NodeFunctionDeclaration function,
            final Hashtable parameterValues) {
        this.function = function;
        this.parameterValues = parameterValues;
    }

    /**
     * Gets the value corresponding to the supplied parameter.
     * @param parameterName Name of the parameter for which the value should be
     *  fetched.
     * @return value belonging to the supplied parameter name.
     * @throws InterpretationException When the supplied parameter name is not
     *  a parameter of this function.
     */
    public Object getParameterValue(final String parameterName)
            throws InterpretationException {
        Double value = (Double)parameterValues.get(parameterName.toLowerCase());
        if (value == null) {
            throw new InterpretationException("Parameter: " + parameterName
                + " does not exist in function:" + function.getName());
        }

        return value;
    }

}