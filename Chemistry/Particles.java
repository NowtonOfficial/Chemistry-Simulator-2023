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
    public Particles(int num) {
        particleChangeRate = num;
    }
    protected int animationCounter = 0;
    public void act()
    {
        animationCounter++;
        animator();
    }

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
