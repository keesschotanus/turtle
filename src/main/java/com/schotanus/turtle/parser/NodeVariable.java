/* Generated By:JJTree: Do not edit this line. NodeVariable.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public
class NodeVariable extends SimpleNode {

  private String name;

  public NodeVariable(int id) {
    super(id);
  }

  public NodeVariable(TurtleParser p, int id) {
    super(p, id);
  }

  public String getName() {
    return name;
}

public void setName(final String name) {
  this.name = name;
}

public void interpret() throws InterpretationException {
  FunctionCall functionCall = (FunctionCall)functionCallStack.peek();
  try {
    expressionStack.push(functionCall.getParameterValue(name));
  } catch (IllegalArgumentException exception) {
    System.out.println("Parameter: " + name + " does not exist!");
    expressionStack.push(Double.valueOf(0));
  }
}

}
/* JavaCC - OriginalChecksum=fe9c9988025ed482d271af4cabc216e3 (do not edit this line) */