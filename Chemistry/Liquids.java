import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/10/2023]
 */
public class Liquids extends Reactants
{
    public Liquids(String displayName, String moleculeType, String formulaName) {
        super();
        this.displayName = displayName;
        this.moleculeType = moleculeType;
        this.formulaName = formulaName;
        this.label = new Label(formulaName,displayName);
    }

    public void act()
    {
        super.act();
        
    }
}
