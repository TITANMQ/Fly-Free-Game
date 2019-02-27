import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */




public class MyWorld extends World
{
    
    final static int WIDTH = 1200;
    final static int HEIGHT = 800;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private ScoreBoard scoreBoard;
    private ScoreBoard fliesDead;
    private Player_2 player__2;
    private Player_1 player_2;
    private int flyPopulation;
    private int frogPopulation;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
   
    public SafeHouseBounds safehousebounds;
    
    private void prepare()
    {   
        safehousebounds = new SafeHouseBounds(500, 300, 270, 270);
        addObject(safehousebounds,273,175);
        safehousebounds.setLocation(270,111);
        safehousebounds.addPointsToWorld();
        //Collectable collectable = new Collectable();
        //addObject(collectable,321,148);

        //removeObject(collectable)
        player_2 = new Player_1( false);
        addObject(player_2,60,122);
        Enemy enemy = new Enemy(safehousebounds);
        addObject(enemy,235,220);
        enemy.setLocation(607,542);
        enemy.setLocation(617,384);

        enemy.setLocation(608,376);
        enemy.setLocation(1136,671);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(270,111);
        safehousebounds.setLocation(16,793);

        player_2.setLocation(621,450);

        player__2 = new Player_2();
        addObject(player__2,661,378);
        scoreBoard = new ScoreBoard("Score: 0", 28);
        addObject(scoreBoard,91,51);
        fliesDead = new ScoreBoard("Flies dead: 0", 28);
        addObject(fliesDead,243,50);

        Collectable collectable = new Collectable();
        addObject(collectable,68,100);
        Collectable collectable2 = new Collectable();
        addObject(collectable2,1140,63);
        Collectable collectable3 = new Collectable();
        addObject(collectable3,1042,779);
        safehousebounds.setLocation(637,445);
        Enemy enemy2 = new Enemy(safehousebounds);
        addObject(enemy2,342,147);
        Enemy enemy3 = new Enemy(safehousebounds);
        addObject(enemy3,901,217);
        Fly_bot fly_bot = new Fly_bot(1);
        addObject(fly_bot,649,514);
        Fly_bot fly_bot2 = new Fly_bot(0);
        addObject(fly_bot2,546,515);
        Fly_bot fly_bot3 = new Fly_bot(0);
        addObject(fly_bot3,717,436);
        Fly_bot fly_bot4 = new Fly_bot(0);
        addObject(fly_bot4,154,477);
        addFliesToPopulation(4);
        frogPopulation = 3;
        
    }
    
    public void setScore(int score)
    {   
        int newValue = scoreBoard.getPreviousValue() + score; 
        scoreBoard.setValue("Score: "+ newValue);
        scoreBoard.setPreviousValue(newValue);
    }
    
    public void setFliesDeaths(int value)
    {   
        int newValue = fliesDead.getPreviousValue() + value; 
        fliesDead.setValue("Flies Dead: "+ newValue);
        fliesDead.setPreviousValue(newValue);
    }
    
    public void addFrogs(int n)
    {
        for(int i = 0; i <n; i++ )
        {      int randX ,randY;
               randX = Greenfoot.getRandomNumber(WIDTH);
               randY = Greenfoot.getRandomNumber(HEIGHT);
             addObject(new Enemy(safehousebounds), randX, randY);
        }
    }
    
    public int getFliesPop()
    {
        return flyPopulation;
    }
    
    public void addFliesToPopulation(int i)
    {
        flyPopulation += i;
    }
    
    public void removeFliesFromPopulation(int i)
    {
        flyPopulation -= i;
    }
    
    public void setFrogPop(int i)
    {
        frogPopulation = i;
    }
    
    public int getFrogPop()
    {
        return frogPopulation;
    }
}
