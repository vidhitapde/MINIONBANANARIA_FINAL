
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
    BananaSmoothie myBS; //Banana smoothie recipe
    BananaCreamPie myBCP; //Banana cream pie recipe
    BananasFoster myBF; //Bananas foster pancakes recipe
    Restaurant myRestaurant;  //Stores orders and associated data
    MBFrame myFrame; //Frame for screens
    Food currentOrder; //Stores order currently being made
    JButton BSreturnButton; //JButton from BananaSmoothie class
    JButton BCPreturnButton; //JButton from BananaCreamPie class
    JButton BFreturnButton; //JButton from BananasFoster class
    JButton helpButton; // JButton for the help button (instructions)
    JLabel myScoreLabel; //displays score
    Integer score; // stores the user's money

    /**
     * Constructor for objects of class KitchenPanel
     */
    public KitchenPanel(MBFrame frame) 
    //Instantiates instance variables
    {
        myFrame = frame;

        myRestaurant = frame.getRestaurant();

        myScoreLabel = new JLabel();

        helpButton = new JButton();
        ImageIcon helpIMG = new ImageIcon(getClass().getResource("assets/helpbutton.png"));
        helpButton.setIcon(helpIMG);
        helpButton.setBounds(900, 20, 75, 75);
        helpButton.addActionListener(this);
        helpButton.setBackground(new Color(0x000000));
        helpButton.setContentAreaFilled(false);
        helpButton.setBorder(null);
        helpButton.setVisible(true);

        score = new Integer(5);
        myScoreLabel.setText("Money: $" + score.toString());
        myScoreLabel.setFont(new Font("Comic Sans", Font.PLAIN, 30));
        myScoreLabel.setBounds(10, 10, 300, 50);

        this.add(helpButton, 0);
        this.add(myScoreLabel);
        this.moveToFront(myScoreLabel);

    }

    public JButton getHelpButton()
    //Accessor methods- used to return data regarding instance variables
    {
        return helpButton;
    }

    public JLabel getScoreLabel()
    // changes the value of the score
    {
        return myScoreLabel;
    }

    public void updateScore(Integer increment)
    //Accessor methods- used to return data regarding instance variables
    {
        score= (score.intValue() + increment.intValue());
        myScoreLabel.setText("Money: $" + score.toString());
    }

    public Integer getScore()
    //Accessor methods- used to return data regarding instance variables
    {
        return score;
    }

    public void paintNewOrder()
    //Adds assets to panel depending on order
    {
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

    public void actionPerformed(ActionEvent event)
    //Checks for button presses and executes corresponding methods
    {
        if(event.getSource() == helpButton){
            myFrame.switchFrame(this, myFrame.getInstPanel());
        }
        if(event.getSource() == BCPreturnButton){

            myBCP.removeComponents();
            this.remove(BCPreturnButton);
            myFrame.repaint();
            myFrame.switchFrame(this, myFrame.getRestaurantPanel());

            myFrame.getRestaurantPanel().checkForDone();
        }
        if(event.getSource() == BSreturnButton){

            myBS.removeComponents();
            this.remove(BSreturnButton);
            myFrame.repaint();
            myFrame.switchFrame(this, myFrame.getRestaurantPanel());

            myFrame.getRestaurantPanel().checkForDone();
        }
        if(event.getSource() == BFreturnButton){
            System.out.println("yes!");
            myBF.removeComponents();
            this.remove(BFreturnButton);
            myFrame.repaint();
            myFrame.switchFrame(this, myFrame.getRestaurantPanel());

            myFrame.getRestaurantPanel().checkForDone();
        }

    }
    public MBFrame getFrame()
    //Accessor methods- used to return data regarding instance variables

    {
        return myFrame;
    }
}
