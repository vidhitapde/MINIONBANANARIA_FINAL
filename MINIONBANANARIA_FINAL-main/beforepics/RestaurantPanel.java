
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
    JButton orderButton;
    JLabel restaurantBack;
    JLabel minion;
    JLabel minionOrder;
    JButton finishButton;
    Restaurant myRestaurant;

    MBFrame mainFrame;
    /**
     * Constructor for objects of class RestaurantPanel
     */
    public RestaurantPanel(MBFrame frame)
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
        //minion.setBounds(450,18,1000, 750);
        minion.setBounds(440,45,1000, 750);

        minionOrder = new JLabel(); 
        minionOrder.setIcon(orderIMG); 
        minionOrder.setBounds(700,200,200,100);

        orderButton = new JButton();
        orderButton.setFocusable(false);
        Dimension buttonSize = new Dimension(500,500); 
        orderButton.setSize(buttonSize); 
        
        //orderButton.setPreferredSize(new Dimension(500,500)); 
        orderButton.setBounds(410,410,350,350);

        orderButton.addActionListener(this);
        orderButton.setIcon(takeOrderIMG);
        orderButton.setBackground(new Color(0xFFFFFF));
        orderButton.setContentAreaFilled(false);
        orderButton.setBorder(null);

        finishButton = new JButton();
        finishButton.setFocusable(false);
        finishButton.setBounds(450,450,350,350);
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
    public void checkForDone(){
        if(myRestaurant.getOrderNum() == myRestaurant.getOrderLength()){
            this.remove(orderButton);
            this.add(finishButton, 0);
            this.moveToFront(finishButton);
            this.remove(minionOrder);
        }else if(myRestaurant.getOrderNum() < myRestaurant.getOrderLength()){
            minionOrder.setIcon(new ImageIcon(getClass().getResource(myRestaurant.getMyOrder().getFoodName())));
        }
    }

    public void actionPerformed(ActionEvent event){
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