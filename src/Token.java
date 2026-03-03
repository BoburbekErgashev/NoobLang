import java.util.Set;

public class Token {
    private final TokenType type;
    private final String lexeme;
    private final Object literal;
    Token(TokenType type, String lexeme, Object literal){
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
    }

    public TokenType getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public Object getLiteral() {
        return literal;
    }


}
