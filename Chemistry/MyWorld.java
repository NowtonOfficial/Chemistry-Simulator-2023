import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * @author Owen P. Desjardins
 * @version [6/6/2023]
 */
public class MyWorld extends World
{
    public static ArrayList beakers;
    public MyWorld()
    {    
        super(1000, 600, 1,false);
        setPaintOrder(Items.class, Label.class, Reactants.class, Particles.class, Equipment.class, ItemSpawner.class,Desktop.class);
        addObject(new Desktop(),500,600);
        addObject(new ItemSpawner("beakers"),450,495);
        addObject(new ItemSpawner("testtubes"),750,475);
        addObject(new Burner(), 150, 490);
        addObject(new Shelf(),682,109);

        Beaker.resetBeakerIndex();
        
        beakers = new ArrayList();
    }
    public void act() {
        Beaker.resetHasPoured();
        if (Greenfoot.isKeyDown("E")) {
            List<Label> labelList = getObjects(Label.class);
            for (int x = 0; x < labelList.size(); x++) {
                Label tempLabel = labelList.get(x);
                tempLabel.toggleLabelTextToFull();
            }
        } else {
            List<Label> labelList = getObjects(Label.class);
            for (int x = 0; x < labelList.size(); x++) {
                Label tempLabel = labelList.get(x);
                tempLabel.toggleLabelTextToFormula();
            }
        }
    }
}
