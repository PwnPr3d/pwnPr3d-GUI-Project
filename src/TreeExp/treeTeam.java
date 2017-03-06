package TreeExp;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Created by Ayettey on 04/03/2017.
 */
public class treeTeam  extends JFrame{

    JTree jTree1;
    private ImageIcon rootIcon = new ImageIcon(getClass().getResource("/PwpIcons/actions/rollback@2x.png"));
    private ImageIcon estudianteIcon = new ImageIcon(getClass().getResource("/PwpIcons/actions/alignbottom.gif"));
    private ImageIcon quimicaIcon = new ImageIcon(getClass().getResource("/PwpIcons/actions/addFacesSupport.png"));
    private ImageIcon calculoIcon = new ImageIcon(getClass().getResource("/PwpIcons/actions/AddMulticaret.png"));
    private ImageIcon javaIcon = new ImageIcon(getClass().getResource("/PwpIcons/actions/aligncenter_d.gif"));
    public treeTeam(){



        //initComponents();

        //Se añade el CellRenderer



        //Se crean los datos para el JTree
        Universidad universidad = new Universidad();
        universidad.setNombre("Universidad de Miskatonic para Enfermos Mentales");
        universidad.setIcon(rootIcon);

        Estudiante esteban = new Estudiante();
        esteban.setId("123");
        esteban.setNombre("Esteban Dido");
        esteban.setCarrera("Medicina");
        esteban.addMateria( new Materia("M235","Química Avanzada","QMA100",23, quimicaIcon));
        esteban.addMateria( new Materia("M899","Biología Básica","BIO432",56));
        esteban.setIcon(estudianteIcon);
        universidad.addEstudiante(esteban);

        Estudiante soila = new Estudiante();
        soila.setId("456");
        soila.setNombre("Soila Cerda");
        soila.setCarrera("Economía");
        soila.addMateria( new Materia("M762","Calculo I","MAT101",0,calculoIcon));
        soila.setIcon(estudianteIcon);
        universidad.addEstudiante(soila);

        Estudiante paco = new Estudiante();
        paco.setId("831");
        paco.setNombre("Paco Mermela");
        paco.setCarrera("Informática");
        paco.setIcon(estudianteIcon);
        universidad.addEstudiante(paco);

        Estudiante aquiles = new Estudiante();
        aquiles.setId("731");
        aquiles.setNombre("Aquiles Baeza");
        aquiles.setCarrera("Ingenieria de Sistemas");
        aquiles.addMateria( new Materia("M540","Calculo I","MAT101",0,calculoIcon));
        aquiles.addMateria( new Materia("M900","Programacion Orientada a Objetos","SIS400",45,javaIcon));
        aquiles.setIcon(estudianteIcon);
        universidad.addEstudiante(aquiles);

        //Se llena el JTree
        //--> Raiz
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(universidad);
        //--> hojas
        for(Estudiante estudiante : universidad.getEstudiantes() )
        {
            DefaultMutableTreeNode estudianteNode = new DefaultMutableTreeNode( estudiante );
            for(Materia materia : estudiante.getMaterias() )
            {
                estudianteNode.add(new DefaultMutableTreeNode(materia));
            }
            root.add(estudianteNode);
        }
        //se crea el model con el root y se añade al JTree
        DefaultTreeModel modelo = new DefaultTreeModel( root );

       jTree1=new JTree();
        jTree1.setModel(modelo);



         jTree1.setCellRenderer( new MyTreeCellRenderer());
        ToolTipManager.sharedInstance().registerComponent( jTree1);





        setVisible(true);
        setContentPane( jTree1);
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();

    }



    public static void main(String [] srg){
        new treeTeam();
    }




}
