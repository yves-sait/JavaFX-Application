package com.example.javafxtravelexpertlogin;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public  class Validation {

    //validate empty textfield
    public static boolean isPresent(TextField text, Label label){
        boolean isValid = true;
        if(text.getText().isEmpty()){
            isValid = false;
            label.setText(text.getAccessibleText()+ " is required.");
            text.getStyleClass().add("textError");
            text.requestFocus();

        }
        return isValid;
    }
}
