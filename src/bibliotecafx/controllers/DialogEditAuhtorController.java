/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.controllers;

import bibliotecafx.MainApp;
import bibliotecafx.MainApp.CrudOperation;
import bibliotecafx.helpers.Dialogs;
import bibliotecafx.models.Autor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eddi
 */
public class DialogEditAuhtorController implements Initializable {
    
    @FXML
    private TextField txtName;
    
    private Stage dialogStage;
    private Autor author;
    private boolean ClikedOk;
    private MainApp.CrudOperation operation;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setOperation(MainApp.CrudOperation operation) {
        this.operation = operation;
    }
    
    public void setAuthor(Autor author) {
        this.author = author;
        
        txtName.setText(author.getName());
    }
    
    public boolean ClikedOk(){
        return this.ClikedOk;
    }
    
    @FXML
    private void addAccept(){
        if(isAuthorValid()){
            author.setName(txtName.getText());
            if (operation.equals(CrudOperation.Create)){
                ClikedOk = Autor.insertAuthor(author);
            }
            if (operation.equals(CrudOperation.Update)){
                ClikedOk = Autor.editAuhor(author);
            }
            dialogStage.close();
        }
    }
    
    @FXML
    private void addCancel(){
        dialogStage.close();
    }
    
    private boolean isAuthorValid(){
        if(txtName.getText() == null || txtName.getText().length() == 0){
            Alert error = Dialogs.getDialog(Alert.AlertType.ERROR, "BibliotecaFX", null, "Invalid Name, "
                    + "Please enter a value!");
            error.showAndWait();
            txtName.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
