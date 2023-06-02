
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class MBFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MBFrame extends JFrame
{
    StartPanel myStartPanel;
    InstPanel myInstPanel;
    RestaurantPanel myRestaurantPanel;
    KitchenPanel myKitchenPanel;
    EndPanel myEndPanel;
    int myScore;
    Restaurant myRestaurant;
    
    /**
     * Constructor for objects of class MBFrame
     */
    public MBFrame()
    {
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
    public void switchFrame(JLayeredPane currentPane, JLayeredPane newPane){
        this.remove(currentPane);
        this.add(newPane);
        this.repaint();
        this.revalidate();
    }
    public Restaurant getRestaurant(){
        return myRestaurant;
    }
    public StartPanel getStartPanel(){
        return myStartPanel;
    }
    public InstPanel getInstPanel(){
        return myInstPanel;
    }
    public RestaurantPanel getRestaurantPanel(){
        return myRestaurantPanel;
    }
    public KitchenPanel getKitchenPanel(){
        return myKitchenPanel;
    }
    public EndPanel getEndPanel(){
        return myEndPanel;
    }
    
    public int getScore(){
        myScore = myKitchenPanel.getScore();
        return myScore;
    }
}
