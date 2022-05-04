package br.ufma.ecp;

public class Parser {
  
  private Scanner scan;
  private Token currentToken;

  public Parser (byte[] input) {
    scan = new Scanner( input );
    nextToken();
  }
  
  private void nextToken() {
    currentToken = scan.nextToken();
  }

  private void match( TokenType type ) {
    if ( currentToken.type == type ) {
      nextToken();;
    } else {
      throw new Error("Syntax Error - expected " + type + " found " + currentToken.lexeme);
    }
  }

  // private char peek() {
  //   if ( current < input.length ) {
  //     return (char)input[current];
  //   } else {
  //     return 0;
  //   }
  // }

  void parser() {
    expr();
  }

  void expr() {
    term();
    oper();
  }

  void term () {
    if ( currentTokenIs( TokenType.NUMBER )) {
      number();
    } else if ( currentTokenIs( TokenType.IDENTIFIER )) {
      identifier();
    } else {
      throw new Error("Syntax Error - found " + currentToken.lexeme);
    }
  }

  void oper() {
    if ( currentTokenIs( TokenType.PLUS ) ) {
      match( TokenType.PLUS );
      term();
      System.out.println("add");
      oper();
    } else if ( currentTokenIs( TokenType.MINUS ) ) {
      match( TokenType.MINUS );
      term();
      System.out.println("sub");
      oper();
    } else if ( currentTokenIs( TokenType.EOF ) ) {
      //Ok!
    } else {
      throw new Error("Syntax Error - found " + currentToken.lexeme);
    }
  }

  void number() {
    System.out.println( "push " + currentToken.lexeme );
    match( TokenType.NUMBER );
  }

  void identifier() {
    System.out.println( "push " + currentToken.lexeme );
    match( TokenType.IDENTIFIER );
  }

  boolean currentTokenIs ( TokenType type ) {
    return currentToken.type == type;
  }
}
