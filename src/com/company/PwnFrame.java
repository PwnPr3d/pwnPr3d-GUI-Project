package com.company;

import PwpCreateComponents.MenuBarComponents;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

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

       try{
           UIManager.setLookAndFeel(new WindowsLookAndFeel());

           MenuBarComponents menuBar=new MenuBarComponents();
           menuBar.setBackground(new Color(142, 208, 255));
           Container pane=getContentPane();
           pane.setLayout(new BorderLayout());

           setJMenuBar((menuBar.menuBarList()));
           ImageIcon icon=new ImageIcon((getClass().getResource("/PwpIcons/windowDecorator/favicon_1.png") ));
           Image image=icon.getImage();
           setIconImage(image);


           pane.add(new PwnPane().createPane(),BorderLayout.CENTER);
           pane.setBackground(new Color(108, 162, 204));


       } catch (UnsupportedLookAndFeelException e) {
           e.printStackTrace();
       }




       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

          // UIManager.setLookAndFeel(new NimbusLookAndFeel());

        setVisible(true);
        setBackground(new Color(108, 162, 204));
        setExtendedState(MAXIMIZED_BOTH);


       }




}
