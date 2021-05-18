package android.challenge.figure;

public class Section {

    private final Point p1;
    private final Point p2;

    public Section(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double length(){
        double a = Math.abs(p1.getX() - p2.getX());
        double b = Math.abs(p1.getY() - p2.getY());
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

}
