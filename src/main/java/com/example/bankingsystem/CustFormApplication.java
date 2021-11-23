package com.example.bankingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustFormApplication extends Application {

    private static Stage stg;


    @Override
    public void start(Stage stage) throws IOException {

        stg = stage;
        stage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(customer_form.class.getResource("customer_form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("Customer Account Form");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}