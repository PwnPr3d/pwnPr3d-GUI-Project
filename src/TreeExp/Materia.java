package TreeExp;

import javax.swing.*;

/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class Materia {


    private String id;
    private String nombre;
    private String sigla;
    private int nota;
    private ImageIcon icon = new ImageIcon(getClass().getResource("/PwpIcons/providers/cvs.png"));

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Materia(String id, String nombre, String sigla, int nota, ImageIcon icon) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.nota = nota;
        this.icon = icon;
    }

    public Materia(String id, String nombre, String sigla, int nota) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.nota = nota;
    }

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

    public ImageIcon getIcon() {
        return icon;
    }
}
