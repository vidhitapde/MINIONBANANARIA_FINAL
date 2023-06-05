
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Rectangle;
/**
 * Write a description of class BananaCreamPie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BananaCreamPie extends Food
{
    JLabel pie; // instantiates the pie label
    JLabel crust;    // instantiates the crust label 
    JLabel filling; // instantiates the pie filling label
    JLabel cream; // instantiates the cream label
    JLabel banana; // instantiates the banana label
    
    ArrayList<ImageIcon> pieimgs; // a list that holds the pie images
    ArrayList<JLabel> ingredients; // a list that holds the JLabeles for the ingredients 
    
    Point previousPoint; // holds the point for the previous point
    
    boolean collision;
    
    boolean crustTouch; //Returns true or false if the crust is touching
    boolean fillingTouch; //Returns true or false if the filling is touching
    boolean bananaTouch; //Returns true or false if the banana is touching


    boolean creamTouch;//Returns true or false if the cream is touching


    
    JLabel focusLabel; //Label being dragged
    
    
    JButton returnButton;
    /**
     * Constructor for objects of class BananaCreamPie
     */
    public BananaCreamPie(KitchenPanel kit)
    //Extends food and calls super(kit)
    {
        super(kit);
        foodName = "assets/bananacreampie.png";
        
        ImageIcon pieIMG = new ImageIcon(getClass().getResource("assets/pie1.png"));
        ImageIcon creamIMG = new ImageIcon(getClass().getResource("assets/cream.png"));
        ImageIcon crustIMG = new ImageIcon(getClass().getResource("assets/piecrust.png"));
        ImageIcon bananaIMG = new ImageIcon(getClass().getResource("assets/bananaslices.png"));
        ImageIcon fillingIMG = new ImageIcon(getClass().getResource("assets/bananafilling.png"));
        ImageIcon returnIMG = new ImageIcon(getClass().getResource("assets/done.png"));
           
        pie = new JLabel();
        cream = new JLabel();
        crust = new JLabel();
        banana = new JLabel();
        filling = new JLabel();
           
        pie.setIcon(pieIMG);
        pie.setBounds(0,0, 1000,750);
        
        cream.setIcon(creamIMG);
        cream.setBounds(120,40,200,169);
        crust.setIcon(crustIMG);
        crust.setBounds(260, 230, 450,272); 
        banana.setIcon(bananaIMG);
        banana.setBounds(370,40,240,205);
        filling.setIcon(fillingIMG);
        filling.setBounds(650, 35, 200,200);
           
        ingredients = new ArrayList<JLabel>();
    
        ingredients.add(crust);
        ingredients.add(filling);
        ingredients.add(banana);
        ingredients.add(cream);
        
           
        pieimgs = new ArrayList<ImageIcon>();
        pieimgs.add(new ImageIcon(getClass().getResource("assets/pie2.png")));
        pieimgs.add(new ImageIcon(getClass().getResource("assets/pie3.png")));
        pieimgs.add(new ImageIcon(getClass().getResource("assets/pie4.png")));
        pieimgs.add(new ImageIcon(getClass().getResource("assets/pie5.png")));
           
        ClickListener clickListener = new ClickListener(); 
        DragListener dragListener = new DragListener();
                   
        foodKitchen.addMouseListener(clickListener); 
        foodKitchen.addMouseMotionListener(dragListener); 
           
        collision = false;
        crustTouch = false;
        fillingTouch = false;
        creamTouch = false;
        bananaTouch = false;
           
        returnButton = new JButton();
        returnButton.setFocusable(false);
        returnButton.setBounds(600,450,350,350);
        returnButton.addActionListener(foodKitchen);
        returnButton.setIcon(returnIMG);
        returnButton.setBackground(new Color(0xFFFFFF));
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(null);
            
        previousPoint = new Point(0, 0);
    }
    public BananaCreamPie()
    // Extends food and calls super()
    {
        super();
        foodName = "assets/Banana Cream Pie Speech Bubble.png";
    
    }
     public class ClickListener extends MouseAdapter 
    {
        public void mousePressed(MouseEvent e)
        //Assigns focusLabel based on coordinates
        {
            previousPoint = e.getPoint(); // updating the previous point to new place that is clicked
            
            for(JLabel img: ingredients){
                boolean withinBounds = previousPoint.getX() > img.getX() && previousPoint.getX()<(img.getX()+img.getWidth()) && previousPoint.getY() > img.getY() && previousPoint.getY() <(img.getY()+img.getHeight());
                if(withinBounds){
                    focusLabel = img;
                }
            }
        }
    }
    public void addComponents(){
        foodKitchen.add(filling);
        foodKitchen.add(crust);
        foodKitchen.add(banana);
        foodKitchen.add(cream);
        foodKitchen.add(pie);
    }
    public void removeComponents(){
        foodKitchen.remove(pie);
        
    }
    public void intersects ()
    //updates screen according to image collision
        {
        if (focusLabel != null){
            boolean inBounds = focusLabel.getX() > 250 && focusLabel.getX()<770 && focusLabel.getY()>280 && focusLabel.getY()<610;
            if(inBounds){
                if(focusLabel == crust && crustTouch == false && fillingTouch == false && bananaTouch == false && creamTouch == false){
                    foodKitchen.remove(crust);
                    pie.setIcon(pieimgs.remove(0));
                    foodKitchen.updateScore(2);
                    crustTouch = true;
                    focusLabel = null;
                }else if(focusLabel == filling && crustTouch == true &&  fillingTouch == false && bananaTouch == false && creamTouch == false ){
                    foodKitchen.remove(filling);
                    pie.setIcon(pieimgs.remove(0));
                    foodKitchen.updateScore(2);
                    fillingTouch = true;
                    focusLabel = null;
                }else if (focusLabel == banana && crustTouch == true &&  fillingTouch == true && bananaTouch == false && creamTouch == false){
                    foodKitchen.remove(banana);
                    pie.setIcon(pieimgs.remove(0));
                    foodKitchen.updateScore(2);
                    bananaTouch = true;
                    focusLabel = null;
                }else if (focusLabel == cream && crustTouch == true &&  fillingTouch == true && bananaTouch == true && creamTouch == false){
                    foodKitchen.remove(cream);
                    pie.setIcon(pieimgs.remove(0));
                    creamTouch = true;
                    focusLabel = null;
                    foodKitchen.updateScore(2);
                    foodKitchen.add(returnButton);
                    foodKitchen.moveToFront(returnButton);
                    foodKitchen.getFrame().repaint();
                }else if (focusLabel == filling && crustTouch == false){
                    focusLabel.setBounds(500,220,244,144);
                    focusLabel = null;
                    foodKitchen.updateScore(-1);
                }else if (focusLabel == banana && (crustTouch == false || fillingTouch == false)){
                    focusLabel.setBounds(370,25,240,205);
                    focusLabel = null;
                    foodKitchen.updateScore(-1);
                }else if(focusLabel == cream && (crustTouch == false || fillingTouch == false || bananaTouch == false)){
                    focusLabel.setBounds(100, 25, 200, 169);
                    focusLabel = null;
                    foodKitchen.updateScore(-1);
                }
                foodKitchen.getFrame().repaint();
            }
        }
            
    }
    public JButton getRestaurantButton(){
        return returnButton;
    }
    public class DragListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        //Updates location of focusLabel based on mouse drag action
        {
            Point currentPoint = e.getPoint(); // gets the point where the mouse is currently
            
            if (focusLabel != null){
                focusLabel.setLocation((int)(currentPoint.getX()-50),(int)(currentPoint.getY())-50);
            }
            
            previousPoint = currentPoint; 

            intersects();
            

            foodKitchen.getFrame().repaint();
        }

        

        
    }
}
