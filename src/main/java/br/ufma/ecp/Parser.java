package br.ufma.ecp;

public class Parser {
  
  private byte[] input;
  private int current;

  public Parser (byte[] input) {
    this.input = input;
  }

  private char peek() {
    if ( current < input.length ) {
      return (char)input[current];
    } else {
      return 0;
    }
  }
}
