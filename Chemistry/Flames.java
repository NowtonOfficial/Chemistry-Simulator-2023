import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/10/2023]
 */
public class Flames extends Particles
{
    
    public Flames() {
        super(10);
        SCALE_FACTOR = 0.6;
        changeInterval = 8;
        finalMultiplier = 4;
        imageName = "fire";
        GreenfootImage img = new GreenfootImage("fire4.png");
        img.scale((int) (img.getWidth() * SCALE_FACTOR), (int) (img.getHeight() * SCALE_FACTOR));
        setImage(img);
    }

    public void act()
    {
        super.act();
    }
}
