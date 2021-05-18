package android.challenge.figure;

public class Rectangle extends Figure {
    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(null);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }


    public Rectangle(long id, Point p1, Point p2 ) {
        //Nie da się wyznaczyć punktów p3 i p4 w sposób jednoznaczny
        super(null);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = null;
        this.p4 = null;

    }


    @Override
    public double circuit() {
        throw new UnsupportedOperationException("This operation is not possible for rectangle with that format");
    }

    @Override
    public double area() {
        throw new UnsupportedOperationException("This operation is not possible for rectangle with that format");
    }

    @Override
    public double maxX() {
        throw new UnsupportedOperationException("This operation is not possible for rectangle with that format");
    }

    @Override
    public double maxY() {
        throw new UnsupportedOperationException("This operation is not possible for rectangle with that format");
    }

    @Override
    public double minX() {
        throw new UnsupportedOperationException("This operation is not possible for rectangle with that format");
    }

    @Override
    public double minY() {
        throw new UnsupportedOperationException("This operation is not possible for rectangle with that format");
    }


}
