
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
    
    MBFrame myFrame;
    JLabel endingScreen;
    JButton playAgain;
    JLabel win;
    JLabel lose;
    /**
     * Constructor for objects of class EndPanel
     */
    public EndPanel(MBFrame frame)
    {
        myFrame = frame;
        playAgain = new JButton();
        ImageIcon playImage = new ImageIcon(getClass().getResource("assets/play button.png"));
        ImageIcon rolloverImage = new ImageIcon(getClass().getResource("assets/hoverplay.png"));
        
       
        playAgain.setFocusable(false);
        playAgain.setBounds(385,450,230,72);
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
        win.setBounds(0,0, 100, 100);
        lose = new JLabel();
        ImageIcon wrongIMG = new ImageIcon(getClass().getResource("assets/wrong.png"));
        lose.setIcon(wrongIMG);
        lose.setBounds(0,0, 100, 100);
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == playAgain){
            myFrame.setVisible(false);
            MBFrame newFrame = new MBFrame();
            
            
        }
        
    }
    public void updateEnd(){
        this.add(playAgain,0);
        if(myFrame.getScore() >=100){
            this.add(win);
        }else if(myFrame.getScore() <100){
            this.add(lose);
        }
    }
}
