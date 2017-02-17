package PwpCreateComponents;


import EventHandlers.ProjectModelEventHandler;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * Created by Ayettey on 10/02/2017.
 */
public class Models {







    private DefaultMutableTreeNode[] newModels;
    public JTree treeNodes;
    private JPopupMenu menuPopUp;
    private  JMenuItem popUpItems;
    private JEditorPane pane;


    public ProjectModelEventHandler modelHandler=new ProjectModelEventHandler(this);





    public JComponent modelTree(){


        //Initialize treeNodes
        newModels=new DefaultMutableTreeNode[12];
        newModels[0]=new DefaultMutableTreeNode("Models");
        newModels[1]=new DefaultMutableTreeNode("Business Model");
        newModels[2]=new DefaultMutableTreeNode("Application Models");
        newModels[3]=new DefaultMutableTreeNode("Technology Models");
        newModels[4]=new DefaultMutableTreeNode("Motivation Models");
        newModels[5]=new DefaultMutableTreeNode("Implementation And Migration  Models");
        newModels[6]=new DefaultMutableTreeNode("Connector");
        newModels[7]=new DefaultMutableTreeNode("Relations");
        newModels[8]=new DefaultMutableTreeNode("Views");
        newModels[9]=new DefaultMutableTreeNode("Default View");
        newModels[10]=new DefaultMutableTreeNode("NetWork Analysis");
        newModels[8].add(newModels[10]);
        newModels[11]=new DefaultMutableTreeNode("Business Interaction");
        newModels[1].add(newModels[11]);

        for(int i=1;i<newModels.length;i++){
               if((i>0)&&(i<=9)) {
                   newModels[0].add(newModels[i]);
               }

        }

        treeNodes=new JTree(newModels[0]);

        //Set the tree cell editable true and show handle of the root
        treeNodes.setEditable(true);
        treeNodes.setShowsRootHandles(true);


        //create a renderer object for the treeNods using DefaultTreeCellRenderer

        DefaultTreeCellRenderer changeIcon=new DefaultTreeCellRenderer();
        changeIcon.setLeafIcon(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        changeIcon.setClosedIcon(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        changeIcon.setOpenIcon(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/fldr_obj.gif")));
        treeNodes.setCellRenderer(changeIcon);

        treeNodes.addMouseListener(modelHandler);











     return treeNodes;
    }

    public JComponent modelEditor(){

        pane=new JEditorPane();

        // pieDataset=new DefaultValueDataset(new Integer(90));
        final DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        dataset.addValue(1,"Gate","Fist Attack");
        dataset.addValue(2,"school","Second Attack");
        dataset.addValue(11,"Idle","OFF");
        dataset.addValue(21,"Save it","Grace");
        dataset.addValue(15,"GATE","Open");
        dataset.addValue(13,"Led","Weed");
        dataset.addValue(17,"Low","Make it");
        dataset.addValue(11,"Low","Body");
       // cyclic.centerRange(2);
        JFreeChart X= ChartFactory.createBarChart("Holograme"," "," ",dataset,PlotOrientation.VERTICAL,true,true,false);
        ApplicationFrame frame=new ApplicationFrame("Pie");

        JPanel P=new JPanel();
        X.setBorderPaint(new ChartColor(4,4,4));

        P.add(new ChartPanel(X));
        frame.setContentPane(P);

        pane.setLayout(new BorderLayout());
        pane.add(P);



        return pane;
    }


    
    public JComponent netWorkComponents(){



        return pane;
    }
    public JComponent properties(){



        return new JTree();
    }
    public JComponent validator(){



        return pane;
    }
    public JComponent Palette(){



        return pane;
    }



}
