package mgw.util;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen {
    public static Dimension size(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
}
