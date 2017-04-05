package RenderFoldersAndSubFoders;


import EventHandlers.FolderAndFileEventHandler;
import RenderFoldersAndSubFoders.FolderAndFileCellEditor.TrimModels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;


/**
 * Created by Ayettey on 10/02/2017.
 */
public class CreateFolders extends TransferHandler{







    public DefaultMutableTreeNode newModels;
    public JTree treeNodes;
    private JPopupMenu menuPopUp;
    private  JMenuItem popUpItems;
    private JEditorPane pane;
    private JPanel modelPanel;
    private JLabel []paletteNetworkObjects;
    private ImageIcon paletteImages;
    DefaultMutableTreeNode nodes;
    DefaultMutableTreeNode root;
    int count=0;

    private ImageIcon modelIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/module.png"));
    private ImageIcon folderIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/menu-open.png"));
    private ImageIcon expandedIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/expandall.png"));
    private ImageIcon collapseIcon=new ImageIcon(getClass().getResource("/PwpIcons/actions/collapseall.png"));
    private ImageIcon defaultViewIcon = new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/models.gif"));

    public JLabel label;



    public FolderAndFileEventHandler modelHandler=new FolderAndFileEventHandler(this);





    Model modelRoot;

    public JComponent modelTree(){



        //Initialize tree objects
       label=new JLabel();
        modelRoot=new Model();
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
        applicationModels.setSubFolders(new SubFolders("Default View",folderIcon));
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






        //Initialize Tree Nodes
        root=new DefaultMutableTreeNode(modelRoot);







       for(Folders folders:modelRoot.getNodesOfFolders()){

            nodes=new DefaultMutableTreeNode(folders);

           for(SubFolders subFolders:folders.getSubFolders()){


               nodes.add(new DefaultMutableTreeNode(subFolders) );
           }

           root.add(nodes);




       }

        DefaultTreeModel model=new DefaultTreeModel(root);
        treeNodes=new JTree();
        treeNodes.setModel(model);
        TreeSelectionModel treeSelectionModel=treeNodes.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
        treeNodes.setSelectionModel(treeSelectionModel);


        //Set the tree cell editable true and show handle of the root
        treeNodes.setDropMode(DropMode.ON);
        treeNodes.setDragEnabled(true);
        treeNodes.setDropTarget(new DropTarget(treeNodes,modelHandler));









        treeNodes.setShowsRootHandles(true);






        treeNodes.setCellRenderer(new TrimModels());
        UIManager.put("Tree.expandedIcon",expandedIcon);
        UIManager.put("Tree.collapsedIcon",collapseIcon);


        treeNodes.addMouseListener(modelHandler);
       //treeNodes.setInvokesStopCellEditing(true);















     return treeNodes;
    }



    private Cursor cursor(int action){
        return (action==DnDConstants.ACTION_MOVE)?
                DragSource.DefaultMoveDrop:DragSource.DefaultCopyDrop;
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
