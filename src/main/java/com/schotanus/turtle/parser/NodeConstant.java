/* Generated By:JJTree: Do not edit this line. NodeConstant.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeConstant extends SimpleNode {
  /**
   * Actual value of the constant which is always maintained using double precision.
   */
  private double value;

  public NodeConstant(int id) {
    super(id);
  }

  public NodeConstant(TurtleParser p, int id) {
    super(p, id);
  }

  /**
   * Member access.
   * @param value {@link #value}.
   */
  public void setValue(final double value) {
    this.value = value;
  }

  /**
   * Interprets a constant by pushing the value on the stack.
   */
  public void interpret() {
    expressionStack.push(value);
  }
}
/* JavaCC - OriginalChecksum=c57ff92637e40d09a71bf9c0601c3389 (do not edit this line) */