/* Generated By:JJTree: Do not edit this line. NodePowerExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodePowerExpression extends SimpleNode {
  public NodePowerExpression(int id) {
    super(id);
  }

  public NodePowerExpression(TurtleParser p, int id) {
    super(p, id);
  }

  public void interpret() throws InterpretationException {
    jjtGetChild(0).interpret();
    double leftOperand = ((Double)expressionStack.pop()).doubleValue();

    jjtGetChild(1).interpret();
    double rightOperand = ((Double)expressionStack.pop()).doubleValue();

    expressionStack.push(Double.valueOf(Math.pow(leftOperand, rightOperand)));
  }
}
/* JavaCC - OriginalChecksum=7a320baf53e3a59a819c3eedcdba5c82 (do not edit this line) */
