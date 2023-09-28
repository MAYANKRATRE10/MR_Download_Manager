package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Download_Manager {
    @FXML
    private TextField downloadURL;
    @FXML
    void downloadButtonClicked(MouseEvent event) {

            String text = downloadURL.getText();
            System.out.println("Button clicked :"+ text);

    }
}
