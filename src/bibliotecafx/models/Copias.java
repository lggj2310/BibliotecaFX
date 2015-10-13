/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafx.models;

import bibliotecafx.helpers.DBHelper;
import bibliotecafx.helpers.Dialogs;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Eddi
 */
public class Copias {
    private int Id;
    private String Location;
    private int idBook;

    public Copias(int Id, String Location, int idBook) {
        this.Id = Id;
        this.Location = Location;
        this.idBook = idBook;
    }

    public Copias() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }
    
     public static ObservableList<Copias> getCopiesList(){
        ObservableList<Copias> Copies = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM Copy";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Copias copy = new Copias();
                copy.setId(rs.getInt("id"));
                copy.setLocation(rs.getString("location"));
                copy.setIdBook(rs.getInt("idBook"));
                
                Copies.add(copy);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFX", null, "Failed to load the list of Copies", e);
            error.showAndWait();
        }
        return Copies;
    }
}
