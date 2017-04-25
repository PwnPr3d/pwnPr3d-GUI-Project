package EventHandlers;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by Ayettey on 12/04/2017.
 */

public class EditorViewHandler extends JDesktopPane {

    private static final DataFlavor FLAVOR=new DataFlavor(JLabel.class,"Label Instances");
    private static final DataFlavor LOCAL_FLAVORS=new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType
            + "; class=javax.swing.JLabel","Label Instances");

   private DragSourceListener source;
   private JLabel dragComponent;
   private JLabel LocationXAndY;
   private int countItem;
   private List<Component[]> connector;
   private List<Pair> connectorPairs;
   private int x;
   private int y;
   private boolean isConnected;
   private ControlPanel transmissionTypes= new ControlPanel();


    private JButton attack;
    private JComboBox transmissionsSettings;
    private JLabel titles;
    private JPanel transmissionPanel;
    private JTextField attackTransmissionTraffic;
    private JDesktopPane deskTop;
    private JPanel colors[];
    private JButton []tool;
    private int openFrameCount=50;

    public JComponent controlPanel(Boolean control){

        //super("IFrame #" + (++openFrameCount))
        transmissionPanel=new JPanel();
        JInternalFrame frame=new JInternalFrame("Transmissions");
        if(true){

            GridBagConstraints constraints=new GridBagConstraints();
            GridBagLayout layout=new GridBagLayout();

            frame.setLayout(layout);

            frame.setBorder(new LineBorder(new Color(0x8ED0FF),1,true));
            frame.setBackground(getBackground());

            constraints.fill=GridBagConstraints.VERTICAL;
            constraints.insets=new Insets(5,10,5,10);


            constraints.gridx=0;


            titles=new JLabel("Connection Type : ",JLabel.LEFT);
            frame.add(titles,constraints);

            titles=new JLabel("Transmission Type : ",JLabel.LEFT);
            frame.add(titles,constraints);

            titles=new JLabel("Ordering  Type : ",JLabel.LEFT);
            frame.add(titles,constraints);

            titles=new JLabel("Attacker's  Traffic : ",JLabel.LEFT);
            frame.add(titles,constraints);

            titles=new JLabel("Attacker : ",JLabel.LEFT);
            frame.add(titles,constraints);


            constraints.gridx=1;


            transmissionsSettings=new JComboBox(new Object[]{"Wired","Wireless"});
            frame.add(transmissionsSettings,constraints);

            transmissionsSettings=new JComboBox(new Object[]{"UDP","TCP"});
            frame.add(transmissionsSettings,constraints);

            transmissionsSettings=new JComboBox(new Object[]{"FIFO","LIFO"});
            frame.add(transmissionsSettings,constraints);




            constraints.ipadx=60;
            attackTransmissionTraffic=new JTextField(10);
            frame.add(attackTransmissionTraffic,constraints);
            constraints.gridx=1;


            attack=new JButton("Attack");
            frame.add(attack,constraints);

            frame.add(new JSeparator(),constraints);

            constraints.gridx=1;

            frame.add(new JSeparator(),constraints);


           // String [] type=new String[2];
           // type[0]






            System.out.println("ControlPanel");



               try{

                   UIManager.setLookAndFeel(new WindowsLookAndFeel());
                   JFrame.setDefaultLookAndFeelDecorated(true);

                   frame.setResizable(true);
                   frame.setClosable(false);
                   frame.setMaximizable(true);
                   frame.setIconifiable(true);
                   frame.setVisible(true);
                   frame.setFrameIcon(new ImageIcon(getClass().getResource("/PwpIcons/general/settings.png")));
                   frame.add(transmissionPanel);
                   frame.pack();






               } catch (UnsupportedLookAndFeelException e) {
                   e.printStackTrace();
               }


        }

        return frame;
    }

    public JComponent toolPanel(Boolean control){

        JPanel colorPanel=new JPanel(new GridLayout(2,2));
        JPanel set=new JPanel(new BorderLayout());


        JInternalFrame frame=new JInternalFrame("Tool Panel");
        if(true){



            GridBagConstraints constraints=new GridBagConstraints();
            GridBagLayout layout=new GridBagLayout();



            set.setLayout(layout);


            constraints.fill=GridBagConstraints.VERTICAL;
            constraints.insets=new Insets(5,10,5,10);


            colorPanel.setLayout(new GridLayout(30,30));

            frame.setBorder(new LineBorder(new Color(0x8ED0FF),1,true));
            frame.setBackground(getBackground());
            frame.setLayout(new BorderLayout());



            colors=new JPanel[30];
            tool=new JButton[4];

            for(int x=0;x<colors.length;x++){
                Random seedRandomly=new Random();
                colors[x]=new JPanel();
                //colors[x].setSize(new Dimension(20,20));
                colors[x].setBackground(new Color((float) seedRandomly.nextDouble(),(float)
                        seedRandomly.nextDouble(),(float) seedRandomly.nextDouble()));
                colorPanel.add(colors[x]);
                colorPanel.setVisible(true);
                colorPanel.setBackground(Color.green);
                frame.add(colorPanel,BorderLayout.CENTER);
            }


            tool[0]=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/note-16.gif")));
            tool[1]=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/note-16.gif")));
            tool[2]=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/note-16.gif")));
            tool[3]=new JButton(new ImageIcon(getClass().getResource("/PwpIcons/OtherImages/note-16.gif")));

            constraints.gridx=0;
            set.add(tool[0] ,constraints);
            constraints.gridx=1;
            set.add(tool[1] ,constraints);
            constraints.gridx=2;
            set.add(tool[2] ,constraints);

            constraints.gridx=3;
            set.add(tool[3] ,constraints);


            for(int x=0;x<tool.length;x++){


                frame.add(set,BorderLayout.NORTH);
            }











            // String [] type=new String[2];
            // type[0]






            System.out.println("ControlPanel");



            try{

               // UIManager.setLookAndFeel(new WindowsLookAndFeel());
                //JFrame.setDefaultLookAndFeelDecorated(true);

                frame.setResizable(true);
                frame.setClosable(false);
                frame.setMaximizable(true);
                frame.setIconifiable(true);
                frame.setVisible(true);
                frame.setFrameIcon(new ImageIcon(getClass().getResource("/PwpIcons/general/externalTools.png")));
                frame.pack();






            }
            catch (Exception e) {
                e.printStackTrace();
            }


        }

        return frame;
    }




    public EditorViewHandler() {
        super();


        DropTarget dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, new DropObject());

        setLayout(null);



        LocationXAndY=new JLabel();
        LocationXAndY.setBounds(5,getWidth(),200,30);
        add(LocationXAndY);

        setBackground(transmissionTypes.getBackground());
        add(controlPanel(true));
        add(toolPanel(true));


        MouseAdapter mouseAdapter=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }





            @Override
            public void mouseDragged(MouseEvent e) {


                LocationXAndY.setText("Dragging at" + e.getX() + " and " + e.getY());
                System.out.println("Dragging at" + e.getX() + " and " + e.getY());
                repaint();
            }

        };


        addMouseListener(mouseAdapter);

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


    Collection <Component>collection;


    public void createComponents(Component comp, Point pointer) {
       // DragSource source = DragSource.getDefaultDragSource();
       // source.createDefaultDragGestureRecognizer(comp, DnDConstants.ACTION_COPY_OR_MOVE, new Gesture());



        comp.setLocation(pointer);
        comp.setSize(comp.getPreferredSize());
        add(comp);


        MouseAdapter mouseListener=new MouseAdapter() {









            @Override
            public void mousePressed(MouseEvent e) {
                for(Component[] conn:connector){
                    System.out.println("BlackGround");
                    JLabel borderLabel= (JLabel) e.getComponent();
                    borderLabel.setBorder(new LineBorder(Color.black,1,true));
                    borderLabel.setSize(new Dimension(100,70));

                }

            }


            @Override
            public void mouseDragged(MouseEvent e) {








            }



        };

        comp.addMouseListener(mouseListener);
        comp.addMouseMotionListener(mouseListener);

        repaint();

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
            LocationXAndY.setText(""+dragComponent.getX());

        }

        @Override
        public void dragExit(DropTargetEvent dte) {

        }

        @Override
        public void drop(DropTargetDropEvent dtde) {



            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {

                dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                Transferable transferObject = dtde.getTransferable();

                try {
                    java.util.List list = (List) transferObject.getTransferData(DataFlavor.javaFileListFlavor);
                    Iterator iterator = list.iterator();

                    while (iterator.hasNext()) {

                        JLabel label = createDragImage((File) iterator.next());

                        createComponents(label, dtde.getLocation());
                       // connect(label,label);

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




                    JLabel label =(JLabel) transferObject.getTransferData(FLAVOR);



                    connector=new ArrayList<>();
                    collection=new ArrayList();
                    collection.add(label);
                    connector.add(new Component[]{label});
                    connectorPairs=new ArrayList<>();
                    //connectorPairs.add();


                    countItem++;


                    if(countItem==2){

                    }



                    MouseAdapter mouseListener=new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {


                            Iterator <Component>iterator=collection.iterator();

                            while (iterator.hasNext()) {
                                 connectorPairs.add(new Pair(iterator.next(),e.getComponent()));

                            }
                            isConnected = true;

                            repaint();




                        }


                        @Override
                        public void mouseDragged(MouseEvent e) {

                            int XOnScreen = e.getXOnScreen();
                            int YOnLocationScreen = e.getLocationOnScreen().y;


                            x = XOnScreen - 100;
                            y = YOnLocationScreen - 100;


                            LocationXAndY.setText("Location On Screen X : " + label.getX() + " Location On Screen Y " + label.getY());
                            LocationXAndY.setSize(new Dimension(300, 10));
                            label.setLocation(x, y);

                             isConnected=true;

                        }


                        @Override
                        public void mouseClicked(MouseEvent e) {


                        }


                    };
                    label.addMouseListener(mouseListener);
                    label.addMouseMotionListener(mouseListener);
                    createComponents(label, dtde.getLocation());
                    dtde.dropComplete(true);
                } catch (UnsupportedFlavorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    dtde.dropComplete(false);
                    e.printStackTrace();
                }
            } else if (dtde.isDataFlavorSupported(LOCAL_FLAVORS)) {

                System.out.println("Local");

                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable transferObject = dtde.getTransferable();

                try {


                    JLabel label = (JLabel) transferObject.getTransferData(LOCAL_FLAVORS);
                    createComponents(label, dtde.getLocation());
                   // connect(new Component[]{});
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


    public void connect(Component parent,Component child ){




            connector = new ArrayList();


            if (parent.getParent() != this) {

                add(parent);
            }

            if (child.getParent() != this) {

                add(child);

            }


        connector.add(new Component[]{parent,child});


       repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);


        g.setColor(Color.RED);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.MAGENTA);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 1f));

        if(isConnected) {
        for (Pair pair : connectorPairs )
        {
            JLabel label1 = pair.getLabel1();
            JLabel label2 = pair.getLabel2();
            Rectangle point1 = label1.getBounds();
            Rectangle point2 = label2.getBounds();


            int i = pair.howToDraw();
            if ( i == 1)
            {

                g2d.fillOval(point1.x  , point1.y + label1.getHeight() / 2,  6 ,  6);
                g2d.fillOval( point2.x + label2.getWidth() , point2.y  +  label1.getHeight() / 2 ,  6 ,  6);
                g.drawLine(point1.x  , point1.y + label1.getHeight() / 2 , point2.x + label2.getWidth() , point2.y  +  label2.getHeight() / 2);



            }
           else if (i == 2)
           {

               g2d.fillOval(point2.x  , point2.y + label2.getHeight() / 2 ,  6 ,  6);
               g2d.fillOval( point1.x + label1.getWidth() , point1.y  +  label1.getHeight() / 2 ,  6 ,  6);
               g.drawLine(point2.x , point2.y + label2.getHeight() / 2 , point1.x + label1.getWidth() , point1.y  +  label1.getHeight() / 2);


           }
         else if (i == 3)
         {
             g2d.fillOval(point2.x  , point2.y + label2.getHeight() / 2 ,  6 ,  6);
             g2d.fillOval( point1.x + label1.getWidth() , point1.y  +  label1.getHeight() / 2 ,  6 ,  6);
             g.drawLine(point1.x + label1.getWidth() / 2 , point1.y , point2.x + label2.getWidth() / 2, point2.y + label2.getHeight());

         }
         else if (i == 4)
         {
             g2d.fillOval(point2.x  , point2.y + label2.getHeight() / 2 ,  6,  6);
             g2d.fillOval( point1.x + label1.getWidth() , point1.y  +  label1.getHeight() / 2 ,  6 ,  6);
             g.drawLine(point2.x + label2.getWidth() / 2 , point2.y , point1.x + label1.getWidth() / 2, point1.y + label1.getHeight());

         }

            repaint();
        }

        }



}

    class Pair
    {
        JLabel label1 ;
        JLabel label2 ;
        private Pair(Component parent, Component child){
            this.label1 = (JLabel)parent ;
            this.label2 = (JLabel) child;
        }
        public Pair(JLabel label1, JLabel label2)
        {
            this.label1 = label1;
            this.label2 = label2;
        }
        @Override
        public String toString()
        {
            return "{"+label1.getLocation()+","+label2.getLocation()+"}";
        }
        public int howToDraw()
        {
            Point point1 = label1.getLocation();
            Point point2 = label2.getLocation();
            if (point1.x > point2.x)
            {
                return 1;
            }
            else if (point1.x < point2.x)
            {
                return 2;
            }
            else if (point1.y > point2.y)
            {
                return 3;
            }
            else if (point1.y < point2.y)
            {
                return 4;
            }
            else
                return 5;
        }
        public JLabel getLabel1()
        {
            return label1;
        }
        public JLabel getLabel2()
        {
            return label2;
        }
        @Override
        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj instanceof Pair)
            {
                Pair temp = (Pair)obj;
                if ((temp.toString()).equalsIgnoreCase(this.toString()))
                {
                    return true;
                }
            }
            return false;
        }
    }


    class ControlPanel extends JInternalFrame{
        static final int xPosition = 30, yPosition = 30;
        public ControlPanel() {
            super("" + (++openFrameCount), true, // resizable
                    true, // closable
                    true, // maximizable
                    true);// iconifiable
            setSize(300, 300);
            // Set the window's location.
            setLocation(xPosition * openFrameCount, yPosition
                    * openFrameCount);
        }

        public JPanel controlPanel(Boolean control){


            transmissionPanel=new JPanel();
            if(true){

                GridBagConstraints constraints=new GridBagConstraints();
                GridBagLayout layout=new GridBagLayout();

                transmissionPanel.setLayout(new BorderLayout());

                transmissionPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
                transmissionPanel.setBackground(Color.green);

               // constraints.fill=GridBagConstraints.VERTICAL;
                constraints.insets=new Insets(5,10,5,10);


                constraints.gridx=0;
                titles=new JLabel("Connection Type : ",JLabel.LEFT);
                transmissionPanel.add(titles,BorderLayout.CENTER);



                System.out.println("ControlPanel");







            }
            return transmissionPanel;
        }
}


    }

