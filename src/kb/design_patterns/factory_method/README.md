# Factory Method pattern

## When to use
The **Factory Method** pattern is useful when we create object without exposing the creation logic to the client. We use a common interface for all objects that will be created:

```Java
Shape circle = factory.getShape(ShapeType.CIRCLE);
Shape rectangle = factory.getShape(ShapeType.RECTANGLE);
Shape triangle = factory.getShape(ShapeType.TRIANGLE);
```
Here `getShape(ShapeType type)` is a factory method responsible for creating the object of the specified type.

I used a **Factory Method** pattern [here](https://github.com/dim4o/copyright-tools/blob/master/src/main/java/com/coprtools/commands/CommandFactory.java).