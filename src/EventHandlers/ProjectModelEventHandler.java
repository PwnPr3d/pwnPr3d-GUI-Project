package EventHandlers;

import PwpCreateComponents.CreateFolders;
import PwpCreateComponents.ModelsPopUpMenuList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.*;

/**
 * Created by Ayettey on 13/02/2017.
 */
public class ProjectModelEventHandler extends ModelsPopUpMenuList implements MouseListener,ActionListener{

    private CreateFolders CreateFolders;
    private JMenuItem eventModelHandlerItems;
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu eventModelHandlerMenu;
    private ModelsPopUpMenuList popUpMenuList;
    private DefaultMutableTreeNode leafs;
    private TreePath[]paths;
    private DefaultTreeModel leafsModel;
    private JTree treeNodes;
    public String getItemNames;




    public ProjectModelEventHandler(CreateFolders CreateFolders){

        this.CreateFolders = CreateFolders;



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


            DefaultMutableTreeNode newNodes;
            TreePath path = CreateFolders.treeNodes.getSelectionPath();
            Object node = path.getLastPathComponent();
            Object nodeNotSelected = CreateFolders.treeNodes.getModel().getRoot();
            newNodes = (DefaultMutableTreeNode) path.getLastPathComponent();


            if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 && CreateFolders.treeNodes.getSelectionCount() > 0) {

                String getNodeSetText = node.toString();

                if (nodeNotSelected.equals(node)) {

                    eventModelHandlerMenu.setEnabled(false);
                }


                    if (getNodeSetText.equals("Business Model")) {
                        System.out.println(node);
                        businessPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);
                        //allBusinessActivities(CreateFolders.treeNodes,getNodeSetText,CreateFolders.getIcon());
                        //applicationModelPopUpMenu(e.getX(),e.getY(),CreateFolders.treeNodes);

                    }
                else if (getNodeSetText.equals("Business Interactive")) {
                    System.out.println(node);
                        getItemNames=getNodeSetText;
                    businessPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);
                    //allBusinessActivities(CreateFolders.treeNodes,getNodeSetText,CreateFolders.getIcon());
                    //applicationModelPopUpMenu(e.getX(),e.getY(),CreateFolders.treeNodes);

                } else if (getNodeSetText.equals(node)) {
                        System.out.println(node);
                        getItemNames=getNodeSetText;
                        businessPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                    } else if (getNodeSetText.equals("Application")) {
                        System.out.println(node);
                        getItemNames=getNodeSetText;
                       applicationModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                    }else if(getNodeSetText.equals("Technology")) {
                        getItemNames=getNodeSetText;
                        System.out.println(node);
                        technologyModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);
                    }

             else if (getNodeSetText.equals("Motivation")) {
                        getItemNames=getNodeSetText;
                    System.out.println(node);
                    motivationModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                } else if (getNodeSetText.equals("Implementation And Migration")) {
                        getItemNames=getNodeSetText;
                    System.out.println(node);
                    implementationAndMigrationModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                } else if (getNodeSetText.equals("Connector")) {
                        getItemNames=getNodeSetText;
                    System.out.println(node);
                    connectorModelPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                } else if (getNodeSetText.equals("Relations")) {
                        getItemNames=getNodeSetText;
                    System.out.println(node);
                    relationsPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                } else if (getNodeSetText.equals("Views")) {
                        getItemNames=getNodeSetText;
                    System.out.println(node);
                    viewsModelsPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                } else if (getNodeSetText.equals("Default View")) {
                        getItemNames=getNodeSetText;
                    System.out.println(node);
                    defaultViewPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                } else if (getNodeSetText.equals("Network Analysis")) {
                        getItemNames=getNodeSetText;
                    System.out.println(node);
                    networkAnalysisPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                } else if (getNodeSetText.equals(newNodes.toString())) {
                        getItemNames=getNodeSetText;
                    //  System.out.println(node);
                    businessPopUpMenu(e.getX(), e.getY(), CreateFolders.treeNodes);

                }
            }

        }catch (NullPointerException x){

          CreateFolders.treeNodes.setSelectionRow(CreateFolders.treeNodes.getRowCount());


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
