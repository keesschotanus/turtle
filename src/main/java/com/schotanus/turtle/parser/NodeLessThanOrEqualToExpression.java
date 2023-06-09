/* Generated By:JJTree: Do not edit this line. NodeLessThanOrEqualToExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeLessThanOrEqualToExpression extends SimpleNode {
  public NodeLessThanOrEqualToExpression(int id) {
    super(id);
  }

  public NodeLessThanOrEqualToExpression(TurtleParser p, int id) {
    super(p, id);
  }

  public void interpret() throws InterpretationException {
    jjtGetChild(0).interpret();
    double leftOperand = ((Double)expressionStack.pop()).doubleValue();

    jjtGetChild(1).interpret();
    double rightOperand = ((Double)expressionStack.pop()).doubleValue();

    expressionStack.push(Boolean.valueOf(leftOperand <= rightOperand));
  }
}
/* JavaCC - OriginalChecksum=7c4f2c2e8d9e031332a30edd1b4160c8 (do not edit this line) */
