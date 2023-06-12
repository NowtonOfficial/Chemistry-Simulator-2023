import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/9/2023]
 */
public class Burner extends Equipment
{
    private Flames flame = new Flames();
    public Burner() {
        GreenfootImage img = new GreenfootImage("burner.png");
        setImage(img);
    }
    private boolean isActive = false;
    private boolean fireExists = false;
    private static boolean itemInContact = false;
    public void act()
    {
        super.act();
        animationCounter++;
        animator(animationCounter);
        if (Greenfoot.mouseClicked(this)) {
            if (isActive) {
                getWorld().removeObject(flame);
                isActive = false;
            } else {
                getWorld().addObject(flame,getX(),getY()-88);
                isActive = true;
            }
        }
    }
    
    public static boolean getContact() {
        return itemInContact;
    }
    public static void setContact(boolean temp) {
        itemInContact = temp;
    }
}
