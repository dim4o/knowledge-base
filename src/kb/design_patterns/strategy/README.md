# Strategy pattern

In **Strategy** pattern, we create objects which represent various strategies and a `Context` object whose behavior varies as per its strategy object. The `Strategy` object changes the executing algorithm of the context object.

## Real word API examples
`java.util.Comparator` in kind of strategy interface. This is an implementation of some comparison strategy:

```Java
class Player {
    int rank; points;

    Player(int rank, int points){
        this.rank = rank;
        this.points = points;
    }
    
    int getRank() { return rank; }
    int getPoints() { return getPoint; }
}
```

One way to sort a collection of players is:

```Java
Collections.sort(players, (p1, p2) -> p1.rank - p2.rank);
```

The `lambda` here represents a strategy: `(p1, p2) -> p1.rank - p2.rank`. Another strategy can be: `(p1, p2) -> p1.points - p2.points` or `Comparator.comparing(Player::getPoints)`.

Internally `Collections.sort(...)` will invoke `player_i.comapre(player_j)` defined by the `lambda` or anonymous function.