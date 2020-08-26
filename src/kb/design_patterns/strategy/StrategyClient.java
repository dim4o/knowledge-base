package kb.design_patterns.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

class Player {
    int rank;
    int points;
    Player(int rank, int points){
        this.rank = rank;
        this.points = points;
    }
    public int getPoints() {
        return points;
    }
}

public class StrategyClient {
    public static void main(String[] args) {
        
        List<Player> players = List.of(new Player(10,  88));
        Collections.sort(players, Comparator.comparing(Player::getPoints));
        
        

        Context addContext = new Context(new AddOperation());
        Context substractContext = new Context(new SubstractOperation());
        Context multiplyContext = new Context(new MultiplyOperation());

        System.out.println(addContext.executeStrategy(2, 5));
        System.out.println(substractContext.executeStrategy(2, 5));
        System.out.println(multiplyContext.executeStrategy(2, 5));
    }
}
