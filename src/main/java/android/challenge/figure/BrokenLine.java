package android.challenge.figure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BrokenLine extends Figure{

    private final List<Point> points;


    @Override
    public double circuit() {
        return createSections().stream()
                .map(Section::length)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double maxX() {
        return points.stream()
                .map(Point::getX)
                .max(Double::compare)
                .map(a->(double) a)
                .orElse(0.0);
    }

    @Override
    public double maxY() {
        return points.stream()
                .map(Point::getY)
                .max(Double::compare)
                .map(a->(double) a)
                .orElse(0.0);
    }

    @Override
    public double minX() {
        return points.stream()
                .map(Point::getX)
                .min(Double::compare)
                .map(a->(double) a)
                .orElse(0.0);
    }

    @Override
    public double minY() {
        return points.stream()
                .map(Point::getY)
                .min(Double::compare)
                .map(a->(double) a)
                .orElse(0.0);
    }

    public BrokenLine(long id, List<Point> points) {
        super(id);
        this.points = points;
    }


    private List<Section> createSections(){
        List<Section> sections = new ArrayList<>();
        for (int i=0 ; i<points.size()-1 ; i++) {
            sections.add(new Section(points.get(i),points.get(i+1)));
        }
        return sections;
    }
}
