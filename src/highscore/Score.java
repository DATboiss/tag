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
{
 private int score;
 private String name;
 
 public int getScore(){
     return score;
 }
 public String getName(){
     return name;
 }
 
 public Score(String name, int score)
 {
     this.name = name;
     this.score = score;
 }
 
}
