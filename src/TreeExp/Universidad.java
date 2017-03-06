package TreeExp;

// IconAndTipCarrier.java
// A simple interface that can be used with IconAndTipRenderer
// tree cell renderer.

import javax.swing.*;
import java.util.ArrayList;

public class Universidad {

    private String Nombre;
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private ImageIcon icon = new ImageIcon(getClass().getResource("/PwpIcons/providers/apache.png"));

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void addEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Universidad: " + Nombre ;
    }
}