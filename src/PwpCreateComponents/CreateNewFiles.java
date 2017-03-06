package PwpCreateComponents;

import javax.swing.*;

/**
 * Created by Ayettey on 05/03/2017.
 */
public class CreateNewFiles {


    private ImageIcon filesIcons=new ImageIcon("/PwpIcons/OtherImages/fldr_obj.gif");
     private String files;

    public CreateNewFiles(String files,ImageIcon filesIcons){
        this.files=files;
        this.filesIcons=filesIcons;
    }


    public void setFiles(String files) {
        this.files = files;
    }

    public Icon getFilesIcons() {
        return filesIcons;
    }

    public void setFilesIcons(ImageIcon filesIcons) {
        this.filesIcons = filesIcons;
    }

    public String getFiles() {
        return files;
    }


}

