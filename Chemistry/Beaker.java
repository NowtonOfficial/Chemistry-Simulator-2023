import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/8/2023]
 */
public class Beaker extends Items
{
    private Boiling bubbles = new Boiling();
    private static Pouring pour = new Pouring();
    private static int beakerIndex = -1;
    public Beaker() {
        super("beaker.png");
        MyWorld.beakers.add(this);
    }
    private boolean isBoiling = false;
    private boolean canBoil = false;
    public void act()
    {
        if (isTouching(Flames.class) && canBoil) {
            if (!isBoiling) {
                Actor beaker = (Actor) MyWorld.beakers.get(0);
                getWorld().addObject(bubbles, beaker.getX(),beaker.getY());
                isBoiling = true;
            }
        } else {
            if (isBoiling) {
                getWorld().removeObject(bubbles);
            }
            isBoiling = false;
        }
        bubbles.setLocation(getX()+3,getY()-50);
        if (isTouching(Liquids.class)) {
            canBoil = true;
        } else {
            canBoil = false;
        }
        beakerCollisions();
        addingAReactant();
        super.act();
    }
    private boolean hasIndicator = false;
    private boolean canPour = false;
    private void beakerCollisions() {
        if (isTouching(Beaker.class) && canPour) {
            if (!hasIndicator) {
                getWorld().addObject(pour,getX(), getY() - 60);
                hasIndicator = true;
            }
        } else {
            if (hasIndicator) {
                getWorld().removeObject(pour);
                hasIndicator = false;
            }
        }
        if (isTouching(Liquids.class)) {
            canPour = true;
        } else {
            canPour = false;
        }
        pour.setLocation(getX(), getY() - 60);
    }

    public static int getBeakerIndex() {
        return beakerIndex;
    }

    public static void lowerBeakerIndex() {
        beakerIndex--;
    }

    public static void raiseBeakerIndex() {
        beakerIndex++;
    }

    public static void resetBeakerIndex() {
        beakerIndex = -1;
    }
    private boolean hasReactant = false;
    private void addingAReactant() {
        if (isTouching(Chemical_Shelf.class) && !hasReactant) {
            Liquids liquid = new Liquids("Water","H2O",100);
            Actor beaker = (Actor) MyWorld.beakers.get(beakerIndex);
            getWorld().addObject(liquid, beaker.getX()+1,beaker.getY()+6);
            hasReactant = true;
        }
    }
}
