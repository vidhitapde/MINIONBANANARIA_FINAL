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
    JLabel label;
    BananaSmoothie mySmoothie;
    int numSpaces;
    ArrayList<ImageIcon> blenderimgs;
    
    public BlenderAction(JLabel lab, BananaSmoothie smoothie){
        label = lab;
        mySmoothie = smoothie;
        numSpaces = 0;
        blenderimgs = new ArrayList<ImageIcon>();
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender2.png")));
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender3.png")));
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender4.png")));
    }
    public void actionPerformed(ActionEvent e){
        if(numSpaces % 5 ==0 && numSpaces !=0){
            if (blenderimgs.size() != 0){
                label.setIcon(blenderimgs.remove(0));
            }
        }
        if(numSpaces < 18){
            if(label.getX() < -49){
                label.setLocation(-40, label.getY());
            }else{
                label.setLocation(-50, label.getY());
            }
            numSpaces++;
            label.getParent().repaint();
        }else if(numSpaces == 18){
            mySmoothie.getNextButton().setVisible(true);
        }
        
        
    
    }
}
