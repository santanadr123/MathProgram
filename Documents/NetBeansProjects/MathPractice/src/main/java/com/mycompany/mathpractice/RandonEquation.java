/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mathpractice;

/**
 *
 * @author santa
 */
public class RandonEquation 
{
    private int digit1;
    private int digit2;
    private String operator;
    String answer;
    
    public String randomEquation()
    {   
        // Swicthed multipler to 6 and 10 to simulate only multiplication table up to six
        digit1 = (int) (Math.random() * 6);
        digit2 = (int) (Math.random() * 10 + 1);
        // Switched the multipler to number one in order to practice only multiplicain
        int randomOperand = (int) (Math.random() * 1 + 1);
        
        switch(randomOperand)
        {
            case 1:
                operator = " x ";
                answer = Integer.toString(digit1 * digit2);
                break;
            case 2:
                operator = " + ";
                answer = Integer.toString(digit1 + digit2);
                break;
            case 3:
                operator = " - ";
                answer = Integer.toString(digit1 - digit2);
                break;
            case 4:
                operator = " / ";
                break;
        }
        
        if(operator.equals(" / "))
        {
            if(digit2 == 0 || digit1 % digit2 != 0)
                randomEquation();
            else
                answer = Integer.toString(digit1 / digit2);
        }
        
        return digit1 + operator + digit2 + " = ";
    }
}
