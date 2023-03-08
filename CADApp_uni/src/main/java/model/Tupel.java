package model;

import java.io.PrintStream;
import java.io.Serializable;
import javafx.scene.paint.Color;

public class Tupel<T> implements Serializable {
    public T x;
    public T y;

    public Tupel() {
    }

    public Tupel(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        try {
            int hash = 7;
            int hashMultiplier = 13;
            hash = hash * hashMultiplier + this.x.hashCode();
            hash = hash * hashMultiplier + this.y.hashCode();
            return hash;
        } catch (Exception var3) {
            return 0;
        }
    }

    public Tupel<T> clone() {
        return new Tupel(this.x, this.y);
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
        return "x: " + this.x + " y: " + this.y;
    }

    public static void main(String[] args) {
        Tupel<Double> testTupel = new Tupel(10.0, 20.0);
        Tupel<Double> testTupel2 = testTupel.clone();
        PrintStream var10000 = System.out;
        boolean var10001 = testTupel.equals(testTupel2);
        var10000.println("Objekt1 == Objekt1 Klon: " + var10001);
        System.out.println(testTupel.toString());
        Tupel<Color> testTupel3 = new Tupel(Color.BLACK, Color.GREEN);
        Tupel<Double> testTupel4 = testTupel.clone();
        var10000 = System.out;
        var10001 = testTupel3.equals(testTupel4);
        var10000.println("Objekt2 == Objekt2 Klon: " + var10001);
        var10000 = System.out;
        var10001 = testTupel3.equals(testTupel);
        var10000.println("Objekt2 == Objekt1: " + var10001);
        System.out.println(testTupel3.toString());
    }
}
