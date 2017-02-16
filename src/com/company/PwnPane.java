package com.company;

import PwpCreateComponents.Models;

import javax.swing.*;
import javax.swing.border.LineBorder;
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

        tabbes=new JTabbedPane[5];
        splitLayersOfPan=new JSplitPane[5];



        splitLayersOfPan[0]=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        tabbes[0]=new JTabbedPane();
        tabbes[0].add(modelTree());
        splitLayersOfPan[0].add(tabbes[0]);
        //splitLayersOfPan[0].setDividerSize(3);



        splitLayersOfPan[1]=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        tabbes[0]=new JTabbedPane();
        tabbes[0].add(modelEditor());
        splitLayersOfPan[1].add(tabbes[0]);
        splitLayersOfPan[1].add(new JTree());


        splitLayersOfPan[1].setContinuousLayout(true);
        splitLayersOfPan[1].setOneTouchExpandable(true);
        splitLayersOfPan[1].setDividerSize(30);
        splitLayersOfPan[1].setDividerLocation(990);



        splitLayersOfPan[2]=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,splitLayersOfPan[0],splitLayersOfPan[1]);
        //TreeNodes
        splitLayersOfPan[2].setContinuousLayout(true);
        splitLayersOfPan[2].setOneTouchExpandable(true);
        splitLayersOfPan[2].setDividerSize(30);
        splitLayersOfPan[2].setDividerLocation(200);




        splitLayersOfPan[3]=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitLayersOfPan[3].add(new JTree());
        splitLayersOfPan[3].setContinuousLayout(true);
        splitLayersOfPan[3].setOneTouchExpandable(true);




        //PropertiesBar

        splitLayersOfPan[4]=new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitLayersOfPan[2],splitLayersOfPan[3]);
        splitLayersOfPan[4].setContinuousLayout(true);
        splitLayersOfPan[4].setOneTouchExpandable(true);
        splitLayersOfPan[4].setDividerSize(30);
        splitLayersOfPan[4].setDividerLocation(450);
        splitLayersOfPan[4].setBorder(new LineBorder(new Color(0x8DC9FF),1,true));


        panel.add(splitLayersOfPan[4],BorderLayout.CENTER);
        panel.setBorder(new LineBorder(new Color(0x8DC9FF),1,true));







      return panel;

    }
}
