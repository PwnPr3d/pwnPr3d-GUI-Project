package com.company;

import EventHandlers.EditorViewHandler;
import EventHandlers.PaletteEventHandler;
import RenderFoldersAndSubFoders.CreateFolders;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Ayettey on 16/02/2017.
 */
public class PwnPane extends CreateFolders {


    private JPanel titlePanel;
    private String title;



    public  PwnPane(){



    }

    public JComponent mainPane(JPanel panel,JSplitPane splitLayersOfPane[],JTextField textField,JTextArea textArea,
            JTabbedPane[] tabbeds ,CreateFolders createFolders,JLabel labels,JEditorPane editorPane){






          createPane(panel,splitLayersOfPane,textField,textArea,tabbeds,createFolders,labels,editorPane);




        return panel;

    }






    public JPanel createPane(JPanel panel, JSplitPane[] splitLayersOfPan
            , JTextField textField, JTextArea textArea, JTabbedPane tabbeds[],
                             CreateFolders createFolders, JLabel labels,JEditorPane editorPane){


        splitLayersOfPan[0]=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        tabbeds[0]=new JTabbedPane();


        projectView(tabbeds,splitLayersOfPan,createFolders);

        tabbeds[0]=new JTabbedPane();

        modelView(tabbeds,editorPane);


        splitLayersOfPan[1]=new JSplitPane();
        tabbeds[1]=new JTabbedPane();
        palette(tabbeds,splitLayersOfPan);

        splitLayersOfPan[2]=new JSplitPane();
        tabbeds[2]=new JTabbedPane();


        modelProperties(tabbeds,splitLayersOfPan,textField,textArea,labels);











        splitLayersOfPan[2]=new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitLayersOfPan[0],splitLayersOfPan[1]);
        splitLayersOfPan[2].setContinuousLayout(true);
        splitLayersOfPan[2].setDividerSize(25);
        splitLayersOfPan[2].setOneTouchExpandable(true);
        splitLayersOfPan[2].setDividerLocation(400);

