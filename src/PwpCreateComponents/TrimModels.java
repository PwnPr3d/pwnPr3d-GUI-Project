package PwpCreateComponents;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * Created by Ayettey on 05/03/2017.
 */
public class TrimModels  extends DefaultTreeCellRenderer {



    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        tree.setRowHeight(20);
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

            }

            else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Actor")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Role")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Role")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Collaboration")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Interface")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Function")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Process")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }else if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Event")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                tree.setToolTipText("Default View");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Product")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Contract")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Service")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Value")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Meaning")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }

            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Representation")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Representation")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Business Object")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Location")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Component")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }

            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Collaboration")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Component")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Interface")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Service")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Function")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Application Interaction")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }
            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Data Object")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }


            if(((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())
                    .getBusinessInteractionAndDefaultView().equals("Default View")){
                setIcon((((SubFolders) ((DefaultMutableTreeNode)value).getUserObject())).getIcon());
                //tree.setToolTipText("Business Actor");


            }


        }



        return this;


    }
}
