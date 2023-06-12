import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/11/2023]
 */
public class Chemical_Shelf extends Equipment
{
    public static Chemistry_Shelf_Inventory csi = new Chemistry_Shelf_Inventory();
    public Chemical_Shelf() {
        GreenfootImage img = new GreenfootImage(320,175);
        img.setColor(new Color(39,105,36));
        img.fill();
        setImage(img);
    }
    public void act()
    {
        super.act();
        if (Greenfoot.mouseClicked(this)) {
            csi.isOpened = true;
        }
    }
}
