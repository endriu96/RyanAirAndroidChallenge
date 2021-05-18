package android.challenge.figure;

public abstract class Figure {


    private final Long id;

    public abstract double circuit();
    public abstract double area();
    public abstract double maxX();
    public abstract double maxY();
    public abstract double minX();
    public abstract double minY();


    public Figure(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}

