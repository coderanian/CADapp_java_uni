package model;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javafx.scene.paint.Color;

public class Drawing implements Serializable {
    private int cnt = 0;
    private ArrayList<IFigure> shapes;
    private static final long serialVersionUID = -167623067552884389L;

    public Drawing() {
    }

    public Drawing(int size) {
        if (size <= 0) {
            size = 10;
        }

        this.shapes = new ArrayList(size);
        this.cnt = 0;
    }

    public IFigure get(int k) {
        return (IFigure)this.shapes.get(k);
    }

    public int getCnt() {
        return this.cnt;
    }

    public ArrayList<IFigure> getShapes() {
        return this.shapes;
    }

    public void set(IFigure shape, int k) {
        this.shapes.set(k, shape);
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setShapes(ArrayList<IFigure> shapes, int cnt) {
        this.shapes = shapes;
        this.cnt = cnt;
    }

    public int add(IFigure f) {
        try {
            this.shapes.add(f);
            ++this.cnt;
        } catch (Exception var3) {
            System.out.println("Hinzufügen misslungen, schade.");
        }

        return this.cnt;
    }

    public Drawing clone() {
        Drawing drawingClone = new Drawing(this.shapes.size());
        drawingClone.cnt = this.cnt;
        Iterator var2 = this.shapes.iterator();

        while(var2.hasNext()) {
            IFigure f = (IFigure)var2.next();
            Figure fig = (Figure)f;
            drawingClone.shapes.add(fig.clone());
        }

        return drawingClone;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Drawing drawing = (Drawing)o;
            if (drawing.shapes.size() != this.shapes.size()) {
                return false;
            } else if (drawing.cnt != this.cnt) {
                return false;
            } else {
                return this.hashCode() == o.hashCode();
            }
        } else {
            return false;
        }
    }

    public static long getSerialVersionUID() {
        return -167623067552884389L;
    }

    public int hashCode() {
        int hash = 7;
        int hashMultiplier = 13;
        hash = hash * hashMultiplier + this.cnt;
        hash = hash * hashMultiplier + this.shapes.hashCode();
        return hash;
    }

    public void remove() {
        if (this.cnt <= 0) {
            System.out.println("Keine Figuren im Array.");
        } else {
            this.shapes.removeAll(this.shapes);
        }

        this.cnt = 0;
        System.out.println("Alle Figuren erfolgreich gelöscht");
    }

    public boolean remove(int k) {
        try {
            this.shapes.remove(k);
            --this.cnt;
            System.out.println("Figur gelöscht. Aktuelle Anzahl im Array " + this.cnt);
            return true;
        } catch (Exception var3) {
            System.out.println("Löschung misslungen, schade.");
            return false;
        }
    }

    public void sort(Comparator<? super IFigure> c) {
        Collections.sort(this.shapes);
    }

    public String toString() {
        if (this.cnt <= 0) {
            return "[]";
        } else {
            String sb = "[";

            IFigure f;
            for(Iterator var2 = this.shapes.iterator(); var2.hasNext(); sb = sb + f + " ") {
                f = (IFigure)var2.next();
            }

            sb = sb + "]";
            return sb;
        }
    }

    public static void main(String[] args) {
        System.out.println("Willkommen in Paint MKXXXXX");
        Drawing test = new Drawing(3);
        System.out.println("Array mit " + test.shapes.size() + " Figuren angelegt. Zeit zu malen!");
        Rectangle r = new Rectangle(0.0, 0.0, 100.0, 200.0, Color.WHITE, Color.WHITE);
        r.setForm("Rectangle");
        test.add(r);
        Ellipse e = new Ellipse(0.0, 0.0, 10.0, 20.0, Color.BLACK, Color.WHITE);
        e.setForm("Ellipse");
        test.add(e);
        Rectangle r2 = new Rectangle(0.0, 0.0, 300.0, 500.0);
        r2.setForm("Rectangle");
        test.add(r2);
        System.out.println("Anzahl von Figuren im Array: " + test.getCnt());
        System.out.println(test.toString());
        Drawing clon = test.clone();
        PrintStream var10000 = System.out;
        boolean var10001 = test.equals(clon);
        var10000.println("Drawing Arrays sind gleich: " + var10001);
        Rectangle testR = new Rectangle();
        clon.add(testR);
        System.out.println("Anzahl von Figuren im Clon-Array: " + clon.getCnt());
        var10000 = System.out;
        var10001 = test.equals(clon);
        var10000.println("Drawing Arrays sind gleich: " + var10001);
        System.out.println("Lösche Figur am Index 2\n" + test.remove(1));
        System.out.println("Anzahl von Figuren im Array: " + test.getCnt());
        System.out.println(test.toString());
        test.remove();
        System.out.println("Anzahl von Figuren im Array: " + test.getCnt());
        System.out.println(test.toString());
    }
}
