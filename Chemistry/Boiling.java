import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/11/2023]
 */
public class Boiling extends Particles
{
    public Boiling() {
        super(15);
        SCALE_FACTOR = 1.0;
        changeInterval = 8;
        finalMultiplier = 5;
        imageName = "bubble";
        GreenfootImage img = new GreenfootImage("bubble5.png");
            setImage(img);
    }
    
    public void act()
    {
        super.act();
    }
}
