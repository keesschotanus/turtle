package com.schotanus.util;

import java.util.StringTokenizer;

/**
 * Utility class.
 */
public class Util {

  /**
   * Splits a String into tokens.
   * This method assumes the following delimiter set: space, tab, newline, carriage-return
   * and the form-feed character.
   * @param input Input string to split into tokens.
   * @return Array containing a String for each token.
   * @see StringTokenizer#StringTokenizer(String)
   */
  public static String [] tokenize(String input) {
    // A null reference should return an empty array not an exception.
    if (input == null) {
      input = "";
    }

    StringTokenizer stringTokenizer = new StringTokenizer(input);

    // Allocate a String array of just the right size.
    String [] tokens = new String[stringTokenizer.countTokens()];

    // Get all tokens from the input and store them.
    int i = 0;
    while (stringTokenizer.hasMoreTokens()) {
      tokens[i++] = stringTokenizer.nextToken();
    }
    return tokens;
  }
}
