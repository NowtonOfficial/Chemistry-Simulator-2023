import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/6/2023]
 */
public class ItemSpawner extends Actor
{
    GreenfootImage image;
    
    int itemID;
    public ItemSpawner(String type) {

        if (type.equalsIgnoreCase("beakers")) {
            image = new GreenfootImage(150,110);
            image.setColor(new Color(235,87,12));
            itemID = 0;
        } else if (type.equalsIgnoreCase("testtubes")) {
            image = new GreenfootImage(300,150);
            image.setColor(new Color(100,56,199));
            itemID = 1;
        }
        image.fill();
        setImage(image);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            if (itemID == 0) {
                getWorld().addObject(new Beaker(), this.getX(), this.getY());
            } else if (itemID == 1) {
                getWorld().addObject(new Test_Tube(), this.getX(), this.getY());
            }
        }
    }
}
