package snake.ladder;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import static javafx.scene.text.Font.font;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
 This class is for moving and painting Green and Red token. 
 */
public class Token {

    private Image greenToken, redToken;
    boolean pcChance = false;

    boolean paintOne = true;
    private int x = 640, y = 490;
    int ax = 0, ay = 0, demoOneX, demoTwoX, demoX;
    boolean demoOne = true, demoTwo = false, demoThree = false, demoFour = false, demoFive = false, demoSix = false, demoSeven = false, demoEight = false, demoNine = false, demoTen = false;
    int reset;
    int resetAgain;

    private int addX1 = 0, addX2 = 0, addX3 = 0, addX4 = 0;

    boolean snakeOne = false, snakeTwo = false, snakeThree = false, snakeFour = false, snakeFive = false, snakeSix = false, snakeSeven = false;
    boolean ladderOne = false, ladderTwo = false, ladderThree = false, ladderFour = false, ladderFive = false, ladderSix = false, ladderSeven = false;
    boolean finalHome = false;
    int finalPart;
    boolean winningSelection = false;
    /*
     This is the constructor of Token Class and it initializes Green and Red token images.
     */

    public Token() {

        greenToken = new ImageIcon("Green.png").getImage();
        redToken = new ImageIcon("Red.png").getImage();

    }
    
    

    /*
     This method sets to '1'no. grid when dice is set to '1' for the first time.
     */
    public void setToOne() {
        x = 17;
        y = 530;
    }
   
    
    

