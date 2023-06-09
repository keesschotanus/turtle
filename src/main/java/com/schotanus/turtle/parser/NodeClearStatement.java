/* Generated By:JJTree: Do not edit this line. NodeClearStatement.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public class NodeClearStatement extends SimpleNode {
  public NodeClearStatement(int id) {
    super(id);
  }

  public NodeClearStatement(TurtleParser p, int id) {
    super(p, id);
  }

  /**
   * Interprets: CLEAR SCREEN
   * <br>No children are involved in this statement.
   */
  public void interpret() {
    turtleTerritoryModel.clearScreen();
  }

}
/* JavaCC - OriginalChecksum=73b9120a2119f41184514e30ecf05f5e (do not edit this line) */
