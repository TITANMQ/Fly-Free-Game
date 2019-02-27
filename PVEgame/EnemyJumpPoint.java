import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyJumpPoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyJumpPoint extends Actor
{
    /**
     * Act - do whatever the EnemyJumpPoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private World world ;
    private int rotation;
    int x;
    int y;
    
   public EnemyJumpPoint(int rotation, int x , int y)
    {
        this.rotation = rotation;
        world = (MyWorld) getWorld();
        this.x = x;
        this.y = y;
         
    }
    
    public void act()
    {
        // // System.out.println("Working fine");
    }
 
 
    
    public void setPoint(int dist)
    {   
        if(x != 0 && y != 0){
            if((x> (0+ 15) && x< (MyWorld.WIDTH- 15)) && (y > (0+15) && y < (MyWorld.HEIGHT -15)))
            {
                setRotation(rotation);
                move(dist);
            }
            else
            {   
                world = (MyWorld) getWorld();
                world.removeObject(this);
            }
            
       
        }else
        {
             world = (MyWorld) getWorld();
             world.removeObject(this);
        }
        
       
    }
    
    public void removePoint()
    {
        world = (MyWorld) getWorld();
        world.removeObject(this);
    }
    
}
