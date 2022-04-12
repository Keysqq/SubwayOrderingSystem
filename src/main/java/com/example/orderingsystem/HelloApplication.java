package com.example.orderingsystem;
//Devs: Justin F,
//Date: 4/12/2022
//Class 171
//Script: Sub Ordering System / week11 group project
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
// create a pane to place nodes in using a grid concept
        GridPane grid = new GridPane();

        //style the grid with padding fields
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(8);

        //create nodes and set values
        Label label1 = new Label("Size");
        Label label2 = new Label("Bread");
        Label label3 = new Label("Meat");
        Label label4 = new Label("Cheese");
        Label label5 = new Label("Veggies");
        Label label6 = new Label("Sauce");

        TextField txt = new TextField();

        Button btn = new Button("Order");
        GridPane.setHalignment(btn, HPos.RIGHT);
        ////////////

        String size[] = { "12\"", "6\"" };
        ComboBox cmbSize = new ComboBox(FXCollections.observableArrayList(size));

        String bread[] = { "Italian", "Wheat","Multi Grain" };
        ComboBox cmbBread = new ComboBox(FXCollections.observableArrayList(bread));

        String meat[] = { "Turkey", "Ham","Roast Beef" };
        ComboBox cmbMeat = new ComboBox(FXCollections.observableArrayList(meat));

        String cheese[] = { "Mozzarella", "American","Swiss" };
        ComboBox cmbCheese = new ComboBox(FXCollections.observableArrayList(cheese));

        String veggies[] = { "Lettuce", "Tomato","Onion" };
        ComboBox cmbVeggies = new ComboBox(FXCollections.observableArrayList(veggies));

        String sauce[] = { "Mayo", "Oil","Vinegar" };
        ComboBox cmbSauce = new ComboBox(FXCollections.observableArrayList(sauce));

        //position nodes within spec col,row

        GridPane.setConstraints(label1,0,0);
        GridPane.setConstraints(cmbSize,1,0);
        GridPane.setConstraints(label2,0,1);
        GridPane.setConstraints(cmbBread,1,1);
        GridPane.setConstraints(label3,2,0);
        GridPane.setConstraints(cmbMeat,3,0);
        GridPane.setConstraints(label4,2,1);
        GridPane.setConstraints(cmbCheese,3,1);
        GridPane.setConstraints(label5,0,2);
        GridPane.setConstraints(cmbVeggies,1,2);
        GridPane.setConstraints(label6,2,2);
        GridPane.setConstraints(cmbSauce,3,2);

        GridPane.setConstraints(btn,0,3);
        GridPane.setConstraints(txt,0,4,4,1);//col, row, colspan, rowspan

        //add nodes to the pane
        grid.getChildren().addAll(label1,label2,label3,label4,label5,label6,cmbSize,cmbBread,cmbMeat,cmbCheese,cmbVeggies,cmbSauce,btn,txt);


        //set an on click action for convert button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //need a check here to see if all fields are selected before creating the obj "Sandwich"

                //create sandwich object
                Sandwich temp = new Sandwich(
                        cmbSize.getValue().toString(),
                        cmbBread.getValue().toString(),
                        cmbMeat.getValue().toString(),
                        cmbCheese.getValue().toString(),
                        cmbVeggies.getValue().toString(),
                        cmbSauce.getValue().toString());
                //txt.appendText(temp.toString());

                //use the obj toString method to display contents
                txt.setText(temp.toString());

            }
        });

        Scene scene = new Scene(grid);
        //scene.getStylesheets().add("style.css");
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}