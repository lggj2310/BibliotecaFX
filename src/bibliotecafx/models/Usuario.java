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
public class Usuario {
    private int Id;
    private String Name;
    private String Phone;
    private String Address;

    public Usuario(int Id, String Name, String Phone, String Address) {
        this.Id = Id;
        this.Name = Name;
        this.Phone = Phone;
        this.Address = Address;
    }

    public Usuario() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public static ObservableList<Usuario> getUsersList(){
        ObservableList<Usuario> users = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM Users";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("userAddress"));
                
                users.add(user);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFX", null, "Failed to load the list of Users", e);
            error.showAndWait();
        }
        return users;
    }
    
}
