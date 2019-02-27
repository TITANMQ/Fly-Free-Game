import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player_2 extends Player implements Iplayer
{
    /**
     * Act - do whatever the Player_2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Player_2( )
    {
        super("Player 2");
    }
    
    /**
     * Event loop
     */
    public void act() 
    {
        moveForward();
        turnRight();
        turnleft();
        moveBackwards();
        boost();
        collects();
        eats(50);
    } 
    
    @Override
    public void turnRight()
    {   
        /**
         * Event: D key pressed
         */
         if(Greenfoot.isKeyDown("d"))//Trigger function
         {
            turn(3); //Event Handler
         }
    }
    @Override
    public void turnleft()
    {
         if(Greenfoot.isKeyDown("a"))
         {
            turn(-3);
         }
    }
    
    @Override
    public void moveForward()
    {
         if(Greenfoot.isKeyDown("w"))
         {
            move(5);
         }
    }
    
    @Override
    public void moveBackwards()
    {
         if(Greenfoot.isKeyDown("s"))
         {
            move(-5);
         }
    }
    @Override 
    public void boost()
    {
        if(Greenfoot.isKeyDown("shift"))
        {
            move(8); 
        } 
    }
}
