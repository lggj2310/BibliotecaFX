/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.controllers;

import bibliotecafx.MainApp;
import bibliotecafx.models.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Eddi
 */
public class UserController implements Initializable {
    
    @FXML
    private TableView<Usuario> tbvUsers;
    @FXML
    private TableColumn<Usuario, String> tbcId;
    @FXML
    private TableColumn<Usuario, String> tbcName;
    
    @FXML
    private Label lblPhone;
    
    @FXML
    private Label lblAddress;
    
    private MainApp mainApp;
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tbvUsers.setItems(mainApp.getUsersList());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbcId.setCellValueFactory(new PropertyValueFactory<Usuario, String>("id"));
        tbcName.setCellValueFactory(new PropertyValueFactory<Usuario, String>("name"));
        
        tbvUsers.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        showDetails(null);
        
        tbvUsers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {        
            @Override
            public void changed(ObservableValue <? extends Usuario> observable,
                Usuario oldValue, Usuario newValue) {
                showDetails(newValue);
            }
        });
    }    
    
    private void showDetails(Usuario user){
        if(user == null){
            lblPhone.setText("");
            lblAddress.setText("");
        }else{
            lblPhone.setText(user.getPhone());
            lblAddress.setText(user.getAddress());
        }
    }
    
}
