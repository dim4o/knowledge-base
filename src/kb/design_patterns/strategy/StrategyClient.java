package kb.design_patterns.strategy;

interface Strategy {
    int doOperation(int a, int b);
}

class AddOperation implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}

class SubstractOperation implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}

class MultiplyOperation implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}

class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.doOperation(a, b);
    }
}

public class StrategyClient {
    public static void main(String[] args) {
        Context addContext = new Context(new AddOperation());
        Context substractContext = new Context(new SubstractOperation());
        Context multiplyContext = new Context(new MultiplyOperation());

        System.out.println(addContext.executeStrategy(2, 5));
        System.out.println(substractContext.executeStrategy(2, 5));
        System.out.println(multiplyContext.executeStrategy(2, 5));
    }
}
