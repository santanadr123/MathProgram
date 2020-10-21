
package com.mycompany.mathpractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author santa
 */
public class LoadGame implements ActionListener{
    
    GUI currentGUI;
    
    LoadGame(GUI currentGUI){
        this.currentGUI = currentGUI;
    }
    
    public void actionPerformed(ActionEvent e){
        try{
            FileInputStream fileInput = new FileInputStream("mathProgram.ser");
            ObjectInputStream oi = new ObjectInputStream(fileInput);
            Score previousFile = (Score) oi.readObject();
            currentGUI.setScore(previousFile.getScore());
            currentGUI.score.setScore(previousFile.getScore());
            oi.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
    

