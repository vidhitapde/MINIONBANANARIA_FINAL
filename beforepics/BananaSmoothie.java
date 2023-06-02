
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
    JLabel cup;
    JLabel bg;
    JButton upButton;
    JButton downButton;
    JButton checkButton;
    JButton nextButton;
    JButton instButton;
    
    ImageIcon[] bananaImages;
    ImageIcon[] milkImages;
    ImageIcon[] iceImages;
    JLabel result;
    int imageIndex;
    ArrayList<String> levels;
    
    
    JLabel blender;
    ArrayList<ImageIcon> blenderimgs;
    boolean moveLeft;
    int spaceCount;
    boolean switch2;
    boolean switch3;

    JLabel bp;
    JLabel smoothiecup;
    int xcoord;
    int ycoord;
   
    boolean left;
    Timer timer;
    JButton returnButton;
    
    MBFrame mainFrame;
    /**
     * Constructor for objects of class BananaSmoothie
     */
    public BananaSmoothie(KitchenPanel kit)
    {
        super(kit);
        mainFrame = foodKitchen.getFrame();
        foodName = "assets/bananaSmoothie.png";
        bananaImages = new ImageIcon[5];
        bananaImages[0] = new ImageIcon(getClass().getResource("assets/cupwithline.png"));
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
        ImageIcon downIMG = new ImageIcon(getClass().getResource("assets/downbutton.png"));
        ImageIcon checkIMG = new ImageIcon(getClass().getResource("assets/checkbutton.png"));
        ImageIcon cupIMG = new ImageIcon(getClass().getResource("assets/cupwithline.png"));
        ImageIcon nextIMG = new ImageIcon(getClass().getResource("assets/next.png"));
        ImageIcon returnIMG = new ImageIcon(getClass().getResource("assets/return.png"));
        ImageIcon instrIMG = new ImageIcon(getClass().getResource("assets/InstrButton.png"));
        
        bg = new JLabel();
        bg.setIcon(bgIMG);
        bg.setBounds(0,0, 1000,750);
        
        
        cup = new JLabel();
        cup.setIcon(cupIMG);
        cup.setBounds(250, 0, 400, 700);
        
        result = new JLabel();
        result.setBounds(750, 300, 200, 100);
        result.setVisible(false);
        
        upButton = new JButton();
        upButton.setFocusable(false);
        upButton.setBounds(100,250,100,100);
        upButton.addActionListener(this);
        upButton.setIcon(upIMG);
        upButton.setBackground(new Color(0xFFFFFF));
        upButton.setContentAreaFilled(false);
        upButton.setBorder(null);
        
        downButton = new JButton();
        downButton.setFocusable(false);
        downButton.setBounds(100,400,100,100);
        downButton.addActionListener(this);
        downButton.setIcon(downIMG);
        downButton.setBackground(new Color(0xFFFFFF));
        downButton.setContentAreaFilled(false);
        downButton.setBorder(null);
        
        checkButton = new JButton();
        checkButton.setFocusable(false);
        checkButton.setBounds(100,550,100,100);
        checkButton.addActionListener(this);
        checkButton.setIcon(checkIMG);
        checkButton.setBackground(new Color(0xFFFFFF));
        checkButton.setContentAreaFilled(false);
        checkButton.setBorder(null);
        
        
        nextButton = new JButton();
        nextButton.setFocusable(false);
        nextButton.setBounds(450,450,350,350);
        nextButton.addActionListener(this);
        nextButton.setIcon(nextIMG);
        nextButton.setBackground(new Color(0xFFFFFF));
        nextButton.setContentAreaFilled(false);
        nextButton.setBorder(null);
        
        nextButton.setVisible(false);
        
        returnButton = new JButton();
        returnButton.setFocusable(false);
        returnButton.setBounds(450,450,350,350);
        returnButton.addActionListener(foodKitchen);
        returnButton.setIcon(returnIMG);
        returnButton.setBackground(new Color(0xFFFFFF));
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(null);
        
        instButton = new JButton();
        instButton.setFocusable(false);
        instButton.setBounds(700,-40,290,150);
        instButton.addActionListener(this);
        instButton.setIcon(instrIMG);
        instButton.setBackground(new Color(0xFFFFFF));
        instButton.setContentAreaFilled(false);
        instButton.setBorder(null);
        foodKitchen.add(instButton);
        
        switch2 = false;
        
        spaceCount = 0;
        ImageIcon blenderIMG = new ImageIcon(getClass().getResource("assets/blender1.png"));
        
        
        blenderimgs = new ArrayList<ImageIcon>();
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender2.png")));
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender3.png")));
        blenderimgs.add(new ImageIcon(getClass().getResource("assets/blender4.png")));
        
        blender = new JLabel();
        blender.setIcon(blenderIMG);
        blender.setBounds(200, 0, 400, 700);
        
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
        bp.setBounds(xcoord,ycoord, 157, 146);
        left = false;
        
        
        ImageIcon smoothiecupIMG = new ImageIcon(getClass().getResource("assets/donesmoothie.png"));
        smoothiecup = new JLabel();
        smoothiecup.setIcon(smoothiecupIMG);
        smoothiecup.setBounds(350, 250, 287,358);
    }
    public BananaSmoothie()
    {
        super();
        foodName = "assets/bananaSmoothie.png";
    }
    public void addComponents(){
        foodKitchen.add(nextButton);
        foodKitchen.add(cup);
        foodKitchen.add(upButton);
        foodKitchen.add(downButton);
        foodKitchen.add(checkButton);
        foodKitchen.add(result);
    }
    public void removeComponents(){
        foodKitchen.remove(smoothiecup);        
        foodKitchen.remove(bp);
    }
    public void actionPerformed(ActionEvent event){
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
        if(event.getSource() == instButton){
            switchToIntro();
        }
    }
    public void switchToIntro(){
        mainFrame.switchFrame(foodKitchen, mainFrame.getInstPanel());
        
    }

    public void switchTo2(){
        foodKitchen.add(blender);
        foodKitchen.add(nextButton);
        nextButton.setVisible(false);
        foodKitchen.add(instButton);
    }
    public void switchTo3(){
        foodKitchen.add(smoothiecup);        
        foodKitchen.add(bp);
        foodKitchen.add(instButton);
        oscillate();
        
        ToppingAction myTA = new ToppingAction(bp, this, timer);
        InputMap bpInput = bp.getInputMap(bp.WHEN_IN_FOCUSED_WINDOW);
        ActionMap bpAction = bp.getActionMap();
        bpInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        bpAction.put("drop", myTA);
        
        nextButton.setVisible(false);
    }
    public JButton getNextButton(){
        return nextButton;
    }
     public JButton getRestaurantButton(){
        return returnButton;
    }
    public void oscillate(){
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
    public void moveDown(){
        JButton retButton = this.getRestaurantButton();
        timer = new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bp.setLocation(xcoord,ycoord);
                ycoord+=5;
                if(xcoord > 350 && xcoord <625){
                    if(ycoord == 150){
                        timer.setRepeats(false);
                        foodKitchen.add(retButton);
                        foodKitchen.moveToFront(retButton);
                        
                        foodKitchen.getFrame().repaint();
                    }
                }else if(ycoord == 500){
                    timer.setRepeats(false);
                    foodKitchen.add(retButton);
                    foodKitchen.moveToFront(retButton);
                    returnButton.setVisible(true);
                    foodKitchen.getFrame().repaint();
                }
                foodKitchen.getFrame().repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
}

