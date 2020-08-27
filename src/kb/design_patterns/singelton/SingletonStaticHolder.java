package kb.design_patterns.singelton;

public class SingletonStaticHolder {

    // JVM ensures that this static class is loaded lazily + safe initialization
    private static class Holder {
        static final SingletonStaticHolder INSTANCE = new SingletonStaticHolder();
    }
    
    public static SingletonStaticHolder getInstance() {
        return Holder.INSTANCE;
    }
    
    private SingletonStaticHolder() {
        // private constructor
        System.out.println("Initializing some expensive resources...");
    }

}
