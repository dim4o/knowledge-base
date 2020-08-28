package kb.design_patterns.singleton;

/**
 * Double check locking implementation
 */
public class SingletonDoubleCheckLock {
    // use "volatile" to tell JVM not to reorder the instruction.
    private static volatile SingletonDoubleCheckLock instance = null;

    private SingletonDoubleCheckLock() {
        // initialize some expensive resources here
        // field1 = some CPU heavy logic
        // field2 = some value from DB
        // ...
        System.out.println("Initializing some expensive resources...");
    }

    /**
     * Static factory method
     */
    public static SingletonDoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheckLock.class) {
                if (instance == null) {
                    // Assigning the instance is actually 3 steps for the compiler, but JVM allow to
                    // reorder this instructions:
                    // 1. Construct empty resource
                    // 2. Assign to instance
                    // 3. call constructor
                    instance = new SingletonDoubleCheckLock();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {

    }
}

/**
 * Static holder pattern
 */

/**
 * Enum pattern
 */
