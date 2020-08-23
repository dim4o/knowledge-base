package kb.design_patterns.observer;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyAllObservers(String s);
}
