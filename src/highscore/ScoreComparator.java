
package highscore;

import java.util.Comparator;

/**
 *
 * @author adams
 */
public class ScoreComparator implements Comparator<Score>  // Tells how to compare the different highscores
{
    public int compare(Score score1, Score score2){
        int sc1 = score1.getScore();
        int sc2 = score2.getScore();
        
        if (sc1 > sc2)
        {
            return -1;
        }
        else if (sc1 < sc2)
        {
            return +1;
        }
        else
        {
            return 0;
        }
        
    }
    
}
