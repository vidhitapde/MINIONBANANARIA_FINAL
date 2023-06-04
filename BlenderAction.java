import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class blenderAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlenderAction extends AbstractAction
{
    JLabel label; // instantiates the label
    BananaSmoothie mySmoothie; // instantiates the bananaSmoothie class
    int numSpaces; // holds the number of times space bar is pressed 
    ArrayList<ImageIcon> blenderimgs; // a list that holds all the blender images 
    
    public BlenderAction(JLabel lab, BananaSmoothie smoothie)
    // instantiates instance variables 
    {
        label = lab;
        mySmoothie = smoothie;
        numSpaces = 0;
        blenderimgs = new ArrayList<ImageIcon>();
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender2.png")));
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender3.png")));
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender4.png")));
    }
    public void actionPerformed(ActionEvent e)
    //Checks for the number of times space key is pressed, updates appearance of smoothie
    {
        if(numSpaces % 5 ==0 && numSpaces !=0){
            if (blenderimgs.size() != 0){
                label.setIcon(blenderimgs.remove(0));
            }
        }
        if(numSpaces < 18){
            if(label.getX() < 11){
                label.setLocation(20, label.getY());
            }else{
                label.setLocation(10, label.getY());
            }
            numSpaces++;
            label.getParent().repaint();
        }else if(numSpaces == 18){
            mySmoothie.getNextButton().setVisible(true);
        }
        
        
    
    }
}