      panel.add(splitLayersOfPan[2],BorderLayout.CENTER);
      return panel;

    }

    public JComponent projectView(JTabbedPane tabbeds[],JSplitPane[] splitLayersOfPan,CreateFolders createFolders){

        splitLayersOfPan[0]=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);


        tabbeds[0].addTab("Project",new ImageIcon(getClass().getResource("/PwpIcons/general/projectTab.png")),
                new JScrollPane(createFolders.modelTree()));

        splitLayersOfPan[0].add(new JScrollPane(tabbeds[0]));
        splitLayersOfPan[0].setDividerSize(20);
        splitLayersOfPan[0].setContinuousLayout(true);
        splitLayersOfPan[0].setOneTouchExpandable(true);






     return splitLayersOfPan[0];
    }




    public JComponent modelView(JTabbedPane tabbeds[],JEditorPane editorPane){

        //Model view and palette

        tabbeds[0].addTab("Network model",new ImageIcon(getClass().getResource("/PwpIcons/toolwindows/toolWindowStructure.png")),
                new JScrollPane(new EditorViewHandler()));

        tabbeds[0].addTab("Analysis View",new ImageIcon(getClass().getResource("/PwpIcons/toolbarDecorator/analyze.png"))
                ,new JScrollPane(modelEditor()));

        //splitLayersOfPan[1].setDividerLocation(990);
       return tabbeds[0];
    }


    public JComponent palette(JTabbedPane tabbeds[] ,JSplitPane splitLayersOfPan[]){


        tabbeds[1].addTab("Palette",new ImageIcon(getClass().getResource("/PwpIcons/toolwindows/toolWindowPalette.png")),
                new JScrollPane(new PaletteEventHandler()));

        tabbeds[1].addTab("Network View",new ImageIcon(getClass().getResource("/PwpIcons/general/ellipsis.png")),
                new JScrollPane(new JTable()));


        splitLayersOfPan[3]=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(tabbeds[0]),new JScrollPane(tabbeds[1]));
        splitLayersOfPan[3].setContinuousLayout(true);
        splitLayersOfPan[3].setDividerLocation(70);
        splitLayersOfPan[3].setDividerSize(20);
        splitLayersOfPan[3].setOneTouchExpandable(true);
        splitLayersOfPan[3].setBackground(treeNodes.getBackground());
        splitLayersOfPan[0].add(splitLayersOfPan[3]);



      








        return  new JScrollPane(splitLayersOfPan[0]);

    }


    private  JLabel labelObjects;
    private ImageIcon labelObjectsIcon;

    public void setLabelObjectsIcon(ImageIcon labelObjectsIcon) {
        this.labelObjectsIcon = labelObjectsIcon;
    }

    public ImageIcon getLabelObjectsIcon() {
        return labelObjectsIcon;
    }

    public void setLabelObjects(JLabel labelObjects) {
        this.labelObjects = labelObjects;
    }

    public JLabel getLabelObjects() {
        return labelObjects;
    }




    public  PwnPane(String title, ImageIcon icon ){





       // System.out.println(icon.toString());
        setTitlePanel(title, icon );
        setTitle(title);
        setIcon(icon);
        System.out.println("Label Me "+getLabelObjects());



    }


    public  JComponent properties(JLabel labels,JTextField textField,JTextArea textArea ){


        GridBagConstraints constraints=new GridBagConstraints();
        GridBagLayout layout=new GridBagLayout();
        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.anchor=GridBagConstraints.NORTH;
        constraints.insets=new Insets(5,10,5,10);

        JLabel label=new JLabel("Name:",JLabel.LEFT);
        label.setFont(new Font("",Font.PLAIN,14));


        JPanel mainPropertyPanel=new JPanel(layout);
        JPanel viewPanel=new JPanel(new BorderLayout());
        constraints.gridx=0;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;


        mainPropertyPanel.add(label,constraints);

        constraints.gridx=1;
        constraints.ipady=7;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        textField.setForeground(new Color(0x0B88A3));
        mainPropertyPanel.add(textField,constraints);


        label=new JLabel("Documentation:",JLabel.LEFT);
        label.setFont(new Font("",Font.PLAIN,14));

        constraints.gridx=1;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        mainPropertyPanel.add(label,constraints);


        constraints.gridx=1;
        constraints.ipady=120;
        mainPropertyPanel.add(new JScrollPane(textArea),constraints);



        viewPanel.add(labels,BorderLayout.BEFORE_FIRST_LINE);
        viewPanel.add(mainPropertyPanel,BorderLayout.CENTER);



        JTabbedPane tabbed=new JTabbedPane(SwingConstants.LEFT,JTabbedPane.TOP);




        tabbed.setFont(new Font("",Font.PLAIN,13));
        tabbed.addTab("Main",null,viewPanel,"Orange");



        constraints.gridx=0;
        constraints.ipadx=40;
        mainPropertyPanel=new JPanel();

        DefaultTableModel model=new DefaultTableModel(new Object[]{"Name","Value"},new Integer(10));
        viewPanel=new JPanel();
        JTable table=new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(1200,200));



        mainPropertyPanel.add(new JScrollPane(table),constraints);

        viewPanel.add(mainPropertyPanel,BorderLayout.CENTER);
        tabbed.addTab("Property",null, viewPanel,"");


        return  tabbed;

    }







    public void setTitle(String title) {
        this.title = title;
    }

    public  Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public void setTitlePanel(String title, ImageIcon icon ) {

        titlePanel=new JPanel(new BorderLayout());
        setLabelObjects(new JLabel(title,icon,
                SwingConstants.LEFT));
        getLabelObjects().setFont(new Font("",Font.PLAIN,13));
        getLabelObjects().setForeground(new Color(0x6CA2CC));
        titlePanel.add(getLabelObjects(),BorderLayout.NORTH);
      //  titlePanel.add(properties(),BorderLayout.CENTER);
        this.titlePanel = titlePanel;
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }





    public   JSplitPane modelProperties(JTabbedPane tabbed[], JSplitPane splitLayersOfPan[],
                                        JTextField textField, JTextArea textArea, JLabel labels){


        tabbed[0]=new JTabbedPane();


       tabbed[0].addTab("Model Properties",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/properties.gif")),
                new JScrollPane(properties(labels,textField,textArea)));



        tabbed[0].addTab("Network View",new ImageIcon(getClass().getResource("/PwpIcons/general/ellipsis.png")),
                new JScrollPane(new JTable(new DefaultTableModel(new Object[]{"Name","Value"},new Integer(34)))));

        tabbed[0].addTab("Network View",new ImageIcon(getClass().getResource("/PwpIcons/general/ellipsis.png")),
                new JScrollPane(new JTable()));




        splitLayersOfPan[1]=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitLayersOfPan[1].add(new JScrollPane(tabbed[0]));
        splitLayersOfPan[1].setContinuousLayout(true);
        splitLayersOfPan[1].setDividerLocation(400);
        splitLayersOfPan[1].setOneTouchExpandable(true);






        return  splitLayersOfPan[1];
    }


}
