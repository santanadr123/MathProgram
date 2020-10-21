/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mathpractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author santa
 */
public class SaveProgram implements ActionListener{
    
    Score score;
    
    SaveProgram(Score score)
    {
        this.score = score;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try {
            FileOutputStream filesaver = new FileOutputStream("mathProgram.ser");
            ObjectOutputStream os = new ObjectOutputStream(filesaver);
            os.writeObject(score);
            os.close();
            JOptionPane.showMessageDialog(null, "Game Saved!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveProgram.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveProgram.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
