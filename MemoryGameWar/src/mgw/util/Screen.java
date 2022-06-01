package mgw.util;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

public class Screen {
    public static GraphicsDevice screenGD = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    
    public static Dimension size(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
}
