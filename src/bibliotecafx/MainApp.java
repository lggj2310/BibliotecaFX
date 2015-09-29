/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliotecafx;

import javafx.scene.control.Alert;
import bibliotecafx.helpers.Dialogs;
import bibliotecafx.helpers.DBHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author informatica
 */
public class MainApp extends Application {
    
    private Stage primaryStage;
    private BorderPane vista;
    private Usuario usuarioAutenticado;
      
    public MainApp(){
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BibliotecaFX");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("FXML.fxml"));
            vista = (BorderPane) loader.load();
            FXMLController controller = loader.getController();
            controller.setMainApp(this);
            Scene scene = new Scene(vista);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "BibliotecaFX", null, "Error al cargar el archivo FXML", e);
            error.showAndWait();
            e.printStackTrace();
        }
       
    }
    
    private void mostrarLogin(){
        boolean loginExitoso = false;
        do{
            Dialogs login = Dialogs.getLoginDialog();
            Optional<Usuario> result = login.showAndWait();
            if(result.equals(Optional.empty())){
                System.exit(0);
            }else if(result.isPresent()){                
                usuarioAutenticado = result.get();
                if(usuarioAutenticado.getPassword().length() > 0){
                    DBHelper.setMainApp(this);
                    try {
                        if(!DBHelper.getConnection().isClosed()){
                            loginExitoso = true;
                            Alert welcome = Dialogs.getDialog(Alert.AlertType.INFORMATION, "CET Kinal", null, "Bienvenido al sistema " + usuarioAutenticado.getUser());
                            welcome.showAndWait();
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Alert error = Dialogs.getErrorDialog(Alert.AlertType.ERROR, "CET Kinal", null, "Error al establecer una conexion a la base de datos", ex);
                        error.showAndWait();
                    }
                }
                else{
                    Alert error = Dialogs.getDialog(Alert.AlertType.ERROR, "CET Kinal", null, "Datos incorrectos, debe ingresar una contraseña");
                    error.showAndWait();
                }
            }
        }while(loginExitoso == false);
        
    }
    
    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
