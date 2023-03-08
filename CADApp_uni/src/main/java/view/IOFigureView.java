package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Figure;
import model.Tupel;
import viewmodel.IOFigureViewModel;
import viewmodel.ViewModel;

public class IOFigureView extends BorderPane implements IView {
    VBox funktionsleiste = new VBox();
    private Label index = new Label("Index:");
    private TextField indexNr = new TextField("1");
    private ObservableList<String> forms = FXCollections.observableArrayList(new String[]{"Rectangle", "Ellipse"});
    private ComboBox<String> formsPicker;
    private Label pos;
    private Label x;
    private TextField xPos;
    private Label y;
    private TextField yPos;
    private Label size;
    private Label width;
    private TextField widthSize;
    private Label height;
    private TextField heightSize;
    private Label colors;
    private Label fc;
    private ColorPicker fcColors;
    private Label lc;
    private ColorPicker lcColors;
    private Button change;
    private Button add;
    private Button remove;
    private Label feat;
    private Label umfang;
    private TextField outputU;
    private Label fläche;
    private TextField outputA;
    private Stage stage;
    private IOFigureViewModel vm;
    private IView parent;

    public IOFigureView(ViewModel vm, IView parent, Stage stage) {
        this.formsPicker = new ComboBox(this.forms);
        this.pos = new Label("Position");
        this.x = new Label("X:");
        this.xPos = new TextField("0");
        this.y = new Label("Y:");
        this.yPos = new TextField("0");
        this.size = new Label("Size");
        this.width = new Label("Width:");
        this.widthSize = new TextField("100");
        this.height = new Label("Height:");
        this.heightSize = new TextField("50");
        this.colors = new Label("Colors");
        this.fc = new Label("FillC:");
        this.fcColors = new ColorPicker(Color.WHITE);
        this.lc = new Label("LineC:");
        this.lcColors = new ColorPicker(Color.BLACK);
        this.change = new Button("Change");
        this.add = new Button("Add");
        this.remove = new Button("Remove");
        this.feat = new Label("Features");
        this.umfang = new Label("Umfang:");
        this.outputU = new TextField("TEST");
        this.fläche = new Label("Fläche:");
        this.outputA = new TextField("TEST");

        try {
            this.vm = new IOFigureViewModel((Figure)null, vm);
            this.parent = parent;
            this.stage = stage;
            this.funktionsleiste.setBorder(new Border(new BorderStroke[]{new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.DARKGRAY, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1.0), Insets.EMPTY)}));
            this.funktionsleiste.setPadding(new Insets(40.0, 30.0, 40.0, 30.0));
            BorderPane indexRow = new BorderPane();
            HBox contIndex = new HBox();
            contIndex.getChildren().add(this.index);
            contIndex.setAlignment(Pos.CENTER_LEFT);
            indexRow.setLeft(contIndex);
            HBox contIndexNr = new HBox();
            contIndexNr.getChildren().add(this.indexNr);
            contIndexNr.setAlignment(Pos.CENTER_RIGHT);
            contIndexNr.setPadding(new Insets(0.0, 0.0, 0.0, 40.0));
            indexRow.setRight(contIndexNr);
            this.funktionsleiste.getChildren().add(indexRow);
            indexRow.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));
            HBox formsRow = new HBox(new Node[]{this.formsPicker});
            formsRow.setAlignment(Pos.CENTER_RIGHT);
            this.funktionsleiste.getChildren().add(formsRow);
            formsRow.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));
            BorderPane positionInput = new BorderPane();
            HBox posTop = new HBox();
            posTop.getChildren().add(this.pos);
            posTop.setAlignment(Pos.CENTER_RIGHT);
            posTop.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
            positionInput.setTop(posTop);
            VBox xyLabel = new VBox();
            xyLabel.getChildren().addAll(new Node[]{this.x, this.y});
            xyLabel.setAlignment(Pos.CENTER_LEFT);
            xyLabel.setSpacing(10.0);
            positionInput.setLeft(xyLabel);
            VBox xyValue = new VBox();
            xyValue.getChildren().addAll(new Node[]{this.xPos, this.yPos});
            xyValue.setAlignment(Pos.CENTER_RIGHT);
            xyValue.setSpacing(10.0);
            positionInput.setRight(xyValue);
            this.funktionsleiste.getChildren().add(positionInput);
            positionInput.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));
            BorderPane sizeInput = new BorderPane();
            HBox sizeTop = new HBox();
            sizeTop.getChildren().add(this.size);
            sizeTop.setAlignment(Pos.CENTER_RIGHT);
            sizeInput.setTop(sizeTop);
            sizeTop.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
            VBox sizeLabel = new VBox();
            sizeLabel.getChildren().addAll(new Node[]{this.width, this.height});
            sizeLabel.setAlignment(Pos.CENTER_LEFT);
            sizeLabel.setSpacing(10.0);
            sizeInput.setLeft(sizeLabel);
            VBox sizeValue = new VBox();
            sizeValue.getChildren().addAll(new Node[]{this.widthSize, this.heightSize});
            sizeValue.setAlignment(Pos.CENTER_RIGHT);
            sizeValue.setSpacing(10.0);
            sizeInput.setRight(sizeValue);
            this.funktionsleiste.getChildren().add(sizeInput);
            sizeInput.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));
            BorderPane colorInput = new BorderPane();
            VBox colorLabel = new VBox();
            colorLabel.getChildren().addAll(new Node[]{this.fc, this.lc});
            colorLabel.setAlignment(Pos.CENTER_LEFT);
            colorLabel.setSpacing(10.0);
            colorInput.setLeft(colorLabel);
            VBox colorPick = new VBox();
            colorPick.getChildren().addAll(new Node[]{this.fcColors, this.lcColors});
            colorPick.setAlignment(Pos.CENTER_RIGHT);
            colorPick.setSpacing(10.0);
            colorInput.setRight(colorPick);
            this.funktionsleiste.getChildren().add(colorInput);
            colorInput.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));
            VBox buttons = new VBox();
            buttons.getChildren().addAll(new Node[]{this.change, this.add, this.remove});
            buttons.setAlignment(Pos.CENTER_RIGHT);
            this.funktionsleiste.getChildren().add(buttons);
            buttons.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));
            buttons.setSpacing(10.0);
            this.change.setPrefSize(120.0, 25.0);
            this.add.setPrefSize(120.0, 25.0);
            this.remove.setPrefSize(120.0, 25.0);
            BorderPane featuresInput = new BorderPane();
            HBox featTop = new HBox();
            featTop.getChildren().add(this.feat);
            featTop.setAlignment(Pos.CENTER_RIGHT);
            featuresInput.setTop(featTop);
            featTop.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
            VBox featLabel = new VBox();
            featLabel.getChildren().addAll(new Node[]{this.umfang, this.fläche});
            featLabel.setAlignment(Pos.CENTER_LEFT);
            featLabel.setSpacing(10.0);
            featuresInput.setLeft(featLabel);
            VBox featInput = new VBox();
            featInput.getChildren().addAll(new Node[]{this.outputU, this.outputA});
            this.outputU.setEditable(false);
            this.outputA.setEditable(false);
            featInput.setAlignment(Pos.CENTER_RIGHT);
            featInput.setSpacing(10.0);
            featuresInput.setRight(featInput);
            this.funktionsleiste.getChildren().add(featuresInput);
            this.setSettings(this.vm.getFigure());
        } catch (Exception var24) {
            var24.printStackTrace();
        }

    }

    public void update() {
    }

    public String getForm() {
        return (String)this.formsPicker.getSelectionModel().getSelectedItem();
    }

    public void setForm(String form) {
        this.formsPicker.getSelectionModel().select(form);
    }

    public double getIndex() {
        return (double)this.vm.getFigureID();
    }

    public Figure getSettings(Figure fig) {
        return fig;
    }

    public Figure setSettings(Figure fig) {
        Tupel<Double> pos = fig.getPosition();
        Tupel<Double> size = fig.getSize();
        Tupel<Color> col = fig.getColors();
        int index = (int)this.getIndex();
        this.indexNr.setText(Integer.toString(index));
        this.setForm(fig.getForm());
        this.xPos.setText(Double.toString((Double)pos.x));
        this.yPos.setText(Double.toString((Double)pos.y));
        this.widthSize.setText(Double.toString((Double)size.x));
        this.heightSize.setText(Double.toString((Double)size.y));
        this.fcColors.setValue((Color)col.x);
        this.lcColors.setValue((Color)col.y);
        this.outputA.setText(Double.toString(fig.area()));
        this.outputU.setText(Double.toString(fig.circumference()));
        return fig;
    }

    private class LabeledText extends BorderPane {
        public ColorPicker cp;
        public Label lbl;
        public TextField txt;

        public LabeledText(String lblText, String txtText) {
            this(lblText, txtText, true);
        }

        public LabeledText(String lblText, String txtText, boolean enable) {
            this.cp = new ColorPicker();
            this.lbl = null;
            this.txt = null;
            BorderPane bp = new BorderPane();
            this.lbl = this.createLabel(lblText);
            bp.setLeft(this.lbl);
            this.txt = this.createTextField(txtText, enable);
            bp.setRight(this.txt);
        }

        public LabeledText(String lblText, Color rcColor) {
            this.cp = new ColorPicker();
            this.lbl = null;
            this.txt = null;
            BorderPane bp = new BorderPane();
            this.lbl = this.createLabel(lblText);
            bp.setRight(this.lbl);
            this.lbl.setAlignment(Pos.CENTER_RIGHT);
            bp.setLeft(this.cp);
            this.setColor(rcColor);
        }

        public void setTextField(double value) {
            this.txt.setText(String.valueOf(value));
        }

        public void setColor(Color rcColor) {
            this.cp.setValue(rcColor);
        }

        public double getTextField() {
            return Double.parseDouble(this.txt.getText());
        }

        public String getForm() {
            return (String)IOFigureView.this.formsPicker.getValue();
        }

        public Color getColor() {
            return (Color)this.cp.getValue();
        }

        private Label createLabel(String lblText) {
            Label lbl = new Label(lblText);
            return lbl;
        }

        private TextField createTextField(String txtText, Boolean ro) {
            TextField txt = new TextField(txtText);
            txt.setEditable(ro);
            return txt;
        }
    }

    public static class ButtonAction extends Button {
        public ButtonAction(String btnText) {
            Button b = new Button(btnText);
            b.setPrefSize(120.0, 75.0);
        }
    }
}