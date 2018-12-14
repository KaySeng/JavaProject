import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
/**
 * Ghost Class
 * 
 * Available functions (see Assignment document for explanations on what each function does):
 * treeFront, treeAbove, treeBelow, treeToLeft, treeToRight,
 * getDirection, setDirection,
 * move,
 * isScared,
 * animate, animateDead, animateScared,
 * getClara, getGhostHealer,
 * isAboveMe, isBelowMe, isToMyLeft, isToMyRight,
 * makeClaraDead,
 * playGhostEatenSound,
 * isPacmanIntroStillPlaying,
 * wrapAroundWorld
 */
public class Ghost extends Character
{
    public final String  UP = "up";    
    public final String  DOWN = "down";    
    public final String  LEFT = "left";    
    public final String  RIGHT = "right"; 
    //Add and initialise Ghost variables here
    int level  = 0;
    boolean startLevel = true;
    boolean isKeyDown = false;
    boolean isAtSameIntersection = false;
    /**
     * Act method, runs on every frame
     */
    public void act()

    {
        animate();
        startGhost();
        
        if ( intersects(getGhostHealer()) )// || intersects( getGhostWall() )   )
        {
            setDirection("up");
            isAtSameIntersection = true;
            //isGhostAtIntersection = true;
        }

        if ( isAtIntersection() && !isAtSameIntersection)
        {
            randomTurn();
            isAtSameIntersection = true;
        }
        
        if ( treeFront() )
            randomTurn();
       
        if ( !isAtIntersection() )
            isAtSameIntersection = false;
            
        if (intersects (getClara()))
        {
            makeClaraDead();
        }
        
        //controlClara(); // remove this later
        wrapAroundWorld();
        //animate();
        //if (isAtIntersection() == true)
        //{
        //    randomTurn();
        // }   
        //move(3);
        //isAtIntersection();
    }

    boolean isAtIntersection() 
    {
        boolean retVal = false;  
        
        if (!treeAbove() && !treeBelow()&& !treeToRight() && !treeToLeft())
        {
            retVal = true;
            //isGhostAtIntersection = true;
        }
        /*
        else
        if (!treeToRight() && !treeToLeft())
        {
            retVal = true;
            //isGhostAtIntersection = true;
        }
        else
        if (isToMyLeft(getGhostHealer()))
        {
            setDirection ("left");
            isGhostAtIntersection = true;
        }
        else
        if (isToMyRight(getGhostHealer()))
        {
            setDirection ("right");
            isGhostAtIntersection = true;
        }
        */
        else
        if (!treeAbove() && !treeToRight() && !treeToLeft() )
        {
            retVal = true;
            //isGhostAtIntersection = true;
        }
        else
        if (!treeBelow() && !treeToRight() && !treeToLeft())
        {
            retVal = true;    
           // isGhostAtIntersection = true;
        }
        else
        if (!treeBelow() && !treeAbove() && !treeToLeft())
        {
            retVal = true;
            //isGhostAtIntersection = true;
        }
        else
        if (!treeBelow() && !treeAbove() && !treeToRight())
        {
            retVal = true;    
            //isGhostAtIntersection = true;
        }
       
        /*
        else
        if (!treeBelow() && !treeAbove() && !treeToRight() && !treeToLeft())
        {
            retVal = true;
            isGhostAtIntersection = true;
        }
        else
        if (treeToRight() && treeToLeft() && !treeAbove())
        {
            retVal = true;
            isGhostAtIntersection = true;
        }
        */
        return retVal;
    }

    void randomTurn()
    {
        //if (isGhostAtIntersection == true)
        {
            int randomDir = Greenfoot.getRandomNumber(4);
            if (randomDir == 0)
            {
                setDirection("left");
                //isGhostAtIntersection = false;
            }
            else
            if (randomDir == 1)
            {
                setDirection("right");
                //isGhostAtIntersection = false;
            }
            else
            if (randomDir == 2)
            {
                setDirection("up");
                //isGhostAtIntersection = false;
            }
            else
            if (randomDir == 3)
            {
                setDirection("down");
                //isGhostAtIntersection = false;
            }
        }
    }
    //music
    void startGhost()
    {   
        if (startLevel == true)
        {
            //playPacmanIntro();
            Greenfoot.setSpeed(50);
            startLevel = false;
        }
        if (startLevel == false)
        {
            if (!isPacmanIntroStillPlaying())
            {
                controlGhost();
            }
        }
    }

    void animateGhost()
    {
        if (!treeFront())
        {
            animate();
        }
    }

    void controlGhost()
    {
        //setDirection("up");
        // if (isKeyDown == true)

        /*
        if ( isAtIntersection() == true)
        {
            randomTurn();
        }
        */

        if (!treeFront())
        {
            move(1);
            //isAtIntersection();
        }


    }
    //Give the Ghost functions here
}
