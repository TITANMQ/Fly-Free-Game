import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tadpole here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tadpole extends Actor
{

    int spawnCounter = 500; 
    boolean spawned = false;
    World world;
    private SafeHouseBounds safeBounds;
    /**
     * Act - do whatever the Tadpole wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        swim(4);
        growUp();

    }  

    /**
     * Designates the safe area's bounds on creation of the tadpole.
     */
    public Tadpole(SafeHouseBounds safeBounds)
    {
        this.safeBounds = safeBounds;
    }

    /**
     * Allows the tadpole to advance in the stages of evolution to become a frog.
     */
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
    /**
     * Replaces the tadpole with a fully-grown frog (Enemy.class), inheriting the safehouse bounds.
     */
    private void spawn()
    {

        world = getWorld(); 
        world.addObject(new Enemy(safeBounds), getX(), getY());
        world.removeObject(this);
    }
    /**
     * Checks if a frog is in the radius of the tadpole.
     * 
     * @return Boolean.
     */
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
    /**
     * Allows the tadpole to move in the game world.
     */
    private void swim(int speed)
    {
        turn(speed);
        move(speed);
    }

}
