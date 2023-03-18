/* Generated By:JJTree: Do not edit this line. NodeUnequalToExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeUnequalToExpression extends SimpleNode {
  public NodeUnequalToExpression(int id) {
    super(id);
  }

  public NodeUnequalToExpression(TurtleParser p, int id) {
    super(p, id);
  }

  public void interpret() throws InterpretationException {
    jjtGetChild(0).interpret();
    double leftOperand = ((Double)expressionStack.pop()).doubleValue();

    jjtGetChild(1).interpret();
    double rightOperand = ((Double)expressionStack.pop()).doubleValue();

    expressionStack.push(new Boolean(leftOperand != rightOperand));
  }

}
/* JavaCC - OriginalChecksum=3dc7e81bee5c9bf202e29236d3d672ff (do not edit this line) */
