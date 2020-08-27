package kb.design_patterns.proxy;

interface DataProcessor {
    void process();
}

class HeavyDataProcessor implements DataProcessor {
    public HeavyDataProcessor() {
        heavyInitialization();
    }

    private void heavyInitialization() {
        System.out.println("heavy initialization complete.");
    }

    @Override
    public void process() {
        System.out.println("pocessing complete.");
    }
}

class HeavyDataProcessorProxy implements DataProcessor {
    private DataProcessor heavyDataProcessor = null;

    @Override
    public void process() {
        if (heavyDataProcessor == null) {
            heavyDataProcessor = new HeavyDataProcessor();
        }

        heavyDataProcessor.process();
    }
}

public class ProxyClient {
    public static void main(String[] args) {
        DataProcessor object = new HeavyDataProcessorProxy();
        // The heavy initialization is only in the first call.
        object.process();

        System.out.println();

        // There is no heavy initialization here.
        object.process();
    }
}
