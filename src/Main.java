import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BufferedReader file;
        try{
            file = new BufferedReader(new FileReader("pl.txt"));
        }catch (IOException e){
            System.out.println("error");
            return;
        }
        Tokenizer tknz = new Tokenizer(file);
        try {
            ArrayList<Token> tokenized = tknz.tokenize();
            for(Token i : tokenized){
                System.out.println(i.getType() + "(" + i.getLexeme() + ")");
            }
        }catch (IOException e){
            System.out.println("error");
            return;
        }
    }
}