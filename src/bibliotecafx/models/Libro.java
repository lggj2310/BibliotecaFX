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
public class Libro {
    private int Id;
    private String Title;
    private String Isbn;
    private String Editorial;
    private int Pages;

    public Libro(int Id, String Title, String Isbn, String Editorial, int Pages) {
        this.Id = Id;
        this.Title = Title;
        this.Isbn = Isbn;
        this.Editorial = Editorial;
        this.Pages = Pages;
    }

    public Libro() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int Pages) {
        this.Pages = Pages;
    }
    
    public static ObservableList<Libro> getBookList(){
        ObservableList<Libro> books = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM Book";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Libro book = new Libro();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setIsbn(rs.getString("isbn"));
                book.setEditorial(rs.getString("editorial"));
                book.setPages(rs.getInt("pages"));
                
                books.add(book);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFX", null, "Failed to load the list of books", e);
            error.showAndWait();
        }
        return books;
    }
}
