import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tadpole here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tadpole extends Actor
{
    /**
     * Act - do whatever the Tadpole wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int spawnCounter = 500; 
    boolean spawned = false;
    World world;
    private SafeHouseBounds safeBounds;
    public void act() 
    {   
        swim(4);
        growUp();
        
        
    }  
    
    public Tadpole(SafeHouseBounds safeBounds)
    {
        this.safeBounds = safeBounds;
    }
    private void growUp()
    {
        if(!spawned){
        if(spawnCounter <= 0){
            spawn(); 
            spawned = true;
        }
        else if(spawnCounter < 50)
        {
            setImage("ant.png");
            spawnCounter--;
        }
        else
            spawnCounter--;
        }
    }
    
     private void spawn()
    {
        
        world = getWorld(); 
        world.addObject(new Enemy(safeBounds), getX(), getY());
        world.removeObject(this);
    }
    
    public boolean enemyInRadius()
    {   
        Actor closest = null; 
        int dist = 50;
        boolean inRadius = false;
       if(!getObjectsInRange(dist, Enemy.class).isEmpty())
       {
        
        
         for (Object obj: getObjectsInRange(dist, Enemy.class))
        {
            Enemy frog = (Enemy) obj;
            int guyDist = (int)Math.hypot(frog.getX() - getX(), frog.getY() - getY());
            if (closest == null || guyDist< dist)
            {
                closest = frog;
                dist = guyDist;
                inRadius =true;
            }
            else
            {
                inRadius = false;
            }
        }
        
        
       
    }
        return inRadius;
    }
    
    private void swim(int speed)
    {
        turn(speed);
        move(speed);
    }
    
}
