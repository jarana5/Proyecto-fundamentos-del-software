package controlador;

import Modelo.Foro;
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

import java.util.LinkedList;

public class Foro_Controlador {
    private String usuario;

    public void setUsuario(String usuario) {
        this.usuario=usuario;
    }
    @FXML
    private Button C_foro;

    @FXML
    private TextField F_Nombre;

    @FXML
    private TextField F_tema;

    @FXML
    private Button Volver_inicio;

    @FXML
    private Label lab1;

    @FXML
    void Crear(ActionEvent event) {
        String nombre=F_Nombre.getText();
        String tema=F_tema.getText();
        if(nombre.isEmpty()||tema.isEmpty()){
            lab1.setText("LLene todas las casillas para generar un foro");
            return;
        }
        LinkedList<String> datos=new LinkedList<>();
        Foro foro=new Foro(usuario,nombre,tema);
        foro.NewForo();
        lab1.setText("El foro ha sido creado exitosamente");
    }

    @FXML
    void Volver_inicio(ActionEvent event) {
        Stage primaryStage;
        try{
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Main_Screen.fxml"));
            Parent root = loader.load();
            primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Main_Screen_Controlador mainc=loader.getController();
            mainc.setUsuario(usuario);
            mainc.Display_Name();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
