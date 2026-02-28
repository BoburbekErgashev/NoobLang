import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

public class Tokenizer {
    private final Reader sourceCode;
    private static final ArrayList<Token> tokens = new ArrayList<Token>();
    //-----------------------------------------------------------------------------
    private static final Map<String, TokenType> keywords = Map.of(
            "show", TokenType.SHOW,
            "read", TokenType.READ,
            "num", TokenType.NUM,
            "text", TokenType.TEXT
    );
    //-----------------------------------------------------------------------------
    private StringBuilder buffer = new StringBuilder();
    //-----------------------------------------------------------------------------
    //Class constructor
    Tokenizer(Reader sourceCode){
        this.sourceCode = sourceCode;
    }
    //-----------------------------------------------------------------------------
    //Tokenization method that returns tokens as ArrayList
    public ArrayList<Token> tokenize() throws IOException {
        int character;
        while ((character = sourceCode.read()) != -1) {

        }
        return tokens;
    }
}
