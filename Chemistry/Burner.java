import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/9/2023]
 */
public class Burner extends Equipment
{
    public Burner() {
        GreenfootImage img = new GreenfootImage(100,120);
        img.setColor(new Color(36,90,134));
        img.fill();
        setImage(img);
    }
    public void act()
    {
        super.act();
    }
}
