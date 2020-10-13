package kb.data_structures.tree;

import java.util.ArrayList;
import java.util.List;

import kb.data_structures.tree.geometry.Point;
import kb.data_structures.tree.geometry.Rectangle;

/**
 * An implementation of QuadTree data structure. Support O(logN) time for
 * insertion and O(K + logN) time for 2D range query.
 * 
 * @author dimcho.nedev
 */
public class QuadTree {
    private Point point = null;
    private QuadTree tLeft = null;
    private QuadTree tRight = null;
    private QuadTree bLeft = null;
    private QuadTree bRight = null;

    public QuadTree(Point point) {
        this.point = point;
    }

    /**
     * Inserts a {@list Point} to the tree recursively.
     * 
     * @param p - point to be inserted
     * @return a result {@link QuadTree}
     */
    public QuadTree insert(Point p) {
        return insert(this, p);
    }

    private QuadTree insert(QuadTree qTree, Point p) {
        if (qTree == null)
            return new QuadTree(p);

        if (qTree.point.getX() < p.getX() && qTree.point.getY() < p.getY()) {
            qTree.tRight = insert(qTree.tRight, p); // North-East
        } else if (qTree.point.getX() < p.getX() && qTree.point.getY() > p.getY()) {
            qTree.bRight = insert(qTree.bRight, p); // South-East
        } else if (qTree.point.getX() > p.getX() && qTree.point.getY() < p.getY()) {
            qTree.tLeft = insert(qTree.tLeft, p); // North-West
        } else {
            qTree.bLeft = insert(qTree.bLeft, p); // South-West
        }

        return qTree;
    }

    /**
     * Finds the points within a given 2D range.
     * 
     * @param rectangle - the 2D range defined by a rectangle.
     * @return a list of points within the given range
     */
    public List<Point> query(Rectangle rectangle) {
        List<Point> res = new ArrayList<>();
        query(this, rectangle, res);
        return res;
    }

    private void query(QuadTree qTree, Rectangle rectangle, List<Point> res) {
        if (qTree == null)
            return;

        int x1 = rectangle.getStart().getX();
        int y1 = rectangle.getStart().getY();
        int x2 = rectangle.getEnd().getX();
        int y2 = rectangle.getEnd().getY();

        Point qPoint = qTree.point;

        if (rectangle.contains(qTree.point))
            res.add(qPoint);

        if (qPoint.getX() < x2 && qPoint.getY() < y2)
            query(qTree.tRight, rectangle, res); // North-East

        if (qPoint.getX() < x2 && qPoint.getY() > y1)
            query(qTree.bRight, rectangle, res); // South-East

        if (qPoint.getX() > x1 && qPoint.getY() < y2)
            query(qTree.tLeft, rectangle, res); // North-West

        if (qPoint.getX() > x1 && qPoint.getY() > y1)
            query(qTree.bLeft, rectangle, res); // South-West
    }

}
