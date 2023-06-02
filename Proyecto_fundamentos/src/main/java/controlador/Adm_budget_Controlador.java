package controlador;

import Modelo.ArchivosAdmin;
import Modelo.Presupuesto;
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


public class Adm_budget_Controlador {
    private String usuario;
    private Float Budget;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Float getBudget() {
        return Budget;
    }

    public void setBudget(Float budget) {
        Budget = budget;
    }

    @FXML
    private TextField A_Eliminar;

    @FXML
    private TextField A_Pres;

    @FXML
    private Button Ad_Regresar;

    @FXML
    private Button Ad_add;

    @FXML
    private Button Ad_eliminar;

    @FXML
    private Label Ad_label1;

    @FXML
    private Label Ad_label2;


    @FXML
    void Add_presupuesto(ActionEvent event) {

        try{
            String value= A_Pres.getText();
            Presupuesto presupuesto=new Presupuesto(usuario,Budget);
            Float amount=Float.parseFloat(value);
            if(value.isEmpty()){
                Ad_label1.setText("El campo esta vacio");
                return;
            }
            if(amount<0){
                Ad_label1.setText("El valor tiene que ser mayor a 0");
                return;
            }
            presupuesto.addMoney(amount);
            Ad_label1.setText("Se ha añadido "+amount+"El nuevo presupuesto es "+presupuesto.getAmmount());
            this.Budget= presupuesto.getAmmount();
            ArchivosAdmin adm= ArchivosAdmin.getInstance();
            adm.Eliminate_Old_budget(usuario);
            LinkedList<String> datos = new LinkedList<>();
            datos.add(usuario);
            datos.add(Budget.toString());
            adm.writeFile("Budget.txt",datos);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }

    @FXML
    void Elimiar_Presupuesto(ActionEvent event) {
        try{
            String value= Ad_eliminar.getText();
            Presupuesto presupuesto=new Presupuesto(usuario,Budget);
            Float amount=Float.parseFloat(value);
            if(value.isEmpty()){
                Ad_label2.setText("El campo esta vacio");
                return;
            }
            if(amount<0){
                Ad_label1.setText("El valor tiene que ser menor al presupuesto existente");
                return;
            }
            presupuesto.addMoney(amount);
            Ad_label1.setText("Se ha Eliminado "+amount+"El nuevo presupuesto es "+presupuesto.getAmmount());
            this.Budget= presupuesto.getAmmount();
            ArchivosAdmin adm= ArchivosAdmin.getInstance();
            adm.Eliminate_Old_budget(usuario);
            LinkedList<String> datos = new LinkedList<>();
            datos.add(usuario);
            datos.add(Budget.toString());
            adm.writeFile("Budget.txt",datos);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void Regresar_Inicio(ActionEvent event) {
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