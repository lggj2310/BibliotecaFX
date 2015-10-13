/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.controllers;

import bibliotecafx.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Eddi
 */
public class MenuController implements Initializable {
    
    private MainApp mainApp;
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private void ClikedUsers(){
        mainApp.showViewUsers();
    }
    
    @FXML
    private void ClickedBooks(){
        mainApp.showViewBooks();
    }
    
    @FXML
    private void ClikedAuthors(){
        mainApp.showViewAuthors();
    }
    
    @FXML
    private void ClikedCopies(){
        mainApp.showViewCopies();
    }
    
    @FXML
    private void ClikedLoans(){
        mainApp.showViewLoans();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
