import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    
    private World world;
    private MyWorld myWorld;
    int x;
    int y; 
    int waitCounter = 30;
    private SafeHouseBounds safeBounds;
    private EnemyJumpPoint newPoint;
    boolean firstTurn = false; 
    private int deathCounter = 0;
    private int lifeLimit = 260; //250
    
    public Enemy(SafeHouseBounds safeBounds)
    {
        
        this.safeBounds = safeBounds;
        myWorld = (MyWorld) getWorld(); 
        
    }
    public void act() 
    {   
        if(firstTurn == false)
        {
            nextTurn();
            // myWorld.setFrogPop(myWorld.getFrogPop()+1);
        }
        eats();
         if(newPoint != null )
        {
            if(safeBounds.isInBounds(newPoint, false))
            {
                world = getWorld();
                world.removeObject(newPoint);
                newPoint = null;
               
            }
        }
        x = getX(); 
        y = getY();
        spawnTadpoles();
        
      
        waitCounter = counterCheck(waitCounter);
     
        if(waitCounter <= 10)// && newPoint != null)
        {
            moveForward(); 
            safeBounds.inBounds(this); 
            nextTurn();
            if(deathCounter++ == lifeLimit )
            {   
                  world = getWorld();
                  world.addObject(new Collectable(), x, y);
                  myWorld.setFrogPop(myWorld.getFrogPop()-1);
                  die();
                
            }
          
           
        }
        
       
    }  
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }

    
    private void nextTurn()
    {   
      
       int randomNumber= Greenfoot.getRandomNumber(2);
       if( randomNumber % 2 == 0 && randomNumber < 2  && waitCounter < 10)
       {   
           turnAround();
           newPoint =new EnemyJumpPoint(getRotation(), getX(), getY());
           World world; 
           world = getWorld();
           if(newPoint != null){
           world.addObject(newPoint, getX(), getY());
           newPoint.setPoint(200);
        }
           waitNow();
           
        }
    }
    private void moveForward() 
    {  
           
           if(atWorldEdge())
           {
               turn(180);
           }
          
           move(100);
         EnemyJumpPoint point = (EnemyJumpPoint)getOneIntersectingObject(EnemyJumpPoint.class);
         if(point != null)
         {  
  
             world = getWorld();
             world.removeObject(point);
             newPoint = null;
             
        }
         world = getWorld();
         world.removeObject(newPoint);
           
    } 
    
    private void turnAround()
    {   
       // int randomNumber= Greenfoot.getRandomNumber(5000);
        
           int randomTurn =  Greenfoot.getRandomNumber(100);
           if(randomTurn > 50)
           {    
               turn(70);
            }else
            {
                turn(-70);
            }
       
        turn(5);
    }
    private void eats()
    {
          Player player = (Player)getOneIntersectingObject(Player.class);
        if(player != null)
        {  
            player.setHealth(player.getHealth()-25);
            
            if(player.getHealth()<= 0)
            {   
                
                if(player.getClass() == Fly_bot.class)
                {
                    Fly_bot fly_bot = (Fly_bot) player;
                    fly_bot.evolve();
                }
                MyWorld world; 
                world = (MyWorld)getWorld();
                world.removeObject(player);
                
                world.setFliesDeaths(1);
                world.removeFliesFromPopulation(1);
            }
            
            
            
        }
        
    }
    private void spawnTadpoles()
    {   
        int randomChance = Greenfoot.getRandomNumber(5000);  
        if( randomChance % 2 == 0 && randomChance < 25){
         world = getWorld(); 
         //int spawnAmount =  Greenfoot.getRandomNumber(1);  
         
          world.addObject(new Tadpole(safeBounds), x, y);
        
       }
   }
   
   private void die()
   {
       World world =(MyWorld) getWorld();
       world.removeObject(this);
    
   }
   private int counterCheck(int counter)
   {
       // if(counter <= 0)
       // {
           // return counter;
        // }else
        // {
            // counter--;
        // }
        if(counter > 0 && counter <= 30)
        {
          counter--;  
        }
        return counter;
    }
   public void waitNow()
   {
       if(waitCounter != 30)
       {
           waitCounter = 30;
       }
   }
}
