/* Generated By:JJTree: Do not edit this line. NodeParseUnit.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

import java.util.HashMap;


public class NodeParseUnit extends SimpleNode {
  public NodeParseUnit(int id) {
    super(id);
  }

  public NodeParseUnit(TurtleParser p, int id) {
    super(p, id);
  }

  public void interpret() throws InterpretationException {
    NodeFunctionDeclaration function = new NodeFunctionDeclaration(-1);
    function.setName("_DEFAULT");
    functionCallStack.push(new FunctionCall(function, new HashMap<>()));

    // Loop over all statements
    for (int i = 0; i < jjtGetNumChildren(); i++) {
      jjtGetChild(i).interpret();
    }

    functionCallStack.pop();
  }
}
/* JavaCC - OriginalChecksum=6f60f87c54d6b318caa4cd5cbec1aef7 (do not edit this line) */
