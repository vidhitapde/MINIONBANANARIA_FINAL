
/**
 * Write a description of class Restaurant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Restaurant
{
    private Food[] orders;
    private int clickCount;
    /**
     * Constructor for objects of class restaurant
     */
    public Restaurant()
    {
        clickCount = 0;    
        orders = new Food[3];
        
        orders[0] = new BananasFoster();
        orders[1] = new BananaSmoothie();
        orders[2] = new BananaCreamPie();
    }
    public void incrementOrder(){
        clickCount++;
    }
    public int getOrderNum(){
        return clickCount;
    }
    public int getOrderLength(){
        return orders.length;
    }
    public Food getMyOrder(){
        if(clickCount < orders.length){
            return orders[clickCount];
        }
        return null;
    }
}
