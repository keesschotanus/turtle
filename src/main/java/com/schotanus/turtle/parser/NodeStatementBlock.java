/* Generated By:JJTree: Do not edit this line. NodeStatementBlock.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeStatementBlock extends SimpleNode {
  public NodeStatementBlock(int id) {
    super(id);
  }

  public NodeStatementBlock(TurtleParser p, int id) {
    super(p, id);
  }
  
  public void interpret() throws InterpretationException {
    for (int i = 0; i < jjtGetNumChildren(); i++) {
      jjtGetChild(i).interpret();
    }
  }
}
/* JavaCC - OriginalChecksum=e3a0acd62a60dbf0e336a22a24b9d94d (do not edit this line) */
