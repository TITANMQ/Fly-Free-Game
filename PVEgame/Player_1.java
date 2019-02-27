import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player_1 extends Player implements Iplayer
{   

    private boolean fromEgg; 
    private boolean layedEgg = false;
    private int layEggCounter = 1000000;
    boolean autoLay = false;
    Stopwatch stopwatch = new Stopwatch(true,10);
    public Player_1( boolean fromEgg)
    {   
        super("Player 1");
        this.fromEgg = fromEgg;
        World world; 
        world = getWorld();

        levelName = new Label("Level 1 Crook", 10);
        // world.addObject(levelName, getX(), getY());
        //world.addObject(stopwatch,10,10);
        //updateStopwatch();  

    }

    public void act() 
    {   
        runStopwatch();
        layEgg();
        moveForward();
        turnRight();
        turnleft();
        moveBackwards();  
        eats(50);
        boost();
        updateStopwatch();
        collects();

        //  collects(scoreboard);

    }   

    private void runStopwatch()
    {
        stopwatch.run();
    }

    @Override 
    public void boost()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            move(8); 
        } 
    }

    @Override
    public void turnRight()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            turn(4);
        }
    }

    @Override
    public void turnleft()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-4);
        }
    } 

    @Override
    public void moveForward()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            move(4);
            //buzz();
        }
    }

    @Override
    public void moveBackwards()
    {
        if(Greenfoot.isKeyDown("down"))
        {
            move(-4);
        }
    }

    private void updateStopwatch()
    {
        //new GreenfootImage(""+ stopwatch.getSeconds(),24, Color.WHITE, new Color(0,0,0,0) ));
    }

    private void layEgg()
    {   
        if(layedEgg == false){
            if(Greenfoot.isKeyDown("space") && !fromEgg )
            {
                World world; 
                world = getWorld(); 
                world.addObject( new Egg(getX(), getY()), getX(), getY()); 
                //System.out.println("spawned"); 
                // layedEgg = true;
                //stopwatch.resetClock();
                stopwatch.startClock();
                MyWorld myWorld = (MyWorld) world;

                myWorld.addFliesToPopulation(1);

            }
        }else
        {  

            if(stopwatch.getSeconds() == 0)
            {
                //layedEgg = false;
                stopwatch.stopClock();
                stopwatch.resetClock();

            }

        }
        if(autoLay)
        {    
            MyWorld world = (MyWorld) getWorld();
            if(world.getFliesPop()< 50)
            {
                World world1; 
                world1 = getWorld(); 
                world1.addObject( new Egg(getX(), getY()), getX(), getY());
                stopwatch.startClock();
                world.addFliesToPopulation(1);
            }
        }
        else
        {  

            if(stopwatch.getSeconds() == 0)
            {
                //layedEgg = false;
                stopwatch.stopClock();
                stopwatch.resetClock();

            }

        }
    }
    private void buzz()
    {   
        int songLength = 100000;
        for(int c = 0; c < songLength; c++)
        {

        }
        Greenfoot.playSound("buzzSound.wav");
    }

}
