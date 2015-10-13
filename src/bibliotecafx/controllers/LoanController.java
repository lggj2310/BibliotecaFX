/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.controllers;

import bibliotecafx.MainApp;
import bibliotecafx.models.Prestamo;
import java.net.URL;
import java.util.Date;
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
public class LoanController implements Initializable {
    
    @FXML
    private TableView<Prestamo> tbvLoans;
    @FXML
    private TableColumn<Prestamo, String> tbcId;
    @FXML
    private TableColumn<Prestamo, String> tbcidUser;
    @FXML
    private TableColumn<Prestamo, String> tbcidCopy;
    
    @FXML
    private Label lbldateLoan;
    
    @FXML
    private Label lblreturnDate;
    
    private MainApp mainApp;
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tbvLoans.setItems(mainApp.getLoansList());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbcId.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("id"));
        tbcidUser.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("idUser"));
        tbcidCopy.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("idCopy"));
        
        tbvLoans.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        showDetails(null);
        
        tbvLoans.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Prestamo>() {        
            @Override
            public void changed(ObservableValue <? extends Prestamo> observable,
                Prestamo oldValue, Prestamo newValue) {
                showDetails(newValue);
            }
        });
    }    
    
    
    private void showDetails(Prestamo loan){
        if(loan == null){
            lbldateLoan.setText("");
            lblreturnDate.setText("");
        }else{
            lbldateLoan.setText(loan.getDateLoan().toString());
            if((loan.getReturnDate()) != null){
                lblreturnDate.setText((loan.getReturnDate()).toString());
            }
        }
    }
}
