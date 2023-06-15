import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
        setPaintOrder(ShelfInventory.class, Items.class, Reactants.class, Particles.class, Equipment.class, ItemSpawner.class,Desktop.class);
        addObject(new Desktop(),500,600);
        addObject(new ItemSpawner("beakers"),150,495);
        addObject(new ItemSpawner("testtubes"),750,475);
        addObject(new Burner(), 450, 490);
        addObject(new Shelf(),750,150);

        Beaker.resetBeakerIndex();
        
        beakers = new ArrayList();
    }
    public void act() {
        Beaker.resetHasPoured();
    }
}
