import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Label
{   
    private int previousValue = 0;
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ScoreBoard(String value, int fontSize)
    {
        super(value, fontSize );
    }
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void setPreviousValue(int value)
    {
        this.previousValue = value;
    }
    
      public int getPreviousValue()
    {
       return previousValue;
    }
}
