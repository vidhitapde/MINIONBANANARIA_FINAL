
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class InstPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InstPanel extends JLayeredPane implements ActionListener
{
    JLabel inst; //Displays instructions

    JButton exit; //Button to switch to RestaurantPanel
    JButton upButton; // responsible for right button
    JButton downButton; // responsible for left button
    MBFrame mainFrame; //Frame for panel
    ImageIcon[] foodImages; //holds the food images
    int imageIndex; // instantiates int value for index of images of food
    ArrayList<String> levels; // arraylist holds string levels
    boolean firstShow; // instantiates a boolean checks if first show or not
    /**
     * Constructor for objects of class InstPanel
     */
    public InstPanel(MBFrame frame) //Initializes instance variables
    {
        mainFrame = frame;
        firstShow = false;
        ImageIcon exitIMG = new ImageIcon(getClass().getResource("assets/exit.png"));
        exit = new JButton();
        exit.setIcon(exitIMG);
        exit.setBounds(775, 30, 75, 75);
        exit.addActionListener(this);
        exit.setBackground(new Color(0x000000));
        exit.setContentAreaFilled(false);
        exit.setBorder(null);
        
        ImageIcon upIMG = new ImageIcon(getClass().getResource("assets/rightbutton.png")); //right button
        ImageIcon downIMG = new ImageIcon(getClass().getResource("assets/leftbutton.png")); //left button
        
        upButton = new JButton();
        upButton.setFocusable(false);
        upButton.setBounds(800,600,107,100);
        upButton.addActionListener(this);
        upButton.setIcon(upIMG);
        upButton.setBackground(new Color(0xFFFFFF));
        upButton.setContentAreaFilled(false);
        upButton.setBorder(null);
        
        downButton = new JButton();
        downButton.setFocusable(false);
        downButton.setBounds(100,600,107,100);
        downButton.addActionListener(this);
        downButton.setIcon(downIMG);
        downButton.setBackground(new Color(0xFFFFFF));
        downButton.setContentAreaFilled(false);
        downButton.setBorder(null);
        
        ImageIcon instIMG = new ImageIcon(getClass().getResource("assets/Instructions.jpg"));
        inst = new JLabel();
        inst.setIcon(instIMG);
        inst.setBounds(0,0,1000,750);
        
        foodImages = new ImageIcon[4];
        foodImages[0] = new ImageIcon(getClass().getResource("assets/Instructions.jpg"));
        foodImages[1] = new ImageIcon(getClass().getResource("assets/Banana Cream Pie Instructions.jpg"));
        foodImages[2] = new ImageIcon(getClass().getResource("assets/Banana Smoothie Instructions.jpg"));
        foodImages[3] = new ImageIcon(getClass().getResource("assets/Banana Foster Pancakes Instructions.jpg"));
        /*
        levels = new ArrayList<String>();
        levels.add("Inst");
        levels.add("bcpInst");
        levels.add("bsInst");
        */
        imageIndex = 1;
        
       
        this.add(exit);
        this.add(upButton);
        this.add(downButton);
        this.add(inst);
        
    }
     public void actionPerformed(ActionEvent event)
     //Checks if exit button is clicked, then switches screens
     {
        if(event.getSource() == exit){
            inst.setIcon(foodImages[0]);
            if(firstShow == false){
                mainFrame.switchFrame(this, mainFrame.getRestaurantPanel());
                firstShow = true;
            }else if(firstShow == true){
                mainFrame.switchFrame(this, mainFrame.getKitchenPanel());
            }
            
        }
        if(event.getSource() == upButton){
            
            inst.setIcon(foodImages[imageIndex]);
            
            System.out.println("inst qorks");
            if(imageIndex<3 && imageIndex>=0)
                imageIndex++;
        }
        if(event.getSource() == downButton){
            
            inst.setIcon(foodImages[imageIndex]);
            
            System.out.println("inst qorks");
            if(imageIndex>0)
                imageIndex--;
        }
        mainFrame.repaint();
    }
    
}


