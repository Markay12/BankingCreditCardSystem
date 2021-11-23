package com.example.bankingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class customer_form {

    @FXML
    private TextField fname_field, lname_field, address_field, number_field, custid_field, saccnt_field, caccnt_field;

    @FXML
    private Label appSentLabel;

    public void erase(ActionEvent actionEvent) throws IOException
    {

        //erase all text fields
        fname_field.setText("");
        lname_field.setText("");
        address_field.setText("");
        number_field.setText("");
        custid_field.setText("");
        saccnt_field.setText("");
        caccnt_field.setText("");

    }

    public void saveToFile(ActionEvent actionEvent) throws IOException
    {

        //save information to a file
        


        //clear information and update success label
        fname_field.setText("");
        lname_field.setText("");
        address_field.setText("");
        number_field.setText("");
        custid_field.setText("");
        saccnt_field.setText("");
        caccnt_field.setText("");

        appSentLabel.setVisible(true);



    }

}
