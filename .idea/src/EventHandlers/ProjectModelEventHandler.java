package EventHandlers;

import PwpCreateComponents.Models;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Ayettey on 13/02/2017.
 */
public class ProjectModelEventHandler implements MouseListener,TreeModelListener,TreeSelectionListener {

    private Models models;
    private JMenuItem eventModelHandlerItems;
    private JPopupMenu eventModelHandlerPopupMenu;
    private JMenu    eventModelHandlerMenu;



    public ProjectModelEventHandler(Models models){

        this.models=models;



    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }



    @Override
    public void mousePressed(MouseEvent e) {




        if((e.getModifiers() & InputEvent.BUTTON3_MASK )!=0  && models.treeNodes.getSelectionCount() !=0){


            BuildModelEventComponents(e.getX(),e.getY());


        }


    }

    public void BuildModelEventComponents(int x,int y){


        eventModelHandlerPopupMenu=new JPopupMenu();
        eventModelHandlerMenu=new JMenu("New");
        eventModelHandlerPopupMenu.add(eventModelHandlerMenu);

        eventModelHandlerPopupMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Folder",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Actor");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Role");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Collaboration");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Interface");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Interaction");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Process");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Event");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Product");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Contact");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Process");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Event");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business product");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Contact");
        eventModelHandlerMenu.add(eventModelHandlerItems);


        eventModelHandlerItems=new JMenuItem("Business Service");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Value");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Meaning");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerMenu.add(new JSeparator());

        eventModelHandlerItems=new JMenuItem("Business Representation");
        eventModelHandlerMenu.add(eventModelHandlerItems);


        eventModelHandlerItems=new JMenuItem("Business Object");
        eventModelHandlerMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Business Location");
        eventModelHandlerMenu.add(eventModelHandlerItems);


        eventModelHandlerItems.setPreferredSize(new Dimension(200,20));

        eventModelHandlerItems=new JMenuItem("Copy",new ImageIcon(getClass().getResource("/PwpIcons/actions/copy.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Paste" ,new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-paste.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Delete",new ImageIcon(getClass().getResource("/PwpIcons/actions/delete.png")));
        eventModelHandlerItems.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,2));
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerItems=new JMenuItem("Rename");
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Generate view for..");
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems=new JMenuItem("Validate model");
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);

        eventModelHandlerPopupMenu.add(new JSeparator());
        eventModelHandlerItems=new JMenuItem("Property");
        eventModelHandlerPopupMenu.add(eventModelHandlerItems);



        eventModelHandlerItems.setPreferredSize(new Dimension(300,20));



        TreePath  path=models.treeNodes.getSelectionPath();
        Object node=path.getLastPathComponent();
        if(node==models.treeNodes.getModel().getRoot()){
            eventModelHandlerPopupMenu.setEnabled(false);
        }else {
            eventModelHandlerPopupMenu.show(models.treeNodes,x,y);
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
