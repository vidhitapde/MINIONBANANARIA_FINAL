import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class InstPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InstPanel extends JLayeredPane implements ActionListener
{
    JLabel inst;

    JButton exit;
    MBFrame mainFrame;
    
    
    
    /**
     * Constructor for objects of class InstPanel
     */
    public InstPanel(MBFrame frame)
    {
        mainFrame = frame;
        
        ImageIcon exitIMG = new ImageIcon(getClass().getResource("assets/exit.png"));
        exit = new JButton();
        exit.setIcon(exitIMG);
        exit.setBounds(775, 30, 75, 75);
        exit.addActionListener(this);
        exit.setBackground(new Color(0x000000));
        exit.setContentAreaFilled(false);
        exit.setBorder(null);
        
        
        ImageIcon instIMG = new ImageIcon(getClass().getResource("assets/Instructions.jpg"));
        inst = new JLabel();
        inst.setIcon(instIMG);
        inst.setBounds(0,0,1000,750);
        
        
        this.add(exit);
        this.add(inst);
    }
     public void actionPerformed(ActionEvent event){
        if(event.getSource() == exit){
            System.out.println("works");
            mainFrame.switchFrame(this, mainFrame.getRestaurantPanel());
        }
    }
    
}
