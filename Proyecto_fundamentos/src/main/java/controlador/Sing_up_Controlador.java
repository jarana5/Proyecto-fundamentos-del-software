package controlador;

import Modelo.Presupuesto;
import Modelo.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Sing_up_Controlador {

    @FXML
    private TextField Re_1con;

    @FXML
    private TextField Re_2con;

    @FXML
    private Label Re_Label;

    @FXML
    private TextField Re_Nombre;

    @FXML
    private Button Re_panting;

    @FXML
    private Button Re_registrarse;

    @FXML
    void Cambiar_Ingresar(ActionEvent event) {
        Stage primaryStage;
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Logged_in.fxml"));
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void Register_User(ActionEvent event) {
       try{
           String Name = Re_Nombre.getText();
           String Password = Re_1con.getText();
           String RPassword = Re_2con.getText();

           Usuarios usuarios = new Usuarios();


           if (Name.isEmpty() || Password.isEmpty() || RPassword.isEmpty()) {
               Re_Label.setText("algunos de los campos esta vacio");
               return;
           }

           if (!Password.equals(RPassword)) {
               Re_Label.setText("Las contraseñas no coinciden");
               return;
           }
           if (usuarios.UserinUse(Name,"0")==true) {
               Re_Label.setText("El usuario ya esta en uso");
               return;
           }
           usuarios.User(Name,Password);
           usuarios.InsertUser();
           Re_Label.setText("Usuario inscrito exitosamente");
           Presupuesto presupuesto=new Presupuesto(Name,0);
           presupuesto.InsertBudget(Name,"0");

       }catch (Exception ex){
           Re_Label.setText("Error");
       }
    }

}
