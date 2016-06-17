package snake.ladder;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import static javafx.scene.text.Font.font;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
This is the class for Dice of the game.
*/

public class Dice {
     private Image Dice;
     Random r=new Random();
     
    

     ScreenManager screen;
    
/*
     This is the constructor of the Dice and initializes Dice image which is seen on the main Game image on right hand side.
     */
    public  Dice() {
        Dice = new ImageIcon("Dice.png").getImage();
        
    }
    /*
    This method paint the Dice image.
    */
    public void paintDice(Graphics2D g){
      g.drawImage(Dice, 632,314,142,100 , null);
    }
    
    /*
    This method paint random number below "Throw Dice"
    */
    
    public void paintRandomNumber(Graphics2D g,int randomNumber){
        
       String randomNumberToString=Integer.toString(randomNumber);
       g.setFont(new Font("default",Font.BOLD,25));
       g.setColor(Color.darkGray.darker());
       g.drawString(randomNumberToString, 680, 235);
    }
    
}
