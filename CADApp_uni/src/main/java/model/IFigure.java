package model;

import java.util.Comparator;

public interface IFigure extends Comparator<IFigure>, Comparable<IFigure> {
    double circumference();

    double area();

    default int compare(IFigure o1, IFigure o2) {
        if (o1.area() == o2.area()) {
            return 0;
        } else {
            return o1.area() > o2.area() ? 1 : -1;
        }
    }

    default int compareTo(IFigure o) {
        if (this.area() == o.area()) {
            return 0;
        } else {
            return this.area() > o.area() ? 1 : -1;
        }
    }
}
