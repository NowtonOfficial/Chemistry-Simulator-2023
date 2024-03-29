import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/6/2023]
 */
public class Items extends Actor
{

    private boolean mouseIsDown = false;
    private final int GRAVITY = 1;
    private int ySpeed;
    // Item superclass for the Beaker and Flask objects.
    public Items(String imageName) {
        GreenfootImage img = new GreenfootImage(imageName);
        setImage(img);
    }

    public void act()
    {
        if (!onScreen()) {
            if (this.getClass() == Beaker.class) {
                MyWorld.beakers.remove(MyWorld.beakers.indexOf(this));
                Beaker.lowerBeakerIndex();
            }
            getWorld().removeObject(this);
            return;
        }
        if (Greenfoot.mouseDragged(this) || isBeingHeld())
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                setLocation(mouse.getX(), mouse.getY());
            }
        } else {
            gravity();
        }
    }
    // Check if Item is On Screen
    private boolean onScreen() {
        boolean onScreen = true;
        if (getX() < 10 || getX() > 1010 || getY() > 610) {
            onScreen = false;
        }
        return onScreen;
    }

    // Mouse is being held checker
    protected boolean isBeingHeld() {
        if (Greenfoot.mousePressed(this)) {
            mouseIsDown = true;
        } else if (Greenfoot.mouseClicked(this)) {
            mouseIsDown = false;
        }
        return mouseIsDown;
    }

    // Gravity Systems
    private void gravity() {
        int height = getImage().getHeight();
        Actor object;
        // Collision Check Part 1.
        if (isTouching(Desktop.class)) {
            object = checkBottomFor(Desktop.class);
        } else if (isTouching(Burner.class)) {
            object = checkBottomFor(Burner.class);
        } else if (isTouching(Flask.class)){
            object = checkBottomFor(Flask.class);
        } else if (isTouching(Beaker.class)){
            object = checkBottomFor(Beaker.class);
        } else {
            object = null;
        }
        // Collision Chekc Part 2.
        if (!isGrounded() && object == null) {
            ySpeed += GRAVITY;
            setLocation(getX(),getY() + ySpeed);
        } else {
            ySpeed = 0;
            int objectHeight = object.getImage().getHeight();
            if (isTouching(Burner.class) && !Burner.getContact()) {
                setLocation(object.getX(), object.getY() - objectHeight / 2 - height / 2 + 1);
                Burner.setContact(true);
            } else {
                setLocation(getX(), object.getY() - objectHeight / 2 - height / 2 + 1);
                Burner.setContact(false);
            }
        }
    }
    // Check if item is touching Desktop.
    private boolean isGrounded() {
        boolean onGround = false;
        if (isTouching(Desktop.class)) {
            onGround = true;
        }
        return onGround;
    }
    // Get the object that is touching the item at 3 different points.
    protected Actor checkBottomFor(Class actor) {
        int height = getImage().getHeight();
        int width = getImage().getWidth();
        Actor object = null;
        int point = -width/2;
        for (int x = 0; x < 3; x++) {
            object = getOneObjectAtOffset(point, height/2, actor);
            if (object != null) {
                return object;
            }
            point += width/2;
        }
        return object;
    }
}
