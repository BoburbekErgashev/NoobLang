import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
public class Tokenizer {
    public static final Set<String> keywords = Set.of(
            "show",
            "read",
            "num",
            "text"
    );
    private final BufferedReader sourceCode;
    private static final ArrayList<Token> tokens = new ArrayList<Token>();
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    private final StringBuilder buffer = new StringBuilder();
    //-----------------------------------------------------------------------------
    //Class constructor
    Tokenizer(BufferedReader sourceCode){
        this.sourceCode = sourceCode;
    }
    //-----------------------------------------------------------------------------
    //Function for indentifying and adding keywords, indentifiers and values to tokens
    private void bufferCheck(){
        if(!buffer.isEmpty()){
            String lexeme = buffer.toString();
            if (keywords.contains(lexeme)){
                tokens.add(new Token(TokenType.KEYWORD, lexeme, null));
            }else{
                char firstChar = lexeme.charAt(0);
                if (Character.isDigit(firstChar)){
                    tokens.add(new Token(TokenType.INT, lexeme , Integer.parseInt(lexeme)));
                }else if(firstChar == '"'){
                    tokens.add(new Token(TokenType.STRING, lexeme, lexeme));
                }else{
                    tokens.add(new Token(TokenType.IDENTIFIER, lexeme, null));
                }
            }
            buffer.setLength(0);
        }
    }
    //-----------------------------------------------------------------------------
    //Tokenization method that returns tokens as ArrayList
    public ArrayList<Token> tokenize() throws IOException {
        boolean skip = false;
        int current;
        int next;
        while ((current = sourceCode.read()) != -1) {
            if (skip){
                skip = false;
                continue;
            }
            sourceCode.mark(2);
            next = sourceCode.read();
            sourceCode.reset();
            if (Character.isLetterOrDigit(current) || current == '_'){
                buffer.append((char)current);
            }else if(Character.isWhitespace(current)){
                bufferCheck();
            }else if((char)current == '"'){
                if (buffer.isEmpty()){
                    buffer.append('"');
                }else {
                    if(buffer.charAt(0) == '"'){
                        buffer.append('"');
                        bufferCheck();
                    }else{
                        bufferCheck();
                        buffer.append('"');
                    }
                }
            }else{
                bufferCheck();
                switch (current){
                    case '=':
                        if (next == '='){
                            tokens.add(new Token(TokenType.EQUALS, "==", null));
                            skip = true;
                        }else{
                            tokens.add(new Token(TokenType.ASSIGN, "=", null));
                        }
                        break;
                    case '+':
                        tokens.add(new Token(TokenType.PLUS, "+", null));
                        break;
                    case '-':
                        tokens.add(new Token(TokenType.MINUS, "-", null));
                        break;
                    case '*':
                        tokens.add(new Token(TokenType.MULTIPLY, "*", null));
                        break;
                    case '/':
                        tokens.add(new Token(TokenType.DIVIDE, "/", null));
                        break;
                    case '(':
                        tokens.add(new Token(TokenType.LPAREN, "(", null));
                        break;
                    case ')':
                        tokens.add(new Token(TokenType.RPAREN, ")", null));
                        break;
                    case '{':
                        tokens.add(new Token(TokenType.LBRACE, "{", null));
                        break;
                    case '}':
                        tokens.add(new Token(TokenType.RBRACE, "}", null));
                        break;
                    case ';':
                        tokens.add(new Token(TokenType.SEMICOLON, ";", null));
                        break;
                    case '%':
                        tokens.add(new Token(TokenType.MODULO, ";", null));
                        break;
                }
            }
        }
        tokens.add(new Token(TokenType.EOF, null, null));
        return tokens;
    }
}
