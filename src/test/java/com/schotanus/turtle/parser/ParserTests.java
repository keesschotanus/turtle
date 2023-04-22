package com.schotanus.turtle.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

public class ParserTests {

    @Test
    void parseSimpleForwardStatement() {
        final StringReader stringReader = new StringReader("forward 10");
        TurtleParser turtleParser;
        SimpleNode node;
        try {
            turtleParser = new TurtleParser(stringReader);
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