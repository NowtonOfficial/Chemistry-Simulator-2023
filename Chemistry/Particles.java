import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/10/2023]
 */
public class Particles extends Actor
{
    protected int particleChangeRate;
    // Shared variables
    protected double SCALE_FACTOR;
    protected int changeInterval;
    protected int finalMultiplier;
    protected String imageName;
    protected int animationCounter = 0;
    // Particle super class using animations.
    public Particles(int num) {
        particleChangeRate = num;
    }
    
    public void act()
    {
        animationCounter++;
        animator();
    }
    // so many headaches were caused making this... -_-
    private void animator() {
        if (animationCounter % changeInterval == 0 && animationCounter <= changeInterval * finalMultiplier) {
            int interval = animationCounter / changeInterval;
            GreenfootImage img = new GreenfootImage("images/particles/"+imageName +interval+".png");
            img.scale((int) (img.getWidth() * SCALE_FACTOR), (int) (img.getHeight() * SCALE_FACTOR));
            setImage(img);
        }
        if (animationCounter > changeInterval * finalMultiplier) {
            animationCounter = 0;
        }
    }
}
