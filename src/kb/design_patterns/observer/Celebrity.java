package kb.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Celebrity implements Subject {

    private List<Observer> followers;
    private String celebrityName;

    public Celebrity(String name) {
        this.followers = new ArrayList<>();
        this.celebrityName = name;
    }

    @Override
    public void register(Observer o) {
        followers.add(o);
        System.out.println(o.getName() + " is registered to " + celebrityName + " feeds.");
    }

    @Override
    public void unregister(Observer o) {
        followers.remove(o);
        System.out.println(o.getName() + " is unregistered from " + celebrityName + " feeds.");
        System.out.println();
    }

    @Override
    public void notifyAllObservers(String message) {
        for (Observer observer : followers)
            observer.update(celebrityName, message);
        System.out.println();
    }

}
