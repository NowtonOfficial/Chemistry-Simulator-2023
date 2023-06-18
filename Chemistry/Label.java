import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6-18-2023]
 */
public class Label extends Actor
{
    private String text;
    public Label(String text) {
        GreenfootImage img = new GreenfootImage (text.length()*10, 30);
        img.drawString(text, 2, 20); 
        setImage (img);
        this.text = text;
    }
    public void act()
    {
        // Add your action code here.
    }
}
