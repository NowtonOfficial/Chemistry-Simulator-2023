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
        int type = Greenfoot.getRandomNumber(2);
        String moleculeType = "";
        if (type == 1) {
            moleculeType = "acid";
        } else {
            moleculeType = "base";
        }
        reactant = new Liquids("",moleculeType,100);
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
        if (this.reactant == null) {
            return;
        }
        Beaker object = (Beaker) getOneIntersectingObject(Beaker.class);
        if (object.hasPoured) {
            return;
        }
        if (object.reactant != null) {
            String newType = Reactions.checkReaction(object.reactant.getMoleculeType(),this.reactant.getMoleculeType());
            Liquids temp = object.reactant;
            getWorld().removeObject(object.reactant);
            object.reactant = mixingColors(temp, this.reactant, newType);
            getWorld().removeObject(this.reactant);
            getWorld().addObject(object.reactant,object.getX(),object.getY());
            this.reactant = null;
            this.hasPoured = true;
            object.hasPoured = true;
        } else {
            object.reactant = this.reactant;
            this.reactant = null;
            this.hasPoured = true;
            object.hasPoured = true;
        } 
    }

    private Liquids mixingColors(Liquids thatObject, Liquids thisObject, String newMoleculeType) {
        Liquids returnedReactant = new Liquids("",newMoleculeType,100);
        int thatRed = thatObject.getImage().getColor().getRed();
        int thatGreen = thatObject.getImage().getColor().getGreen();
        int thatBlue = thatObject.getImage().getColor().getBlue();
        int thatAlpha = thatObject.getImage().getColor().getAlpha();

        int thisRed = thisObject.getImage().getColor().getRed();
        int thisGreen = thisObject.getImage().getColor().getGreen();
        int thisBlue = thisObject.getImage().getColor().getBlue();
        int thisAlpha = thisObject.getImage().getColor().getAlpha();

        int newRed = (thatRed + thisRed) / 2;
        int newGreen = (thatGreen + thisGreen) / 2;
        int newBlue = (thatBlue + thisBlue) / 2;
        int newAlpha = Math.max(thatAlpha,thisAlpha);

        GreenfootImage img = new GreenfootImage(66,70);
        img.setColor(new Color(newRed,newGreen,newBlue,newAlpha));
        img.fill();
        returnedReactant.setImage(img);
        return returnedReactant;
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
