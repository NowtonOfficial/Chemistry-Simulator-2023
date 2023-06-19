import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/11/2023]
 */
public class Shelf extends Equipment
{
    public static ShelfInventory csi = new ShelfInventory();
    public Shelf() {
        GreenfootImage img = new GreenfootImage("shelf.png");
        img.scale(img.getWidth() *2, img.getHeight() *2);
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
