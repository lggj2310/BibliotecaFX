/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliotecafx;

import bibliotecafx.controllers.AutorController;
import bibliotecafx.controllers.BookController;
import bibliotecafx.controllers.CopyController;
import bibliotecafx.controllers.DialogEditAuhtorController;
import bibliotecafx.controllers.LayoutController;
import bibliotecafx.controllers.LoanController;
import bibliotecafx.controllers.MenuController;
import bibliotecafx.controllers.UserController;
import javafx.scene.control.Alert;
import bibliotecafx.helpers.Dialogs;
import bibliotecafx.helpers.DBHelper;
import bibliotecafx.models.Autor;
import bibliotecafx.models.Libro;
import bibliotecafx.models.Copias;
import bibliotecafx.models.Prestamo;
import bibliotecafx.models.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author informatica
 */
public class MainApp extends Application {
    
    private Stage primaryStage;
    private BorderPane Layout;
    private ObservableList<Autor> autoresList = FXCollections.observableArrayList();
    private ObservableList<Libro> librosList = FXCollections.observableArrayList();
    private ObservableList<Copias> copiasList = FXCollections.observableArrayList();
    private ObservableList<Prestamo> prestamosList = FXCollections.observableArrayList();
    private ObservableList<Usuario> usuariosList = FXCollections.observableArrayList();
    public enum CrudOperation{None, Create, Read, Update, Delete}
    
    public MainApp(){
        
    }
    @Override
    public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("BibliotecaFX");
      try{
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(MainApp.class.getResource("views/RootLayout.fxml"));
          Layout = (BorderPane) loader.load();
          LayoutController controller = loader.getController();
          controller.setMainApp(this);
          Scene scene = new Scene(Layout);
          primaryStage.setScene(scene);
          primaryStage.show();
      }catch(IOException e){
          Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFx", null, "Error al cargar archivos FXML.", e);
          error.showAndWait();
          e.printStackTrace();
      }
      this.autoresList = Autor.getAuthorList();
      this.librosList = Libro.getBookList();
      this.copiasList = Copias.getCopiesList();
      this.prestamosList = Prestamo.getLoansList();
      this.usuariosList = Usuario.getUsersList();
      showViewMenu();
    }
    
    public void showViewAutores(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Autor.fxml"));
            AnchorPane authorsPane = (AnchorPane) loader.load();
            AutorController controller = loader.getController();
            controller.setMainApp(this);
            Layout.setCenter(authorsPane);
        }catch(Exception e){
           Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFx", null, "Error al cargar archivos FXML.", e);
          error.showAndWait();
          e.printStackTrace();
        }
    }
    
    public void showViewLibros(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Libros.fxml"));
            AnchorPane booksPane = (AnchorPane) loader.load();
            BookController controller = loader.getController();
            controller.setMainApp(this);
            Layout.setCenter(booksPane);
        }catch(Exception e){
           Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFx", null, "Error al cargar archivos FXML.", e);
          error.showAndWait();
          e.printStackTrace();
        }
    }
    
    public void showViewCopias(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Copias.fxml"));
            AnchorPane CopiesPane = (AnchorPane) loader.load();
            CopyController controller = loader.getController();
            controller.setMainApp(this);
            Layout.setCenter(CopiesPane);
        }catch(Exception e){
           Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFx", null, "Error al cargar archivos FXML.", e);
          error.showAndWait();
          e.printStackTrace();
        }
    }
    
    public void showViewPrestamos(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Prestamo.fxml"));
            SplitPane LoansPane = (SplitPane) loader.load();
            LoanController controller = loader.getController();
            controller.setMainApp(this);
            Layout.setCenter(LoansPane);
        }catch(Exception e){
           Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFx", null, "Error al cargar archivos FXML.", e);
          error.showAndWait();
          e.printStackTrace();
        }
    }
    
    public void showViewUsuarios(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Usuario.fxml"));
            AnchorPane UsersPane = (AnchorPane) loader.load();
            UserController controller = loader.getController();
            controller.setMainApp(this);
            Layout.setCenter(UsersPane);
        }catch(Exception e){
           Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFx", null, "Error al cargar archivos FXML.", e);
          error.showAndWait();
          e.printStackTrace();
        }
    }
    
    public void showViewMenu(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/Menu.fxml"));
            AnchorPane MenuPane = (AnchorPane) loader.load();
            MenuController controller = loader.getController();
            controller.setMainApp(this);
            Layout.setCenter(MenuPane);
        }catch(Exception e){
           Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFx", null, "Error al cargar archivos FXML.", e);
          error.showAndWait();
          e.printStackTrace();
        }
    }
    
    public boolean ShowEditarAutores(Autor author, CrudOperation operation){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/EditarAutor.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editar Autor");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene escena = new Scene(page);
            dialogStage.setScene(escena);
            dialogStage.setResizable(false);
            DialogEditAuhtorController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setOperation(operation);
            controller.setAuthor(author);
            
            dialogStage.showAndWait();
            
            return controller.ClikedOk();
            
        }
        catch(Exception e){
            e.printStackTrace();
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFX", null, "Error al cargar archivos FXML.", e);
            error.showAndWait();
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public ObservableList<Autor> getAutoresList() {
        return autoresList;
    }

    public ObservableList<Libro> getLibrosList() {
        return librosList;
    }

    public ObservableList<Copias> getCopiasList() {
        return copiasList;
    }

    public ObservableList<Prestamo> getPrestamosList() {
        return prestamosList;
    }

    public ObservableList<Usuario> getUsuariosList() {
        return usuariosList;
    }
    
    
}