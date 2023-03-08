package model;

import java.io.PrintStream;
import java.io.Serializable;
import javafx.scene.paint.Color;

public class Ellipse extends Figure implements Serializable {
    private static final long serialVersionUID = 2226556801814491411L;

    public Ellipse() {
        super(0.0, 0.0, 0.0, 0.0, (Color)null, (Color)null);
        this.setForm("Ellipse");
    }

    public Ellipse(double xpos, double ypos, double width, double height) {
        super(xpos, ypos, width, height, (Color)null, (Color)null);
        this.setForm("Ellipse");
    }

    public Ellipse(Tupel position, Tupel size) {
        super(position, size);
        this.setForm("Ellipse");
    }

    public Ellipse(double xpos, double ypos, double width, double height, Color fillcolor, Color linecolor) {
        super(xpos, ypos, width, height, fillcolor, linecolor);
        this.setForm("Ellipse");
    }

    public Ellipse(Tupel<Double> position, Tupel<Double> size, Tupel<Color> colors) {
        super(position, size, colors);
        this.setForm("Ellipse");
    }

    public double area() {
        double seiteA = (Double)this.getSize().x / 2.0;
        double seiteB = (Double)this.getSize().y / 2.0;
        return Math.PI * seiteA * seiteB;
    }

    public double circumference() {
        double seiteA = (Double)this.getSize().x / 2.0;
        double seiteB = (Double)this.getSize().y / 2.0;
        return Math.PI * (seiteA + seiteB);
    }

    public Ellipse clone() {
        return new Ellipse(this.getPosition(), this.getSize(), this.getColors());
    }

    public static void main(String[] args) {
        Ellipse eTest1 = new Ellipse();
        eTest1.setSize(500.0, 300.0);
        eTest1.setColors(Color.CYAN, Color.MAGENTA);
        System.out.println(eTest1.toString());
        Ellipse eTest2 = new Ellipse(0.0, 0.0, 100.0, 100.0);
        eTest2.setColors(Color.BLACK, Color.GRAY);
        System.out.println(eTest2.toString());
        Ellipse eTest3 = new Ellipse(0.0, 0.0, 100.0, 100.0, Color.BLUE, Color.GREEN);
        System.out.println(eTest3.toString());
        PrintStream var10000 = System.out;
        boolean var10001 = eTest1.equals(eTest2);
        var10000.println("Figur1 == Figur2: " + var10001);
        Ellipse eTest4 = eTest3.clone();
        var10000 = System.out;
        var10001 = eTest3.equals(eTest4);
        var10000.println("Figur3 == Figur3 Klon: " + var10001);
    }
}
