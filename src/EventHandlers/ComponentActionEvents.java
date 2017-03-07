package EventHandlers;

import PwpCreateComponents.ModelsPopUpMenuList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Ayettey on 23/02/2017.
 */
public class ComponentActionEvents extends ModelsPopUpMenuList  {

    private int counter;
    private String getItems;
    public ArrayList <String>addItems=new ArrayList<>();

    public void setGetItems(String getItems) {
        this.getItems = getItems;
    }

    public String getGetItems() {
        return getItems;
    }

    public ActionListener eventHandler(JTree treeNode, JMenuItem item){



        ActionListener listen=new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Kill it");

                 counter++;


               if(item.getText().equals("Delete")){
                   System.out.println("Those is what was selected" + item.getText());

                   delete(treeNode);

               } if(item.getText().equals("Folder")){
                   System.out.println("Those is what was selected" + item.getText() + counter);

                   newFolder(treeNode);

               }
                if(item.getText().equals(e.getActionCommand())){
               ;
                   allBusinessActivities(treeNode,e.getActionCommand()
                           ,item.getIcon());




                  System.out.println("Action" + e.getActionCommand() );



               }
                   else {
                   System.out.println("Those is what was date" + item.getText());
               }
                System.out.println("Those is what was selected" + item.getText());
            }


        };
        return listen;
    }








}
