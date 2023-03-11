/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.javapp.devj140.javafxmltable;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ru.avalon.javapp.devj140.javafxmltable.models.Users;

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
            
            new PersonTable().init();
        } else {        
            loginCheck.setStyle("-fx-text-fill: RED");
            loginCheck.setText("Login or password is incorrect");
        }
                    
    }       
}
