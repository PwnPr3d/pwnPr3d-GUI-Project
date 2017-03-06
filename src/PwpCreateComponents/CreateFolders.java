package PwpCreateComponents;


import EventHandlers.ProjectModelEventHandler;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;


/**
 * Created by Ayettey on 10/02/2017.
 */
public class CreateFolders extends DefaultTreeCellRenderer{







    public DefaultMutableTreeNode newModels;
    public JTree treeNodes;
    private JPopupMenu menuPopUp;
    private  JMenuItem popUpItems;
    private JEditorPane pane;
    private JPanel modelPanel;
    private JLabel []paletteNetworkObjects;
    private ImageIcon paletteImages;

    private ImageIcon modelIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/module.png"));
    private ImageIcon folderIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-open.png"));
    private ImageIcon expandedIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/expandall.png"));
    private ImageIcon collapseIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/collapseall.png"));
    private ImageIcon defaultViewIcon = new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/models.gif"));





    public ProjectModelEventHandler modelHandler=new ProjectModelEventHandler(this);







    public JComponent modelTree(){



        //Initialize tree objects

        Model modelRoot=new Model();
        modelRoot.setModels("Models");
        modelRoot.setIcon(modelIcon);
        modelRoot.setCollapseIcon(collapseIcon);

        Folders businessModel=new Folders();
        businessModel.setNodes("Business Model");
        businessModel.setSubFolders(new SubFolders("Business Interaction",folderIcon));
        businessModel.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(businessModel);






        Folders applicationModels=new Folders();
        applicationModels.setNodes("Application");
        applicationModels.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(applicationModels);

        Folders technologyModels=new Folders();
        technologyModels.setNodes("Technology");
        technologyModels.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(technologyModels);

        Folders motivationModels=new Folders();
        motivationModels.setNodes("Motivation");
        motivationModels.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(motivationModels);

        Folders implementationAndMigrationModels=new Folders();
        implementationAndMigrationModels.setNodes("Implementation And Migration");
        implementationAndMigrationModels.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(implementationAndMigrationModels);

        Folders relations=new Folders();
        relations.setNodes("Relations");
        relations.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(relations);

        Folders connector=new Folders();
        connector.setNodes("Connector");
        connector.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(connector);

        Folders views=new Folders();
        views.setNodes("Views");
        views.setSubFolders(new SubFolders("Default View",defaultViewIcon));
        views.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(views);



        Folders networkAnalysis=new Folders();
        networkAnalysis.setNodes("Network Analysis");
        networkAnalysis.setIcon(folderIcon);
        modelRoot.setNodesOfFolders(networkAnalysis);




        DefaultMutableTreeNode root=new DefaultMutableTreeNode(modelRoot);

        //Initialize Tree Nodes








       for(Folders folders:modelRoot.getNodesOfFolders()){

           DefaultMutableTreeNode nodes=new DefaultMutableTreeNode(folders);

           for(SubFolders subFolders:folders.getSubFolders()){



               nodes.add(new DefaultMutableTreeNode(subFolders));
           }

           root.add(nodes);




       }

        DefaultTreeModel model=new DefaultTreeModel(root);
        treeNodes=new JTree();
        treeNodes.setModel(model);

        //Set the tree cell editable true and show handle of the root
        treeNodes.setEditable(true);
        treeNodes.setShowsRootHandles(true);




        //create a renderer object for the treeNods using DefaultTreeCellRenderer








        treeNodes.setCellRenderer(new TrimModels());


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
         layout.setHgap(-150);
         layout.setVgap(-120);

        modelPanel=new JPanel(layout);
        modelPanel.setBackground(modelPanel.getBackground());
        modelPanel.setBorder(new LineBorder(new Color(0x9C353E),1,true));

        pane.setLayout(new BorderLayout());

        paletteNetworkObjects=new JLabel[25];

        for(int i=1;i<paletteNetworkObjects.length;i++){


            paletteImages=new ImageIcon(new ImageIcon(getClass().getResource("/PaletteIconsNetworkIcons/NetworkAndActivities" +
                    "/pwp-computer-analyzer-"+i+".png")).getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT));

            paletteNetworkObjects[i]=new JLabel(paletteImages,JLabel.CENTER);
            paletteNetworkObjects[i].setCursor(new Cursor(12));



            modelPanel.add(paletteNetworkObjects[i]);


        }

        pane.add(modelPanel,BorderLayout.CENTER);





        return pane;
    }





}
