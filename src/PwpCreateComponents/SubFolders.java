package PwpCreateComponents;

import javax.swing.*;

/**
 * Created by Ayettey on 05/03/2017.
 */
public class SubFolders {

    private String defaultView;
    private String businessInteractionAndDefaultView;
    private String files;
    private ImageIcon changeIcon= new ImageIcon("/PwpIcons/OtherImages/fldr_obj.gif");
    private ImageIcon defaultViewIcon = new ImageIcon("/PwpIcons/OtherImages/default_model_thumb.png");
    private Icon icon = new ImageIcon("/PwpIcons/OtherImages/aligncenter.gif");




    public SubFolders(String businessInteractionAndDefaultView,Icon icon) {
        this.businessInteractionAndDefaultView = businessInteractionAndDefaultView;
        this.icon=icon;

    }

    public void setBusinessInteractionAndDefaultView(String businessInteractionAndDefaultView) {
        this.businessInteractionAndDefaultView = businessInteractionAndDefaultView;
    }

    public void setChangeIcon(ImageIcon changeIcon) {
        this.changeIcon = changeIcon;
    }

    public void setDefaultViewIcon(ImageIcon defaultViewIcon) {
        this.defaultViewIcon = defaultViewIcon;
    }



    public Icon getChangeIcon() {
        return changeIcon;
    }

    public Icon getIcon() {


        return icon;
    }

    public Icon getDefaultViewIcon() {
        return defaultViewIcon;
    }



    public void setBusinessInteraction(String businessInteraction) {
        this.businessInteractionAndDefaultView = businessInteraction;
    }



    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public void setDefaultView(String defaultView) {
        this.defaultView = defaultView;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getBusinessInteractionAndDefaultView() {
        return businessInteractionAndDefaultView;
    }

    public String getBusinessInteraction() {
        return businessInteractionAndDefaultView;
    }

    public String getDefaultView() {
        return defaultView;
    }

    public String getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return getBusinessInteractionAndDefaultView();
    }

}