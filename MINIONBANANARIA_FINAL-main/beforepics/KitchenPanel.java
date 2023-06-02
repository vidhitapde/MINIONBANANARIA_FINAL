
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class KitchenPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KitchenPanel extends JLayeredPane implements ActionListener
{
    BananaSmoothie myBS;
    BananaCreamPie myBCP;
    BananasFoster myBF;
    Restaurant myRestaurant;
    MBFrame myFrame;
    Food currentOrder;
    JButton BSreturnButton;
    JButton BCPreturnButton;
    JButton BFreturnButton;
    
    JLabel myScoreLabel;
    Integer score;
    JLabel coordLabel;
    /**
     * Constructor for objects of class KitchenPanel
     */
    public KitchenPanel(MBFrame frame) 
    {
        myFrame = frame;
        myRestaurant = frame.getRestaurant();
        myScoreLabel = new JLabel();
        coordLabel = new JLabel();
        coordLabel.setBounds(10, 50, 300, 50);
        score = new Integer(5);
        myScoreLabel.setText("Money: $" + score.toString());
        myScoreLabel.setFont(new Font("Comic Sans", Font.PLAIN, 30));
        myScoreLabel.setBounds(10, 10, 300, 50);
        this.add(myScoreLabel);
        this.moveToFront(myScoreLabel);
        this.add(coordLabel);
    }
    public JLabel getCoordLabel(){
    
        return coordLabel;        
    }
    public JLabel getScoreLabel(){
        return myScoreLabel;
    }
    public void updateScore(Integer increment){
        score= (score.intValue() + increment.intValue());
        myScoreLabel.setText("Money: $" + score.toString());
    }
    public Integer getScore(){
        return score;
    }
    public void paintNewOrder(){
        currentOrder = myRestaurant.getMyOrder();
        
        System.out.println("score");
        if(currentOrder instanceof BananaSmoothie){
            myBS = new BananaSmoothie(this);
            myBS.addComponents();
            
            System.out.println("hello");
            BSreturnButton = myBS.getRestaurantButton();
        }
        if(currentOrder instanceof BananaCreamPie){
            myBCP= new BananaCreamPie(this);
            myBCP.addComponents();
            System.out.println("hi");
            BCPreturnButton = myBCP.getRestaurantButton();
            
        }
        if(currentOrder instanceof BananasFoster){
            myBF= new BananasFoster(this);
            myBF.addComponents();
            System.out.println("hola");
            BFreturnButton = myBF.getRestaurantButton();
        }
        
        
        
        myFrame.repaint();
        myFrame.revalidate();
        myRestaurant.incrementOrder();
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == BCPreturnButton){
            
            myBCP.removeComponents();
            this.remove(BCPreturnButton);
            
            
        }
        if(event.getSource() == BSreturnButton){
        
            myBS.removeComponents();
            this.remove(BSreturnButton);
            
            
        }
        if(event.getSource() == BFreturnButton){
            System.out.println("yes!");
            myBF.removeComponents();
            this.remove(BFreturnButton);
            
            
        }
        myFrame.repaint();
        myFrame.switchFrame(this, myFrame.getRestaurantPanel());
        
        myFrame.getRestaurantPanel().checkForDone();
            
        
    
    }
    public MBFrame getFrame(){
        return myFrame;
    }
}
