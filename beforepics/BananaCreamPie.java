
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
    JLabel pie;
    JLabel crust;    
    JLabel filling;
    JLabel cream;
    JLabel banana;
    
    JButton instButton;
    
    ArrayList<ImageIcon> pieimgs;
    ArrayList<JLabel> ingredients;
    
    Point previousPoint;
    
    boolean collision;
    
    boolean crustTouch;
    boolean fillingTouch;
    boolean bananaTouch;
    boolean creamTouch;
    
    JLabel focusLabel;
    
    
    JButton returnButton;
    MBFrame mainFrame;
    /**
     * Constructor for objects of class BananaCreamPie
     */
    public BananaCreamPie(KitchenPanel kit)
    {
        super(kit);
        foodName = "assets/bananacreampie.png";
        
        mainFrame = foodKitchen.getFrame();
        
        ImageIcon pieIMG = new ImageIcon(getClass().getResource("assets/pie1.png"));
        ImageIcon creamIMG = new ImageIcon(getClass().getResource("assets/cream.png"));
        ImageIcon crustIMG = new ImageIcon(getClass().getResource("assets/piecrust.png"));
        ImageIcon bananaIMG = new ImageIcon(getClass().getResource("assets/bananaslices.png"));
        ImageIcon fillingIMG = new ImageIcon(getClass().getResource("assets/bananafilling.png"));
        ImageIcon returnIMG = new ImageIcon(getClass().getResource("assets/return.png"));
        ImageIcon instrIMG = new ImageIcon(getClass().getResource("assets/InstrButton.png"));
        
        pie = new JLabel();
        cream = new JLabel();
        crust = new JLabel();
        banana = new JLabel();
        filling = new JLabel();
           
        pie.setIcon(pieIMG);
        pie.setBounds(200,450,632,250);
        cream.setIcon(creamIMG);
        cream.setBounds(100,100,199,103);
        crust.setIcon(crustIMG);
        crust.setBounds(150, 300, 303,112); 
        banana.setIcon(bananaIMG);
        banana.setBounds(500,100,244,124);
        filling.setIcon(fillingIMG);
        filling.setBounds(500, 300, 244,124);
           
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
        returnButton.setBounds(450,450,350,50);
        returnButton.addActionListener(foodKitchen);
        returnButton.setIcon(returnIMG);
        returnButton.setBackground(new Color(0xFFFFFF));
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(null);
        
        instButton = new JButton();
        instButton.setFocusable(false);
        instButton.setBounds(700,-40,290,150);
        instButton.addActionListener(foodKitchen);
        instButton.setIcon(instrIMG);
        instButton.setBackground(new Color(0xFFFFFF));
        instButton.setContentAreaFilled(false);
        instButton.setBorder(null);
        foodKitchen.add(instButton);
            
        previousPoint = new Point(0, 0);
    }
    public BananaCreamPie()
    {
        super();
        foodName = "assets/bananacreampie.png";
    
    }
     public class ClickListener extends MouseAdapter 
    {
        public void mousePressed(MouseEvent e)
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
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == instButton){
            switchToIntro();
        }
    }
    public void switchToIntro(){
        mainFrame.switchFrame(foodKitchen, mainFrame.getInstPanel());
        
    }
    public void addComponents(){
        foodKitchen.add(filling);
        foodKitchen.add(crust);
        foodKitchen.add(banana);
        foodKitchen.add(cream);
        foodKitchen.add(pie);
        foodKitchen.add(instButton);
    }
    public void removeComponents(){
        foodKitchen.remove(pie);
        
    }
    public void intersects ()
        {
            /**int imageSideL = (int) imageCorner.getX(); 
            int imageSideR = imageSideL + WIDTH; 
            int imageTop = (int) imageCorner.getY();
            int imageBottom = HEIGHT + imageTop;

            int image2SideL = 50; 
            int image2SideR = image2SideL + image2.getIconWidth( ); 
            int image2Top = 50; 
            int image2Bottom = image2Top + image2.getIconHeight(); 

            if (imageSideR >= image2SideL && imageSideL <= image2SideR && imageBottom >= image2Top && imageTop <= image2Bottom)
            {
                return true;
            }
            */
            boolean inBounds = focusLabel.getX() > 250 && focusLabel.getX()<770 && focusLabel.getY()>480 && focusLabel.getY()<610;
            if(inBounds){
                if(focusLabel == crust && crustTouch == false && fillingTouch == false && bananaTouch == false && creamTouch == false){
                    foodKitchen.remove(crust);
                    pie.setIcon(pieimgs.remove(0));
                    crustTouch = true;
                }else if(focusLabel == filling && crustTouch == true &&  fillingTouch == false && bananaTouch == false && creamTouch == false ){
                    foodKitchen.remove(filling);
                    pie.setIcon(pieimgs.remove(0));
                    fillingTouch = true;
                }else if (focusLabel == banana && crustTouch == true &&  fillingTouch == true && bananaTouch == false && creamTouch == false){
                    foodKitchen.remove(banana);
                    pie.setIcon(pieimgs.remove(0));
                    bananaTouch = true;
                }else if (focusLabel == cream && crustTouch == true &&  fillingTouch == true && bananaTouch == true && creamTouch == false){
                    foodKitchen.remove(cream);
                    pie.setIcon(pieimgs.remove(0));
                    creamTouch = true;
                    foodKitchen.add(returnButton);
                    foodKitchen.moveToFront(returnButton);
                    foodKitchen.getFrame().repaint();
                }else{
                    foodKitchen.updateScore(-1);
                }
                foodKitchen.getFrame().repaint();
            }
            
            
            

        }
    public JButton getRestaurantButton(){
        return returnButton;
    }
    public class DragListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        {
            Point currentPoint = e.getPoint(); // gets the point where the mouse is currently
            
            focusLabel.setLocation((int)(currentPoint.getX()-50),(int)(currentPoint.getY())-50);
            
            previousPoint = currentPoint; 

            intersects();
            

            foodKitchen.getFrame().repaint();
        }

        

        
    }
}