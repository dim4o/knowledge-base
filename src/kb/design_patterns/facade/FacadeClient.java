package kb.design_patterns.facade;

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle.");
    }
}

class ShapeFacade {
    private Rectangle rectangle;
    private Circle circle;
    private Triangle triangle;

    public ShapeFacade() {
        rectangle = new Rectangle();
        circle = new Circle();
        triangle = new Triangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawTriangle() {
        triangle.draw();
    }
}

public class FacadeClient {
    public static void main(String[] args) {
        ShapeFacade painter = new ShapeFacade();

        painter.drawRectangle();
        painter.drawCircle();
        painter.drawTriangle();
    }
}
