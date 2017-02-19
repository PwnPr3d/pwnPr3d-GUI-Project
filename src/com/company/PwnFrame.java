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


       pane.add(new PwnPane().createPane(),BorderLayout.CENTER);
       pane.setBackground(new Color(108, 162, 204));




       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

          // UIManager.setLookAndFeel(new NimbusLookAndFeel());

        setVisible(true);
        setBackground(new Color(108, 162, 204));
        setExtendedState(MAXIMIZED_BOTH);


       }




}
