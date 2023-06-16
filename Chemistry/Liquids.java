import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/10/2023]
 */
public class Liquids extends Reactants
{
    public Liquids(String name, String moleculeType,int bp /*BOILING POINT*/) {
        super(1);
        this.name = name;
        this.boilingTemp = bp;
        this.moleculeType = moleculeType;
    }
    public void act()
    {
        super.act();
    }
}
