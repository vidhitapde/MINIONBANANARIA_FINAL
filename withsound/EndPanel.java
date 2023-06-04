
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class EndPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EndPanel extends JLayeredPane implements ActionListener
{
    // instance variables - replace the example below with your own
    
    MBFrame myFrame; //Frame for screens
    JLabel endingScreen; //Background image
    JButton playAgain; //restarts game if pressed
    JLabel win; // displays message (win)
    JLabel lose; //displays message (lose)
    JLabel winScreen;
    /**
     * Constructor for objects of class EndPanel
     */
    public EndPanel(MBFrame frame)
    // instantiates instance variables 
    {
        myFrame = frame;
        playAgain = new JButton();
        ImageIcon playImage = new ImageIcon(getClass().getResource("assets/play button.png"));
        ImageIcon rolloverImage = new ImageIcon(getClass().getResource("assets/hoverplay.png"));
         
        
       
        playAgain.setFocusable(false);
        playAgain.setBounds(385,390,230,72);
        playAgain.addActionListener(this);
        playAgain.setIcon(playImage);
        playAgain.setBackground(new Color(0xFAE7B5));
        playAgain.setContentAreaFilled(false);
        playAgain.setBorder(null);
        playAgain.setRolloverEnabled(true);
        playAgain.setRolloverIcon(rolloverImage);
        
        win = new JLabel();
        ImageIcon slayIMG = new ImageIcon(getClass().getResource("assets/slay.png"));
        win.setIcon(slayIMG);
        win.setBounds(0,0, 500, 100);
        
        
        lose = new JLabel();
        ImageIcon wrongIMG = new ImageIcon(getClass().getResource("assets/wrong.png"));
        lose.setIcon(wrongIMG);
        lose.setBounds(0,0, 500, 100);
        winScreen = new JLabel(); 
        ImageIcon minionbeach = new ImageIcon(getClass().getResource("assets/Minion Beach.png"));
        winScreen.setIcon(minionbeach); 
        winScreen.setBounds(0,0,1000,750); 
    }
    public void actionPerformed(ActionEvent event)
    //Creates new MBFrame when pressed
    {
        if(event.getSource() == playAgain){
            myFrame.stopMusic();
            myFrame.setVisible(false);
            MBFrame newFrame = new MBFrame();
            
            
        }
        
    }
    public void updateEnd()
    //Displays correct result image
    {
        this.add(playAgain,0);
        if(myFrame.getScore() >=100){
            this.add(win);
            this.add(winScreen);
        }else if(myFrame.getScore() <100){
             
            this.add(lose);
            this.moveToFront(lose); 
            
        }
    }
}
