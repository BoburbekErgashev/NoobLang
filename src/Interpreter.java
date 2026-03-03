import java.util.HashMap;

public class Interpreter {
    private final HashMap<String, Object> runtimeVariables= new HashMap<>();

    public void declareVariable(String name, Object value){
        runtimeVariables.put(name, value);
    }
}