    /*
     This method handels movement of both Green and Red token.
     */
    public void moveGreenToken(int moveamount) {
        demoX = 12 + ax + addX1 + addX2 + addX3 + addX4;

        if (ladderOne) {
            ladderOne = false;
            ax = 900;
            demoOne = false;
            demoTwo = true;
        }

        if (ladderTwo == true) {
            ladderTwo = false;
            demoOne = false;
            demoFour = true;
            ax = 0;
            demoX = 1812;

            reset = (-1 * (1169 - demoX - 15 + 60));
            addX1 = reset;
            demoTwo = false;
            demoThree = true;
            demoX = 12 + ax + addX1;

        }

        if (ladderThree == true) {
            ladderThree = false;
            demoOne = false;
            demoTwo = false;
            demoFour = true;
            ax = 0;
            demoX = 2232;

            reset = (-1 * (1169 - demoX - 15 + 60));
            addX1 = reset;
            demoTwo = false;
            demoThree = true;
            demoX = 12 + ax + addX1;

        }

        if (ladderFour == true) {
            ladderFour = false;
            demoOne = false;
            demoTwo = false;
            demoThree = false;
            demoFour = false;
            demoFive = false;
            demoNine = true;
            demoX = 1386;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX4 = reset;

            demoX = 12 + ax + addX4;
            addX3 = 0;
            addX2 = 0;
            addX1 = 0;
        }

        if (ladderFive == true) {
            ladderFive = false;
            demoOne = false;
            demoTwo = false;
            demoThree = false;
            demoFour = false;

            demoEight = true;
            demoX = 2228;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX3 = reset;

            demoX = 12 + ax + addX3;
            addX2 = 0;
            addX1 = 0;
            addX4 = 0;

        }

        if (ladderSix == true) {
            ladderSix = false;
            demoFive = false;

            demoOne = false;
            demoTwo = false;
            demoThree = false;
            demoFour = false;
            demoSeven = true;
            demoX = 1568;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX3 = reset;
            demoSix = false;
            demoSeven = true;
            demoX = 12 + ax + addX3;
            addX2 = 0;
            addX1 = 0;
        }

        if (ladderSeven == true) {
            ladderSeven = false;
            demoOne = false;
            demoTwo = false;
            demoThree = false;
            demoFour = false;
            demoFive = false;
            demoSix = false;
            demoEight = false;
            demoTen = true;
            demoX = 1986;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX4 = reset;
            demoEight = false;
            demoNine = true;
            demoX = 12 + ax + addX4;
            addX3 = 0;
            addX2 = 0;
            addX1 = 0;

        }

        if (snakeOne == true) {
            snakeOne = false;

            demoTwo = false;
            demoOne = true;
            ax = 240;
            demoX = 252;
        }

        if (snakeTwo == true) {
            snakeTwo = false;
            demoOne = false;
            demoFive = false;
            demoTwo = true;
            ax = 780;
            demoX = 792;
            addX1 = 0;
            addX2 = 0;
            addX3 = 0;
            addX3 = 0;
            addX4 = 0;
        }

        if (snakeThree == true) {
            snakeThree = false;
            demoSeven = false;
            demoThree = true;
            demoX = 1272;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX1 = reset;

            demoX = 12 + ax + addX1;
            addX2 = 0;
            addX3 = 0;
            addX4 = 0;
        }
        if (snakeFour == true) {
            snakeFour = false;
            demoEight = false;
            demoSix = true;
            demoX = 2230;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX2 = reset;

            demoX = 12 + ax + addX2;
            addX1 = 0;
            addX3 = 0;
            addX4 = 0;

        }
        if (snakeFive == true) {
            snakeFive = false;
            demoNine = false;
            demoSeven = true;
            demoX = 1508;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX3 = reset;

            demoX = 12 + ax + addX3;
            addX2 = 0;
            addX1 = 0;
            addX4 = 0;

        }
        if (snakeSix == true) {
            snakeSix = false;
            demoTen = false;
            demoFour = true;
            demoX = 1872;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX1 = reset;

            demoX = 12 + ax + addX1;
            addX2 = 0;
            addX3 = 0;
            addX4 = 0;
        }

        if (snakeSeven == true) {
            snakeSeven = false;
            demoTen = false;
            demoThree = true;
            demoX = 1392;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX1 = reset;

            demoX = 12 + ax + addX1;
            addX2 = 0;
            addX3 = 0;
            addX4 = 0;

        }

        if (finalHome == true) {
            finalHome = false;
            demoNine = false;
            demoTen = true;
            demoX = finalPart;

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX4 = reset;

            demoX = 12 + ax + addX4;
            addX3 = 0;
            addX1 = 0;
            addX2 = 0;
            finalPart = 0;

        }

        if (demoOne == true && demoX <= 552) {
            x = 12 + ax;
            y = 530 + ay;

            if (demoX == 312) {
                ladderOne = true;
            }

            if (demoX == 492) {
                ladderTwo = true;
            }
        } else if (demoOne == true && demoX > 552) {
            demoOne = false;
            demoTwo = true;
        } else if (demoTwo == true && demoX > 552 && demoX <= 1152) {

            x = 1169 - demoX;
            y = 475;

            if (demoX == 1092) {
                ladderThree = true;
            }
            if (demoX == 972) {
                snakeOne = true;
            }

        } else if (demoTwo == true && demoX > 1152) {

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX1 = reset;
            demoTwo = false;
            demoThree = true;
            demoX = 12 + ax + addX1;

        } else if (demoThree == true && demoX <= 552) {

            x = 12 + ax + reset;
            y = 410;

            if (demoX == 430) {
                ladderFour = true;
            }
        } else if (demoThree == true && demoX > 552 && demoX <= 1152) {
            demoThree = false;
            demoFour = true;

        } else if (demoFour == true && demoX > 552 && demoX <= 1152) {

            x = 1169 - demoX;
            y = 355;

            if (demoX == 1150) {
                ladderFive = true;
            }

        } else if (demoFour == true && demoX > 1152) {

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX2 = reset;
            demoFour = false;
            demoFive = true;
            demoX = 12 + ax + addX2;
            addX1 = 0;

        } else if (demoFive == true && demoX <= 552) {

            x = 12 + ax + reset;
            y = 300;

            if (demoX == 548) {
                ladderSix = true;
            }

            if (demoX == 248) {
                snakeTwo = true;
            }

        } else if (demoFive == true && demoX > 552 && demoX <= 1152) {
            demoFive = false;
            demoSix = true;

        } else if (demoSix == true && demoX > 552 && demoX <= 1152) {
            x = 1169 - demoX;
            y = 235;

        } else if (demoSix == true && demoX > 1152) {

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX3 = reset;
            demoSix = false;
            demoSeven = true;
            demoX = 12 + ax + addX3;
            addX2 = 0;

        } else if (demoSeven == true && demoX <= 552) {

            x = 12 + ax + reset;
            y = 180;

            if (demoX == 6) {
                snakeThree = true;
            }

        } else if (demoSeven == true && demoX > 552 && demoX <= 1152) {
            demoSeven = false;
            demoEight = true;

        } else if (demoEight == true && demoX > 552 && demoX <= 1152) {
            x = 1169 - demoX;
            y = 115;

            if (demoX == 666) {
                ladderSeven = true;
            }

            if (demoX == 966) {
                snakeFour = true;
            }
        } else if (demoEight == true && demoX > 1152) {

            ax = 0;
            reset = (-1 * (1169 - demoX - 15 + 60));
            addX4 = reset;
            demoEight = false;
            demoNine = true;
            demoX = 12 + ax + addX4;
            addX3 = 0;

        } else if (demoNine == true && demoX <= 552) {

            x = 12 + ax + reset;
            y = 60;

            if (demoX == 364) {
                snakeFive = true;
            }

        } else if (demoNine == true && demoX > 552 && demoX <= 1152) {
            demoNine = false;
            demoTen = true;

        } else if (demoTen == true && demoX > 552 && demoX <= 1152) {

            x = 1169 - demoX;
            y = 5;

            if (demoX == 664) {
                snakeSix = true;
            }
            if (demoX == 1024) {
                snakeSeven = true;
            }
            if (demoX == 1144) {
                x = 660;
                y = 33;
            }
            finalPart = demoX + 1202;

        } else if (demoTen == true && demoX > 1152) {
            demoTen = false;
            finalHome = true;
            winningSelection = true;
        }

    }
    /*
     This method takes random number of Red token.
     */

    public void update() {
        Random r = new Random();
    }
    /*
     This method paint both Green and Red token with perfect grid number.
     */

    public void paint(Graphics2D g) {
        if (pcChance == false) {
            g.drawImage(greenToken, x, y, 40, 65, null);
        } else {
            g.drawImage(redToken, x, y, 40, 65, null);
        }
    }
}
