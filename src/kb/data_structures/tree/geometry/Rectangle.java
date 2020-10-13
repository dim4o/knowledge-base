package kb.data_structures.tree.geometry;

/**
 * Represents a rectangle defined by two coordinates(bottom-left and top-right).
 * The rectangle can be considered and as a 2D range interval.
 * 
 * @author dimcho.nedev
 */
public class Rectangle {
    private Point bLeft;
    private Point tRight;

    /**
     * Defines a rectangle with two {@link Point}.
     * 
     * @param bLeft  - the bottom-left point of a rectangle
     * @param tRight - the top-right point of the rectangle
     */
    public Rectangle(Point bLeft, Point tRight) {
        this.bLeft = bLeft;
        this.tRight = tRight;
    }

    public Point getStart() {
        return bLeft;
    }

    public Point getEnd() {
        return tRight;
    }

    /**
     * Tests whether a point lies inside this rectangle.
     * 
     * @param point
     * @return whether a {@link Point} is in a rectangle.
     */
    public boolean contains(Point point) {
        return bLeft.getX() <= point.getX() && tRight.getX() >= point.getX()
                && bLeft.getY() <= point.getY() && tRight.getY() >= point.getY();
    }

    /**
     * Not used.
     * 
     * @return whether this rectangle intersects another rectangle.
     */
    public boolean intersects(Rectangle rec) {
        int x1 = rec.getStart().getX();
        int y1 = rec.getStart().getY();
        int x2 = rec.getEnd().getX();
        int y2 = rec.getEnd().getY();

        int X1 = bLeft.getX();
        int Y1 = bLeft.getY();
        int X2 = tRight.getX();
        int Y2 = tRight.getY();
        // TODO: > or >= ?
        if (x1 > X2 || x2 < X1 || y1 > Y2 || y2 < Y1) {
            return false;
        }

        return true;
    }
}
