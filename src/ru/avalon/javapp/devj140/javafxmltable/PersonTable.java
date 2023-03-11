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
public class PersonTable extends Stage{
    public void init() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("PersonTable.fxml"));
            initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            setTitle("Person list");
            setScene(scene);            
            showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
