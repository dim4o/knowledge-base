package kb.design_patterns.observer;

public class TweetApp {

    public static void main(String[] args) {
        Subject celebrity = new Celebrity("R.G.");

        Observer o0 = new Follower("D.N.");
        Observer o1 = new Follower("N.S.");
        Observer o2 = new Follower("B.N.");

        celebrity.register(o0);
        celebrity.register(o1);
        celebrity.register(o2);
        // D.N. is registered to R.G. feeds.
        // N.S. is registered to R.G. feeds.
        // B.N. is registered to R.G. feeds.
        System.out.println();

        celebrity.notifyAllObservers("Hello, I am in your town now!");
        // D.N. has received an update about R.G.: Hello, I am in your town now!
        // N.S. has received an update about R.G.: Hello, I am in your town now!
        // B.N. has received an update about R.G.: Hello, I am in your town now!

        celebrity.unregister(o1);
        // B.N. is unregistered from R.G. feeds.

        celebrity.notifyAllObservers("Hello, I am leaving town now!");
        // D.N. has received an update about R.G.: Hello, I am leaving town now!
        // B.N. has received an update about R.G.: Hello, I am leaving town now!
    }

}
