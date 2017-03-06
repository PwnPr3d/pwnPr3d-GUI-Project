package TreeExp;

/**
 * Created by Ayettey on 03/03/2017.
 // IconAndTipRenderer.java
 // A renderer for our tree cells that have icons and tooltips.
 //

 **/

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;


public class MyTreeCellRenderer extends DefaultTreeCellRenderer{

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected,expanded, leaf, row, hasFocus);
        //altura de cada nodo
        tree.setRowHeight(26);

        setOpaque(true);
        //color de texto
        setForeground( Color.black );
        if( selected )
            setForeground( Color.red );
        //-- Asigna iconos
        // si value es la raiz
        if ( tree.getModel().getRoot().equals( (DefaultMutableTreeNode) value ) ) {
            setIcon( ((Universidad)((DefaultMutableTreeNode) value).getUserObject()).getIcon() );
        }
         if( ((DefaultMutableTreeNode) value).getUserObject() instanceof Estudiante)
        {
            setIcon( ((Estudiante)((DefaultMutableTreeNode) value).getUserObject()).getIcon() );
            System.out.println("Icon");
        }
         if( ((DefaultMutableTreeNode) value).getUserObject() instanceof Materia)
        {
            setIcon( ((Materia)((DefaultMutableTreeNode) value).getUserObject()).getIcon() );

        }
        return this;
    }

}//end:MyTreeCellRenderernd:MyTreeCellRenderer