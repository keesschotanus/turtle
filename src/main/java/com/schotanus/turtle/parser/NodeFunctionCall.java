/* Generated By:JJTree: Do not edit this line. NodeFunctionCall.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

import java.util.Hashtable;


public class NodeFunctionCall extends SimpleNode {
  /**
   * Name of the function.
   */
  private String name;

  public NodeFunctionCall(int id) {
    super(id);
  }

  public NodeFunctionCall(TurtleParser p, int id) {
    super(p, id);
  }

   /**
     * Member access.
     * @return {@link #name}.
     */
    public String getName() {
      return name;
  }

  /**
   * Member access.
   * @param name {@link #name}.
   */
  public void setName(final String name) {
      this.name = name;
  }

  /**
   * Interprets a function call which has the following format:
   * function-name [ expression ( <COMMA> expression )* ]
   * @throws InterpretationException When the function does not exist or when
   *  the function does exist but the number of arguments does not match.
   */
  public void interpret() throws InterpretationException {
    NodeFunctionDeclaration function = (NodeFunctionDeclaration)functions.get(name.toLowerCase());
    if (function == null) {
      throw new InterpretationException("Function:" + name + " does not exist!");
    } else {
      // Check actual versus formal number of arguments
      NodeActualArguments actualArguments = (NodeActualArguments)jjtGetChild(0);
      NodeFormalArguments formalArguments = (NodeFormalArguments)function.jjtGetChild(0);
      if (formalArguments.jjtGetNumChildren() != actualArguments.jjtGetNumChildren()) {
        throw new InterpretationException("Function:" + name + " accepts:"
          + formalArguments.jjtGetNumChildren() + " arguments but "
          + actualArguments.jjtGetNumChildren() + " are supplied!");
      } else {
        // Interpret arguments and store their values
        Hashtable parameterValues = new Hashtable();
        for (int i = 0; i < formalArguments.jjtGetNumChildren(); i++) {
          actualArguments.jjtGetChild(i).interpret();
          NodeVariable variable = (NodeVariable)formalArguments.jjtGetChild(i);
          parameterValues.put(variable.getName().toLowerCase(), expressionStack.pop());
        }
        functionCallStack.push(new FunctionCall(function, parameterValues));

        // Interpret function statement block
        function.jjtGetChild(1).interpret();
        functionCallStack.pop();
      }
    }
  }
}
/* JavaCC - OriginalChecksum=1e4c915214c8147b24abac0164d99aac (do not edit this line) */
