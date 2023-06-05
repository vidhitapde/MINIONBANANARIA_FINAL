import java.awt.*; // access to Container
import java.awt.event.*; // access to WindowAdapter, WindowEvent
import javax.swing.*; // access to JFrame and Jcomponents
import javax.swing.event.*; // access to JSlider events
import javax.swing.Timer;
import java.util.*;
/**
 * Write a description of class BananasFoster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BananasFoster extends Food implements ActionListener, MouseListener
{
    JLabel griddle; // pancake griddle image
    ArrayList<ImageIcon> griddleimgs; // list of images for the pancake griddle
    JLabel batter1; // first pancake batter image 
    JLabel batter2; // second pancake batter image 
    JLabel batter3;// third pancake batter image
    JLabel batter4;// fourth pancake batter image
    JLabel batter5;// fifth pancake batter image
    JLabel batter6;// sixth pancake batter image
    JLabel[] batters; // List of batter JLabels

    JLabel pan; // pan image
    JLabel butter; // butter image 
    JLabel sugar; // sugar image
    JLabel banana; // banana image 
    ArrayList<JLabel> paningredients; // holds ingredients for pan step
    ArrayList<ImageIcon> panimgs; // holds images for the pan

    int batterCount; // holds the number of batters dropped onto the pan
    JButton nextButton; // button for the next step
    JButton returnButton; // button to return to the restaurant 

    private JLabel pancake1; // img for first stacked pancake
    private JLabel pancake2; // img for second stacked pancake
    private JLabel pancake3; // img for third stacked pancake
    private JLabel plate; // / img for plate

    private int x1; // xcoordinate for pancake1
    private int y1; //y coordinate for pancake1

    private int x2; // xcoordinate for pancake2
    private int y2; //y coordinate for pancake2

    private int x3; // xcoordinate for pancake3
    private int y3; //y coordinate for pancake3

    private boolean left; // true if the pancake is moving left 
    private Timer timer; // times the game

    JLabel pancakePlate; // image of pancake plate
    JLabel syrup; // image of the syrup 
    JLabel chocolateChips; // image of the bananas 
    JLabel whippedCream; // image of whipped cream
    ArrayList<JLabel> plateingredients; // JLabels of plate ingredients 
    ArrayList<ImageIcon> plateimgs; // images of plates 

    boolean switch2; //Stores if switch2 method has been executed
    boolean switch3; //Stores if switch3 method has been executed
    boolean switch4; //Stores if switch4 method has been executed

    Point previousPoint; //Stores previous coordinates
    JLabel focusLabel; // Jlabel being moved 

    boolean butterTouch; // stores if butter touches pan
    boolean sugarTouch; // stores if sugar touches pan
    boolean bananaTouch; // sotres if bananas touches pan
    boolean syrupTouch; // stores if syrup touches pancakes 
    boolean whippedCreamTouch; // stores if whipped cream touches pancakes 
    boolean chocolateChipsTouch; // stores if banana sugar touches pancakes 
    
    
    public BananasFoster(KitchenPanel kit) 
    // extends food and calls super (kit)
    {
        super(kit);
        foodName = "assets/Banana Pancake Speech Bubble.png";

        switch2 = false;
        switch3 = false;
        switch4 = false;

        ImageIcon griddleIMG = new ImageIcon(getClass().getResource("assets/griddle1.png"));
        ImageIcon nextIMG = new ImageIcon(getClass().getResource("assets/next.png"));
        ImageIcon returnIMG = new ImageIcon(getClass().getResource("assets/done.png"));

        griddle = new JLabel();
        griddle.setIcon(griddleIMG);
        griddle.setBounds(0,0, 1000, 750);
        griddle.addMouseListener(this);

        griddleimgs = new ArrayList<ImageIcon>();
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle2.png")));
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle3.png")));
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle4.png")));
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle5.png")));
        griddleimgs.add(new ImageIcon(getClass().getResource("assets/griddle6.png")));

        batter1 = new JLabel();
        batter2 = new JLabel();
        batter3 = new JLabel();
        batter4 = new JLabel();
        batter5 = new JLabel();
        batter6 = new JLabel();
        JLabel[] batters = new JLabel[6];
        batters[0] = batter1;
        batters[1] = batter2;
        batters[2] = batter3;
        batters[3] = batter4;
        batters[4] = batter5;
        batters[5] = batter6;
        batterCount = 0;

        ImageIcon panIMG = new ImageIcon(getClass().getResource("assets/pan1.png"));
        pan = new JLabel();
        pan.setIcon(panIMG);
        pan.setBounds(400, 100,470,470);
        panimgs = new ArrayList<ImageIcon>();
        panimgs.add(new ImageIcon(getClass().getResource("assets/pan2.png")));
        panimgs.add(new ImageIcon(getClass().getResource("assets/pan3.png")));
        panimgs.add(new ImageIcon(getClass().getResource("assets/pan4.png")));

        ImageIcon butterIMG = new ImageIcon(getClass().getResource("assets/butterbowl.png"));
        ImageIcon sugarIMG = new ImageIcon(getClass().getResource("assets/sugarbowl.png"));
        ImageIcon bananaIMG = new ImageIcon(getClass().getResource("assets/bananaslices.png"));

        butter = new JLabel();
        butter.setIcon(butterIMG);
        butter.setBounds(100, 100, 200, 71);

        sugar = new JLabel();
        sugar.setIcon(sugarIMG);
        sugar.setBounds(100, 200, 200, 200);

        banana = new JLabel();
        banana.setIcon(bananaIMG);
        banana.setBounds(100, 425, 220, 188);

        paningredients = new ArrayList<JLabel>();
        paningredients.add(butter);
        paningredients.add(sugar);
        paningredients.add(banana);

        ImageIcon pancake1IMG = new ImageIcon(getClass().getResource("assets/pancakes.png"));
        pancake1 = new JLabel();
        pancake1.setIcon(pancake1IMG);
        x1= 200;
        y1 = 0;
        pancake1.setBounds(x1,y1, 500, 500);


        ImageIcon pancake2IMG = new ImageIcon(getClass().getResource("assets/pancakes.png"));
        pancake2 = new JLabel();
        pancake2.setIcon(pancake2IMG);
        x2 = 50;
        y2 = 0;
        pancake2.setBounds(x2,y2, 500, 500);


        ImageIcon pancake3IMG = new ImageIcon(getClass().getResource("assets/pancakes.png"));
        pancake3 = new JLabel();
        pancake3.setIcon(pancake3IMG);
        x3 = 50;
        y3 = 0;
        pancake3.setBounds(x1,y1, 500, 500);
        left = false;

        ImageIcon plateIMG2 = new ImageIcon(getClass().getResource("assets/pie1.png"));
        plate = new JLabel();
        plate.setIcon(plateIMG2);
        plate.setBounds(0,0, 1000,750);

        ImageIcon plateIMG = new ImageIcon(getClass().getResource("assets/pancake1.png"));
        pancakePlate = new JLabel();
        pancakePlate.setIcon(plateIMG);
        pancakePlate.setBounds(0,0,1000,750);

        plateimgs = new ArrayList<ImageIcon>();
        plateimgs.add(new ImageIcon(getClass().getResource("assets/pancake2.png")));
        plateimgs.add(new ImageIcon(getClass().getResource("assets/pancake3.png")));
        plateimgs.add(new ImageIcon(getClass().getResource("assets/pancake4.png")));

        ImageIcon syrupIMG = new ImageIcon(getClass().getResource("assets/syrup.png"));
        ImageIcon whippedcreamIMG = new ImageIcon(getClass().getResource("assets/chocolatechips.png"));
        ImageIcon chocIMG = new ImageIcon(getClass().getResource("assets/whippedcream.png"));

        syrup = new JLabel();
        syrup.setIcon(syrupIMG);
        syrup.setBounds(130, 20, 127, 210);

        whippedCream = new JLabel();
        whippedCream.setIcon(whippedcreamIMG);
        whippedCream.setBounds(300, 20, 310, 236);

        chocolateChips = new JLabel();
        chocolateChips.setIcon(chocIMG);
        chocolateChips.setBounds(640, 20, 210, 210);

        plateingredients = new ArrayList<JLabel>();
        plateingredients.add(syrup);
        plateingredients.add(whippedCream);
        plateingredients.add(chocolateChips);

        syrupTouch = false;
        whippedCreamTouch = false;
        chocolateChipsTouch = false;

        nextButton = new JButton();
        nextButton.setFocusable(false);
        nextButton.setBounds(700,450,350,350);
        nextButton.addActionListener(this);
        nextButton.setIcon(nextIMG);
        nextButton.setBackground(new Color(0xFFFFFF));
        nextButton.setContentAreaFilled(false);
        nextButton.setBorder(null);

        nextButton.setVisible(false);
        
        returnButton = new JButton();
        returnButton.setFocusable(false);
        returnButton.setBounds(600,450,350,350);
        returnButton.addActionListener(foodKitchen); //FIX THIS
        returnButton.setIcon(returnIMG);
        returnButton.setBackground(new Color(0xFFFFFF));
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(null);
        ClickListener clickListener = new ClickListener(); 
        DragListener dragListener = new DragListener();

        foodKitchen.addMouseListener(clickListener); 
        foodKitchen.addMouseMotionListener(dragListener); 
        
        
    }
    public BananasFoster()
    //extends food and calls super()
    {
        super();
        foodName = "assets/Banana Pancake Speech Bubble.png";
    }

    public void addComponents()
    // adds components to the panel
    {
        
        foodKitchen.add(griddle);
        foodKitchen.add(nextButton);
        
    }

    public void removeComponents()
    // removes components from panel

    {
        foodKitchen.remove(pancakePlate);
    }

    public void switchTo2()
    // switches to the next step
    {
        foodKitchen.add(butter);
        foodKitchen.add(sugar);
        foodKitchen.add(banana);
        foodKitchen.add(pan);
        nextButton.setVisible(false);
        /** 
         * 
        this.add(smoothiecup);        
        this.add(bp);

        oscillate();

        toppingAction myTA = new toppingAction(bp, this, timer);
        InputMap bpInput = bp.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap bpAction = bp.getActionMap();
        bpInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        bpAction.put("drop", myTA);

        nextButton.setVisible(false);
         */
    }
    
    public JButton getNextButton()
    //returns nextButton object
    {
        return nextButton;
    }

    public JLabel getPancake1()
    // returns pancake1
    {
        return pancake1;
    }

    public JLabel getPancake2()
    // returns pancake2    
    {
        return pancake2;
    }

    public JLabel getPancake3()
    // returns pancake3
    {
        return pancake3;
    }

    public void switchTo3()
    // switches to the next step
    {
        foodKitchen.add(plate);
        foodKitchen.add(pancake1);
        oscillate(pancake1); 

        pancakeAction myTA = new pancakeAction(pancake1, this, timer);
        InputMap pancake1Input = pancake1.getInputMap(pancake1.WHEN_IN_FOCUSED_WINDOW);
        ActionMap pancake1Action = pancake1.getActionMap();
        pancake1Input.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        pancake1Action.put("drop", myTA);
    }

    public void switchTo4()
    //switches to the next step
    {
        foodKitchen.add(syrup);
        foodKitchen.add(whippedCream);
        foodKitchen.add(chocolateChips);
        foodKitchen.add(pancakePlate);

    }

    public void mouseClicked(MouseEvent e)
    // updates panel accordingly
    {
        JLabel currBatter = null;
        int XBound1 = 0;
        int YBound1 = 0;
        int XBound2 = 0;
        int YBound2 = 0;
        if(batterCount < 6){

            if(batterCount ==0){
                currBatter = batter1;
                XBound1 = 202;
                XBound2 = 238;
                YBound1 = 132;
                YBound2 = 168;
            }else if(batterCount == 1){
                currBatter = batter2;
                XBound1 = 382;
                XBound2 = 418;
                YBound1 = 132;
                YBound2 = 168;
            }else if(batterCount ==2){
                currBatter = batter3;
                XBound1 = 572;
                XBound2 = 608;
                YBound1 = 132;
                YBound2 = 168;
            }else if(batterCount == 3){
                currBatter = batter4;
                XBound1 = 202;
                XBound2 = 238;
                YBound1 = 322;
                YBound2 = 358;
            }else if (batterCount == 4){
                currBatter = batter5;
                XBound1 = 382;
                XBound2 = 418;
                YBound1 = 322;
                YBound2 = 358;
            }else if (batterCount == 5){
                currBatter = batter6;
                XBound1 = 572;
                XBound2 = 608;
                YBound1 = 322;
                YBound2 = 358;
            }

            currBatter.setIcon(new ImageIcon(getClass().getResource("assets/battercircleogc.png")));
            foodKitchen.add(currBatter);
            foodKitchen.moveToFront(currBatter);
            int currentX = (int)MouseInfo.getPointerInfo().getLocation().getX()-90;
            int currentY = (int)MouseInfo.getPointerInfo().getLocation().getY()-130;
          
            currBatter.setBounds(currentX, currentY, 208, 208);
            if(!(currentX > XBound1 && currentX < XBound2 && currentY > YBound1 && currentY < YBound2)){
                foodKitchen.updateScore(-1);

            }else{
                foodKitchen.updateScore(1);
            }
            if(griddleimgs.size() > 0){
                griddle.setIcon(griddleimgs.remove(0));
            }

            foodKitchen.getFrame().repaint();
            batterCount++;

        }
        if (batterCount == 6){
            nextButton.setVisible(true);
            foodKitchen.moveToFront(nextButton);
            foodKitchen.getFrame().repaint();
            batterCount++;
        }

    }

    public void mousePressed(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void actionPerformed(ActionEvent event)
    // checks for button press, updates game, accordingly
    {
        if(event.getSource() == nextButton){
            foodKitchen.removeAll();
            foodKitchen.add(foodKitchen.getScoreLabel());
            foodKitchen.add(foodKitchen.getHelpButton(), 0);
            if(switch2 == true && switch3 == true){
                switchTo4();
                switch4 = true;
            }

            if(switch2 == true && switch3 == false){
                System.out.println("switching");
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
    private class ClickListener extends MouseAdapter 
    {
        public void mousePressed(MouseEvent e)
        {
            previousPoint = e.getPoint(); // updating the previous point to new place that is clicked
            if(switch2 == true && switch3 == false){
                for(JLabel img: paningredients){
                    boolean withinBounds = previousPoint.getX() > img.getX() && previousPoint.getX()<(img.getX()+img.getWidth()) && previousPoint.getY() > img.getY() && previousPoint.getY() <(img.getY()+img.getHeight());
                    if(withinBounds){
                        focusLabel = img;
                    }
                }
            }else if(switch2 == true && switch3 == true && switch4 == true){
                for(JLabel img: plateingredients){
                    boolean withinBounds = previousPoint.getX() > img.getX() && previousPoint.getX()<(img.getX()+img.getWidth()) && previousPoint.getY() > img.getY() && previousPoint.getY() <(img.getY()+img.getHeight());
                    if(withinBounds){
                        focusLabel = img;
                    }
                }
            }
        }
    }

    public void intersects ()
    //checks for collision
    {
        

        if(switch2 == true && switch3 == false){
            if(focusLabel.getX() > 500 && focusLabel.getX()<850 && focusLabel.getY()>150 && focusLabel.getY()<900){
                if(focusLabel == butter && butterTouch == false && sugarTouch == false){
                    foodKitchen.updateScore(1);
                    foodKitchen.remove(butter);
                    pan.setIcon(panimgs.remove(0));
                    butterTouch = true;
                    focusLabel = null;
                }else if(focusLabel == sugar && butterTouch == true && sugarTouch == false){
                    foodKitchen.updateScore(1);
                    foodKitchen.remove(sugar);
                    pan.setIcon(panimgs.remove(0));
                    sugarTouch = true;
                    focusLabel = null;
                }else if (focusLabel == banana && butterTouch == true && sugarTouch == true){
                    foodKitchen.updateScore(1);
                    foodKitchen.add(nextButton,0);
                    nextButton.setVisible(true);
                    foodKitchen.moveToFront(nextButton);
                    foodKitchen.remove(banana);
                    pan.setIcon(panimgs.remove(0));
                    focusLabel = null;

                }else if (focusLabel == sugar && (butterTouch == false && sugarTouch == false) ) {
                    focusLabel.setBounds(100, 250, 200, 200);
                    focusLabel = null;
                    foodKitchen.updateScore(-1);
                }else if(focusLabel == banana && (butterTouch == false && sugarTouch == false || butterTouch == true && sugarTouch == false)){
                    focusLabel.setBounds(100, 500, 220, 188);
                    focusLabel = null;
                    foodKitchen.updateScore(-1);
                }
                foodKitchen.getFrame().repaint();
            }
        }else if(switch2==true && switch3 == true){
            if(focusLabel.getX() > 250 && focusLabel.getX()<770 && focusLabel.getY()>250 && focusLabel.getY()<680){
                if(focusLabel == syrup && syrupTouch == false && whippedCreamTouch == false && chocolateChipsTouch == false){
                    foodKitchen.remove(syrup);
                    foodKitchen.updateScore(1);
                    pancakePlate.setIcon(plateimgs.remove(0));
                    focusLabel = null;
                    syrupTouch = true;
                }else if(focusLabel == whippedCream && syrupTouch == true && whippedCreamTouch == false && chocolateChipsTouch == false){
                    foodKitchen.remove(whippedCream);
                    foodKitchen.updateScore(1);
                    pancakePlate.setIcon(plateimgs.remove(0));
                    focusLabel = null;
                    whippedCreamTouch = true;
                }else if (focusLabel == chocolateChips && syrupTouch == true && whippedCreamTouch == true && chocolateChipsTouch == false){
                    foodKitchen.remove(chocolateChips);
                    pancakePlate.setIcon(plateimgs.remove(0));
                    focusLabel = null;
                    chocolateChipsTouch = true;
                    foodKitchen.updateScore(1);
                    foodKitchen.remove(banana);
                    foodKitchen.add(returnButton);
                    returnButton.setVisible(true);
                    foodKitchen.moveToFront(returnButton);

                }else if (focusLabel == whippedCream && syrupTouch == false && whippedCreamTouch == false){
                    focusLabel.setBounds(400, 20, 107, 219);
                    focusLabel = null;
                    foodKitchen.updateScore(-1);
                }else if (focusLabel == chocolateChips &&(syrupTouch == false && whippedCreamTouch == false || syrupTouch == true && whippedCreamTouch == false)){
                    focusLabel.setBounds(700, 20, 233, 72);
                    focusLabel = null;
                    foodKitchen.updateScore(-1);
                }
                foodKitchen.getFrame().repaint();
            }
        }


    }

    public void pancakeTwo()
    // adds, executes components associated with pancake2
    {
        foodKitchen.add(pancake2);
        oscillate(pancake2); 

        pancakeAction myTA2 = new pancakeAction(pancake2, this, timer);
        InputMap panInput = pancake2.getInputMap(pancake2.WHEN_IN_FOCUSED_WINDOW);
        ActionMap panAction = pancake2.getActionMap();
        panInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        panAction.put("drop", myTA2);
    }

    public void pancakeThree()
    //adds, executes components associated with pancake3
    {
        foodKitchen.add(pancake3);
        oscillate(pancake3); 
        System.out.println("oscillating");
        pancakeAction myTA3 = new pancakeAction(pancake3, this, timer);
        InputMap pancakesInput = pancake3.getInputMap(pancake3.WHEN_IN_FOCUSED_WINDOW);
        ActionMap pancakesAction = pancake3.getActionMap();
        pancakesInput.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "drop");
        pancakesAction.put("drop", myTA3);
    }

    public int getPanX(JLabel pancake)
    //get value of pancake’s x coordinate 
    {
        if (pancake == pancake1){
            return x1;
        }else if(pancake == pancake2){
            return x2;
        }else if(pancake == pancake3){
            return x3;
        }
        return 0;
    }

    public int getPanY(JLabel pancake)
    // get value of pancake’s y coordinate 
    {
        if (pancake == pancake1){
            return y1;
        }else if(pancake == pancake2){
            return y2;
        }else if(pancake == pancake3){
            return y3;
        }
        return 0;
    }

    public void incrementPanX(JLabel pancake, int value)
    // Changes value of pancake’s x coordinate by increment 
    {
        if (pancake == pancake1){
            x1+=value;
        }else if(pancake == pancake2){
            x2+=value;
        }else if(pancake == pancake3){
            x3+=value;
        }
    }

    public void incrementPanY(JLabel pancake, int value)
    // Changes value of pancake’s y coordinate by increment

    {
        if (pancake == pancake1){
            y1+=value;
        }else if(pancake == pancake2){
            y2+=value;
        }else if(pancake == pancake3){
            y3+=value;
        }
    }

    public int getRequiredY(JLabel pancake){
        if (pancake == pancake1){
            return 335;
        }else if(pancake == pancake2){
            return 305;
        }else if(pancake == pancake3){
            return 275;
        }
        return 0;
    }

    public void oscillate(JLabel pancake)
    // moves the pancake back and forth oscillate movement
    {
        BananasFoster panel = this;
        timer = new Timer(10, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    pancake.setLocation(panel.getPanX(pancake), 0);
                    if(left == false){
                        panel.incrementPanX(pancake, 5);

                    }else{
                        panel.incrementPanX(pancake, -5);
                    }
                    if(panel.getPanX(pancake) == 600 || panel.getPanX(pancake) == -100){
                        left = !left;
                    }
                    pancake.getParent().repaint();
                }
            });
        timer.setRepeats(true);
        timer.start();
    }

    public void movePancakeDown(JLabel pancake)
    // moves the pancake down onto the plate when space bar is pressed
    {
        BananasFoster panel2 = this;
        JButton thisNext = panel2.getNextButton();
        
        timer = new Timer(10, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    pancake.setLocation(panel2.getPanX(pancake),panel2.getPanY(pancake));
                    panel2.incrementPanY(pancake, 5);
                    
                    
                
                    foodKitchen.moveToBack(plate); 
                    foodKitchen.moveToFront(pancake);
                    if(panel2.getPanX(pancake) > 70 && panel2.getPanX(pancake) <505){
                        if(panel2.getPanY(pancake) >= panel2.getRequiredY(pancake))
                        {

                            timer.setRepeats(false);

                            foodKitchen.moveToFront(pancake);
                            timer.stop(); 

                            if (pancake == pancake1){
                                pancakeTwo();
                                foodKitchen.updateScore(1);
                            }else if(pancake == pancake2){
                                System.out.println("2");
                                foodKitchen.updateScore(1);
                                pancakeThree();

                            }else if (pancake == pancake3){
                                foodKitchen.add(thisNext,0);
                                thisNext.setVisible(true);
                                foodKitchen.moveToFront(thisNext);
                                foodKitchen.updateScore(1);
                                
                            }
                        }

                    }else if(panel2.getPanY(pancake) >= 330){
                        timer.setRepeats(false);

                        foodKitchen.moveToFront(pancake); 
                        timer.stop(); 
                        if (pancake == pancake1){
                            pancakeTwo();
                        }else if(pancake == pancake2){
                            pancakeThree();
                        }else if (pancake == pancake3){
                            foodKitchen.add(thisNext,0);
                            thisNext.setVisible(true);
                            foodKitchen.moveToFront(thisNext);
                            System.out.println("3");

                        }
                        foodKitchen.updateScore(-1);
                    }
                    pancake.getParent().repaint();
                }
            });
        timer.setRepeats(true);
        timer.start();
    }

    public JButton getRestaurantButton()
    // returns restaurant button
    {
        return returnButton;
    }
    private class DragListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        //Updates location of focusLabel based on mouse drag action
        {
            Point currentPoint = e.getPoint(); // gets the point where the mouse is currently

            if(focusLabel != null){
                focusLabel.setLocation((int)(currentPoint.getX()-50),(int)(currentPoint.getY())-50);

                previousPoint = currentPoint; 

                intersects();

                foodKitchen.getFrame().repaint();
            }

        }

    }
}


