
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;

/**
 * Write a description of class pancakeAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pancakeAction extends AbstractAction
{
    JLabel label; //Jlabel representing pancake
    BananasFoster pane; // BananasFoster object
    Timer timer; // instantiates a timer 
    
    public pancakeAction(JLabel lab, BananasFoster jpane, Timer tim)
    // instantiates instance  variables 
    {
        label = lab;
        pane = jpane;
        timer = tim;
    }
    public void actionPerformed(ActionEvent e)
    //Executes movePancakeDown method based on pancake
    {
        System.out.println("holaaaaa");
        timer.setRepeats(false);
        
        if (label == pane.getPancake1()) {
            pane.movePancakeDown(pane.getPancake1());
        } else if (label == pane.getPancake2()) {
            pane.movePancakeDown(pane.getPancake2());
        } else if (label == pane.getPancake3())
        {
            pane.movePancakeDown(pane.getPancake3());
        }
        
    }
}
