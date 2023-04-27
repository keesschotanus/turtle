package com.schotanus.turtle.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

public class ParserTests {

    /**
     * Parses a simple Turtle statement.
     */
    @Test
    void parseSimpleForwardStatement() {
        SimpleNode node;
        try {
            new TurtleParser(new StringReader("forward 10"));
            node = TurtleParser.parseUnit();
        } catch (ParseException exception) {
            throw new RuntimeException();
        }

        try {
            node.interpret();
            assertEquals("ParseUnitStatementBackOrForwardStatementUnaryExpressionConstant", nodeToString(node));
        } catch (InterpretationException interpretationException) {
            throw new RuntimeException();
        }

    }

    /**
     * Convert a node to a String.
     * @param node The node to convert.
     * @return String representation of the supplied node.
     */
    String nodeToString(SimpleNode node) {
        StringBuilder result = new StringBuilder(node.toString());
        final Node [] childNodes = node.children;
        if (childNodes != null) {
            for (int i = 0; i < childNodes.length; ++i) {
              SimpleNode childNode = (SimpleNode)childNodes[i];
              if (childNode != null) {
                result.append(this.nodeToString(childNode));
              }
            }
          }

        return result.toString();
    }
}