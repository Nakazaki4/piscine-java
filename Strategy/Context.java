
public class Context {

    private OperationStrategy operationStrategy;

    public Context() {
        this.operationStrategy = new AddStrategy();
    }

    public void changeStrategy(OperationStrategy newStrategy) {
        this.operationStrategy = newStrategy;
    }

    public int execute(int a, int b) {
        return this.operationStrategy.execute(a, b);
    }
}
