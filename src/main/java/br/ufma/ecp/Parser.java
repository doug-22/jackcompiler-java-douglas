package br.ufma.ecp;

public class Parser {
  
  private byte[] input;
  private int current;

  public Parser (byte[] input) {
    this.input = input;
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

  void parser() {
    expr();
  }

  void expr() {
    digit();
    oper();
  }

  void oper() {
    if ( peek() == '+') {
      match('+');
      digit();
      oper();
    } else if ( peek() == '-') {
      match('-');
      digit();
      oper();
    } else if ( peek() == 0) {
      //Ok!
    } else {
      throw new Error("Syntax Error");
    }
  }

  void digit() {
    if (Character.isDigit( peek() )) {
      match( peek() );
    } else {
      throw new Error("Syntax Error");
    }
  }
}
