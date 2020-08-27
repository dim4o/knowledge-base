package kb.design_patterns.bridge;

class BridgeClient {

    public static void main(String[] arg) {
        Shape redSquare = new Square(new Red());
        Shape blueSquare = new Square(new Blue());
        Shape redTriangle = new Triangle(new Red());
        Shape blueTriangle = new Triangle(new Blue());

        System.out.println(redSquare.draw());
        System.out.println(blueSquare.draw());
        System.out.println(redTriangle.draw());
        System.out.println(blueTriangle.draw());
    }
}
