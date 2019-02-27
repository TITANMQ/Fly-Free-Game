import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Player extends Actor
{   
    private int health = 100; 
    private int score = 0; 
    private int level = 1;
    private int collected = 0; 
    public Label levelName;
    private String name;
    
    public Player(String name)
    {   
        
        this.name = name;
        
    }
    
    public int getHealth()
    {
        return health;
    } 
    
    public void setHealth(int health)
    {
        this.health = health;
        
    }
    public void collects()
    {   
        Actor collectable = getOneIntersectingObject(Collectable.class);
        if(collectable != null)
        {  
            
            MyWorld world; 
            world = (MyWorld) getWorld();
            world.setScore(Collectable.POINT_VALUE);
            world.removeObject(collectable); 
            if(++collected % 10 == 0)
            {
                level+=9;
            }
            
            
            
        }
       
    }
    
    protected void eats(int points)
    {
          Actor tadpole = getOneIntersectingObject(Tadpole.class);
        if(tadpole != null)
        {  
            
            MyWorld world; 
            world = (MyWorld) getWorld();
            world.setScore(points);
            world.removeObject(tadpole);
            
            
        }
    }
    
    
}

