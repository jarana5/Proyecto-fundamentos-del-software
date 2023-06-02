package Modelo;

import javafx.scene.shape.Line;

import java.util.LinkedList;

public class Foro {
    private String Email;
    private String Nombre;
    private String Tema;

    public Foro(String email, String nombre, String tema) {
        Email = email;
        Nombre = nombre;
        Tema = tema;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String tema) {
        Tema = tema;
    }
    public void NewForo(){
        ArchivosAdmin adm=ArchivosAdmin.getInstance();
        LinkedList<String> datos=new LinkedList<>();
        datos.add(getNombre());
        datos.add(getTema());
        datos.add(getEmail());
        adm.writeFile("Foro.txt",datos);
    }
}
