package print.wf.common;

import java.awt.*;

public final class SystemProperties {
        public static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        public static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        public static final String USER_DIR = System.getProperty("user.dir");

        public SystemProperties() {
        }
    }


