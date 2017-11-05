/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highscore;

import java.io.Serializable;

/**
 *
 * @author adams
 */
public class Score implements Serializable 
// This class gives us the ability to make a score class, with the name and score of a player after a finished game. 
// It implements Serializable so we can sort the scores.
{
 private int score;
 private String name;
 
 public Score(String name, int score)
 {
     this.name = name;
     this.score = score;
 }
 
 public int getScore(){
     return score;
 }
 public String getName(){
     return name;
 }
 

}
