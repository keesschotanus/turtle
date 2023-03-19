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
     * The key is the name of the parameter (stored in lower case).
     * The value is the value of the parameter.
     */
    private Hashtable<String, Object> parameterValues;

    /**
     * Constructs a function call.
     * @param function {@link #function}.
     * @param parameterValues #parameterValues}.
     */
    public FunctionCall(
            final NodeFunctionDeclaration function,
            final Hashtable<String, Object> parameterValues) {
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
        final Double value = (Double)parameterValues.get(parameterName.toLowerCase());
        if (value == null) {
            throw new InterpretationException("Parameter: " + parameterName
                + " does not exist in function:" + function.getName());
        }

        return value;
    }

}