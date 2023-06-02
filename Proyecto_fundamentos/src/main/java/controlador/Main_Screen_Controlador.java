package controlador;

import Modelo.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main_Screen_Controlador {
    private String usuario;

    public void setUsuario(String usuario) {
        this.usuario=usuario;
    }

    @FXML
    private Button Ir_Budget;

    @FXML
    private Button Ir_Foros;

    @FXML
    private Button Ir_goals;

    @FXML
    private Label Laber_1;

    @FXML
    private Button Salir;


    public void Display_Name(){

        Laber_1.setText("Bienvenido: "+ usuario);
    }
    @FXML
    void Logout(ActionEvent event) {
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
    void Pantalla_Budget(ActionEvent event) {
        Stage primaryStage;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Budget.fxml"));
            Parent root = loader.load();
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Budget_Controlador budgetControlador=loader.getController();
            budgetControlador.setUsuario(usuario);
            budgetControlador.Show_Budget();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void Pantalla_Foros(ActionEvent event) {
        Stage primaryStage;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Foro.fxml"));
            Parent root = loader.load();
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Foro_Controlador foroControlador=loader.getController();
            foroControlador.setUsuario(usuario);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void Pantalla_Goals(ActionEvent event) {
        Stage primaryStage;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Goal.fxml"));
            Parent root = loader.load();
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Goal_Controlador goalControlador=loader.getController();
            goalControlador.setUsuario(usuario);
            goalControlador.Mostrar_Metas();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}