/* Generated By:JJTree: Do not edit this line. NodeLeftOrRightStatement.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeLeftOrRightStatement extends SimpleNode {
  private boolean left;

  public NodeLeftOrRightStatement(int id) {
    super(id);
  }

  public NodeLeftOrRightStatement(TurtleParser p, int id) {
    super(p, id);
  }

  public void setLeft(final boolean left) {
    this.left = left;
  }

  public void interpret() throws InterpretationException {
    jjtGetChild(0).interpret();
    double degrees = ((Double)expressionStack.pop()).doubleValue();
    if (left) {
      getActiveTurtleModel().turn(degrees);
    } else {
      getActiveTurtleModel().turn(-degrees);
    }
  }
}
/* JavaCC - OriginalChecksum=fda4761f67db018d7415cdc818a8fc20 (do not edit this line) */
