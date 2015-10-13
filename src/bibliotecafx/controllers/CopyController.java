/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.controllers;

import bibliotecafx.MainApp;
import bibliotecafx.models.Copias;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Eddi
 */
public class CopyController implements Initializable {
    
    @FXML
    private TableView<Copias> tbvCopy;
    @FXML
    private TableColumn<Copias, String> tbcId;
    @FXML
    private TableColumn<Copias, String> tbcLocation;
    @FXML
    private TableColumn<Copias, String> tbcidBook;
    
    private MainApp mainApp;
    
     public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tbvCopy.setItems(mainApp.getCopiesList());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbcId.setCellValueFactory(new PropertyValueFactory<Copias, String>("id"));
        tbcLocation.setCellValueFactory(new PropertyValueFactory<Copias, String>("location"));
        tbcidBook.setCellValueFactory(new PropertyValueFactory<Copias, String>("idBook"));
        
        tbvCopy.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        tbvCopy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Copias>() {        
            @Override
            public void changed(ObservableValue <? extends Copias> observable,
                Copias oldValue, Copias newValue) {
            }
        });
    }    
    
}
