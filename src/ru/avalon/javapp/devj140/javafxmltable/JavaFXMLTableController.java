/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.javapp.devj140.javafxmltable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VOsipenkov
 */
public class JavaFXMLTableController implements Initializable {
    
    @FXML
    private Label welcome;
    @FXML
    private Label dbUser;
    @FXML
    private TextField userName;
    @FXML
    private Label dbPassword;
    @FXML
    private PasswordField password;
    @FXML
    private Label loginCheck;
    @FXML
    private Button login;
          
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void buttonLogin (ActionEvent actionEvent){
        if(new DBObjectBilder().dbLoginCheck(userName.getText(), password.getText())){
            Stage stage = (Stage) welcome.getScene().getWindow();
            stage.close();//как по другому получить ссылку на stage не придумал
            new PersonTable().init();
        } else {        
            loginCheck.setStyle("-fx-text-fill: RED");
            loginCheck.setText("Login or password is incorrect");
        }
                    
    }       
}
