package TreeExp;

/**
 * Created by Ayettey on 04/03/2017.
 */
import javax.swing.*;
import java.util.ArrayList;

/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class Estudiante {

    private String id;
    private String nombre;
    private String carrera;
    private ArrayList<Materia> materias = new ArrayList<Materia>();
    private ImageIcon emptyIcon = new ImageIcon(getClass().getResource("/PwpIcons/providers/eclipse.png"));
    private ImageIcon icon = new ImageIcon(getClass().getResource("/PwpIcons/providers/sybase.png"));

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String Carrera) {
        this.carrera = Carrera;
    }

    public void addMateria(Materia materia)
    {
        this.materias.add(materia);
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public ImageIcon getIcon() {
        if( materias.size()>0)
            return icon;
        else
            return emptyIcon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Estudiante: " + nombre + " (" + carrera + ")";
    }

}





