/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highscore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author adams
 */
public class HighscoreManager
{

    private ArrayList<Score> scores;

    // The name of the file where the highscores will be saved
    private static final String HIGHSCORE_FILE = "scores.dat";

    //Initialising an in and outputStream for working with the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighscoreManager()
    {
        scores = new ArrayList<Score>();
    }

    public ArrayList<Score> getScores() throws IOException
    {
        loadScoreFile();
        sort();
        return scores;
    }

    private void sort()
    {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
    }

    public void addScore(String name, int score) throws IOException
    {
        loadScoreFile();
        scores.add(new Score(name, score));
        updateScoreFile();
    }

    public void loadScoreFile() throws IOException
    //This function will load the arraylist that is in the high-score file and will put it in the "scores"-arraylist.
    //The try-catch structure will avoid that your program crashes when there is something wrong while loading the file (like when the file is corrupted or doesn't exist).
    {
        try
        {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e)
        {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e)
        {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally
        {
            try
            {
                if (outputStream != null)
                {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e)
            {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }

    public void updateScoreFile() //it will be writing the "score"-arraylist to the file
    {
        try
        {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e)
        {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e)
        {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally
        {
            try
            {
                if (outputStream != null)
                {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e)
            {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

    public String getHighscoreString() throws IOException //This function will only have the top 10 players but you can adjust the variable "max" to change that.
    {
        String highscoreString = "";
        int max = 10;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max)
        {
            x = max;
        }
        while (i < x)
        {
            highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
    }
}
