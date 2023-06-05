
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import javax.sound.sampled.*;
import java.io.File;
/**
 * Write a description of class MBFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MBFrame extends JFrame
{
    StartPanel myStartPanel; //JLayeredPane displaying start screen
    InstPanel myInstPanel; //JLayeredPane displaying instructions screen
    RestaurantPanel myRestaurantPanel; //JLayeredPane displaying restaurant screen
    KitchenPanel myKitchenPanel; //JLayeredPane displaying kitchen screen
    EndPanel myEndPanel; // JLayeredPane displaying ending screen
    int myScore;// Records user’s score
    Restaurant myRestaurant; //Stores orders and associated data
    
    AudioInputStream audioStream;
    Clip clip;
    /**
     * Constructor for objects of class MBFrame
     */
    public MBFrame() //Initializes all instance variables, sets up frame for game to be played

    {
        try
        {
            try
            {
                audioStream = AudioSystem.getAudioInputStream(getClass().getResource("assets/music.wav"));
            }
            catch (java.io.IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        catch (UnsupportedAudioFileException uafe)
        {
            uafe.printStackTrace();
        }
        try
        {
            clip = AudioSystem.getClip();
        }
        catch (LineUnavailableException lue)
        {
            lue.printStackTrace();
        }
        try
        {
            try
            {
                clip.open(audioStream);
            }
            catch (java.io.IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        catch (LineUnavailableException lue)
        {
            lue.printStackTrace();
        }
        clip.start();
        clip.loop(clip.LOOP_CONTINUOUSLY);
        myRestaurant = new Restaurant();
        myStartPanel= new StartPanel(this);
        this.add(myStartPanel);

        setTitle("Minion Bananaria!");
        ImageIcon image = new ImageIcon(getClass().getResource("assets/bananapudding.png"));

        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(0xFAE7B5));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        setVisible(true);

        myInstPanel = new InstPanel(this);
        myRestaurantPanel  = new RestaurantPanel(this); 
        myKitchenPanel = new KitchenPanel(this);
        myEndPanel = new EndPanel(this);

    }
    public void stopMusic(){
        clip.stop();
    }
    public void switchFrame(JLayeredPane currentPane, JLayeredPane newPane)
    //Removes currentPane from the frame and adds newPane to the frame
    {
        getContentPane().setBackground(new Color(0xB4D3B2));
        this.remove(currentPane);
        this.add(newPane);
        this.repaint();
        this.revalidate();
    }

    public Restaurant getRestaurant() 
    //Accessor methods - used to return data regarding instance variables
    {
        return myRestaurant;
    }

    public StartPanel getStartPanel()
    //Accessor methods - used to return data regarding instance variables
    {
        return myStartPanel;
    }

    public InstPanel getInstPanel()
    //Accessor methods - used to return data regarding instance variables
    {
        return myInstPanel;
    }

    public RestaurantPanel getRestaurantPanel()
    //Accessor methods - used to return data regarding instance variables 
    {
        return myRestaurantPanel;
    }

    public KitchenPanel getKitchenPanel()
    //Accessor methods - used to return data regarding instance variables
    {
        return myKitchenPanel;
    }

    public EndPanel getEndPanel()
    //Accessor methods - used to return data regarding instance variables
    {
        return myEndPanel;
    }

    public int getScore()
    //Accessor methods - used to return data regarding instance variables
    {
        myScore = myKitchenPanel.getScore();
        return myScore;
    }
}
