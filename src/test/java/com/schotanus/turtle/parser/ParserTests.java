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
        TurtleParser turtleParser;
        SimpleNode node;
        try {
            turtleParser = new TurtleParser(new StringReader("forward 10"));
            node = TurtleParser.parseUnit();
            node.dump("");
        } catch (ParseException exception) {
            throw new RuntimeException();
        }

        try {
            node.interpret();
        } catch (InterpretationException interpretationException) {
            throw new RuntimeException();
        }

    }

}