package com.schotanus.turtle.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

class ParserTests {

    /**
     * Parses a forward statement.
     */
    @Test
    void parseForwardStatement() {
        String code = "forward 10";
        assertEquals(
            "ParseUnitStatementBackOrForwardStatementUnaryExpressionConstant",
            parse(code),
            ParserTests.getParseErrorMessage(code));

        code = "forward 10 + 20";
        assertEquals(
            "ParseUnitStatementBackOrForwardStatementAddExpressionUnaryExpressionConstantUnaryExpressionConstant",
            parse(code),
            ParserTests.getParseErrorMessage(code));
    }

    /**
     * Parses the supplied code.
     * @param code The code to parse.
     * @return A string representation of the parsed code
     *  or null incase the code could not be parsed or interpreted.
     */
    private String parse(final String code) {
        
        try {
            TurtleParser.ReInit(new StringReader(code));
            final SimpleNode node = TurtleParser.parseUnit();
            node.interpret();
            return ParserTests.nodeToString(node);
        } catch (final ParseException exception) {
            fail("Could not parse: " + code, exception);
        } catch (final InterpretationException exception) {
            fail("Could not interpret: " + code, exception);
        }

        return null;
    }

    /**
     * Convert a node to a String.
     * @param node The node to convert.
     * @return String representation of the supplied node.
     */
    private static String nodeToString(SimpleNode node) {
        StringBuilder result = new StringBuilder(node.toString());
        final Node [] childNodes = node.children;
        if (childNodes != null) {
            for (int i = 0; i < childNodes.length; ++i) {
              SimpleNode childNode = (SimpleNode)childNodes[i];
              if (childNode != null) {
                result.append(ParserTests.nodeToString(childNode));
              }
            }
          }

        return result.toString();
    }

    /**
     * Creates a parse error messages from the supplied code.
     * @param code The code that could not be parsed
     * @return A parse error message.
     */
    private static String getParseErrorMessage(String code) {
        return null;
    }
}