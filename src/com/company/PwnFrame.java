package com.company;

import PwpCreateComponents.MenuBarComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ayettey on 02/02/2017.
 */
public class PwnFrame extends JFrame {

   public PwnFrame()  {


       /*Create MenuBarComponent instance
         JScrollPane,JSplitPane,JTabbedPane and put Component on their instance
        */

       MenuBarComponents menuBar=new MenuBarComponents();
       menuBar.setBackground(new Color(142, 208, 255));
       Container pane=getContentPane();
       pane.setLayout(new BorderLayout());

       setJMenuBar((menuBar.menuBarList()));
      // JTabbedPane tabbedPane=new JTabbedPane();
      //
      // tabbedPane.addTab("Project",new ImageIcon(getClass().getResource("/PwpIcons/actions/module.png")),models.modelTree());
      // JScrollPane scrollPane=new JScrollPane(tabbedPane);
      //
      // JSplitPane  splitPane=new JSplitPane();
      // splitPane.setLayout(new BorderLayout());
      // splitPane.add(scrollPane,BorderLayout.EAST);
      // splitPane.setBackground(new Color(108, 162, 204));
      // splitPane.setOneTouchExpandable(true);
      // splitPane.setResizeWeight(0.1);
      // splitPane.setContinuousLayout(true);

       pane.add(new PwnPane().createPane(),BorderLayout.CENTER);
       pane.setBackground(new Color(108, 162, 204));




       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

          // UIManager.setLookAndFeel(new NimbusLookAndFeel());

        setVisible(true);
        setBackground(new Color(108, 162, 204));
        setExtendedState(MAXIMIZED_BOTH);


       }




}
