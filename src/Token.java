public class Token {
    public TokenType type;
    public String lexme;
    public Object literal;
    Token(TokenType type, String lexme, Object literal){
        this.type = type;
        this.lexeme = lexme;
        this.literal = literal;
    }
}
