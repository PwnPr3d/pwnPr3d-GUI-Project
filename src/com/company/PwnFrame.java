package com.company;

import EventHandlers.PaletteEventHandler;
import PwpCreateComponents.MenuBarComponents;
import RenderFoldersAndSubFoders.CreateFolders;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ayettey on 02/02/2017.
 */
public class PwnFrame extends JFrame {

    private  JTabbedPane[] tabbedPane=new JTabbedPane[4];
    private  JPanel panel;
    private  JSplitPane[] splitLayersOfPan;
    private JEditorPane editorPane;
    private  JTabbedPane[] tabbeds;
    private CreateFolders folders=new CreateFolders();
    private PaletteEventHandler handler=new PaletteEventHandler();



   public  PwnFrame()  {


       /*Create MenuBarComponent instance
         JScrollPane,JSplitPane,JTabbedPane and put Component on their instance
        */

       try{
           UIManager.setLookAndFeel(new WindowsLookAndFeel());
           setDefaultLookAndFeelDecorated(true);

           MenuBarComponents menuBar=new MenuBarComponents();
           menuBar.setBackground(new Color(142, 208, 255));
           Container pane=getContentPane();
           pane.setLayout(new BorderLayout());

           setJMenuBar((menuBar.menuBarList()));
           ImageIcon icon=new ImageIcon((getClass().getResource("/PwpIcons/windowDecorator/favicon_1.png") ));
           Image image=icon.getImage();
           setIconImage(image);








           panel=new JPanel(new BorderLayout());
           splitLayersOfPan=new JSplitPane[4];
           tabbeds=new JTabbedPane[4];
           editorPane=new JEditorPane();

           new PaletteEventHandler().revalidate();
              add(new PwnPane().mainPane(panel,splitLayersOfPan,folders.label,
                      new JTextArea("Add documentation relating to this object here")
                      ,tabbedPane,folders,folders.labels,editorPane));








               setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

               setExtendedState(MAXIMIZED_BOTH);

               setVisible(true);
           } catch (UnsupportedLookAndFeelException e) {
               e.printStackTrace();
           }
   }


  //    } catch (UnsupportedLookAndFeelException e) {
  //        e.printStackTrace();
  //    }
  //
  //
  //
  //
  //    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  //
  //       // UIManager.setLookAndFeel(new NimbusLookAndFeel());
  //
  //     setVisible(true);
  //     setBackground(new Color(108, 162, 204));
  //
  //
  //     setExtendedState(MAXIMIZED_BOTH);
  //
  //
  //    }




}
