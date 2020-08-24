package kb.design_patterns.visitor;

/* An interface for all visitors. */
interface CartVisitor {
    double visit(TShirt item);
    double visit(Book ithem);
}

/* An interface for the item that will be visited. */
interface ItemElement {
    double accept(CartVisitor visitor);
}

enum Color { WHITE, BLACK, RED, GREEN, BLUE, MIXED }
enum Size { S, M, L }

/* An item that overrides "accept" method */
class TShirt implements ItemElement {
    private double price;
    private Color color;
    private Size size;
    
    public double getPrice() { return price; }
    public Color getColor() { return color; }
    public Size getSize() { return size; }

    public TShirt(double price, Color color, Size size) {
        this.price = price;
        this.color = color;
    }

    @Override
    public double accept(CartVisitor visitor) {
        return visitor.visit(this);
    }
}

/* An item that overrides "accept" method */
class Book implements ItemElement {
    private double price;
    private String isbn;
    
    public double getPrice() { return price; }
    public String getISBN() { return isbn; }

    public Book(double price, String isbn) {
        this.price = price;
        this.isbn = isbn;
    }

    @Override
    public double accept(CartVisitor visitor) {
        return visitor.visit(this);
    }
}

/*
 * Represents the visitor object. Contains the algorithms that will be performed
 * on the items. Later this visitor implementation can will be easy replaced
 * with an implementation with different business logic.
 */
class ShoppingCartVisitor implements CartVisitor {

    @Override
    public double visit(TShirt item) {
        double cost = item.getPrice();
        // 5% discount for RED and BLACK color
        if (item.getColor() == Color.RED || item.getColor() == Color.BLACK)
            cost *= 0.95d; 
        
        return cost;
    }

    @Override
    public double visit(Book ithem) {
        return ithem.getPrice();
    }
}

public class VisitorClient {

    public static void main(String[] args) {
        ItemElement[] items = { new Book(150.0d, "0-4574-3496-1"),
                new TShirt(100.0d, Color.RED, Size.M) };
        
        CartVisitor cartVisitor = new ShoppingCartVisitor();
        
        double total = 0.;
        for (ItemElement itemElement : items) {
            double currPrice = itemElement.accept(cartVisitor);
            System.out.println(itemElement.getClass().getSimpleName() + " price: " + currPrice);
            total += itemElement.accept(cartVisitor);
        }
        System.out.println("\nTotal cost: " + total);
    }
}
