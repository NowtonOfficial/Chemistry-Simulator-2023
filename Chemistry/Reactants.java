import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * @author Owen P. Desjardins
 * @version [6/10/2023]
 */
public class Reactants extends Actor
{
    protected int boilingTemp;
    protected String name;
    protected String molecularFormula;
    // TEMPORARY COLOR RANDOMIZER!!!
    int r = Greenfoot.getRandomNumber(255);
    int g = Greenfoot.getRandomNumber(255);
    int b = Greenfoot.getRandomNumber(255);
    int alpha = Greenfoot.getRandomNumber(70) +100;
    private int phase;
    public Reactants(int phaseType) {
        phase = phaseType;
        if (phaseType == 1) {
            GreenfootImage img = new GreenfootImage(66,70);
            img.setColor(new Color(r,g,b,alpha)); 
            img.fill();
            setImage(img);
        }
    }
    public void act()
    {
        if (!onScreen()) {
            getWorld().removeObject(this);
        }
    }
    private boolean onScreen() {
        boolean onScreen = true;
        if (getX() < 10 || getX() > 1010 || getY() > 610) {
            onScreen = false;
        }
        return onScreen;
    }
    public int getPhaseType() {
        return phase;
    }

}
