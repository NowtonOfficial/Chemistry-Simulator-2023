import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Owen P. Desjardins
 * @version [6/6/2023]
 */
public class MyWorld extends World
{
    public static Desktop desk = new Desktop();
    public static Burner burner = new Burner();
    public MyWorld()
    {    
        super(1000, 600, 1,false);
        setPaintOrder(Items.class, Equipment.class, ItemSpawner.class,Desktop.class);
        addObject(desk,500,600);
        addObject(new ItemSpawner("beakers"),150,495);
        addObject(new ItemSpawner("testtubes"),750,475);
        addObject(burner, 450, 490);
    }
}
