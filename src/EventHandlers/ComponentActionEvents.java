package EventHandlers;

import PwpCreateComponents.Models;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * Created by Ayettey on 23/02/2017.
 */
public class ComponentActionEvents extends Models{

    public void delete(){
        DefaultMutableTreeNode node;
        DefaultTreeModel model=(DefaultTreeModel) treeNodes.getModel();
        TreePath []paths=treeNodes.getSelectionPaths();

        for(int i=0;i<paths.length;i++){
            node= (DefaultMutableTreeNode) paths[i].getLastPathComponent();
            model.removeNodeFromParent(node);
        }

    }
}
