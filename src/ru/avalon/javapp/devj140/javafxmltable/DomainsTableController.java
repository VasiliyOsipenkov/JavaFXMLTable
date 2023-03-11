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
import ru.avalon.javapp.devj140.javafxmltable.models.Domains;

/**
 * FXML Controller class
 *
 * @author Sleeproom
 */
public class DomainsTableController implements Initializable {

    /**
     * Initializes the controller class.
     */  
    @FXML
    private TableView<Domains> table;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
        table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        
        table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("webName"));        
        
        table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("domainName"));
        
        table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ip"));
        
        table.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dateReg"));
        
        table.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("countryReg"));
      
        // TODO
    }
    
    public void initDomainsTable(int personId) {
        ObservableList<Domains> domains = FXCollections.observableArrayList(new DBObjectBilder().getDomainsByPersonId(personId));
        table.setItems(domains);
    }
}
