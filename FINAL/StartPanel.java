
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class startPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartPanel extends JLayeredPane implements ActionListener
{
    JButton play; //Button to switch to InstPanel
    JLabel title;//Displays title of game
    
    MBFrame mainFrame; //Frame for panel
    /**
     * Constructor for objects of class startPanel
     */
    public StartPanel(MBFrame frame) 
    //Initializes instance variables
    {
        // initialise instance variables
        mainFrame = frame;
        ImageIcon playImage = new ImageIcon(getClass().getResource("assets/play button.png"));
        ImageIcon rolloverImage = new ImageIcon(getClass().getResource("assets/hoverplay.png"));
        
        
        play = new JButton();
        play.setFocusable(false);
        play.setBounds(385,450,230,72);
        play.addActionListener(this);
        play.setIcon(playImage);
        play.setBackground(new Color(0xFAE7B5));
        play.setContentAreaFilled(false);
        play.setBorder(null);
        play.setRolloverEnabled(true);
        play.setRolloverIcon(rolloverImage);
        
        title = new JLabel();
        ImageIcon titleImage = new ImageIcon(getClass().getResource("assets/title (1).png"));
        title.setIcon(titleImage);
        title.setBounds(-140,-50,1280,381);
        
        this.add(title);
        this.add(play);
        
        
    }
    public void actionPerformed(ActionEvent event)
    //Checks if play button is clicked, then switches screens
    {
        if(event.getSource() == play){
            
            mainFrame.switchFrame(this, mainFrame.getInstPanel());
            
            //intro = new introFrame();
            
        }
    }
    
}
