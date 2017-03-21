package EventHandlers;

import PwpCreateComponents.Folders;
import PwpCreateComponents.PopUpMenuListComponents;
import PwpCreateComponents.SubFolders;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by Ayettey on 23/02/2017.
 */
public class ComponentActionEvents extends PopUpMenuListComponents {

    private String getItems;


    DefaultMutableTreeNode cloneNode;
    DefaultMutableTreeNode nodeToReplicate;
    DefaultMutableTreeNode newNodeReplicated;

    DefaultTreeModel insertReplicateModel;
    Icon icon = new ImageIcon(getClass().getResource("/PwpIcons/actions/addFacesSupport.png"));
    Folders createFolders;


    String clip;

    public String getClip() {
        return clip;
    }

    public void setClip(String clip) throws IOException, UnsupportedFlavorException {


        Clipboard clipper = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection txt = new StringSelection(clip);
        clipper.setContents(txt, txt);

        this.clip = (clipper.getData(DataFlavor.stringFlavor).toString());
    }


    DefaultMutableTreeNode newNode;

    private DefaultMutableTreeNode deepClone(DefaultMutableTreeNode source) {
        newNode = (DefaultMutableTreeNode) source.clone();
        for (Enumeration enumerate = source.children(); enumerate.hasMoreElements(); ) {
            deepClone((DefaultMutableTreeNode) enumerate.nextElement());

        }

        return newNode;
    } //end of deepClone


    public DefaultMutableTreeNode getNewNode() {
        return newNode;
    }

    public ActionListener eventHandler(JTree treeNode, JMenuItem item) {

        ArrayList<String> addItems = new ArrayList<>();

        ActionListener listen = new ActionListener() {


            public DefaultMutableTreeNode node;
            public DefaultMutableTreeNode newNodes;

            @Override
            public void actionPerformed(ActionEvent e) {


                for (String x : addItems)
                    node = new DefaultMutableTreeNode(x);

                if (item.getText().equals("Delete")) {


                    delete(treeNode);

                } else if (item.getText().equals("Folder")) {


                    while (userObject.toString().equals(""))

                        userObject=JOptionPane.showInputDialog(null,"The text must not be empty",
                                "New Folder",SwingConstants.CENTER,icon,null,null);

                    newFolder(treeNode,userObject);

                } else if (item.getText().equals(e.getActionCommand())) {

                    if (!e.getActionCommand().equals("Folder") && !(e.getActionCommand().equals("Rename"))
                            && !(item.getText().equals("Duplicate")) && !(item.getText().equals("Paste"))
                            && !(item.getText().equals("Copy"))) {
                        allBusinessActivities(treeNode, e.getActionCommand(), item.getIcon());


                    } else if (item.getText().equals("Rename")) {
                        rename(treeNode);
                        System.out.println("Those is what was date" + item.getText());

                    } else if (item.getText().equals("Duplicate")) {
                        duplicate(treeNode, e.getActionCommand(), item.getIcon());


                    }
                    if (item.getText().equals("Copy")) {

                        TreePath[] paths = treeNode.getSelectionPaths();
                        DefaultTreeModel model = (DefaultTreeModel) treeNode.getModel();
                        for (int i = 0; i < paths.length; i++) {
                            newNodes = (DefaultMutableTreeNode) paths[i].getLastPathComponent();


                            deepClone(new DefaultMutableTreeNode(newNodes.getUserObject()));

                            try {
                                setClip(paths[i].getLastPathComponent().toString());
                            } catch (Exception x) {
                                x.printStackTrace();
                            }

                        }


                        System.out.println("Copy");

                    }


                    if (item.getText().equals("Paste")) {

                        try {
                            System.out.println("paste" + getNewNode());
                            TreePath paths[] = treeNode.getSelectionPaths();
                            DefaultTreeModel model = (DefaultTreeModel) treeNode.getModel();


                            createFolders = new Folders();


                            for (int i = 0; i < paths.length; i++) {
                                String itemName = paths[i].getLastPathComponent().toString();

                                if ((itemName.startsWith(itemName))) {


                                    if (itemName.equals("")) {
                                        return;
                                    } else {
                                        createFolders.setSubFolders(new SubFolders(getClip(), icon));
                                    }


                                }


                            }


                            for (int i = 0; i < paths.length; i++) {


                                newNodes = (DefaultMutableTreeNode) paths[i].getLastPathComponent();


                                for (int x = 0; x < createFolders.getSubFolders().size(); x++) {


                                    //  if(itemName.equals("Business Model"))
                                    if (getNewNode().getUserObject().equals("")) {

                                        return;
                                    } else {
                                        model.insertNodeInto(getNewNode(),
                                                (MutableTreeNode) newNodes, newNodes.getChildCount());
                                        deepClone(getNewNode());
                                        // treeNode.expandPath(paths[i]);

                                    }

                                }


                                //model.reload();

                                //tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
                                //ToolTipManager.sharedInstance().registerComponent(treeNode);


                                // treeNode.expandPath(paths[i]);
                            }


                        } catch (Exception x) {
                            x.printStackTrace();
                        }

                    }


                }


            }



        }; return listen;
    }
}
