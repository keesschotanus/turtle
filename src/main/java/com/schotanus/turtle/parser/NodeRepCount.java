/* Generated By:JJTree: Do not edit this line. NodeRepCount.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeRepCount extends SimpleNode {
  public NodeRepCount(int id) {
    super(id);
  }

  public NodeRepCount(TurtleParser p, int id) {
    super(p, id);
  }

  public void interpret() {
    if (repCountStack.isEmpty()) {
      System.out.println("repcount used outside repeat");
      expressionStack.push(Double.valueOf(0.0));
    } else {
      expressionStack.push(repCountStack.peek());
    }
  }
}
/* JavaCC - OriginalChecksum=0ead7c6970d78a3f30bbceb1615dd544 (do not edit this line) */
