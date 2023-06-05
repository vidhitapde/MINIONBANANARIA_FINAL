
/**
 * Write a description of class Restaurant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Restaurant
{
    private Food[] orders; // holds different orders
    private int clickCount; // holds the amount of times click is pressed 
    /**
     * Constructor for objects of class restaurant
     */
    public Restaurant()
    // instantiates instance variables 
    {
        clickCount = 0;    
        orders = new Food[9];
        
        orders[0] = new BananaCreamPie();
        orders[1] = new BananaSmoothie();
        orders[2] = new BananasFoster();
        orders[3] = new BananaCreamPie();
        orders[4] = new BananaSmoothie();
        orders[5] = new BananasFoster();
        orders[6] = new BananaCreamPie();
        orders[7] = new BananaSmoothie();
        orders[8] = new BananasFoster();
        
    }
    public void incrementOrder()
    // increments clickCount by 1
    {
        clickCount++;
    }
    public int getOrderNum()
    // returns the number of orders
    {
        return clickCount;
    }
    public int getOrderLength()
    // returns the length of orders 
    {
        return orders.length;
    }
    public Food getMyOrder()
    //Returns the food that is being made in the order
    {
        if(clickCount < orders.length){
            return orders[clickCount];
        }
        return null;
    }
}
