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
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;



/**
 *
 * @author Eddi
 */
public class Prestamo {
    private int Id;
    private int idUser;
    private int idCopy;
    private Date dateLoan;
    private Date returnDate;

    public Prestamo(int Id, int idUser, int idCopy, Date dateLoan, Date returnDate) {
        this.Id = Id;
        this.idUser = idUser;
        this.idCopy = idCopy;
        this.dateLoan = dateLoan;
        this.returnDate = returnDate;
    }

    public Prestamo() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(int idCopy) {
        this.idCopy = idCopy;
    }

    public Date getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
     public static ObservableList<Prestamo> getLoansList(){
        ObservableList<Prestamo> loans = FXCollections.observableArrayList();
        
        try{
            Connection con = DBHelper.getConnection();
            String sql = "SELECT * FROM Loan";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                Prestamo loan = new Prestamo();
                loan.setId(rs.getInt("id"));
                loan.setIdUser(rs.getInt("idUser"));
                loan.setIdCopy(rs.getInt("idCopy"));
                loan.setDateLoan(rs.getDate("fechaPrestamo"));
                loan.setReturnDate(rs.getDate("fechaDevolucion"));
                
                loans.add(loan);
            }
        }catch(Exception e){
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFX", null, "Failed to load the list of Loans", e);
            error.showAndWait();
        }
        return loans;
    }
}
