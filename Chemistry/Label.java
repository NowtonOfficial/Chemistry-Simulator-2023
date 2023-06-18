import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6-18-2023]
 */
public class Label extends Actor
{
    private String text;
    public Label(String text) {
        GreenfootImage img = new GreenfootImage (text,20,Color.BLACK,null);
        img.setColor(new Color(100,100,100));
        setImage (img);
        this.text = text;
    }
    public void act()
    {
        // Add your action code here.
    }
}
