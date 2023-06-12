import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * @author Owen P. Desjardins
 * @version [6/6/2023]
 */
public class MyWorld extends World
{
    public static Desktop desk = new Desktop();
    public static Burner burner = new Burner();
    
    public static ArrayList beakers;
    public MyWorld()
    {    
        super(1000, 600, 1,false);
        setPaintOrder(Chemistry_Shelf_Inventory.class, Items.class, Reactants.class, Particles.class, Equipment.class, ItemSpawner.class,Desktop.class);
        addObject(desk,500,600);
        addObject(new ItemSpawner("beakers"),150,495);
        addObject(new ItemSpawner("testtubes"),750,475);
        addObject(burner, 450, 490);
        addObject(new Chemical_Shelf(),750,150);

        Beaker.resetBeakerIndex();
        
        beakers = new ArrayList();
    }
}
