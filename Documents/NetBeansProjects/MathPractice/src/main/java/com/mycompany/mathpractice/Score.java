
package com.mycompany.mathpractice;

import java.io.Serializable;

/**
 *
 * @author santa
 */
public class Score implements Serializable{
    private int score;
    

    public void plusOne()
    {
        score++;
    }
    
    public void minusOne()
    {
        score--;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
}
