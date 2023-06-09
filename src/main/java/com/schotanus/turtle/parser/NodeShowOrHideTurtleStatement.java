/* Generated By:JJTree: Do not edit this line. NodeShowOrHideTurtleStatement.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeShowOrHideTurtleStatement extends SimpleNode {
  private boolean show;

  public NodeShowOrHideTurtleStatement(int id) {
    super(id);
  }

  public NodeShowOrHideTurtleStatement(TurtleParser p, int id) {
    super(p, id);
  }

  public void setShow(final boolean show) {
    this.show = show;
  }

  public void interpret() {
    if (show) {
      System.out.println("show turtle");
    } else {
      System.out.println("hide turtle");
    }
  }
}
/* JavaCC - OriginalChecksum=1205e086849d0551f1bba6655e85febd (do not edit this line) */
