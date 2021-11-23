package com.example.bankingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.action.Action;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class customer_form {

    @FXML
    private TextField fname_field, lname_field, address_field, number_field, custid_field, saccnt_field, caccnt_field;

    @FXML
    private Label appSentLabel;

    private int createdFile = 0;

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
        try
        {

            //create string to write to text File
            String customer_info = "";

            customer_info += "First name: " + fname_field.getText() + "\nLast name: " + lname_field.getText() + "\nCustomer ID: " + custid_field.getText() + "\nPhone Number: " + number_field.getText()
            + "\nAddress: " + address_field.getText() + "\nSavings Account #: " + saccnt_field.getText() + "\tChecking Account #: " + caccnt_field.getText() + "\n\n";


            //buffered writer for multiple lines
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ashin\\OneDrive\\Desktop\\BankingCreditCardSystem\\customer_information\\customer_information.txt", true));

            //write to file
            writer.write(customer_info);
            writer.close();


        }
        catch (IOException e)
        {

            System.out.println("Error opening/writing to file");
            e.printStackTrace();

        }


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


    public void clearSuccess(MouseEvent mouseEvent)
    {

        appSentLabel.setVisible(false);

    }
}
