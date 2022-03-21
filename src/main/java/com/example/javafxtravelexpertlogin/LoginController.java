/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

package com.example.javafxtravelexpertlogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import static com.example.javafxtravelexpertlogin.Validation.isPresent;

public class LoginController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnLogin"
    private Button btnLogin; // Value injected by FXMLLoader

    @FXML // fx:id="lblAdmin"
    private Label lblAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="lblEmailError"
    private Label lblEmailError; // Value injected by FXMLLoader

    @FXML // fx:id="lblPasswordError"
    private Label lblPasswordError; // Value injected by FXMLLoader

    @FXML // fx:id="txtEmail"
    private TextField txtEmail; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassword"
    private PasswordField txtPassword; // Value injected by FXMLLoader

    @FXML
    void onLoginClicked(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'login.fxml'.";
        assert lblAdmin != null : "fx:id=\"lblAdmin\" was not injected: check your FXML file 'login.fxml'.";
        assert lblEmailError != null : "fx:id=\"lblEmailError\" was not injected: check your FXML file 'login.fxml'.";
        assert lblPasswordError != null : "fx:id=\"lblPasswordError\" was not injected: check your FXML file 'login.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'login.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'login.fxml'.";



        //call method when login button is clicked
        btnLogin.setOnMouseClicked(mouseEvent -> {
            if(isPresent(txtEmail,lblEmailError) && isPresent(txtPassword, lblPasswordError)){
                //if validation is successful. Load the main scene.
                try {
                    loadMain();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //set default css when user is typing on the text field
        txtEmail.setOnKeyPressed(keyEvent -> {
            txtEmail.getStyleClass().remove("textError");
            lblEmailError.setText("");

        });
        txtPassword.setOnKeyPressed(keyEvent -> {
            txtPassword.getStyleClass().remove("textError");
            lblPasswordError.setText("");
        });
    }

    //method that load the main stage.
    private void loadMain() throws IOException {
        Stage mainStage = (Stage) btnLogin.getScene().getWindow();
        FXMLLoader mainFxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene mainScene = new Scene(mainFxmlLoader.load());
        mainStage.setTitle("Travel Experts Admin Console");
        mainStage.setScene(mainScene);
        mainStage.show();


    }



}
