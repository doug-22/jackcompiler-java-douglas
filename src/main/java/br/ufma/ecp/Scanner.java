package br.ufma.ecp;

public class Scanner {
  private byte[] input;
  private int current;
  private int start;

  public Scanner (byte[] input) {
    this.input = input;
    current = 0;
    start = 0;
  }

  private void advance() {
    char ch = peek();
    if (ch != 0) {
      current++;
    }
  }

  private void match( char c ) {
    if ( c == peek() ) {
      current++;
    } else {
      throw new Error("Syntax Error");
    }
  }

  private char peek() {
    if ( current < input.length ) {
      return (char)input[current];
    } else {
      return 0;
    }
  }

}
