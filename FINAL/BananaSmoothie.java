
import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;

/**
 * Write a description of class BananaSmoothie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BananaSmoothie extends Food implements ActionListener
{
    JLabel cup; //displays the cup image
    JLabel bg; // displays bg label
    JButton upButton; // up button
    JButton downButton; // down button
    JButton checkButton; // check button
    JButton nextButton; // next button
    
    ImageIcon[] bananaImages; // stores the images of the banana 
    ImageIcon[] milkImages; // stores the images of levels of milk
    ImageIcon[] iceImages; // stores the images of levels of ice 
    JLabel result; // displays the result label
    int imageIndex; // holds the image index number
    ArrayList<String> levels; // holds a list of levels (array list)
    
    
    JLabel blender; // instantiates the blender label
    ArrayList<ImageIcon> blenderimgs; // holds a list of blender images 
    boolean moveLeft; 
    int spaceCount; // Stores the number of times space bar is pressed
    boolean switch2; // Returns true or false of switch2 has happened
    boolean switch3;// Returns true or false of switch3 has happened

    JLabel bp; // instantiates the umbrella panel
    JLabel smoothiecup; // instantiates the smoothie cup panel
    int xcoord;// holds the x-coordinate of the object 
    int ycoord; // holds the y-coordinate of the object
   
    boolean left; //Returns true or false if the object is moving left
    Timer timer; // instantiates the timer
    JButton returnButton; // instantiates the return button
    
    MBFrame mainFrame; // displays the screens 
    /**
     * Constructor for objects of class BananaSmoothie
     */
    public BananaSmoothie(KitchenPanel kit) 
    // extends food and calls super (kit)
    {
        super(kit);
        mainFrame = foodKitchen.getFrame();
        foodName = "assets/bananaSmoothie.png";
        bananaImages = new ImageIcon[5];
        bananaImages[0] = new ImageIcon(getClass().getResource("assets/bananafill0.png"));
        bananaImages[1] = new ImageIcon(getClass().getResource("assets/bananafill1.png"));
        bananaImages[2] = new ImageIcon(getClass().getResource("assets/bananafill2.png"));
        bananaImages[3] = new ImageIcon(getClass().getResource("assets/bananafill3.png"));
        bananaImages[4] = new ImageIcon(getClass().getResource("assets/bananafill4.png"));
        
        milkImages = new ImageIcon[5];
        milkImages[0] = new ImageIcon(getClass().getResource("assets/milk0.png"));
        milkImages[1] = new ImageIcon(getClass().getResource("assets/milk1.png"));
        milkImages[2] = new ImageIcon(getClass().getResource("assets/milk2.png"));
        milkImages[3] = new ImageIcon(getClass().getResource("assets/milk3.png"));
        milkImages[4] = new ImageIcon(getClass().getResource("assets/milk4.png"));
        
        iceImages = new ImageIcon[5];
        iceImages[0] = new ImageIcon(getClass().getResource("assets/ice0.png"));
        iceImages[1] = new ImageIcon(getClass().getResource("assets/ice1.png"));
        iceImages[2] = new ImageIcon(getClass().getResource("assets/ice2.png"));
        iceImages[3] = new ImageIcon(getClass().getResource("assets/ice3.png"));
        iceImages[4] = new ImageIcon(getClass().getResource("assets/ice4.png"));
        
        imageIndex = 0;
        
        levels = new ArrayList<String>();
        levels.add("banana");
        levels.add("ice");
        levels.add("milk");
        
        
        
        
        ImageIcon bgIMG = new ImageIcon(getClass().getResource("assets/bg.png"));
        
        ImageIcon upIMG = new ImageIcon(getClass().getResource("assets/upbutton.png"));
        ImageIcon rolloverUpImage = new ImageIcon(getClass().getResource("assets/hoverplayupbutton.png"));
        
        ImageIcon downIMG = new ImageIcon(getClass().getResource("assets/downbutton.png"));
        ImageIcon rolloverDownImage = new ImageIcon(getClass().getResource("assets/hoverplaydownbutton.png"));
        
        ImageIcon checkIMG = new ImageIcon(getClass().getResource("assets/checkbutton.png"));
        ImageIcon rolloverCheckImage = new ImageIcon(getClass().getResource("assets/hoverplaycheckbutton.png"));
        
        ImageIcon cupIMG = new ImageIcon(getClass().getResource("assets/bananafill0.png"));
        ImageIcon nextIMG = new ImageIcon(getClass().getResource("assets/next.png"));
        ImageIcon returnIMG = new ImageIcon(getClass().getResource("assets/done.png"));
        
        bg = new JLabel();
        bg.setIcon(bgIMG);
        bg.setBounds(0,0, 1000,750);
        
        
        cup = new JLabel();
        cup.setIcon(cupIMG);
        cup.setBounds(175, 0, 750, 750);
        
        result = new JLabel();
        result.setBounds(645, 300, 315, 115);
        result.setVisible(false);
        
        upButton = new JButton();
        upButton.setFocusable(false);
        upButton.setBounds(100,175,100,100);
        upButton.addActionListener(this);
        upButton.setIcon(upIMG);
        upButton.setBackground(new Color(0xFFFFFF));
        upButton.setContentAreaFilled(false);
        upButton.setBorder(null);
        upButton.setRolloverEnabled(true);
        upButton.setRolloverIcon(rolloverUpImage);
        
        downButton = new JButton();
        downButton.setFocusable(false);
        downButton.setBounds(100,325,100,100);
        downButton.addActionListener(this);
        downButton.setIcon(downIMG);
        downButton.setBackground(new Color(0xFFFFFF));
        downButton.setContentAreaFilled(false);
        downButton.setBorder(null);
        downButton.setRolloverEnabled(true);
        downButton.setRolloverIcon(rolloverDownImage);
        
        checkButton = new JButton();
        checkButton.setFocusable(false);
        checkButton.setBounds(100,475,100,100);
        checkButton.addActionListener(this);
        checkButton.setIcon(checkIMG);
        checkButton.setBackground(new Color(0xFFFFFF));
        checkButton.setContentAreaFilled(false);
        checkButton.setBorder(null);
        checkButton.setRolloverEnabled(true);
        checkButton.setRolloverIcon(rolloverCheckImage);
        
        
        nextButton = new JButton();
        nextButton.setFocusable(false);
        nextButton.setBounds(700,450,175,175);
        nextButton.addActionListener(this);
        nextButton.setIcon(nextIMG);
        nextButton.setBackground(new Color(0xFFFFFF));
        nextButton.setContentAreaFilled(false);
        nextButton.setBorder(null);
        
        nextButton.setVisible(false);
        
        returnButton = new JButton();
        returnButton.setFocusable(false);
        returnButton.setBounds(600,450,350,350);
        returnButton.addActionListener(foodKitchen);
        returnButton.setIcon(returnIMG);
        returnButton.setBackground(new Color(0xFFFFFF));
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(null);
        
        switch2 = false;
        
        spaceCount = 0;
        ImageIcon blenderIMG = new ImageIcon(getClass().getResource("assets/blender1.png"));
        
        
        blenderimgs = new ArrayList<ImageIcon>();
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender2.png")));
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender3.png")));
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender4.png")));
        
        blender = new JLabel();
        blender.setIcon(blenderIMG);
        blender.setBounds(10, -100, 600, 1000);
        
        BlenderAction myBA = new BlenderAction(blender, this);
        InputMap blenderInput = blender.getInputMap(blender.WHEN_IN_FOCUSED_WINDOW);
        ActionMap blenderAction = blender.getActionMap();
        blenderInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "move");
        blenderAction.put("move", myBA);
        
        switch3 = false;
        
        
        ImageIcon umbrellaIMG = new ImageIcon(getClass().getResource("assets/umbrella.png"));
        bp = new JLabel();
        bp.setIcon(umbrellaIMG);
        xcoord=200;
        ycoord = 0;
        bp.setBounds(xcoord,ycoord, 146, 146);
        left = false;
        
        
        ImageIcon smoothiecupIMG = new ImageIcon(getClass().getResource("assets/donesmoothie.png"));
        smoothiecup = new JLabel();
        smoothiecup.setIcon(smoothiecupIMG);
        smoothiecup.setBounds(350, 250, 236,395);
    }
    public BananaSmoothie()
    // constructor = extends food and calls super () 
    {
        super();
        foodName = "assets/Banana Smoothie Speech Bubble.png";
    }
    public void addComponents()
    // adds components from foodKitchen
    {
        foodKitchen.add(nextButton);
        foodKitchen.add(cup);
        foodKitchen.add(upButton);
        foodKitchen.add(downButton);
        foodKitchen.add(checkButton);
        foodKitchen.add(result);
    }
    public void removeComponents()
    // removes components from foodKitchen
    {
        foodKitchen.remove(smoothiecup);        
        foodKitchen.remove(bp);
    }
    public void actionPerformed(ActionEvent event)
    //Checks for button presses and executes the corresponding methods
    {
        if(event.getSource() == upButton){
            if(imageIndex < 4){
                imageIndex ++;
                if(levels.get(0) == "banana"){
                    cup.setIcon(bananaImages[imageIndex]);
                }else if(levels.get(0) == "ice"){
                    cup.setIcon(iceImages[imageIndex]);
                }else if(levels.get(0) == "milk"){
                    cup.setIcon(milkImages[imageIndex]);
                }
                foodKitchen.getFrame().repaint();
            }
        }
        if(event.getSource() == downButton){
            if(imageIndex > 0){
                imageIndex --;
                if(levels.get(0) == "banana"){
                    cup.setIcon(bananaImages[imageIndex]);
                }else if(levels.get(0) == "ice"){
                    cup.setIcon(iceImages[imageIndex]);
                }else if(levels.get(0) == "milk"){
                    cup.setIcon(milkImages[imageIndex]);
                }
                foodKitchen.getFrame().repaint();
            }
        }
        if(event.getSource() == checkButton){
            if(imageIndex!= 3){
                ImageIcon wrongIMG = new ImageIcon(getClass().getResource("assets/wrong.png"));
                result.setIcon(wrongIMG);
                result.setVisible(true);
                foodKitchen.updateScore(-1);
                Timer timer = new Timer(1000, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        result.setVisible(false);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }else{
                ImageIcon slayIMG = new ImageIcon(getClass().getResource("assets/slay.png"));
                result.setIcon(slayIMG);
                result.setVisible(true);
                foodKitchen.updateScore(1);
                if(levels.size() != 0){
                    String the = levels.remove(0);
                }
                
                imageIndex = 0;
                if(levels.size() == 0){
                    
                    
                    ImageIcon nextIMG = new ImageIcon(getClass().getResource("assets/next.png"));
                    
                    nextButton.setVisible(true);
                    
                    mainFrame.repaint();
                }else if(levels.get(0) == "ice"){
                    cup.setIcon(iceImages[imageIndex]);
                    foodKitchen.getFrame().repaint();
                }else if(levels.get(0) == "milk"){
                    cup.setIcon(milkImages[imageIndex]);
                    foodKitchen.getFrame().repaint();
                }
                Timer timer = new Timer(1000, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        result.setVisible(false);
                    }
                });
                timer.setRepeats(false);
                timer.start();
                
            }
        }
        if(event.getSource() == nextButton){
            foodKitchen.removeAll();
            foodKitchen.add(foodKitchen.getScoreLabel());
            foodKitchen.add(foodKitchen.getHelpButton(), 0);
            if(switch2 == true && switch3 == false){
                switchTo3();
                switch3 = true;
            }
            if(switch2 == false){
                switchTo2();
                switch2 = true;
            }
            foodKitchen.getFrame().repaint();
        }
    }
    public void switchTo2()
    // switches to the filling smoothie frame
    {
        foodKitchen.add(blender);
        foodKitchen.add(nextButton);
        nextButton.setVisible(false);
    }
    public void switchTo3()
    // switches to the blender frame 
    
    {
        
        foodKitchen.add(smoothiecup);        
        foodKitchen.add(bp);
        
        oscillate();
        
        ToppingAction myTA = new ToppingAction(bp, this, timer);
        InputMap bpInput = bp.getInputMap(bp.WHEN_IN_FOCUSED_WINDOW);
        ActionMap bpAction = bp.getActionMap();
        bpInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        bpAction.put("drop", myTA);
        
        nextButton.setVisible(false);
    }
    public JButton getNextButton()
    // returns to the next button
    {
        return nextButton;
    }
     public JButton getRestaurantButton()
     // returns to the back to the restaurant button
     {
        return returnButton;
    }
    public void oscillate()
    // oscillates the ingredient back and forth
    {
        
        timer = new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bp.setLocation(xcoord,0);
                
                if(left == false){
                    xcoord+=5;
                }else{
                    xcoord-=5;
                }
                if(xcoord == 800 || xcoord == 200){
                    left = !left;
                }
                bp.getParent().repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
    public JLabel getTopping(){
        return bp;
    }
    public void moveDown()
    // responsible for keyboard space bar (moves object down when pressed)
    {
        JButton retButton = this.getRestaurantButton();
        timer = new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bp.setLocation(xcoord,ycoord);
                ycoord+=5;
                if(xcoord > 320 && xcoord <445){
                    if(ycoord == 175){
                        timer.setRepeats(false);
                        foodKitchen.add(retButton);
                        foodKitchen.moveToFront(retButton);
                        foodKitchen.updateScore(2);
                        foodKitchen.getFrame().repaint();
                    }
                }else if(ycoord == 500){
                    timer.setRepeats(false);
                    foodKitchen.add(retButton);
                    foodKitchen.moveToFront(retButton);
                    returnButton.setVisible(true);
                    foodKitchen.updateScore(-1);
                    foodKitchen.getFrame().repaint();
                }
                foodKitchen.getFrame().repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
}

