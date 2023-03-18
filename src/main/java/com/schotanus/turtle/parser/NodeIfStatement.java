/* Generated By:JJTree: Do not edit this line. NodeIfStatement.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeIfStatement extends SimpleNode {
  public NodeIfStatement(int id) {
    super(id);
  }

  public NodeIfStatement(TurtleParser p, int id) {
    super(p, id);
  }

  public void interpret() throws InterpretationException{
    jjtGetChild(0).interpret();
    boolean result = ((Boolean)expressionStack.pop()).booleanValue();

    if (result == true) {
      jjtGetChild(1).interpret();
    } else {
      // Check for optional else statement block
      if (jjtGetNumChildren() == 3) {
          jjtGetChild(2).interpret();
      }
    }
  }
}
/* JavaCC - OriginalChecksum=733908e1a95332d87c807b509268d2b4 (do not edit this line) */