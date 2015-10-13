/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.controllers;

import bibliotecafx.MainApp;
import bibliotecafx.helpers.Dialogs;
import bibliotecafx.models.Autor;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Eddi
 */
public class AutorController implements Initializable {

    
    @FXML
    private TableView<Autor> tbvAuthors;
    @FXML
    private TableColumn<Autor, String> tbcId;
    @FXML
    private TableColumn<Autor, String> tbcName;
    
    @FXML
    private void ClikedMain(){
        mainApp.showViewMenu();
    }
    
    private MainApp mainApp;
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        tbvAuthors.setItems(mainApp.getAuthorsList());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbcId.setCellValueFactory(new PropertyValueFactory<Autor, String>("id"));
        tbcName.setCellValueFactory(new PropertyValueFactory<Autor, String>("name"));
        
        tbvAuthors.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        tbvAuthors.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Autor>() {        
            @Override
            public void changed(ObservableValue <? extends Autor> observable,
                Autor oldValue, Autor newValue) {
            }
        });
    }    
    
  
    @FXML
    private void addAuthor(){
        Autor authorTemp = new Autor();
        boolean pressAdd = mainApp.ShowDialogEditAuthor(authorTemp, MainApp.CrudOperation.Create);
        if(pressAdd){
            mainApp.getAuthorsList().add(authorTemp);
            Refresh();
        }
    }
    
    @FXML
    private void editAuthor() {
        Autor selectAuthor = tbvAuthors.getSelectionModel().getSelectedItem();
        if (selectAuthor != null) {
            boolean okClicked = mainApp.ShowDialogEditAuthor(selectAuthor, MainApp.CrudOperation.Update);
            if (okClicked) {
                Refresh();
            }

        } else {
            Alert error = Dialogs.getDialog(AlertType.ERROR, "BibliotecaFX", null, "You did not select any field");
            error.showAndWait();
        }
    }
    
    @FXML
    private void deleteAuthor() {
        int selectedIndex = tbvAuthors.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Autor deleteAuthor = tbvAuthors.getSelectionModel().getSelectedItem();
            Alert pregunta = Dialogs.getDialog(AlertType.CONFIRMATION, "BibliotecaFX", null, "You want to delete this author");
            Optional<ButtonType> result = pregunta.showAndWait();
            if (result.get() == ButtonType.OK){
                if(Autor.deleteAuthor(deleteAuthor)){
                    tbvAuthors.getItems().remove(selectedIndex);
                }
            }
        } else {
            Alert error = Dialogs.getDialog(AlertType.ERROR, "BibliotecaFX", null, "You did not select any field");
            error.showAndWait();
        }
    }
    
    private void Refresh(){
        int selectedIndex = tbvAuthors.getSelectionModel().getSelectedIndex();
        tbvAuthors.setItems(null);
        tbvAuthors.layout();
        tbvAuthors.setItems(mainApp.getAuthorsList());
        tbvAuthors.getSelectionModel().select(selectedIndex);
    }
}
