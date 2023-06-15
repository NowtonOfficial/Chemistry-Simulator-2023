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
    public Liquids reactant;
    public Beaker() {
        super("beaker.png");
        MyWorld.beakers.add(this);
    }
    private boolean isBoiling = false;
    private boolean canBoil = false;
    public void act()
    {
        if (reactant != null) {
            if (reactant.getPhaseType() == 1) {
                canBoil = true;
                canPour = true;
                boilTheBeaker();
            }
            updateReactantPosition();
            if (isTouching(Beaker.class) && Greenfoot.mouseClicked(this)) {
                changeBeakerReactant();
            }
        } else {
            if (isTouching(Shelf.class)) {
                addingAReactant();
            }
        }
        super.act();
    }

    private void addingAReactant() {
        reactant = new Liquids("","",100);
        getWorld().addObject(reactant,getX(), getY());
    } 

    private void updateReactantPosition() {
        Actor beaker = (Actor) MyWorld.beakers.get(MyWorld.beakers.indexOf(this));
        reactant.setLocation(beaker.getX() + 1, beaker.getY() +6);
    }
    private boolean hasIndicator = false;
    private boolean canPour = false;
    private void boilTheBeaker() {
        if (isTouching(Flames.class) && canBoil) {
            if (!isBoiling) {
                Actor beaker = (Actor) MyWorld.beakers.get(MyWorld.beakers.indexOf(this));
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
    }
    private static boolean hasPoured = false;
    public static void resetHasPoured() {
        hasPoured = false;
    }
    public void changeBeakerReactant() {
        Beaker object = (Beaker) getOneIntersectingObject(Beaker.class);
        if (!object.hasPoured && object.reactant == null && this.reactant != null) {
            object.reactant = this.reactant;
            this.reactant = null;
            this.hasPoured = true;
            object.hasPoured = true;
        } else if (!object.hasPoured && object.reactant != null && this.reactant != null) {
            Reactants objectsReactant = object.reactant;
            Reactants thisReactant = this.reactant;
            object.reactant = this.reactant;
            this.reactant = null;
            this.hasPoured = true;
            object.hasPoured = true;
        }
    }
    
    private Color mixingColors(Color objectColor, Color thisColor) {
        
    }

    public Liquids getBeakerReactant() {
        return reactant;
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

}
