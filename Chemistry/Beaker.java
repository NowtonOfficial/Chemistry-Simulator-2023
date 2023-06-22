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
    private Liquids reactant;
    private boolean isBoiling = false;
    private boolean canBoil = false;
    private boolean hasIndicator = false;
    private boolean canPour = false;
    private static boolean hasPoured = false;
    public Beaker() {
        super("beaker.png");
        MyWorld.beakers.add(this);
    }

    public void act()
    {
        if (reactant != null) {
            canBoil = true;
            canPour = true;
            boilTheBeaker();
            updateReactantPosition();
            // Mixing Reactants
            if (isTouching(Beaker.class) && Greenfoot.mouseClicked(this)) {
                changeBeakerReactant();
            }
        } else {
            // If in contact with the Shelf, randomly add a new Reactant.
            if (isTouching(Shelf.class)) {
                addingAReactant();
            }
        }
        super.act();
    }
    // Randomly loading a new Reactant to beaker.
    private void addingAReactant() {
        int type = Greenfoot.getRandomNumber(2);
        String moleculeType = "";
        if (type == 1) {
            moleculeType = "acid";
        } else {
            moleculeType = "base";
        }
        String fullName = Reactions.moleculeName(moleculeType);
        String temp = fullName.substring(0,fullName.indexOf('-')+1);
        String displayName = temp.replace("-","");//For some reason I have to do this to avoid an index error...
        String formulaName = fullName.substring(fullName.indexOf('-')+1);
        reactant = new Liquids(displayName,moleculeType,formulaName);
        getWorld().addObject(reactant,getX(), getY());
    } 
    // Updating reactant position relative to the beaker.
    private void updateReactantPosition() {
        Actor beaker = (Actor) MyWorld.beakers.get(MyWorld.beakers.indexOf(this));
        reactant.setLocation(beaker.getX() + 1, beaker.getY() +6);
    }
    // Boiling mechanic
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
    // Has poured resetter.
    public static void resetHasPoured() {
        hasPoured = false;
    }
    // Mixing Reactants
    public void changeBeakerReactant() {
        if (this.reactant == null) {
            getWorld().removeObject(this.reactant.label);
            return;
        }
        Beaker object = (Beaker) getOneIntersectingObject(Beaker.class);
        if (object.hasPoured) {
            return;
        }
        if (object.reactant != null) {
            String newType = Reactions.checkReaction(object.reactant.getMoleculeType(),this.reactant.getMoleculeType());
            String newFormula = "";
            String newDisplayName = "";
            if (newType.equals("water")) {
                newFormula = "H2O";
                newDisplayName = "Dihydrogen Monoxide";
            }
            Liquids temp = object.reactant;
            getWorld().removeObject(object.reactant.label);
            getWorld().removeObject(object.reactant);
            object.reactant = mixingColors(temp, this.reactant, newType, newFormula,newDisplayName);
            getWorld().removeObject(this.reactant);
            getWorld().removeObject(this.reactant.label);
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
    // Creating a new Reactant with a mixture between 2 Colors.
    private Liquids mixingColors(Liquids thatObject, Liquids thisObject, String newMoleculeType, String newFormula,String displayName) {
        Liquids returnedReactant = new Liquids(displayName,newMoleculeType,newFormula);
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
    // Beaker Index methods.
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
