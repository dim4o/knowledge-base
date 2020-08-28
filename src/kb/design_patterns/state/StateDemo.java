package kb.design_patterns.state;

interface State {
    void pull(ChainContext chain);
}

class ChainContext {
    private State state;

    public ChainContext() {
        this.state = new Off();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void nextState() {
        this.state.pull(this);
    }
}

class Off implements State {
    @Override
    public void pull(ChainContext chain) {
        chain.setState(new Low());
        System.out.println("Low");
    }
}

class Low implements State {
    @Override
    public void pull(ChainContext chain) {
        chain.setState(new Medium());
        System.out.println("Medium");
    }
}

class Medium implements State {
    @Override
    public void pull(ChainContext chain) {
        chain.setState(new High());
        System.out.println("High");
    }
}

class High implements State {
    @Override
    public void pull(ChainContext chain) {
        chain.setState(new Off());
        System.out.println("Off");
    }
}

public class StateDemo {

    public static void main(String[] args) throws Exception {
        ChainContext chain = new ChainContext();
        for (int i = 0; i < 16; i++) {
            chain.nextState();
            Thread.sleep(2000);
        }
        
        // Low, Medium, High, Off, Low, Medium, High ...
    }

}
