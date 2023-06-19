import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6-18-2023]
 */
public class Label extends Actor
{
    private String formula;
    private String fullName;
    private GreenfootImage img;
    public Label(String formula, String fullName) {
        img = new GreenfootImage(formula,20,Color.BLACK,null);
        setImage(img);
        this.formula = formula;
        this.fullName = fullName;
    }

    public void act()
    {

    }

    public void toggleLabelTextToFull() {
        img = new GreenfootImage(fullName,20,Color.BLACK,null);
        setImage(img);
    }
    
    public void toggleLabelTextToFormula() {
        img = new GreenfootImage(formula,20,Color.BLACK,null);
        setImage(img);
    }
}
