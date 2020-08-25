package kb.design_patterns.factory_method;

/**
 * This is a very naive example of Factory Method design pattern.
 */

interface Shape {
    void draw();
}

enum ShapeType { CIRCLE, RECTANGLE, TRIANGLE, SQUARE }

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

/**
 * A class that contains a factory method. This class can implement interface
 * Factory with getShape() method.
 */
class ShapeFactory {

    public Shape getShape(ShapeType shapeType) {
        boolean notSupported = false;
        switch (shapeType) {
        case CIRCLE:
            return new Circle();
        case RECTANGLE:
            return new Rectangle();
        case TRIANGLE:
            return new Triangle();
        default:
            notSupported = true;
        }
        
        if (notSupported) 
            throw new UnsupportedOperationException("Unsupported Shape: " + shapeType);
        
        return null;
    }
}

public class FactoryMethodClient {

    public static void main(String[] args) {
        // Initiate a factory object
        ShapeFactory factory = new ShapeFactory();
        
        Shape circle = factory.getShape(ShapeType.CIRCLE);
        
        Shape rectangle = factory.getShape(ShapeType.RECTANGLE);
        
        Shape triangle = factory.getShape(ShapeType.TRIANGLE);
        
        circle.draw();    // Drawing a circle
        rectangle.draw(); // Drawing a rectangle
        triangle.draw();  // Drawing a triangle
        
        factory.getShape(ShapeType.SQUARE); // Unsupported type
    }
}
