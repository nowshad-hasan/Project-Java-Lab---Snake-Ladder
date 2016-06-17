package snake.ladder;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
 It is the mian class of Snake & Ladder
 */
public class SnakeLadder implements KeyListener, MouseListener, MouseMotionListener {
    /*
     It is the main method of Snake & Ladder 
     */

    public static void main(String args[]) {

        SnakeLadder b = new SnakeLadder();
        b.run();

    }

    Image bg, mainGame, menuImage, instructionsImage, guti, selectionImage, gameBackground, winningImage, lostImage;
    boolean gameRunning = true;
    boolean mainMenu = false;
    boolean playGame = false;
    boolean playInstructions = false;
    boolean pcturn = false;
    int flag3 = 0;
    boolean openScreen = true;
    boolean Green2 = false;
    int dicenum = 0;
    boolean changeColorPlay = false;
    boolean changeColorInstructions = false;

    int flag = 0;
    int flag2 = 0;
    boolean paintRandomNumber = false;
    int diceNum2 = 0;
    int flag4 = 0;
    int x = 0, y = 0;
    int showx;
    boolean Green = false;
    boolean selection = true;

    /*
     This methos takes pc's display resolution
     */
    private static final DisplayMode modes1[] = {
        //new DisplayMode(1366,768,32,0),
        //new DisplayMode(800,600,32,0),
        //new DisplayMode(800,600,24,0),
        new DisplayMode(800, 600, 16, 0), //new DisplayMode(640,480,24,0),
    //new DisplayMode(640,480,16,0),
    //new DisplayMode(1366,768,16,0),
    };
    Dice dice = new Dice();
    Token token = new Token();
    Token pc = new Token();

    /*
     this method initializes my images used in this class
     */
    public void init() {
        bg = new ImageIcon("Background.jpg").getImage();
        mainGame = new ImageIcon("PlayGame.jpg").getImage();
        menuImage = new ImageIcon("MainMenu.jpg").getImage();
        instructionsImage = new ImageIcon("Instructions.jpg").getImage();

        selectionImage = new ImageIcon("SelectionImage.png").getImage();
        gameBackground = new ImageIcon("GameBackground.jpg").getImage();
        winningImage = new ImageIcon("WinningImage.jpg").getImage();
        lostImage = new ImageIcon("LostImage.jpg").getImage();

        pc.pcChance = true;

    }
    ScreenManager s = new ScreenManager();
    Graphics2D g = s.getGraphics();

    /*
     This method do the main work of the game.All works happened on the game is called by it directly or indirectly.
     */
    public void run() {

        try {
            DisplayMode dm = s.findFirstCompatibleMode(modes1);
            s.setFullScreen(dm);
            Window w = s.getFullScreenWindow();
            w.addKeyListener(this);
            w.addMouseListener(this);
            w.addMouseMotionListener(this);

            init();

            while (gameRunning == true) {

                while (openScreen == true) {
                    g = s.getGraphics();
                    paintMainMenu(g);
                    s.update();
                    g.dispose();
                }

                while (playGame) {
                    g = s.getGraphics();
                    paintGame(g);
                    if (flag2 == 1) {
                        token.moveGreenToken(dicenum);
                    }
                    if (Green) {
                        token.setToOne();
                        Green = false;
                        flag2 = 1;

                    }
                    if (flag3 == 1) {
                        pc.moveGreenToken(diceNum2);
                    }
                    if (Green2) {
                        pc.setToOne();
                        Green2 = false;
                        flag3 = 1;

                    }

                    if (token.winningSelection == true) {
                        g = s.getGraphics();
                        
                        g.drawImage(winningImage, 0, 0, 800, 600, null);
                         s.update();
                        g.dispose();
                        try{
                            Thread.sleep(3000);
                        }
                        catch(Exception exxx){}
                        gameRunning=false;
                        token.winningSelection = false;
                        playGame=false;
                        openScreen=false;
                        

                    } else if (pc.winningSelection == true) {
                        g = s.getGraphics();
                        g.drawImage(lostImage, 0, 0, 800, 600, null);
                        s.update();
                        g.dispose();
                        try{
                            Thread.sleep(3000);
                        }
                        catch(Exception exxx){}
                       
                        gameRunning=false;
                        pc.winningSelection=false;
                         playGame=false;
                        openScreen=false;
                    }

                    s.update();
                    g.dispose();

                }

                while (playInstructions) {
                    g = s.getGraphics();
                    paintInstructions(g);
                    s.update();
                    g.dispose();
                }

            }

        } finally {
            s.restoreScreen();
        }
    }
    /*
     This methos paint the images of all class making objects like dice,background,tokens,maingame.
     */

    public void paintGame(Graphics2D g) {
        g.drawImage(bg, x, y, null);
        g.drawImage(gameBackground, 0, 0, 800, 600, null);
        g.drawImage(mainGame, 0, 0, 600, 600, null);
        dice.paintDice(g);
        token.paint(g);
        pc.paint(g);

        dice.paintRandomNumber(g, dicenum);

    }

    /*
     This method paint the instructions of the game from main menu.
     */
    public void paintInstructions(Graphics2D g) {
        g.drawImage(bg, x, y, null);
        g.drawImage(instructionsImage, 0, 0, 800, 600, null);

    }
    /*
     This method displays the Main Menu from where we can select Play or Instructions.
     */

    public void paintMainMenu(Graphics2D g) {
        g.drawImage(menuImage, 0, 0, null);

        g.drawImage(selectionImage, 0, 0, null);

        g.setFont(new Font("default", Font.BOLD, 20));
        if (changeColorPlay == false) {
            g.setColor(Color.darkGray.darker());
            g.drawString("Play", 310, 310);
        } else if (changeColorPlay) {
            g.setColor(Color.lightGray.brighter());
            g.drawString("Play", 310, 310);
        } else if (!changeColorInstructions) {
            g.setColor(Color.darkGray.darker());
            g.drawString("Instructions", 310, 350);
        } else if (changeColorInstructions) {
            g.setColor(Color.lightGray.brighter());
            g.drawString("Instructions", 310, 350);
        }

        g.drawString("Instructions", 310, 360);

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gameRunning = false;
            playGame = false;
            playInstructions = false;
            openScreen=false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    /*
     This method happens when mouse is clicked in the window.And it handels all mouse clicking options of the game.
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        if (gameRunning == true) {
            if (e.getX() > 300 && e.getX() < 420 && e.getY() > 300 && e.getY() < 330) {
                mainMenu = false;
                playGame = true;
                openScreen = false;
            }
            if (e.getX() > 300 && e.getX() < 420 && e.getY() > 350 && e.getY() < 380) {
                mainMenu = false;
                playInstructions = true;
                openScreen = false;
            }
            if (e.getX() > 622 && e.getX() < 760 && e.getY() > 149 && e.getY() < 188) {
                Random r = new Random();

                dicenum = r.nextInt(6) + 1;
                if (dicenum == 1 && flag == 0) {
                    Green = true;
                    flag = 1;
                } else if (flag == 1) {
                    token.ax += (dicenum * 60);
                    //token.ay+=(dicenum*55);
                }

                diceNum2 = r.nextInt(6) + 1;

                if (diceNum2 == 1 && flag4 == 0) {
                    Green2 = true;
                    flag4 = 1;
                } else if (flag4 == 1) {
                    pc.ax += (diceNum2 * 60);
                    //token.ay+=(dicenum*55);
                }

            }
            if (playInstructions == true) {
                if (e.getX() > 40 && e.getX() < 165 && e.getY() > 512 && e.getY() < 535) {
                    playInstructions = false;
                    openScreen = true;
                }

            }

           
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
