# Prototype pattern
Prototype allows us to hide the complexity of making new instances from the client. The concept is to copy an existing object rather than creating a new instance from scratch, something that may include costly operations.

## Prototype Design Participants

1. `Prototype` : This is the prototype of actual object.
2. `Prototype registry` : This is used as registry service to have all prototypes accessible using simple string parameters.
3. `Client` : Client will be responsible for using registry service to access prototype instances.


## Real world API examples
Prototype recognizable by creational methods returning a different instance of itself with the same properties

- `java.lang.Object#clone()` (the class has to implement `java.lang.Cloneable`)