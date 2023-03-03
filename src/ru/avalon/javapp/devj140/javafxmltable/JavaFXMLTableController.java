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
    private Text welcome;
    @FXML
    private Label dbUser;
    @FXML
    private TextField userName;
    @FXML
    private Label dbPassword;
    @FXML
    private PasswordField password;
    @FXML
    private Text loginCheck;
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
        
    }
        (new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(dbLoginCheck(url, user, pword)){
                    primaryStage.close();
                    new PersonTable(url, user, pword).init();
                } else loginCheck.setVisible(true);
                    
            }
        });
        
    private void getlogin(String url, String user, String pword){
        new PersonTable(url, user, pword).init(); 
    }     
       
    private boolean dbLoginCheck(String url, String user, String pword){
        try(Connection conn = DriverManager.getConnection(url, user, pword);
                Statement stm = conn.createStatement()){
            List<Users> userList = new ArrayList<>();
            try(ResultSet rs = stm.executeQuery("select * from USERS")){
                while(rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String userPassword = rs.getString(3);
                    userList.add(new Users(id, name, userPassword));
                }                                 
            }
            for(Users u : userList){
            if(u.getName().equals(userName.getText()) && u.getPassword().equals(password.getText()))
                return true;
            }               
        } catch (SQLException ex) {               
        }
        return false;
    }
    
}
