/* Generated By:JJTree: Do not edit this line. NodePenYPositionStatement.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodePenYPositionStatement extends SimpleNode {
  public NodePenYPositionStatement(int id) {
    super(id);
  }

  public NodePenYPositionStatement(TurtleParser p, int id) {
    super(p, id);
  }

  public void interpret() throws InterpretationException {
    jjtGetChild(0).interpret();
    double y = ((Double)expressionStack.pop()).doubleValue();

    getActiveTurtleModel().setXPosition(y);
  }
}
/* JavaCC - OriginalChecksum=8dd5bd0848509603c87eaed947b5ef0e (do not edit this line) */
