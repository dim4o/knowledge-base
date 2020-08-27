package kb.design_patterns.bridge;

abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract String draw();
}

class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    public String draw() {
        return "Square is drawn. " + super.color.fill();
    }
}

class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    public String draw() {
        return "Triangle is drawn. " + super.color.fill();
    }
}