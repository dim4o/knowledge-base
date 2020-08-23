package kb.design_patterns.observer;

public interface Observer {
    void update(String name, String message);
    String getName();
}
