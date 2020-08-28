package kb.design_patterns.singleton;

public enum SingeltonEnum {
    // JVM ensures that the instance is loaded lazily + safe initialization
    INSTANCE;

    private SingeltonEnum() {
        // private constructor
        System.out.println("Initializing some expensive resources...");
    }
}
