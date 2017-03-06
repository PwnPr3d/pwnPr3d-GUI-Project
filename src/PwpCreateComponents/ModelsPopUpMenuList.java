package PwpCreateComponents;

import EventHandlers.ComponentActionEvents;
import EventHandlers.ProjectModelEventHandler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Ayettey on 15/02/2017.
 */
public class ModelsPopUpMenuList  implements ClipboardOwner {


    public JMenuItem eventModelHandlerItems;
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu    eventModelHandlerMenu;
    private ProjectModelEventHandler eventItemHandler;
    private ComponentActionEvents eventHandler;
    public  String items;
    private List temp;
    private ArrayList<String> hashTemp;
    private DefaultMutableTreeNode newFolder;
    private Folders createFiles;
    Object userObject;




    public void businessPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventHandler=new ComponentActionEvents();

        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerItems.setText("Folder");

        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(eventHandler.eventHandler(treeNodes,eventModelHandlerItems));



        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Actor",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-actor-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(eventHandler.eventHandler(treeNodes,eventModelHandlerItems));

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



    public void delete(JTree treeNodes) {


        try{

            DefaultMutableTreeNode node;

            TreePath[] paths = treeNodes.getSelectionPaths();
            DefaultTreeModel model = (DefaultTreeModel) treeNodes.getModel();

            for (int i=0;i<paths.length;i++){
                node = (DefaultMutableTreeNode) paths[i].getLastPathComponent();
                model.removeNodeFromParent(node);

            }

        }catch (NullPointerException x){

        }



    }


    public void newFolder(JTree treeNodes) {

        DefaultMutableTreeNode newNodes;
        Icon icon = new ImageIcon(getClass().getResource("/PwpIcons/actions/newFolder.png"));
        TreePath[] paths = treeNodes.getSelectionPaths();
        DefaultTreeModel model = (DefaultTreeModel) treeNodes.getModel();



        UIManager.put("OptionPane.minimumSize",new Dimension(420,120));
        Object message=JOptionPane.showInputDialog(null,"Enter a new directory","New Folder",SwingConstants.CENTER,icon,null,null);



             hashTemp=new ArrayList<>();



            try {



               System.out.println(userObject.toString());

                if (!message.toString().equals("") && !message.equals(userObject.toString())) {
                    temp = new List();
                    temp.add(message.toString());
                    hashTemp = new ArrayList<>();
                    // ArrayList l=new ArrayList()
                    for (int x = 0; x < temp.getItemCount(); x++) {
                        hashTemp.add(x, temp.getItem(x));
                    }

                } else {
                    while (message.toString().equals(""))
                        message = JOptionPane.showInputDialog(null, "The text field must not be empty", "New Folder", SwingConstants.CENTER, icon, null, null);

                    temp = new List();
                    temp.add(message.toString());
                    hashTemp = new ArrayList<>();
                    // ArrayList l=new ArrayList()
                    for (int x = 0; x < temp.getItemCount(); x++) {
                        hashTemp.add(x, temp.getItem(x));
                    }

                }


                for (int x = 0; x < hashTemp.size(); x++) {

                    newNodes = (DefaultMutableTreeNode) paths[x].getLastPathComponent();


                    model.insertNodeInto(newFolder = new DefaultMutableTreeNode(hashTemp.iterator().next())
                            , newNodes, newNodes.getChildCount());

                    treeNodes.expandPath(paths[x]);


                    System.out.println(temp.getItem(x) + "  size" + temp.getItemCount());

                }

            }catch (Exception e){


                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"No component was created","Empty message",JOptionPane.OK_OPTION);

            }

    }




    DefaultMutableTreeNode newNodes;
    public DefaultTreeModel allBusinessActivities(JTree treeNodes, String itemName) {



        TreePath paths[] = treeNodes.getSelectionPaths();
        DefaultTreeModel model = (DefaultTreeModel) treeNodes.getModel();










          try{





              ImageIcon icon=new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-actor-16.png"));
              createFiles=new Folders();
              createFiles.setSubFolders(new SubFolders(itemName,icon));



              for(int i=0;i<paths.length;i++){


                  newNodes= (DefaultMutableTreeNode) paths[i].getLastPathComponent();

                  System.out.println("This is real" +createFiles.getModels());

                  model.insertNodeInto(newFolder=new DefaultMutableTreeNode(createFiles.getSubFolders().iterator().next()),newNodes,newNodes.getChildCount());




                                   //model.reload();

                                   treeNodes.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
                                   ToolTipManager.sharedInstance( ).registerComponent(treeNodes);






                treeNodes.expandPath(paths[i]);
          }

            }

        catch (Exception e){
             e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No component was created","Empty message",JOptionPane.OK_OPTION);

        }
      return model;
    }

















    public void cut(){
        ClipboardOwner owner=new ClipboardOwner() {
            @Override
            public void lostOwnership(Clipboard clipboard, Transferable contents) {

            }
        };

    }



    private void trimTree(int x,int y,JTree treeNodes){

        eventHandler=new ComponentActionEvents();


        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);


        eventModelHandlerItems=new JMenuItem(new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setText("Delete");
       // items=eventModelHandlerItems.getText();
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));

        eventModelHandlerItems.addActionListener( eventHandler.eventHandler(treeNodes,eventModelHandlerItems));

        eventModelHandlerPopupMenu.addMouseListener(eventItemHandler);
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

        eventHandler=new ComponentActionEvents();

        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem(new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setText("Delete");
        items=eventModelHandlerItems.getText();
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(eventHandler.eventHandler(treeNodes,eventModelHandlerItems));



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
    public void networkAnalysisPopUpMenu(int x,int y,JTree treeNodes){

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


    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        Toolkit kit=Toolkit.getDefaultToolkit();
         clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();



    }


}
