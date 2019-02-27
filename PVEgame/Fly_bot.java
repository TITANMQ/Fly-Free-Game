import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fly_bot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly_bot extends Player
{
    /**
     * Act - do whatever the fly_bot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public final int evolutionSpeed = 2;
    public static int maxSpeed;
    private int playerFollowing;
    private int width= 100;
    private int height = 100;
    private int speed = 7;
    private int speedCap = 20;
    public Fly_bot(int playerClass)
    {   
        super("Fly ");
        playerFollowing = playerClass;
        speed = maxSpeed;
       
        
    }

    public void act() 
    {
        followFly(playerFollowing);
        eats(50);
    } 

    private  void followFly(int playerClass)
    {

        Object followPlayer;
        switch(playerClass)
        {
            case Egg.PLAYER1_CLASS:
            followPlayer = Player_1.class;
            break;
            case Egg.PLAYER2_CLASS:
            followPlayer = Player_2.class;
            break;
            default:  
            followPlayer = Player_1.class;
            break;
        }

        
        int dist = 400;
        int dist2 = 1000;
        Actor closest = null;

        if(!getObjectsInRange(dist, followPlayer.getClass()).isEmpty())
        {
            for (Object obj: getObjectsInRange(dist, followPlayer.getClass()))
            {
                Player_1 player_1 = (Player_1) obj;
                int guyDist = (int)Math.hypot(player_1.getX() - getX(), player_1.getY() - getY());
                if (closest == null || guyDist< dist)
                {
                    closest = player_1;
                    dist = guyDist;
                }
            }
            turnTowards(closest.getX(),closest.getY());
            move();
        }
        else if(!getObjectsInRange(dist2, Tadpole.class).isEmpty())
        {

            Tadpole tadpole =  null;
            for (Object obj: getObjectsInRange(dist2, Tadpole.class))
            {
                tadpole = (Tadpole) obj;
                int guyDist = (int)Math.hypot(tadpole.getX() - getX(), tadpole.getY() - getY());
                if (closest == null || guyDist< dist2)
                {
                    closest = tadpole;
                    dist2 = guyDist;
                }
            }
            turnTowards(closest.getX(),closest.getY());
            if(!tadpole.enemyInRadius()  )
            {   
                if(!enemyInRadius())
                {
                    move();
                }else if(!enemyJumpPointInRadius())
                {   
                    turn(90);
                    move(10);
                    
                }
                else
                {    
                    if(!checkEnemyRight())
                    {
                        turn(110);
                        move(-3);
                        
                    }
                    else
                    {
                        if(!checkEnemyLeft())
                        {
                            turn(-110);
                            move(-3);
                            
                        }
                        else
                        {
                            move(-10);
                        }
                    }
                    
                    move(4);
                  

                }

            }else
            {
                move(4);
            }

        }
        else
        {   MyWorld world = (MyWorld) getWorld();
            int safeHouseX =world.safehousebounds.getX();
            int safeHouseY = world.safehousebounds.getY();
            turnTowards(safeHouseX,safeHouseY );
            if(!(getX() == safeHouseX && getY() == safeHouseY ) )
            {
                 if(!enemyInRadius())
                {
                    move();
                }else if(!enemyJumpPointInRadius())
                {   
                    turn(90);
                    move(10);
                    
                }
                else
                {    
                    if(!checkEnemyRight())
                    {
                        setRotation(getRotation()+100);

                    }
                    else
                    {
                        if(!checkEnemyLeft())
                            setRotation(getRotation()-100);
                        else
                            move(-10);
                    }
                    
                    move(10);
                }

            }
            
          
        }
    }

    private void move()
    {

        if(Greenfoot.isKeyDown("enter"))
        {
            move(speed + 2);
        }
        else
        {
            move(speed); //3
        }

    }

    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 5, clss);
        return actor != null;        
    }

    public boolean enemyInRadius()
    {   
        Actor closest = null; 
        int dist = 100;
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
    
     public boolean enemyJumpPointInRadius()
    {   
        Actor closest = null; 
        int dist = 100;
        boolean inRadius = false;
        if(!getObjectsInRange(dist, EnemyJumpPoint.class).isEmpty())
        {

            for (Object obj: getObjectsInRange(dist, EnemyJumpPoint.class))
            {
                EnemyJumpPoint jumpPoint = (EnemyJumpPoint) obj;
                int guyDist = (int)Math.hypot(jumpPoint.getX() - getX(), jumpPoint.getY() - getY());
                if (closest == null || guyDist< dist)
                {
                    closest = jumpPoint;
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
    private boolean checkEnemyRight()
    {   
        boolean isRight = false;
        BoundPointPosition p1 = new BoundPointPosition(getX() +1 , getY() + (height/2));
        BoundPointPosition p2 = new BoundPointPosition(p1.getX() + width , getY() + (height/2));
        BoundPointPosition p3 = new BoundPointPosition(p1.getX(), p1.getY() + height );
        BoundPointPosition p4 = new BoundPointPosition(p2.getX() + width , p2.getY());
        for (Actor frog : getWorld().getObjects(Enemy.class))
        {
            if(frog.getX() >= p1.getX() && frog.getX() <= p2.getX())
            {
                if(frog.getY() >= p2.getY() && frog.getY() <= p4.getY())
                {
                   isRight =  true;
                }
            }

        }      
        return isRight;
    }

    private boolean checkEnemyLeft()
    {   
       
        
       boolean isLeft = false;
        BoundPointPosition p2 = new BoundPointPosition(getX() - 1 , getY() + (height/2)); 
        BoundPointPosition p1 = new BoundPointPosition(p2.getX() - width , getY() + (height/2));
        BoundPointPosition p3 = new BoundPointPosition(p1.getX(), p1.getY() + height );
        BoundPointPosition p4 = new BoundPointPosition(p2.getX() + width , p2.getY());
        
     
        for (Actor frog : getWorld().getObjects(Enemy.class))
        {
            if(frog.getX() >= p1.getX() && frog.getX() <= p2.getX())
            {
                if(frog.getY() >= p2.getY() && frog.getY() <= p4.getY())
                {
                   isLeft =  true;
                }
            }

        }
    
        return isLeft;
        
    }
  
    
    public int getSpeed()
    {
        return speed;
    }
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    public void evolve()
    {   
        
        MyWorld world = (MyWorld)getWorld();
        for(Fly_bot obj : world.getObjects(Fly_bot.class))
        {   
            if(obj.getSpeed() <=speedCap)
            {
                obj.setSpeed(getSpeed()+ evolutionSpeed);
                 Fly_bot.maxSpeed = obj.getSpeed();
            }
            
            obj.setHealth(getHealth()+ evolutionSpeed );
           
           
        }
       
    }
    
    private String getRandomName()
    {
        String rName; 
        int id = Greenfoot.getRandomNumber(1000)+1;
        rName = "Fly Id " +  id;
        return rName;
    }
    
}
