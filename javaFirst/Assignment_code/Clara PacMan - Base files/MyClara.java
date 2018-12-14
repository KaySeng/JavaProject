import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.Iterator;
import java.util.List;

/**
 * MyClara
 * 
 * Available functions (see Assignment document for explanations on what each function does):
 * treeFront, ghostWallFront,
 * getDirection, setDirection,
 * move,
 * makeScared, isScared,
 * animate, animateDead, 
 * onLeaf, removeLeaf, 
 * onMushroom, removeMushroom,
 * allLeavesEaten, 
 * isClaraDead,
 * playClaraDieSound, isClaraDieSoundStillPlaying,
 * playLeafEatenSound,
 * playPacmanIntro, isPacmanIntroStillPlaying,
 * wrapAroundWorld,
 * getCurrentLevelNumber, advanceToLevel
 */
public class MyClara extends Clara
{

    // Please leave this first level here,
    // until after you've completed "Part 12 -
    // Making and Adding Levels"
    public final char[][] LEVEL_1 = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','.','#'},
            {'#','$','#','#','.','#','#','#','.','#','.','#','#','#','.','#','#','$','#'},
            {'#','.','#','#','.','#','#','#','.','#','.','#','#','#','.','#','#','.','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','#','#','.','#','.','#','#','#','#','#','.','#','.','#','#','.','#'},
            {'#','.','.','.','.','#','.','.','.','#','.','.','.','#','.','.','.','.','#'},
            {'#','#','#','#','.','#','#','#',' ','#',' ','#','#','#','.','#','#','#','#'},
            {' ',' ',' ','#','.','#',' ',' ',' ',' ',' ',' ',' ','#','.','#',' ',' ',' '},
            {'#','#','#','#','.','#',' ','#','#','|','#','#',' ','#','.','#','#','#','#'},
            {' ',' ',' ',' ','.',' ',' ','#','%','?','%','#',' ',' ','.',' ',' ',' ',' '},
            {'#','#','#','#','.','#',' ','#','#','#','#','#',' ','#','.','#','#','#','#'},
            {' ',' ',' ','#','.','#',' ',' ',' ',' ',' ',' ',' ','#','.','#',' ',' ',' '},
            {'#','#','#','#','.','#',' ','#','#','#','#','#',' ','#','.','#','#','#','#'},
            {'#','.','.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','.','#'},
            {'#','.','#','#','.','#','#','#','.','#','.','#','#','#','.','#','#','.','#'},
            {'#','$','.','#','.','.','.','.','.','@','.','.','.','.','.','#','.','$','#'},
            {'#','#','.','#','.','#','.','#','#','#','#','#','.','#','.','#','.','#','#'},
            {'#','.','.','.','.','#','.','.','.','#','.','.','.','#','.','.','.','.','#'},
            {'#','.','#','#','#','#','#','#','.','#','.','#','#','#','#','#','#','.','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };
    public final char[][] LEVEL_2 = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','$','#','#','.','#','#','#','.','#','.','#','#','#','.','#','#','$','#'},
            {'#','.','#','#','.','#','#','#','.','#','.','#','#','#','.','#','#','.','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','#','#','.','#','.','#','#','#','#','#','.','#','.','#','#','.','#'},
            {'#','.','.','.','.','#','.','.','.','#','.','.','.','#','.','.','.','.','#'},
            {'#','#','#','#','.','#','#','#',' ','#',' ','#','#','#','.','#','#','#','#'},
            {' ',' ',' ','#','.','#',' ',' ',' ',' ',' ',' ',' ','#','.','#',' ',' ',' '},
            {'#','#','#','#','.','#',' ','#','#','|','#','#',' ','#','.','#','#','#','#'},
            {' ',' ',' ',' ','.',' ',' ','#','%','?','%','#',' ',' ','.',' ',' ',' ',' '},
            {'#','#','#','#','.','#',' ','#','#','#','#','#',' ','#','.','#','#','#','#'},
            {' ',' ',' ','#','.','#',' ',' ',' ',' ',' ',' ',' ','#','.','#',' ',' ',' '},
            {'#','#','#','#','.','#',' ','#','#','#','#','#',' ','#','.','#','#','#','#'},
            {'#','.','.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','.','#'},
            {'#','.','#','#','.','#','#','#','.','#','.','#','#','#','.','#','#','.','#'},
            {'#','$','.','#','.','.','.','.','.','@','.','.','.','.','.','#','.','$','#'},
            {'#','#','.','#','.','#','.','#','#','#','#','#','.','#','.','#','.','#','#'},
            {'#','.','.','.','.','#','.','.','.','#','.','.','.','#','.','.','.','.','#'},
            {'#','.','#','#','#','#','#','#','.','#','.','#','#','#','#','#','#','.','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };

    // Movement constants
    public final String  UP = "up";    
    public final String  DOWN = "down";    
    public final String  LEFT = "left";    
    public final String  RIGHT = "right";        

    // Add and initialise Clara's variables here
    /*
     * 
     */
    int level  = 0;
    int x = 0;
    boolean startLevel = true;
    boolean isKeyDown = false;
    /**
     * Act method
     * 
     * Runs of every frame
     */
    public void act()

    {
        animateClara();
        startClara();
        //controlClara(); // remove this later
        wrapAroundWorld();
        eatingSound();
        levelClara();
        claraDead();
    }
    //music
    void claraDead()
    {

        if (isClaraDead())
        {
            animateDead();
            playClaraDieSound();
        }

    }

    void startClara()
    {   
        if (startLevel == true)
        {
            Greenfoot.setSpeed(50);
            playPacmanIntro();
            startLevel = false;
        }
        if (startLevel == false)
        {
            if (!isPacmanIntroStillPlaying())
            {
                controlClara();
            }
        }
    }

    void levelClara()
    {
        level = getCurrentLevelNumber();
        if ((level == 1) == true)
        {
            if (allLeavesEaten())
            {
                advanceToLevel(LEVEL_2);
            }
        }
        if ((level == 1) == false)
        {
            if (allLeavesEaten())
            {
                advanceToLevel(LEVEL_1);
            }
        }
    }

    void eatingSound()
    {
        if (onLeaf())
        {
            removeLeaf(); 
            playLeafEatenSound();           
        }
    }

    void animateClara()
    {
        if (!treeFront() && !ghostWallFront())
        {   
            x++;
            if (x == 4)
            {
                animate();
                x = 0;
            }
            //animate();           
        }
    }

    void controlClara()
    {
        if (!isClaraDead())
        {
            if (Greenfoot.isKeyDown("down"))
            {
                System.out.println("down");
                setDirection("down");
                isKeyDown = true;
            }
            if (Greenfoot.isKeyDown("up"))
            {
                System.out.println("up");
                setDirection("up");
                isKeyDown = true;
            }
            if (Greenfoot.isKeyDown("left"))
            {
                System.out.println("left");
                setDirection("left");
                isKeyDown = true;
            }
            if (Greenfoot.isKeyDown("right"))
            {
                System.out.println("right");
                setDirection("right");
                isKeyDown = true;
            } 
            if (isKeyDown == true)
            {      
                if (!treeFront() && !ghostWallFront() && !isClaraDead())
                {
                    move(3);
                    
                }
            }
        }
        else
            playClaraDieSound();

        //Give Clara functions here
    }
}