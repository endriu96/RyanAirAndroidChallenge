package android.challenge;

import android.challenge.figure.BrokenLine;
import android.challenge.figure.Figure;
import android.challenge.figure.Point;
import android.challenge.figure.Rectangle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AndroidChallengeLauncher {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Figure> figures = new FigureFileReader()
                .read(AndroidChallengeLauncher.class.getClassLoader().getResource("Android_Challenge_2021.csv"))
                .stream()
                .filter(AndroidChallengeLauncher::isCorrectFigure)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("zad2a: " + sumCircuitOfFigures(figures));
        System.out.println("zad2b: " + sumAreaOfFigures(figures));
        System.out.println("zad2c: " + numberOfFigures(figures));
        System.out.println("zad3a: " + averageLengthOfBrokenLines(figures));
        Rectangle rectangle = minimumRectangleWhichContainsAllFigures(figures) ;
        System.out.println("zad3c: " + pointToString(rectangle.getP1()) + pointToString(rectangle.getP2())
        + pointToString(rectangle.getP3()) + pointToString(rectangle.getP4()));

    }

    private static double sumCircuitOfFigures(List<Figure> figures) {
        return figures.stream()
                .map(Figure::circuit)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    private static double sumAreaOfFigures(List<Figure> figures){
        return figures.stream()
                .map(Figure::area)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    private static boolean isCorrectFigure(Figure figure) {
        if (figure instanceof Rectangle) {
            return false;
        }
        return true;
    }

    private static Map<Class<? extends Figure>, Long> numberOfFigures(List<Figure> figures) {
        return figures.stream().collect(Collectors.groupingBy(f -> f.getClass(), Collectors.counting()));
    }


    private static double averageLengthOfBrokenLines(List<Figure> figures) {
        List<Figure> brokenLines = figures.stream()
                .filter(figure -> figure instanceof BrokenLine)
                .collect(Collectors.toList());
        int size = brokenLines.size();
        double sum = brokenLines.stream()
                .map(s -> s.circuit())
                .reduce(Double::sum)
                .orElse(0.0);
        return sum / size;

    }

    private static Rectangle minimumRectangleWhichContainsAllFigures(List<Figure> figures) {
        Double minY = figures.stream()
                .map(Figure::minY)
                .min(Double::compareTo)
                .orElse(
                        0.0);
        Double minX = figures.stream()
                .map(Figure::minX)
                .min(Double::compareTo)
                .orElse(0.0);
        Double maxY = figures.stream()
                .map(Figure::maxY)
                .max(Double::compareTo)
                .orElse(0.0);
        Double maxX = figures.stream()
                .map(Figure::maxX)
                .max(Double::compareTo)
                .orElse(0.0);
        return new Rectangle(
                new Point(minX,minY),
                new Point(minX,maxY),
                new Point(maxX,minY),
                new Point(maxX,maxY)
                );
    }

    private static String pointToString(Point point){
        return "(" + point.getX() + "," +point.getY() + ")";
    }


}
