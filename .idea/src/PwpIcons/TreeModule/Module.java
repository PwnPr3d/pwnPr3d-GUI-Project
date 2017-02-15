package PwpIcons.TreeModule;

import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Ayettey on 07/02/2017.
 */

class createTreeNodes {

    private Object[] nodes=new Object[1];

    public createTreeNodes(){
        treeNodes();

    }

    public JComponent treeNodes(){

        Vector treeRoot=new Vector(){
            public String toString(){

                return "Project";
            }
        };

        Vector treeRoot1=new Vector(){
            public String toString(){

                return "Model";
            }
        };


        Vector treeRoot2=new Vector(){
            public String toString(){

                return "Others";
            }
        };
        treeRoot.add(treeRoot1);
        treeRoot.add(treeRoot2);
        nodes[0]=treeRoot;
        JTree tree=new JTree(nodes);
        tree.setRootVisible(false);
        tree.setEditable(true);
        return tree;
    }

}
public class  Module extends JTable implements TreeModel {



    private boolean leaves;

    public boolean isLeaves() {
        return leaves;
    }

    public void setLeaves(boolean leaves) {
        this.leaves = leaves;
    }

    public Module(){
        super();

    }

    public JComponent tree(){

        return new JTable();

    }


    @Override
    public Object getRoot() {
        return new JTable();
    }

    @Override
    public Object getChild(Object parent, int index) {
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        return ((TreeNode)parent).getChildCount();
    }

    @Override
    public boolean isLeaf(Object node) {
        setLeaves(true);
        boolean scale;
        if(isLeaves()){
            scale=((TreeNode)node).getAllowsChildren();
        }
        else {
            scale=((TreeNode)node).getAllowsChildren();
        }
        return scale;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {

    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }
}

class getChangableTree implements MutableTreeNode{

    getChangableTree(){
        super();
    }

    @Override
    public void insert(MutableTreeNode child, int index) {
        child.removeFromParent();
        children.insertElementAt(child,index);

        child.setParent(this);

    }

    @Override
    public void remove(int index) {

        MutableTreeNode node=(MutableTreeNode)(children.remove(index));

                node.setParent(null);

    }

    Vector children=new Vector();

    @Override
    public void remove(MutableTreeNode node) {

        remove(children.indexOf(node));

    }


    Object getObject;
    @Override
    public void setUserObject(Object object) {
        getObject=object;

    }

    @Override
    public void removeFromParent() {
        MutableTreeNode parentNode=(MutableTreeNode)getParent();
        if(parentNode!=null){
            remove(parentNode);
        }

    }


    MutableTreeNode mutableTreeNode;
    @Override
    public void setParent(MutableTreeNode newParent) {
        mutableTreeNode=newParent;

    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration children() {
        return null;
    }
}
