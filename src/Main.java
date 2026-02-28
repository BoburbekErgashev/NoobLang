import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
                System.out.println(i.type + "('" + i.lexme + "')");
            }
        }catch (IOException e){
            System.out.println("errer");
            return;
        }
    }
}