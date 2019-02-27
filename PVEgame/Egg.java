import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Egg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Egg extends Actor
{
    /**
     * Act - do whatever the Egg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static final int PLAYER1_CLASS = 1;
    public static final int PLAYER2_CLASS = 2;
    private World world;
    int x;
    int y; 
    int spawnCounter = 700; 
    boolean spawned = false;
    
    
    public Egg(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void act() 
    {   
        if(!spawned){
        if(spawnCounter <= 0){
            spawn(); 
            spawned = true;
        }
        else
            spawnCounter--;
        }
    }     
    
    private void spawn()
    {
        
        world = getWorld(); 
        int rnd = Greenfoot.getRandomNumber(100);
        if(rnd < 50){
           // world.addObject(new Player_1( true), x, y);
            world.addObject(new Fly_bot(PLAYER1_CLASS), x, y);
        }else
        {
            //world.addObject(new Player_2(null), x, y);
           // world.addObject(new Fly_bot(PLAYER2_CLASS), x, y);
             world.addObject(new Fly_bot(PLAYER1_CLASS), x, y);
        }
        
        world.removeObject(this);
    }
}
