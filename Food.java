
/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food
{
    protected String foodName; // holds the name of the food
    protected KitchenPanel foodKitchen; // stores existing KitchenPanel
    public Food(KitchenPanel kit)
    // sets foodKitchen to kit
    {
        foodKitchen = kit;
    }
    public Food()
    // doesn't instantiate anything
    {
        
    }
    public String getFoodName()
    // returns the food name
    {
        return foodName;
    }
    
}
