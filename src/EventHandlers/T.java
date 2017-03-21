package EventHandlers;

import PwpCreateComponents.CreateFolders;
import PwpCreateComponents.Folders;
import PwpCreateComponents.PopUpMenuListComponents;
import PwpCreateComponents.SubFolders;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by Ayettey on 17/03/2017.
 */



public class T extends PopUpMenuListComponents implements MouseListener,ActionListener {

    JFrame frame = new JFrame("Clip Image");
    Icon icon = new ImageIcon(getClass().getResource("/PwpIcons/actions/addFacesSupport.png"));
    private ImageIcon folderIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-open.png"));
    final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public JMenuItem eventModelHandlerItems;
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu    eventModelHandlerMenu;

    CreateFolders tree;
    Folders createFolders;
    JPopupMenu popupMenu;
    JMenuItem item;
    public DefaultMutableTreeNode newNodes;
    public DefaultMutableTreeNode  insertANode;

    public T(CreateFolders tree) {
        this.tree = tree;
    }


    SubFolders t;

    String clip;

    public String getClip() {
        return clip;
    }

    public  void setClip(String clip) throws IOException, UnsupportedFlavorException {


        Clipboard clipper=Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection txt=new StringSelection(clip);
        clipper.setContents(txt,txt);

        this.clip=(clipper.getData(DataFlavor.stringFlavor).toString());
    }


    DefaultMutableTreeNode newNode;
    private DefaultMutableTreeNode deepClone(DefaultMutableTreeNode source)
    {
        newNode=(DefaultMutableTreeNode)source.clone();
        for(Enumeration enumerate=source.children();enumerate.hasMoreElements();){
            deepClone((DefaultMutableTreeNode)enumerate.nextElement());

        }

        return newNode;
    } //end of deepClone

    DefaultMutableTreeNode folderNode;
    private DefaultMutableTreeNode folderClone(DefaultMutableTreeNode source)
    {
        folderNode=(DefaultMutableTreeNode)source.clone();
        for(Enumeration enumerate=source.children();enumerate.hasMoreElements();){
            folderClone((DefaultMutableTreeNode)enumerate.nextElement());

        }

        return folderNode;
    } //


    public DefaultMutableTreeNode getFolderNode() {
        return folderNode;
    }

