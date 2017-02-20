package EventHandlers;

import PwpCreateComponents.Models;
import PwpCreateComponents.ModelsPopUpMenuList;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Ayettey on 13/02/2017.
 */
public class ProjectModelEventHandler extends ModelsPopUpMenuList implements MouseListener,TreeModelListener,TreeSelectionListener {

    private Models models;
    private JMenuItem eventModelHandlerItems;
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu eventModelHandlerMenu;




    public ProjectModelEventHandler(Models models){

        this.models=models;



    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }



    @Override
    public void mousePressed(MouseEvent e) {



            TreePath path = models.treeNodes.getSelectionPath();
            System.out.println(path);
            Object node = path.getLastPathComponent();
            Object notSelectable = models.treeNodes.getModel().getRoot();




        if((e.getModifiers() & InputEvent.BUTTON3_MASK )!=0  && models.treeNodes.getSelectionCount() !=0){

            String getNodeSetText=node.toString();

            if(node==notSelectable){

                eventModelHandlerMenu.setEnabled(false);

            }else if(getNodeSetText.equals("Business Model")) {
                System.out.println(node);
                businessPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }else if(getNodeSetText.equals("Business Interaction")) {
                System.out.println(node);
                businessInteractionPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }else if(getNodeSetText.equals("Application Models")) {
                System.out.println(node);
                applicationModelPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }else if(getNodeSetText.equals("Technology Models")) {
                System.out.println(node);
               technologyModelPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }else if(getNodeSetText.equals("Motivation Models")) {
                System.out.println(node);
                motivationModelPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }else if(getNodeSetText.equals("Implementation And Migration  Models")) {
                System.out.println(node);
                implementationAndMigrationModelPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }else if(getNodeSetText.equals("Connector")) {
                System.out.println(node);
                connectorModelPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }else if(getNodeSetText.equals("Relations")) {
                System.out.println(node);
                relationsPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }else if(getNodeSetText.equals("Views")) {
                System.out.println(node);
                viewsModelsPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }else if(getNodeSetText.equals("Default View")) {
                System.out.println(node);
                defaultViewPopUpMenu(e.getX(),e.getY(),models.treeNodes);

            }

        }







    }





    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void treeNodesChanged(TreeModelEvent e) {

    }

    @Override
    public void treeNodesInserted(TreeModelEvent e) {

    }

    @Override
    public void treeNodesRemoved(TreeModelEvent e) {

    }

    @Override
    public void treeStructureChanged(TreeModelEvent e) {

    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        System.out.println("Selected");
    }


}
