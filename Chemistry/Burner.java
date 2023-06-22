import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/9/2023]
 */
public class Burner extends Equipment
{
    private Flames flame = new Flames();
    private boolean isActive = false;
    private boolean fireExists = false;
    private static boolean itemInContact = false;
    public Burner() {
        GreenfootImage img = new GreenfootImage("burner.png");
        setImage(img);
    }
    public void act()
    {
        super.act();
        if (Greenfoot.mouseClicked(this)) {
            // Check if burner is active to either add or remove the flame effect.
            if (isActive) {
                getWorld().removeObject(flame);
                isActive = false;
            } else {
                getWorld().addObject(flame,getX(),getY()-88);
                isActive = true;
            }
        }
    }
    // Getter and Setter methods.
    public static boolean getContact() {
        return itemInContact;
    }
    public static void setContact(boolean temp) {
        itemInContact = temp;
    }
}
