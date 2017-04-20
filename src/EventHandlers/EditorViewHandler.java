package EventHandlers;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ayettey on 12/04/2017.
 */

public class EditorViewHandler extends JPanel {

    private static final DataFlavor FLAVOR=new DataFlavor(JLabel.class,"Label Instances");
    private static final DataFlavor LOCAL_FLAVORS=new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType
            + "; class=javax.swing.JLabel","Label Instances");

    public DragSourceListener source;
    public JLabel dragComponent;

    public EditorViewHandler() {
        super();
        setLayout(null);
        DropTarget dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, new DropObject());
        source=new DragObjectFromSource();

    }


    public JLabel createDragImage(File file) {
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        JLabel label = new JLabel(icon);
        String cutExtension=file.getName();
        label.setText(cutExtension.substring(0,cutExtension.lastIndexOf('.')+1));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        return label;

    }


    public void createComponents(Component comp, Point pointer) {
        DragSource source = DragSource.getDefaultDragSource();
        source.createDefaultDragGestureRecognizer(comp, DnDConstants.ACTION_COPY_OR_MOVE, new Gesture());
        comp.setLocation(pointer);
        comp.setSize(comp.getPreferredSize());
        add(comp);
        repaint();

    }

    class TransferObject implements Transferable{

        public  DataFlavor[]flavors={FLAVOR,LOCAL_FLAVORS};
        JLabel label;

        TransferObject(JLabel label){
           this. label=label;
        }




        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return flavors;
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {

            for(int i=0;i<flavors.length;i++){
                if(flavors[i].equals(flavor)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            if(flavor.equals(FLAVOR)){
                return label;
            }
            if(flavor.equals(LOCAL_FLAVORS)){
                return label;

            }
          throw new UnsupportedFlavorException(flavor);
        }
    }

    class Gesture implements DragGestureListener {






        @Override
        public void dragGestureRecognized(DragGestureEvent dge) {
            Cursor cursor=null;
            dragComponent= (JLabel) dge.getComponent();

            switch (dge.getDragAction()){
                case DnDConstants.ACTION_COPY:
                    cursor=DragSource.DefaultCopyDrop;
                    break;
                case DnDConstants.ACTION_MOVE:
                    cursor=DragSource.DefaultMoveDrop;
                    break;
                case DnDConstants.ACTION_LINK:
                    cursor=DragSource.DefaultLinkDrop;
                    break;
            }
            dge.startDrag(cursor,new TransferObject(dragComponent),new DragObjectFromSource());

        }
    }

    class DropObject implements DropTargetListener {

        @Override
        public void dragEnter(DropTargetDragEvent dtde) {
            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)
                    || dtde.isDataFlavorSupported(LOCAL_FLAVORS) || dtde.isDataFlavorSupported(FLAVOR)) {
                return;
            }
            dtde.rejectDrag();
        }

        @Override
        public void dragOver(DropTargetDragEvent dtde) {

        }

        @Override
        public void dropActionChanged(DropTargetDragEvent dtde) {

        }

        @Override
        public void dragExit(DropTargetEvent dte) {

        }

        @Override
        public void drop(DropTargetDropEvent dtde) {
            System.out.print("Gate");
            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {

                dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                Transferable transferObject = dtde.getTransferable();

                try {
                    java.util.List list = (List) transferObject.getTransferData(DataFlavor.javaFileListFlavor);
                    Iterator iterator = list.iterator();

                    while (iterator.hasNext()) {
                        JLabel label = createDragImage((File) iterator.next());
                        createComponents(label, dtde.getLocation());

                    }
                    dtde.dropComplete(true);

                } catch (UnsupportedFlavorException e) {
                    dtde.dropComplete(false);
                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            } else if (dtde.isDataFlavorSupported(FLAVOR)) {

                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable transferObject = dtde.getTransferable();

                try {


                    JLabel label = (JLabel) transferObject.getTransferData(FLAVOR);
                    createComponents(label, dtde.getLocation());
                    dtde.dropComplete(true);
                } catch (UnsupportedFlavorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    dtde.dropComplete(false);
                    e.printStackTrace();
                }
            } else if (dtde.isDataFlavorSupported(LOCAL_FLAVORS)) {

                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable transferObject = dtde.getTransferable();

                try {


                    JLabel label = (JLabel) transferObject.getTransferData(LOCAL_FLAVORS);
                    createComponents(label, dtde.getLocation());
                    dtde.dropComplete(true);
                } catch (UnsupportedFlavorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    dtde.dropComplete(false);
                    e.printStackTrace();
                }


            }
        }
    }


    class DragObjectFromSource implements DragSourceListener{

        @Override
        public void dragEnter(DragSourceDragEvent dsde) {

        }

        @Override
        public void dragOver(DragSourceDragEvent dsde) {

        }

        @Override
        public void dropActionChanged(DragSourceDragEvent dsde) {

        }

        @Override
        public void dragExit(DragSourceEvent dse) {

        }

        @Override
        public void dragDropEnd(DragSourceDropEvent dsde) {
            DragSourceContext context=dsde.getDragSourceContext();
            remove(context.getComponent());
            repaint();

        }
    }
}
