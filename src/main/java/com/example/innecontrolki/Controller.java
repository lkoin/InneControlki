package com.example.innecontrolki;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Circle circle;

    @FXML
    private Slider slider;

    @FXML
    private TextField txtInfo;

    @FXML
    private ScrollBar scroll;

    @FXML
    private TextField txtScroll;

    @FXML
    private Rectangle rectangle;

    @FXML
    private CheckBox chbRMF;

    @FXML
    private CheckBox chbMAXXX;

    @FXML
    private CheckBox chbZET;

    @FXML
    private CheckBox chbMELO;

    @FXML
    private TextArea textArea;

    @FXML
    private ChoiceBox<String> choicebox;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label lblChoice;

    @FXML
    private Label lblCombo;

    @FXML
    private ListView<String> list;

    @FXML
    private Spinner<Integer> spinnerMin;

    @FXML
    private Spinner<Integer> spinnerMax;

    @FXML
    private Label lblInfo2;

    @FXML
    private Label lblRandom;


    private String[] radio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                txtInfo.setText(String.valueOf((int)slider.getValue()) + "%");
                circle.setRadius(slider.getValue());
                txtInfo.setOnAction(event -> {
                    try {
                    slider.setValue(Double.parseDouble(txtInfo.getText()));
                    }
                    catch (Exception e) {
                        System.out.println("To nie jest liczba");
                    }
                });
            }
        });

        //Scroll Bar
        scroll.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                rectangle.setLayoutY(15+ scroll.getValue());
                txtScroll.setText(String.valueOf((int)scroll.getValue()));
                txtScroll.setOnAction(event -> {
                    try {
                        scroll.setValue(Double.parseDouble((txtScroll.getText())));
                    }
                    catch (Exception e) {
                        System.out.println("Podana wartość jest nieprawidłowa");
                    }
                });
            }
        });

        chbMAXXX.setOnAction(event -> addTextAreaAndList(chbMAXXX));
        chbMELO.setOnAction(event -> addTextAreaAndList(chbMELO));
        chbRMF.setOnAction(event -> addTextAreaAndList(chbRMF));
        chbZET.setOnAction(event -> addTextAreaAndList(chbZET));

        radio = new String[] {chbMAXXX.getText(),chbZET.getText(),chbMELO.getText(),chbRMF.getText()};
//        choicebox.getItems().add(chbMAXXX.getText());
//        choicebox.getItems().add(chbZET.getText());
//        choicebox.getItems().add(chbRMF.getText());
//        choicebox.getItems().add(chbMELO.getText());

        choicebox.getItems().addAll(radio);
        choicebox.setOnAction(event -> lblChoice.setText(choicebox.getValue()));
        comboBox.getItems().addAll(radio);
        comboBox.setOnAction(event -> lblCombo.setText(comboBox.getValue()));

        //SPINNER
        SpinnerValueFactory<Integer> Min = new SpinnerValueFactory.IntegerSpinnerValueFactory(50,150,100);
        SpinnerValueFactory<Integer> Max = new SpinnerValueFactory.IntegerSpinnerValueFactory(200,600,500);

        spinnerMin.setValueFactory(Min);
        spinnerMax.setValueFactory(Max);


        spinnerMin.setOnMouseClicked(mouseEvent -> {
            lblInfo2.setText("Losowanie liczb z zakresu" + spinnerMin.getValue() + " do " + spinnerMax.getValue());
        });

        spinnerMax.setOnMouseClicked(mouseEvent -> {
            lblInfo2.setText("Losowanie liczb z zakresu" + spinnerMin.getValue() + " do " + spinnerMax.getValue());
        });



    }
    public void addTextToArea(CheckBox checkBox){
        if (checkBox.isSelected()) textArea.appendText(checkBox.getText() +"\n");
    }

    public void addTextAreaAndList(CheckBox checkBox){
        if (checkBox.isSelected()) {
            textArea.appendText(checkBox.getText() +"\n");
            list.getItems().add(checkBox.getText());
        }
        else list.getItems().remove(checkBox.getText());
    }
}
