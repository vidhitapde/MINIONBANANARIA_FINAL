import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
/**
 * Write a description of class RestaurantPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RestaurantPanel extends JLayeredPane implements ActionListener
{
    JButton orderButton; //JButton for the Start Order button
    JLabel restaurantBack; //JLabel for the restaurant background
    JLabel minion; //JLabel for the minion image
    JLabel minionOrder; //JLabel for the minion order image
    JButton finishButton; //JButton for the finish button
    Restaurant myRestaurant; //Frame for panel
    
    MBFrame mainFrame;
    /**
     * Constructor for objects of class RestaurantPanel
     */
    public RestaurantPanel(MBFrame frame)
    //Initializes instance variables
    {
        
        mainFrame = frame;
        myRestaurant = mainFrame.getRestaurant();
        ImageIcon restaurantBackIMG = new ImageIcon(getClass().getResource("assets/Bakery.jpg"));
        ImageIcon minionIMG = new ImageIcon(getClass().getResource("assets/minion.png"));
        ImageIcon orderIMG = new ImageIcon(getClass().getResource(frame.getRestaurant().getMyOrder().getFoodName()));
        ImageIcon takeOrderIMG = new ImageIcon(getClass().getResource("assets/orderfood.png"));
        ImageIcon finishIMG = new ImageIcon(getClass().getResource("assets/done.png"));
        
           
        restaurantBack = new JLabel();
        restaurantBack.setIcon(restaurantBackIMG);
        restaurantBack.setBounds(0,0,1000, 750);
        
        minion = new JLabel();
        minion.setIcon(minionIMG);
        minion.setBounds(440,45,1000, 750);
        
        minionOrder = new JLabel(); 
        minionOrder.setIcon(orderIMG); 
        minionOrder.setBounds(575,80,400,400);

        orderButton = new JButton();
        orderButton.setFocusable(false);
        orderButton.setBounds(410,410,350,350);

        orderButton.addActionListener(this);
        orderButton.setIcon(takeOrderIMG);
        orderButton.setBackground(new Color(0xFFFFFF));
        orderButton.setContentAreaFilled(false);
        orderButton.setBorder(null);

        finishButton = new JButton();
        finishButton.setFocusable(false);
        finishButton.setBounds(600,420,350,350);
        finishButton.addActionListener(this);
        finishButton.setIcon(finishIMG);
        finishButton.setBackground(new Color(0xFFFFFF));
        finishButton.setContentAreaFilled(false);
        finishButton.setBorder(null);

        this.add(minionOrder);
        this.add(orderButton);
        this.add(minion);

        this.add(restaurantBack);

    }
    public void checkForDone()
    //Checks if orders have been completed and updates screen accordingly
    {
        if(myRestaurant.getOrderNum() == myRestaurant.getOrderLength()){
            this.remove(orderButton);
            this.add(finishButton, 0);
            this.moveToFront(finishButton);
            this.remove(minionOrder);
        }else if(myRestaurant.getOrderNum() < myRestaurant.getOrderLength()){
            minionOrder.setIcon(new ImageIcon(getClass().getResource(myRestaurant.getMyOrder().getFoodName())));
        }
    }
    public void actionPerformed(ActionEvent event)
    //Switches to the kitchen scene when order button is clicked
    {
        if(event.getSource() == orderButton){
            mainFrame.getKitchenPanel().paintNewOrder();
            mainFrame.switchFrame(this,mainFrame.getKitchenPanel());
            //setVisible(false); 
            
            //kitchen.setVisible(true);
            
            //kitchen.paintNewOrder();
            
        }
        if(event.getSource()==finishButton){
            mainFrame.getEndPanel().updateEnd();
            mainFrame.switchFrame(this,mainFrame.getEndPanel());
        }
    }
    
}
