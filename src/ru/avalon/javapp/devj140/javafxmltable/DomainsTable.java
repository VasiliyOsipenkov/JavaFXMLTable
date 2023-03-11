/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.javapp.devj140.javafxmltable;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Sleeproom
 */
public class DomainsTable extends Stage{
    
    private Integer personId;

    public DomainsTable(int personId) {
        this.personId = personId;        
    }   
    
    
    public void init(){        
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DomainsTable.fxml"));
            root = loader.load();
            ((DomainsTableController)loader.getController()).initDomainsTable(personId);//инициализируем данные в таблице контроллера
            initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            setTitle("List of user id = " + personId + " domains");
            setScene(scene);            
            showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*   
       
        Scene scene = new Scene(root, 660, 500);
        */
    }
}
