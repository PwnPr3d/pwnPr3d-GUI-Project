package EventHandlers;

import PwpCreateComponents.ModelsPopUpMenuList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ayettey on 23/02/2017.
 */
public class ComponentActionEvents extends ModelsPopUpMenuList  {

    public int counter;

    public ActionListener eventHandler(JTree treeNode,JMenuItem item){



        ActionListener listen=new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Kill it");

                 counter++;


               if(item.getText().equals("Delete")){
                   System.out.println("Those is what was selected" + item.getText());

                   delete(treeNode);

               }else if(item.getText().equals("Folder")){
                   System.out.println("Those is what was selected" + item.getText() + counter);

                   newFolder(treeNode);

               }
               else if(item.getText().equals(e.getActionCommand())){

                   allBusinessActivities(treeNode,e.getActionCommand());
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
