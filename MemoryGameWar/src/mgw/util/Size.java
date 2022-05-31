package mgw.util;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Size {
    public static Dimension screenSize(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
}
