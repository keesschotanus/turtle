/* Generated By:JJTree: Do not edit this line. NodeStringLiteral.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeStringLiteral extends SimpleNode {
  private String text;

  public NodeStringLiteral(int id) {
    super(id);
  }

  public NodeStringLiteral(TurtleParser p, int id) {
    super(p, id);
  }
  
  public void setText(final String text) {
    this.text = text;
  }

  public void interpret() {
    expressionStack.push(text);
  }
}
/* JavaCC - OriginalChecksum=e8b338d58cc8f5af2ca28a3198315b7c (do not edit this line) */
