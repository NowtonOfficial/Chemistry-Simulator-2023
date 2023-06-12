import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins 
 * @version [6/12/2023]
 */
public class Chemistry_Shelf_Inventory extends GUI
{
    public boolean isOpened = false;
    private GreenfootImage img;
    public Chemistry_Shelf_Inventory() {
        img = new GreenfootImage(900,500);
        img.setColor(new Color(167,89,35));
        img.fill();
        setImage(img);
        img.setTransparency(0);
    }
    public void act()
    {
        super.act();
        if (isOpened) {
            System.out.println("CLICKED");
            img.setTransparency(0);
            setImage(img);
        }
    }
}
