import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeaderBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeaderBoard extends Actor
{
    /**
     * Act - do whatever the LeaderBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int fontSize;
    private Label[] leaderBoard = new Label[10];
    public LeaderBoard(int fontSize)
    {
        this.fontSize = fontSize; 
        int x = 600;
        int y = 100;
        for(int i = 0; i < 10; i++)
        {   
            y += 20;
            leaderBoard[i] = new Label(i + " ) ", 15 );
            getWorld().addObject(leaderBoard[i], x , y);
            
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
