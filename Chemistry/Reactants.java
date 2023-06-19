import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * @author Owen P. Desjardins
 * @version [6/10/2023]
 */
public class Reactants extends Actor
{
    protected String displayName;
    protected String moleculeType;
    protected String formulaName;
    // TEMPORARY COLOR RANDOMIZER!!!
    int r = Greenfoot.getRandomNumber(255);
    int g = Greenfoot.getRandomNumber(255);
    int b = Greenfoot.getRandomNumber(255);
    int alpha = Greenfoot.getRandomNumber(70) +100;
    protected Label label;
    public Reactants() {
        GreenfootImage img = new GreenfootImage(66,70);
        img.setColor(new Color(r,g,b,alpha)); 
        img.fill();
        setImage(img);
    }

    public void act()
    {
        if (!onScreen()) {
            getWorld().removeObject(label);
            getWorld().removeObject(this);
            return;
        }
        if (moleculeType.equals("water")) {
            GreenfootImage img = new GreenfootImage(66,70);
            img.setColor(new Color(0,0,255,30)); 
            img.fill();
            setImage(img);
        }
        getWorld().addObject(label,getX(),getY()-56);
        label.setLocation(this.getX(), this.getY()-56);
    }

    private boolean onScreen() {
        boolean onScreen = true;
        if (getX() < 11 || getX() > 1011 || getY() > 616) {
            onScreen = false;
        }
        return onScreen;
    }

    public String getMoleculeType() {
        return moleculeType;
    }

}
