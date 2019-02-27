/**
 * Write a description of class SafeHouseBounds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class SafeHouseBounds extends Actor 
{
    
    
    
    private BoundPointPosition point1;
    private BoundPointPosition point2;
    private BoundPointPosition point3;
    private BoundPointPosition point4;
    private boolean bool = false;
    
    /**
     * Constructor for objects of class SafeHouseBounds
     * 10,10,20,20
     */
    public SafeHouseBounds(int x1 , int y1, int width, int height )
    {
        point1 = new BoundPointPosition(x1,y1); //10,10
        point2 = new BoundPointPosition(point1.getX()+width,y1);//30, 10
        point3 = new BoundPointPosition(point2.getX(),point2.getY()+ height);//30,30 
        point4 = new BoundPointPosition(point1.getX(),point1.getY()+height);//10, 30
        
    }
    //TODO FIX this constructor 
  /*  public SafeHouseBounds(BoundPointPosition point1, BoundPointPosition point2, BoundPointPosition point3, BoundPointPosition point4)
    {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }
    */
   
    public void addPointsToWorld()
    {
        World world; 
            world = getWorld(); 
        try{
           world.addObject( point1, point1.getX(), point1.getY() ); 
            world.addObject( point2, point2.getX(), point2.getY() );
            world.addObject( point3, point3.getX(), point3.getY() );
            world.addObject( point4, point4.getX(), point4.getY() ); 
        }catch(NullPointerException e)
        {
            System.out.println(e);
        }
           
    } 
   //TODO make random respawn when entered
    public void GetOutOfBounds(Actor actor)
    {
        actor.setLocation(point3.getX()+100,point3.getY()+500);
       
    }
   public void inBounds(Actor actor)
   {
       if(actor.getX() >= point1.getX() && actor.getX() <= point2.getX())
       {
           if(actor.getY() >= point2.getY() && actor.getY() <= point4.getY())
           {
               GetOutOfBounds(actor);
            }
        }
       
   }
   public boolean isInBounds(Actor actor, boolean move)
   {    
       boolean inBounds = false;
       if(actor != null && actor.getWorld() !=  null)
       {
           if(actor.getX() >= point1.getX() && actor.getX() <= point2.getX())
           {
               if(actor.getY() >= point2.getY() && actor.getY() <= point4.getY())
               {    
                   if(move)
                   {
                       GetOutOfBounds(actor);
                    }

                    inBounds = true;
                }
            }
        }
       return inBounds;
   }
   
}
