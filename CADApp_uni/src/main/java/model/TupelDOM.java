package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class TupelDOM<T> extends Tupel<T> {
    public TupelDOM() {
    }

    public static Element makeElement(Document dokument, Element element, Object obj) {
        if (element.getNodeName().equals("Position") || element.getNodeName().equals("Size")) {
            Element xx = dokument.createElement("X");
            Element yy = dokument.createElement("Y");
            Tupel<Double> t = (Tupel)obj;
            xx.appendChild(dokument.createTextNode(((Double)t.x).toString()));
            yy.appendChild(dokument.createTextNode(((Double)t.y).toString()));
            element.appendChild(xx);
            element.appendChild(yy);
        }

        return element;
    }

    public static Object getInstance(Node element) {
        Tupel<Double> t = new Tupel();
        if (element.getNodeName().equals("Position") || element.getNodeName().equals("Size")) {
            NodeList childs = element.getChildNodes();

            for(int i = 0; i < childs.getLength(); ++i) {
                if (childs.item(i).getNodeName().contentEquals("X")) {
                    t.x = Double.parseDouble(childs.item(i).getTextContent());
                }

                if (childs.item(i).getNodeName().contentEquals("Y")) {
                    t.y = Double.parseDouble(childs.item(i).getTextContent());
                }
            }
        }

        return t;
    }
}