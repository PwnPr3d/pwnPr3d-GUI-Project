package com.company;

import PwpCreateComponents.Models;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ayettey on 16/02/2017.
 */
public class PwnPane extends Models {
    private JTabbedPane[] tabbes;
    private JSplitPane[] splitLayersOfPan;
    private JPanel panel;



    public PwnPane(){
        createPane();

    }

    public JComponent createPane(){
      panel=new JPanel(new BorderLayout());
      splitLayersOfPan=new JSplitPane[4];
      tabbes=new JTabbedPane[2];


        projectView();
        modelView();
        palette();
        modelProperties();







        splitLayersOfPan[2]=new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitLayersOfPan[0],splitLayersOfPan[1]);
        splitLayersOfPan[2].setContinuousLayout(true);
        splitLayersOfPan[2].setDividerSize(25);
        splitLayersOfPan[2].setOneTouchExpandable(true);
        splitLayersOfPan[2].setDividerLocation(400);

      panel.add(splitLayersOfPan[2],BorderLayout.CENTER);
      return panel;

    }

    public JComponent projectView(){

        splitLayersOfPan[0]=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        //Project view
        tabbes[0]=new JTabbedPane();
        tabbes[0].addTab("Project",new ImageIcon(getClass().getResource("/PwpIcons/general/projectTab.png")),new JScrollPane(modelTree()));

        splitLayersOfPan[0].add(new JScrollPane(tabbes[0]));
        splitLayersOfPan[0].setDividerSize(20);
        splitLayersOfPan[0].setContinuousLayout(true);
        splitLayersOfPan[0].setOneTouchExpandable(true);






     return splitLayersOfPan[0];
    }

    public JComponent modelView(){

        //Model view and palette
        tabbes[0]=new JTabbedPane();
        tabbes[0].addTab("Network model",new ImageIcon(getClass().getResource("/PwpIcons/toolwindows/toolWindowStructure.png")),
                new JScrollPane(new JEditorPane()));
        tabbes[0].addTab("Analysis View",new ImageIcon(getClass().getResource("/PwpIcons/toolbarDecorator/analyze.png"))
                ,new JScrollPane(modelEditor()));

        //splitLayersOfPan[1].setDividerLocation(990);
       return tabbes[0];
    }


    public JComponent palette(){

        tabbes[1]=new JTabbedPane();
        tabbes[1].addTab("Palette",new ImageIcon(getClass().getResource("/PwpIcons/toolwindows/toolWindowPalette.png")),new JScrollPane(paletteModel()));
        tabbes[1].addTab("Network View",new ImageIcon(getClass().getResource("/PwpIcons/general/ellipsis.png")),new JScrollPane(new JTable()));

        splitLayersOfPan[3]=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,tabbes[0],new JScrollPane(tabbes[1]));
        splitLayersOfPan[3].setContinuousLayout(true);
        splitLayersOfPan[3].setDividerLocation(770);
        splitLayersOfPan[3].setDividerSize(20);
        splitLayersOfPan[3].setOneTouchExpandable(true);
        splitLayersOfPan[0].add(splitLayersOfPan[3]);

      








        return  splitLayersOfPan[0];

    }



    public   JComponent modelProperties(){


        tabbes[0]=new JTabbedPane();
        tabbes[0].addTab("Model Properties",new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/properties.gif")),new JScrollPane(new JTable()));
        tabbes[0].addTab("Network View",new ImageIcon(getClass().getResource("/PwpIcons/general/ellipsis.png")),new JScrollPane(new JTable()));

        tabbes[0].addTab("Network View",new ImageIcon(getClass().getResource("/PwpIcons/general/ellipsis.png")),new JScrollPane(new JTable()));

        splitLayersOfPan[1]=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitLayersOfPan[1].add(new JScrollPane(tabbes[0]));
        splitLayersOfPan[1].setContinuousLayout(true);
        splitLayersOfPan[1].setDividerLocation(400);
        splitLayersOfPan[1].setOneTouchExpandable(true);




        return  splitLayersOfPan[1];
    }
}
