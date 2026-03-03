public class Binary implements Expression {
    public final Expression left;
    public final Expression right;
    public final Token operation;

    public Binary(Expression left, Expression right, Token operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }
}
