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
import java.util.ArrayList;

public class customer_form {

    @FXML
    private TextField fname_field, lname_field, address_field, number_field, custid_field, saccnt_field, caccnt_field;

    @FXML
    private Label appSentLabel, errorLabel;

    private int fileNum = 0;

    //list to hold all customer Id information
    private int idCount = 0;
    private ArrayList<String> idList = new ArrayList<String>();

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

        boolean canSave = true;

        //error and type checking
        if (fname_field.getText().isEmpty())
        {
            errorLabel.setText("Please enter a first name.");
            errorLabel.setVisible(true);
            canSave = false;

        }
        else if (lname_field.getText().isEmpty())
        {

            errorLabel.setText("Please enter a last name.");
            errorLabel.setVisible(true);
            canSave = false;

        }
        else if (custid_field.getText().isEmpty())
        {

            errorLabel.setText("Please enter a customer ID.");
            errorLabel.setVisible(true);
            canSave = false;

        }
        else if (custid_field.getText().length() != 4)
        {
            if (custid_field.getText().length() > 4) {

                errorLabel.setText("Customer ID is too long.");
                errorLabel.setVisible(true);
                canSave = false;
            }
            else
            {
                errorLabel.setText("Customer ID is too short.");
                errorLabel.setVisible(true);
                canSave = false;
            }

        }
        else if (number_field.getText().isEmpty())
        {

            errorLabel.setText("Please enter a phone number.");
            errorLabel.setVisible(true);
            canSave = false;

        }
        else if (number_field.getText().length() != 10)
        {

            errorLabel.setText("Please enter a valid phone number.");
            errorLabel.setVisible(true);
            canSave = false;

        }
        else if (address_field.getText().isEmpty())
        {

            errorLabel.setText("Please enter an address.");
            errorLabel.setVisible(true);
            canSave = false;

        }
        else if (saccnt_field.getText().isEmpty())
        {

            errorLabel.setText("Please enter a savings account number.");
            errorLabel.setVisible(true);
            canSave = false;

        }
        else if (caccnt_field.getText().isEmpty())
        {

            errorLabel.setText("Please enter a checking account number.");
            errorLabel.setVisible(true);
            canSave = false;

        }

        boolean badId = false;

        for (int i = 0; i < idCount; i++)
        {

            if (custid_field.getText().equals(idList.get(i)))
            {

                badId = true;
                continue;

            }

        }


        if (badId)
        {

            errorLabel.setText("Duplicate user id entered.");
            errorLabel.setVisible(true);
            badId = false;
            canSave = false;

        }


        if (canSave) {


            //save information to a file
            try {

                fileNum++;

                FileWriter writer = new FileWriter("customer" + fileNum + "Information.txt");

                //create string to write to text File
                String customer_info = "";

                customer_info += "First name: " + fname_field.getText() + "\nLast name: " + lname_field.getText() + "\nCustomer ID: " + custid_field.getText() + "\nPhone Number: " + number_field.getText()
                        + "\nAddress: " + address_field.getText() + "\nSavings Account #: " + saccnt_field.getText() + "\tChecking Account #: " + caccnt_field.getText() + "\n\n";


                //write to file
                writer.write(customer_info);

                //add customer id to list
                idList.add(custid_field.getText());
                //increment amount of id's
                idCount++;

                //stop showing previous error label
                errorLabel.setVisible(false);

                writer.close();


            } catch (IOException e) {

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
    }


    public void clearSuccess(MouseEvent mouseEvent)
    {

        appSentLabel.setVisible(false);

    }
}
