package android.challenge.figure;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(String template){
       String[] splitedTemplate = template.split("-");
       this.x = Double.parseDouble(splitedTemplate[0]);
       this.y = Double.parseDouble(splitedTemplate[1]);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
