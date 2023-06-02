
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class ToppingAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ToppingAction extends AbstractAction
{
    JLabel label;
    BananaSmoothie mySmoothie;
    Timer timer;
    public ToppingAction(JLabel lab, BananaSmoothie smoothie, Timer tim){
        label = lab;
        mySmoothie = smoothie;
        timer = tim;
    }
    public void actionPerformed(ActionEvent e){
        
        timer.setRepeats(false);
        mySmoothie.moveDown();
    }
}