    public DefaultMutableTreeNode getNewNode(){
        return newNode;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


        if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 && tree.treeNodes.getSelectionCount() > 0) {
            TreePath[] path=tree.treeNodes.getSelectionPaths();

            try{

                for(int i=0;i<path.length;i++) {
                    insertANode = (DefaultMutableTreeNode) path[i].getLastPathComponent();

                    Object model = tree.treeNodes.getModel().getRoot();

                    final String selectedLeafOrNode = insertANode.getUserObject().toString();

                    if (model.toString().equals(selectedLeafOrNode)) {

                        eventModelHandlerMenu.setEnabled(false);
                        tree.treeNodes.setSelectionRow(1);

                    }
                    if ((path[i].getLastPathComponent().toString().equals("Business Model"))) {
                        businessPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                        // }else if((selectedLeafOrNode.equals("Business Interaction")) ){

                        businessPopUpMenu(e.getX(), e.getY(), tree.treeNodes);


                    } else if ((path[i].getLastPathComponent().toString().equals("Business Interaction"))) {
                        businessPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                    } else if ((path[i].getParentPath().getLastPathComponent().toString().equals("Business Model"))
                            || path[i].getParentPath().getLastPathComponent().toString().equals("Business Interaction")
                            || path[i].getParentPath().getLastPathComponent().toString().equals(getFolderNode().getUserObject().toString())) {
                        // System.out.println("Model" + getFolderNode().getUserObject().toString());
                        trimLeaves(e.getX(), e.getY(), tree.treeNodes);


                    } else if ((path[i].getLastPathComponent().toString().equals("Business Interaction"))) {
                        businessPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                    }
                    if ((path[i].getLastPathComponent().toString().equals(getFolderNode().getUserObject().toString()))) {
                        businessPopUpMenu(e.getX(), e.getY(), tree.treeNodes);
                    }

                }

            }catch (Exception x){

            }






        }
    }

    private void trimTree(int x,int y,JTree treeNodes){




        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);


        eventModelHandlerItems=new JMenuItem("Delete",new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);


        eventModelHandlerItems=new JMenuItem("Rename");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerItems.addActionListener( this);
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Generate view for..");
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Validate model");
        eventModelHandlerItems.addActionListener( this);
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Property");
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
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
    public void trimLeaves(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Delete",new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem();
        eventModelHandlerItems.setText("Duplicate");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,3));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);




        eventModelHandlerItems=new JMenuItem("Rename");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(new JSeparator());


        eventModelHandlerItems=new JMenuItem("Generate view for..");
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Validate model");
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Property");
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
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



        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem(new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setText("Delete");
        items=eventModelHandlerItems.getText();
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);




        eventModelHandlerItems=new JMenuItem("Rename");
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);


        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Collapse",new ImageIcon(getClass().getResource("/PwpIcons/actions/collapseall.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,0));
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Generate view for..");
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Validate model");
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Property");
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));
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

    public DefaultMutableTreeNode businessPopUpMenu(int x,int y,JTree treeNodes){

        eventModelHandlerPopupMenu=new JPopupMenu();
        item=new JMenuItem();


        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerItems.setText("Folder");

        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));



        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Actor");
        eventModelHandlerItems.setIcon(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-actor-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Role");
        eventModelHandlerItems.setIcon(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-role-16.png")));
        item.setText(eventModelHandlerItems.getText());
        item.setIcon(eventModelHandlerItems.getIcon());
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Collaboration",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-collaboration-16.png")));
        item.setText(eventModelHandlerItems.getText());
        item.setIcon(eventModelHandlerItems.getIcon());
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Interface",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interface-16.png")));
        item.setText(eventModelHandlerItems.getText());
        item.setIcon(eventModelHandlerItems.getIcon());
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Function",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-function-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Process",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-process-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Event",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-event-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Interaction",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-interaction-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Product",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-product-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Contract",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-contract-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Service",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-service-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(this);

        eventModelHandlerItems=new JMenuItem("Business Value",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-value-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        //   eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Meaning",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-meaning-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Representation",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-representation-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Business Object",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-object-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems=new JMenuItem("Location",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/archimate/business-location-16.png")));
        eventModelHandlerMenu.add(eventModelHandlerItems);
        eventModelHandlerItems.addActionListener(listenerToItems(treeNodes,eventModelHandlerItems));

        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));

        trimTree(x,y,treeNodes);
        // allBusinessActivities( treeNodes,"Business Actor" ,eventModelHandlerItems.getIcon());




      return  newNode;

    }
        @Override
        public void mouseReleased (MouseEvent e){

        }

        @Override
        public void mouseEntered (MouseEvent e){

        }

        @Override
        public void mouseExited (MouseEvent e){

        }

    @Override
    public void actionPerformed(ActionEvent e) {

     //  if(e.getActionCommand().equals("Copy")){
     //
     //      copy();
     //  }else if(e.getActionCommand().equals("Paste")){
     //
     //       paste();
     //
     //
     //  }else if(e.getActionCommand().equals("Paste")){
     //
     //      paste();
     //
     //
     //  } else if (!e.getActionCommand().equals("Folder") & !(e.getActionCommand().equals("Rename"))
     //          &!(item.getText().equals("Duplicate")) & !(item.getText().equals("Paste"))
     //          & !(item.getText().equals("Copy")) ){
     //
     //      allBusinessActivities(tree.treeNodes,e.getActionCommand()
     //              ,eventModelHandlerItems.getIcon());
     //
     //
     //
     //
     //
     //
     //
     //
     //  }else if (!e.getActionCommand().equals("Delete")){
     //
     //  }
     //
     //  System.out.println(item.getText() +" " + e.getActionCommand() );
     //  //  }



        //}


        }



        ActionListener listenerToItems(JTree treeNode, JMenuItem item){
            ArrayList<String> addItems = new ArrayList<>();
            Icon dialogIcon = new ImageIcon(getClass().getResource("/PwpIcons/actions/newFolder.png"));
            ActionListener listen = new ActionListener() {


                public DefaultMutableTreeNode node;
                public DefaultMutableTreeNode newNodes;

                @Override
                public void actionPerformed(ActionEvent e) {


                    for (String x : addItems) {
                        node = new DefaultMutableTreeNode(x);
                    }

                    if (item.getText().equals("Delete")) {

                        delete(treeNode);

                    } else if (item.getText().equals("Folder")) {


                        UIManager.put("OptionPane.minimumSize",new Dimension(400,130));
                        userObject=JOptionPane.showInputDialog(null,"Enter a new directory","New Folder"
                                ,SwingConstants.CENTER,dialogIcon,null,null);
                        folderClone(new DefaultMutableTreeNode(userObject));

                        while (userObject.toString().equals(""))

                            userObject=JOptionPane.showInputDialog(null,"The text must not be empty",
                                    "New Folder",SwingConstants.CENTER,dialogIcon,null,null);

                        folderClone(new DefaultMutableTreeNode(userObject));

                        newFolder(treeNode,userObject);

                    } else if ((!e.getActionCommand().equals("Folder") )&& (!(e.getActionCommand().equals("Delete"))
                            &&(!(e.getActionCommand().equals("Copy") )&&( !(e.getActionCommand().equals("Paste"))))
                            &&(!(e.getActionCommand().equals("Duplicate") )&&( !(e.getActionCommand().equals("Rename")))))){

                            allBusinessActivities(treeNode, e.getActionCommand(), item.getIcon());


                        } else if (item.getText().equals("Rename")) {
                            rename(treeNode);


                        } else if (item.getText().equals("Duplicate")) {
                            duplicate(treeNode, e.getActionCommand(), item.getIcon());


                        }
                        if (item.getText().equals("Copy")) {
                            copy();
                        }


                        if (item.getText().equals("Paste")) {

                            paste();

                        }





                }



            }; return listen;
        }
        public void copy(){

            TreePath[] paths = tree.treeNodes.getSelectionPaths();
            DefaultTreeModel model = (DefaultTreeModel) tree.treeNodes.getModel();
            for (int i = 0; i < paths.length; i++){
                newNodes = (DefaultMutableTreeNode) paths[i].getLastPathComponent();


                deepClone(new DefaultMutableTreeNode(newNodes.getUserObject()));

                try {
                    setClip(paths[i].getLastPathComponent().toString());
                } catch (Exception x) {
                    x.printStackTrace();
                }

            }

        }

        public void paste(){



            try {
                System.out.println("paste");
                TreePath paths[] = tree.treeNodes.getSelectionPaths();
                DefaultTreeModel model = (DefaultTreeModel) tree.treeNodes.getModel();



                createFolders = new Folders();


                for (int i = 0; i < paths.length; i++) {
                    String itemName = paths[i].getLastPathComponent().toString();
                    newNodes= (DefaultMutableTreeNode) paths[i].getLastPathComponent();

                    if ((itemName.startsWith(itemName))) {


                        if(itemName.equals("")  ){

                            return;
                        }else if ( itemName.equals(getNewNode().getUserObject().toString())){

                            model.insertNodeInto(getNewNode(),
                                    (MutableTreeNode) newNodes.getParent(), newNodes.getChildCount());
                           deepClone(getNewNode());

                            tree.treeNodes.expandPath(paths[i]);
                            //tree.revalidate();


                        }    else{
                            createFolders.setSubFolders( new SubFolders(itemName, icon));
                        }





                    }


                }


                for (int i = 0; i < paths.length; i++) {


                    newNodes = (DefaultMutableTreeNode) paths[i].getLastPathComponent();


                    for (int x = 0; x < createFolders.getSubFolders().size(); x++) {


                        //  if(itemName.equals("Business Model"))
                        if(getNewNode().getUserObject().equals("") ) {

                            return;
                        }else {
                            model.insertNodeInto(getNewNode(),
                                    (MutableTreeNode) newNodes, newNodes.getChildCount());
                            deepClone(getNewNode());
                            tree.treeNodes.expandPath(paths[i]);
                           // tree.revalidate();


                        }

                    }


                    //model.reload();

                    //tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
                    ToolTipManager.sharedInstance().registerComponent(tree);



                    tree.treeNodes.expandPath(paths[i]);
                }


            } catch (Exception x) {
                x.printStackTrace();

            }

        }

    }







