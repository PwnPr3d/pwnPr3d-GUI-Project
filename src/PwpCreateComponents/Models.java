package PwpCreateComponents;


import EventHandlers.ProjectModelEventHandler;









import javax.swing.*;
import javax.swing.border.LineBorder;
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
    private JPanel modelPanel;
    private JLabel []paletteNetworkObjects;
    private ImageIcon paletteImages;


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



        pane.setLayout(new BorderLayout());




        return pane;
    }

    public JComponent paletteModel(){

        pane=new JEditorPane();
        GridLayout layout=new GridLayout(6,5);
         layout.setHgap(-15);
         layout.setVgap(-90);

        modelPanel=new JPanel(layout);
        modelPanel.setBackground(modelPanel.getBackground());
        modelPanel.setBorder(new LineBorder(new Color(0x9C353E),1,true));

        pane.setLayout(new BorderLayout());

        paletteNetworkObjects=new JLabel[25];

        for(int i=1;i<paletteNetworkObjects.length;i++){


            paletteImages=new ImageIcon(new ImageIcon(getClass().getResource("/PaletteIconsNetworkIcons/NetworkAndActivities" +
                    "/pwp-computer-analyzer-"+i+".png")).getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));

            paletteNetworkObjects[i]=new JLabel(paletteImages);
            paletteNetworkObjects[i].setCursor(new Cursor(12));



            modelPanel.add(paletteNetworkObjects[i]);


        }

        pane.add(modelPanel,BorderLayout.CENTER);





        return pane;
    }





}
