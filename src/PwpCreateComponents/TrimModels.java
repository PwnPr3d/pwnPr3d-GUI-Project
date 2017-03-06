package PwpCreateComponents;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;

/**
 * Created by Ayettey on 05/03/2017.
 */
public class TrimModels  extends DefaultTreeCellRenderer {


    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        tree.setRowHeight(18);
        if(sel)
            setBackground(new Color(0xFF4F59));

        if(tree.getModel().getRoot().equals((DefaultMutableTreeNode)value ) ){
            setIcon(((Model)((DefaultMutableTreeNode)value).getUserObject()).getIcon());
            tree.setToolTipText("Model");
        }
        if( ((DefaultMutableTreeNode) value).getUserObject() instanceof Folders){
             //System.out.println(((DefaultMutableTreeNode) value).getUserObject().toString());
            setIcon(((Folders)((DefaultMutableTreeNode)value).getUserObject()).getIcon());


        }

        if(((DefaultMutableTreeNode)value).getUserObject() instanceof SubFolders ){
            if(((SubFolders) ((DefaultMutableTreeNode) value).getUserObject())

                    .getBusinessInteraction().equals("Business Interaction")){
                setIcon(((SubFolders)((DefaultMutableTreeNode)value).getUserObject()).getIcon());
                tree.setToolTipText("Business Interaction");

            }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Default View")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setToolTipText("Default View");


            }

            else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Actor")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
             DefaultMutableTreeNode node;
            TreePath []paths=  tree.getSelectionPaths();
            DefaultTreeModel model= (DefaultTreeModel) tree.getModel();
           try {

               for (int i = 0; i < paths.length; i++) {
                   node = (DefaultMutableTreeNode) paths[i].getLastPathComponent();
                   if (node.getUserObject().equals("Business Actor")) {
                       setIcon((((SubFolders) ((DefaultMutableTreeNode) value).getUserObject())).getIcon());
                       tree.setToolTipText("Business Actor");

                       System.out.println("Yeah");


                   }
               }
           }catch (Exception e){

           }


        }



        return this;


    }
}
