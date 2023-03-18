/* Generated By:JJTree: Do not edit this line. NodeFunctionDeclaration.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.schotanus.turtle.parser;

public class NodeFunctionDeclaration extends SimpleNode {
  /**
   * Function name
   */
  private String name;

  public NodeFunctionDeclaration(int id) {
    super(id);
  }

  public NodeFunctionDeclaration(TurtleParser p, int id) {
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
   * Interprets a function declaration.
   * <br>The term interprets is misleading here since the complete function
   * together with optional formal arguments and mandatory statement block
   * is stored in a functions hashtable with a key consisting of the lower-
   * case function name. When a function was previously declared the new
   * functiondeclaration overwrites the old declaration.
   */
  public void interpret() {
      functions.put(name.toLowerCase(), this);
  }
}
/* JavaCC - OriginalChecksum=6831e257361c7b852adb1943fa34fbd0 (do not edit this line) */
