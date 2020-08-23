package kb.design_patterns.observer;

public class Follower implements Observer {
    private String followerName;

    public Follower(String name) {
        this.followerName = name;
    }

    @Override
    public void update(String celebrityName, String message) {
        System.out.println(
                followerName + " has received an update about " + celebrityName + ": " + message);
    }

    @Override
    public String getName() {
        return followerName;
    }

}
