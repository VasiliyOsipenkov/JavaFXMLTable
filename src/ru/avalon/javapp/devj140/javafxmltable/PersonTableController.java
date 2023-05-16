/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.javapp.devj140.javafxmltable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ru.avalon.javapp.devj140.javafxmltable.models.Person;

/**
 * FXML Controller class
 *
 * @author Sleeproom
 */
public class PersonTableController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<Person> table;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Person> persons = FXCollections.observableArrayList(new DBObjectBilder().getPerson());
                     
        table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));             
   
        table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("jobTitle"));        
               
        table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("firstNameLastName"));
        
        table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("phone"));       
        
        table.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
        
        table.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("domainsCount"));
       
        table.setItems(persons);
                    
        // TODO
    } 
    
    @FXML
    public void setOnMouseClicked(MouseEvent event) {
        if(event.getClickCount()==2){
                Person person = table.getSelectionModel().getSelectedItem();
                new DomainsTable(person.getId()).init();
            }
    }
    
}
