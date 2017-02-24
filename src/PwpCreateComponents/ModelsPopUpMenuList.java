package PwpCreateComponents;

import EventHandlers.ProjectModelEventHandler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Ayettey on 15/02/2017.
 */
public class ModelsPopUpMenuList  {


    private JMenuItem eventModelHandlerItems;
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu    eventModelHandlerMenu;
    private ProjectModelEventHandler eventItemHandler;




    public void businessPopUpMenu(int x,int y,JTree treeNodes){
        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Actor",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-actor-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Role",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-role-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Collaboration",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-collaboration-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Interface",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interface-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

     //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Function",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-function-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Process",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-process-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Event",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-event-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Interaction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interaction-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

     //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Product",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-product-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Contract",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-contract-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Service",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-service-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Value",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-value-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

     //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Meaning",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-meaning-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Representation",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-representation-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Object",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-object-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Location",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-location-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));

        trimTree(x,y,treeNodes);






    }


    private void trimTree(int x,int y,JTree treeNodes){


        eventItemHandler=new ProjectModelEventHandler(this);

        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Delete",new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode node;
                DefaultTreeModel treeModel;
                DefaultTreeModel model=(DefaultTreeModel) treeNodes.getModel();
                TreePath []paths=treeNodes.getSelectionPaths();
                TreeModel path=treeNodes.getModel();

                for(int i=0;i<paths.length;i++){

                    node=(DefaultMutableTreeNode) paths[i].getLastPathComponent();
                    model.removeNodeFromParent(node);

                }
            }
        });

        eventModelHandlerPopupMenu.add(eventModelHandlerItems);


        eventModelHandlerItems=new JMenuItem("Rename");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Generate view for..");
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Validate model");
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Property");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, ActionEvent.ALT_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));

        TreePath path=treeNodes.getSelectionPath();
        Object node=path.getLastPathComponent();
        if(node==treeNodes.getModel().getRoot()){
            eventModelHandlerPopupMenu.setEnabled(false);
        }else {
            eventModelHandlerPopupMenu.show(treeNodes,x,y);
        }

    }
    private void trimTreeCollapse(int x,int y,JTree treeNodes){
        eventItemHandler=new ProjectModelEventHandler(this);


        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Delete",new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(eventItemHandler);


        eventModelHandlerItems=new JMenuItem("Rename");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);


        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Collapse",new ImageIcon(getClass().getResource("/PwpIcons/actions/collapseall.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,0));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Generate view for..");
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Validate model");
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Property");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, ActionEvent.ALT_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));

        TreePath path=treeNodes.getSelectionPath();
        Object node=path.getLastPathComponent();
        if(node==treeNodes.getModel().getRoot()){
            eventModelHandlerPopupMenu.setEnabled(false);
        }else {
            eventModelHandlerPopupMenu.show(treeNodes,x,y);
        }

    }
    public void businessInteractionPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Actor",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-actor-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Role",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-role-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Collaboration",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-collaboration-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Interface",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interface-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Function",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-function-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Process",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-process-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Event",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-event-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Interaction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interaction-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Product",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-product-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Contract",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-contract-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Service",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-service-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Value",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-value-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Meaning",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-meaning-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Representation",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-representation-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Object",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-object-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Location",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-location-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));

        trimTree(x,y,treeNodes);





    }
    public void applicationModelPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Application Component",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-component-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Application Collaboration",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-collaboration-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Application interface",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-interface-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Application service",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-service-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

     //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Application Function",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-function-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Application Interaction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-interaction-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Data Object",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/application-data-object-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);


        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));
        trimTree(x,y,treeNodes);


    }
    public void technologyModelPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Artifact",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-artifact-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Communication Path",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-communication-path-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Network",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-network-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Infrastructure Interface",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-infra-interface-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

     //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Infrastructure Function",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-function-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Infrastructure Service",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-infra-service-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Node",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-node-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("System Software",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-system-software-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

     //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Device",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/technology-device-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);


        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));





        trimTree(x,y,treeNodes);




    }
    public void motivationModelPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Stakeholder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/stakeholder-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Driver",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/driver-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Assessment",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/assessment-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Goal",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/goal-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Principle",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/principle-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Requirement",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/requirement-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Constraint",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/constraint-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);


        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));




        trimTree(x,y,treeNodes);




    }
    public void implementationAndMigrationModelPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Work Package",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/workpackage-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Deliverable",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/deliverable-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Plateau",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/plateau-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Gap",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/gap-filled-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));



        trimTree(x,y,treeNodes);



    }
    public void connectorModelPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Junction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/junction-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("And Junction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/junction-and-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Or Junction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/junction-or-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);



        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));






        trimTree(x,y,treeNodes);


    }
    public void relationsPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);




        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));
        trimTree(x,y,treeNodes);




    }
    public void viewsModelsPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("PwnPr3d View");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Sketch View",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/sketch-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Blank Canvas");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Canvas From Template");
        eventModelHandlerMenu.add(eventModelHandlerItems);



        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));


        trimTreeCollapse(x,y,treeNodes);


    }

    public void defaultViewPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerPopupMenu.setBorder(new LineBorder(new Color(130, 173, 255),1,true));
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("PwnPr3d View");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Sketch View",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/sketch-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Blank Canvas");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Canvas From Template");
        eventModelHandlerMenu.add(eventModelHandlerItems);



        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));

         trimTree(x,y,treeNodes);

    }



}
