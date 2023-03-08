package model;

import java.io.Serializable;
import javafx.scene.paint.Color;

public abstract class Figure implements IFigure, Serializable {
    private Tupel<Double> position;
    private Tupel<Double> size;
    private Tupel<Color> colors;
    private String form;
    private static final long serialVersionUID = -4913882936112037419L;

    public Figure() {
    }

    public Figure(double xpos, double ypos, double width, double height) {
        this.position = new Tupel(xpos, ypos);
        this.size = new Tupel(width, height);
        this.colors = new Tupel(Color.BLACK, Color.WHITE);
    }

    public Figure(double xpos, double ypos, double width, double height, Color fillcolor, Color linecolor) {
        this.position = new Tupel(xpos, ypos);
        this.size = new Tupel(width, height);
        this.colors = new Tupel(fillcolor, linecolor);
    }

    public Figure(Tupel<Double> position, Tupel<Double> size) {
        this.position = position;
        this.size = size;
        this.colors = new Tupel(Color.WHITE, Color.BLACK);
    }

    public Figure(Tupel<Double> position, Tupel<Double> size, Tupel<Color> colors) {
        this.position = position;
        this.size = size;
        this.colors = colors;
    }

    public Tupel<Double> getPosition() {
        return this.position;
    }

    public Tupel<Double> getSize() {
        return this.size;
    }

    public Tupel<Color> getColors() {
        return this.colors;
    }

    public String getForm() {
        return this.form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setPosition(double xpos, double ypos) {
        this.position.x = xpos;
        this.position.y = ypos;
    }

    public void setSize(double width, double height) {
        if (!(width < 0.0) && !(height < 0.0)) {
            this.size.x = width;
            this.size.y = height;
        } else {
            this.size.x = 0.0;
            this.size.y = 0.0;
        }

    }

    public void setColors(Color fillcolor, Color linecolor) {
        this.colors.x = fillcolor;
        this.colors.y = linecolor;
    }

    public int hashCode() {
        int hash = 7;
        int hashMultiplier = 13;
        hash = hash * hashMultiplier + this.position.hashCode();
        hash = hash * hashMultiplier + this.size.hashCode();
        hash = hash * hashMultiplier + this.colors.hashCode();
        return hash;
    }

    public Figure clone() {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (this.getClass() != o.getClass()) {
            return false;
        } else {
            return this.hashCode() == o.hashCode();
        }
    }

    public String toString() {
        String var10000 = this.form;
        return "[" + var10000 + ", Abmessungen: " + this.size + ", Position: " + this.position + ", Farben: " + this.colors + ", Fläche: " + this.circumference() + ", Umfang: " + this.area() + "]";
    }
}
