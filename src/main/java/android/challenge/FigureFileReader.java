package android.challenge;
import android.challenge.figure.*;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FigureFileReader {

    public List<Figure> read(URL path) throws IOException, URISyntaxException {
        List<Figure> figures = new ArrayList<>();
        BufferedReader csvreader = new BufferedReader(new FileReader(new File(path.toURI())));
        String row;
        while ((row = csvreader.readLine())!= null){
            String[] data = row.split(";");
            try{
                figures.add(mapToFigure(data));
            } catch(Exception e) {
                System.out.println("Couldnt read figure with id " + data[0]);
            }

        }
        return figures;
    }


    private Figure mapToFigure(String[] data){
        String id = data[0];
        String type = data[1];
        String[] figureParameters = removeQuote( Arrays.copyOfRange(data, 2,data.length));

        switch(type) {
            case "C":
                return mapToCircle(id, figureParameters);
            case "L":
                return mapToBrokenLine(id, figureParameters);
            case "R":
                return mapToRectangle(id, figureParameters);
            default:
                throw new IllegalArgumentException("Type " + type + " not supported");
        }
    }

    private Circle mapToCircle(String id, String[] figureParameters){
        return new Circle(
                Long.valueOf(id),
                Double.valueOf(figureParameters[1]),
                new Point(figureParameters[0]));
    }

    private BrokenLine mapToBrokenLine(String id, String[] figureParameters){
        return new BrokenLine(
                Long.valueOf(id),
                Stream.of(figureParameters)
                        .map(Point::new)
                        .collect(Collectors.toList()));
    }


    private Rectangle mapToRectangle(String id, String[] figureParameters){
        return new Rectangle(
                Long.valueOf(id),
                new Point(figureParameters[0]),
                new Point(figureParameters[1]));
    }

    private String[] removeQuote(String[] array){
        return Stream.of(array)
                .map(s -> s.replace("\"",""))
                .toArray(String[]::new);
    }

}
