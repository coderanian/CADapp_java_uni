package model;

import java.io.PrintStream;
import javafx.scene.paint.Color;

public class Rectangle extends Figure {
    private static final long serialVersionUID = -7082201814855812246L;

    public Rectangle() {
        super(0.0, 0.0, 100.0, 50.0, (Color)null, (Color)null);
        this.setForm("Rectangle");
    }

    public Rectangle(double xpos, double ypos, double width, double height) {
        super(xpos, ypos, width, height, (Color)null, (Color)null);
        this.setForm("Rectangle");
    }

    public Rectangle(Tupel<Double> position, Tupel<Double> size, Tupel<Color> colors) {
        super(position, size, colors);
        this.setForm("Rectangle");
    }

    public Rectangle(double xpos, double ypos, double width, double height, Color fillcolor, Color linecolor) {
        super(xpos, ypos, width, height, fillcolor, linecolor);
        this.setForm("Rectangle");
    }

    public double circumference() {
        return 2.0 * ((Double)this.getSize().x + (Double)this.getSize().y);
    }

    public double area() {
        return (Double)this.getSize().x * (Double)this.getSize().y;
    }

    public Rectangle clone() {
        return new Rectangle(this.getPosition(), this.getSize(), this.getColors());
    }

    public static void main(String[] args) {
        Rectangle rTest1 = new Rectangle();
        rTest1.setSize(500.0, 300.0);
        rTest1.setColors(Color.CYAN, Color.MAGENTA);
        System.out.println(rTest1.toString());
        Rectangle rTest2 = new Rectangle(0.0, 0.0, 100.0, 100.0);
        rTest2.setColors(Color.BLACK, Color.GRAY);
        System.out.println(rTest2.toString());
        Rectangle rTest3 = new Rectangle(0.0, 0.0, 100.0, 100.0, Color.BLUE, Color.GREEN);
        System.out.println(rTest3.toString());
        PrintStream var10000 = System.out;
        boolean var10001 = rTest1.equals(rTest2);
        var10000.println("Figur1 == Figur2: " + var10001);
        Rectangle rTest4 = rTest3.clone();
        var10000 = System.out;
        var10001 = rTest3.equals(rTest4);
        var10000.println("Figur3 == Figur3 Klon: " + var10001);
    }
}

