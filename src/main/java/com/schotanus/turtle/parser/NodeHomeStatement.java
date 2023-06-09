/* Generated By:JJTree: Do not edit this line. NodeHomeStatement.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeHomeStatement extends SimpleNode {
  public NodeHomeStatement(int id) {
    super(id);
  }

  public NodeHomeStatement(TurtleParser p, int id) {
    super(p, id);
  }

  /**
   * Interprets: HOME
   * <br>Sets the active turtle to position 0.0, 0.0
   */
  public void interpret() {
    getActiveTurtleModel().setPosition(0.0, 0.0);
  }
}
/* JavaCC - OriginalChecksum=27ae338d99d3f854d26f88614ce85bf6 (do not edit this line) */
