package android.challenge.figure;

public class Circle extends Figure{

    private final double radius;
    private final Point center;

    public Circle(long id, double radius, Point center) {
        super(id);
        this.radius = radius;
        this.center = center;
    }

    @Override
    public double circuit() {
        return 2*Math.PI*radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double maxX() {
        return center.getX()+radius;
    }

    @Override
    public double maxY() {
        return center.getY()+radius;
    }

    @Override
    public double minX() {
        return center.getX()-radius;
    }

    @Override
    public double minY() {
        return center.getY()-radius;
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }



}
