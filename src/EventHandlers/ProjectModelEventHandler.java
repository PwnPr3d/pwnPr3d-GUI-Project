package EventHandlers;

import PwpCreateComponents.Models;
import PwpCreateComponents.ModelsPopUpMenuList;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.*;

/**
 * Created by Ayettey on 13/02/2017.
 */
public class ProjectModelEventHandler extends ModelsPopUpMenuList implements MouseListener, ActionListener {

    private Models models;
    private JMenuItem eventModelHandlerItems;
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu eventModelHandlerMenu;
    private ModelsPopUpMenuList popUpMenuList;
    private Object nodeSelected;




    public ProjectModelEventHandler(Models models){

        this.models=models;



    }

    public ProjectModelEventHandler(ModelsPopUpMenuList popUpMenuList){

        this.popUpMenuList=popUpMenuList;



    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }



    @Override
    public void mousePressed(MouseEvent e) {

         try {

             System.out.println("This was"+nodeSelected);

            TreePath path = models.treeNodes.getSelectionPath();
            System.out.println(path);
            Object node = path.getLastPathComponent();
            Object nodeNotSelected = models.treeNodes.getModel().getRoot();
             nodeSelected = models.treeNodes.getModel().getRoot();




        if((e.getModifiers() & InputEvent.BUTTON3_MASK )!=0  && models.treeNodes.getSelectionCount() !=0){

            String getNodeSetText=node.toString();

            if(node==nodeNotSelected){

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



         }catch (NullPointerException x){
             models.treeNodes.setSelectionRow(1);

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
    public void actionPerformed(ActionEvent e) {


    }
}
