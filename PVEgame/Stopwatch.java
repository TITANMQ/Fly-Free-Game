import greenfoot.*;
/**
 * Write a description of class Stopwatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stopwatch extends Actor
{
    // instance variables - replace the example below with your ow
    boolean countDown; 
    boolean count = false;
    boolean timeUp = false; 
    long lastCurrentSecond =0;
    int seconds = 0;
    int startingTime;
    long timeSaved = 0;
    int some = 0;
    /**
     * Constructor for objects of class Stopwatch
     */
    public Stopwatch(boolean countDown, int startingTime)
    {   
        
        this.countDown = countDown;
        this.startingTime = startingTime;
     
        seconds = startingTime;
      
        if (!countDown) {
            seconds = 0;
        }
        
    }
    public void run()
    {
        if (countDown) {
            if (count && !timeUp) {
                if (System.currentTimeMillis() - lastCurrentSecond >= 1000) {
                    lastCurrentSecond += 1000;
                    seconds--;
                  
                }
                
                    timeUp = true;
                }
            
        }
        else { 
            if (count) {
                if (System.currentTimeMillis() - lastCurrentSecond >= 1000) {
                    lastCurrentSecond += 1000;
                    seconds++;
                   
                }else
                {
                    some = 120;
                }
            }
    }
}
    public void act()
    {
           if (countDown) {
            if (count && !timeUp) {
                if (System.currentTimeMillis() - lastCurrentSecond >= 1000) {
                    lastCurrentSecond += 1000;
                    seconds--;
                  
                }
                
                    timeUp = true;
                }
            
        }
        else { 
            if (count) {
                if (System.currentTimeMillis() - lastCurrentSecond >= 1000) {
                    lastCurrentSecond += 1000;
                    seconds++;
                   
                }else
                {
                    some = 120;
                }
            }
        }
    }
    
      public boolean timeUp() {
        return timeUp;
    }
    
      public void startClock() {
        lastCurrentSecond = System.currentTimeMillis() - timeSaved;
        count = true;
    }
    
     public void stopClock() {
        timeSaved = System.currentTimeMillis() - lastCurrentSecond;
        count = false;
    }
    
      public void resetClock() {
        seconds = startingTime;
        timeUp = false;
    }
    
    public int getSeconds()
    {
        return seconds;
    }
 
}
