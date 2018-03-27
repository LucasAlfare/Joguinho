package com.bomesmo.joguinho;

/**
 * Created by Lucas on 27/03/2018.
 */

public class Debugger {

    public enum Level {
        INFO("INFO"),
        DEBUG("DEBUG"),
        WARN("WARN"),
        ERROR("ERROR");

        private String label;

        Level(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    public static String debug(Object o, Level level){
        return String.format("[%s] %s", level.getLabel(), o.toString());
    }
}
