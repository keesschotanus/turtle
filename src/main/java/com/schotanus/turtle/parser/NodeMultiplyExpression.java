/* Generated By:JJTree: Do not edit this line. NodeMultiplyExpression.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeMultiplyExpression extends SimpleNode {
  public NodeMultiplyExpression(int id) {
    super(id);
  }

  public NodeMultiplyExpression(TurtleParser p, int id) {
    super(p, id);
  }

  public void interpret() throws InterpretationException {
    jjtGetChild(0).interpret();
    double leftOperand = ((Double)expressionStack.pop()).doubleValue();

    jjtGetChild(1).interpret();
    double rightOperand = ((Double)expressionStack.pop()).doubleValue();

    expressionStack.push(new Double(leftOperand * rightOperand));
  }
}
/* JavaCC - OriginalChecksum=cdd08cbb48487d0c3e64652e39c0e101 (do not edit this line) */