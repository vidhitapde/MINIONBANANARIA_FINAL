
/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food
{
    protected String foodName;
    protected KitchenPanel foodKitchen;
    public Food(KitchenPanel kit){
        foodKitchen = kit;
    }
    public Food(){
        
    }
    public String getFoodName(){
        return foodName;
    }
    
}
