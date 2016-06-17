package snake.ladder;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

/*
This class is for taking PC's full window.
*/

public class ScreenManager {
    private GraphicsDevice vc;
    
    /*
    This methos is the constructor of Screen Manager class.
    */
    
    public ScreenManager (){
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = e.getDefaultScreenDevice();
        
    }
    
    /*
    This methos takes the display resolution.
    */
    
    public DisplayMode[] getCompatibleDisplayModes(){
        return vc.getDisplayModes();
    }
    
    /*
    This method takes different display modes and set to perfect display modes for perfect display.
    */
    
    public DisplayMode findFirstCompatibleMode(DisplayMode modes[]){
        DisplayMode goodModes[] = vc.getDisplayModes();
        for (int x=0;x<modes.length;++x){
            for (int y=0;y<goodModes.length;++y){
                if (displayModesMatch(modes[x],goodModes[y])){
                    return (modes[x]);
                }
            }   
        }
        return null;
    }
    
    /*
      This method is for getting current display.
    */
    
    public DisplayMode getCurrentDisplayMode(){
        return vc.getDisplayMode();
    }
    
    /*
    This method mathes two display mode and compare with them. 
    */
    
    public boolean displayModesMatch(DisplayMode m1,DisplayMode m2){
        if (m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()){
            return false;
        }
        if (m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()){
            return false;
        }
        if (m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()){
            return false;
        }
        return true;
    }
    
    /*
    This method setsw PC's window to full screen. 
    */
    
    public void setFullScreen (DisplayMode dm){
        JFrame f = new JFrame();
        f.setUndecorated(true);
        f.setIgnoreRepaint(true);
        f.setResizable(false);
        vc.setFullScreenWindow(f);
        
        if (dm!=null && vc.isDisplayChangeSupported()){
            try {
                vc.setDisplayMode(dm);
                
            }catch(Exception e){}
        }
        f.createBufferStrategy(2);
        
    }
    
    /*
     This method gets PC's graphics.
    */
    
    public Graphics2D getGraphics (){
        Window w = vc.getFullScreenWindow();
        if (w!=null){
            BufferStrategy s = w.getBufferStrategy();
            return (Graphics2D)s.getDrawGraphics();
        }
        else 
            return null;
    }
    
    /*
      This method always updates PC's full screen.
    */
    
    public void update(){
        Window w = vc.getFullScreenWindow();
        if (w!=null){
            BufferStrategy s = w.getBufferStrategy();
            if (!s.contentsLost()){
                s.show();
            }
        }
    }
    
    /*
    This method get full screen window.
    */
    
    public Window getFullScreenWindow(){
        return vc.getFullScreenWindow();
    }
    
    /*
    This method get width of full screen.
    */
    
    public int getWidth (){
        Window w = vc.getFullScreenWindow();
        if (w!=null){
            return w.getWidth();
        }
        else {
            return 0;
        }
    }
    
    /*
    This method get Height of full screen.
    */
    
    public int getHeight (){
        Window w = vc.getFullScreenWindow();
        if (w!=null){
            return w.getHeight();
        }
        else {
            return 0;
        }
    }
    
    /*
     After updating full screen this method restores the full screen.
    */
    
    public void restoreScreen (){
        Window w = vc.getFullScreenWindow();
        if (w!=null){
            w.dispose();
        }
        vc.setFullScreenWindow(null);
    }
    
    /*
    This method get width,height and refresh rate of window and create compatibale image.
    
    */
    
    public BufferedImage createCompatibleImage(int w,int h,int t){
        Window win = vc.getFullScreenWindow();
        if (win!=null){
            GraphicsConfiguration gc = win.getGraphicsConfiguration();
            return (gc.createCompatibleImage(w, h, t));
        }
        return null;
    }
}

