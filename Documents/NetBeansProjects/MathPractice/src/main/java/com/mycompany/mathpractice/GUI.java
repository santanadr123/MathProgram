
package com.mycompany.mathpractice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author santa
 */
public class GUI extends JPanel
{
    private final JFrame mainFrame = new JFrame();
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton check;
    private JButton newEquation;
    private JTextField output;
    private JTextField input;
    private JTextField currentScore;
    private GridBagConstraints topGBC;
    private GridBagConstraints bottomGBC;
    private String userAnswer;
    private JLabel scoreLabel, background;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem saveGame, loadGame;
   
    
    Score score;
    RandonEquation randomEquation;
    Icon img = new ImageIcon("C:\\Users\\santa\\Documents\\NetBeansProjects\\MathPractice\\src\\main\\java\\com\\mycompany\\mathpractice\\dinosaurs.jpg");
    File mathSocreFile;   
    public void createGUI()
    {
        // Instance to add or subtract score
        score = new Score();
        // Main Frame
        mainFrame.setSize(820, 640);
        mainFrame.setResizable(false);
        background = new JLabel(img);
        //background.setLayout(new GridLayout(2,1));
        mainFrame.setContentPane(background);
        mainFrame.setLayout(new GridLayout(2,1));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Bar Menu
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        saveGame = new JMenuItem("Save Game");
        loadGame = new JMenuItem("Load Previous Game");
        saveGame.addActionListener(new SaveProgram(score));
        loadGame.addActionListener(new LoadGame(this));
        menu.add(saveGame);
        menu.add(loadGame);
        menuBar.add(menu);
        
        // Top panel
        topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        topPanel.setOpaque(false);
        topPanel.setBackground(Color.red);
        topGBC = new GridBagConstraints();
        topPanel.setPreferredSize(new Dimension(500,300));
        TitledBorder tb1 = new TitledBorder("Equation");
        tb1.setTitleFont(new Font("",4,12));
        tb1.setTitleColor(Color.yellow);
        topPanel.setBorder(tb1); 
        
        //Bottom panel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridBagLayout());
        bottomPanel.setOpaque(false);
        bottomGBC = new GridBagConstraints();
        TitledBorder tb = new TitledBorder("Answer");
        tb.setTitleFont(new Font("",4,12));
        tb.setTitleColor(Color.yellow);
        bottomPanel.setBorder(tb);
        bottomPanel.setPreferredSize(new Dimension(500,250));
        
        // Next button    
        newEquation = new JButton("NEXT");
        newEquation.setPreferredSize(new Dimension(200, 55));
        newEquation.setFont(new Font("serif", 5,30));
        topGBC.insets = new Insets(10,10,10,10);
        topGBC.gridx = 0;
        topGBC.gridy = 2;
        topGBC.gridwidth = 2;
        newEquation.addActionListener(e -> {
            randomEquation = new RandonEquation();
            output.setText(randomEquation.randomEquation());
            input.setEditable(true);
        });
        
        // Add new equation button
        topPanel.add(newEquation, topGBC);
        
        // Check button
        check = new JButton("CHECK");
        check.setPreferredSize(new Dimension(200, 55));
        check.setFont(new Font("serif", 5, 30));
        bottomGBC.insets = new Insets(10,10,10,10);
        bottomGBC.gridx = 0;
        bottomGBC.gridy = 1;
        check.addActionListener(e ->
            {
                userAnswer = input.getText();
                if(userAnswer.length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Enter your answer");
                }
                else if(userAnswer.equals(randomEquation.answer))
                {
                    JOptionPane.showMessageDialog(null, "Good Job!!!");
                    input.setText(null);
                    score.plusOne();
                    currentScore.setText(Integer.toString(score.getScore()));
                    output.setText(randomEquation.randomEquation());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Try Again");
                    if(score.getScore() != 0)
                    {
                        score.minusOne();
                        currentScore.setText(Integer.toString(score.getScore()));
                    }
                    input.setText(null);
                }  
            
        });
        
        // Add check button
        bottomPanel.add(check, bottomGBC);
        
        // Text field for equations
        output = new JTextField();
        output.setPreferredSize(new Dimension(440,118));
        output.setEditable(false);
        output.setFont(new Font("serif", 10, 50));
        output.setText("Click Next Abraham!");
        output.setHorizontalAlignment(JTextField.CENTER);
        topGBC.gridx = 0;
        topGBC.gridy = 1;
        topGBC.gridwidth = 2;
        
        // Add equations field
        topPanel.add(output, topGBC);
        
        // Text for answer
        bottomGBC.gridx = 0;
        bottomGBC.gridy = 0;
        input = new JTextField();
        input.setPreferredSize(new Dimension(350,118));
        input.setFont(new Font("serif", 10, 50));
        input.setHorizontalAlignment(JTextField.CENTER);
        input.setEditable(false);        
        
        // Add text for answer
        bottomPanel.add(input, bottomGBC);
        
        // Label for scores 
        scoreLabel = new JLabel("Score");
        scoreLabel.setFont(new Font("",10,20));
        topGBC.gridx = 0;
        topGBC.gridy = 0;  
        
        // textfield for current score
        currentScore = new JTextField(10);
        currentScore.setPreferredSize(new Dimension(10,30));
        currentScore.setFont(new Font("", 10,20));
        currentScore.setEditable(false);
        currentScore.setText("0");
        currentScore.setHorizontalAlignment(JTextField.CENTER);
        topGBC.gridx = 1;
        topGBC.gridy = 0;
             
        // Add label score & current score
        topPanel.add(scoreLabel);
        topPanel.add(currentScore);

        
        // Add panels
        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.pack();
        mainFrame.setVisible(true);  
    }
    
    // Use in LoadGame.java to set the saved score on the GUI.
    public void setScore(int currentScore){
        this.currentScore.setText(Integer.toString(currentScore));
    }
}
