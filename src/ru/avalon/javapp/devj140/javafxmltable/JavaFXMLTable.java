/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.javapp.devj140.javafxmltable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author VOsipenkov
 */
public class JavaFXMLTable extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("JavaFXMLTable.fxml"));
             
        Scene scene = new Scene(root,300,250);
        stage.setTitle("JavaFXMLTable");
        stage.setScene(scene);
        //stage.setResizable(false); //в случае если требуется постоянный размер окна
        stage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
