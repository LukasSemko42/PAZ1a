package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class SmartTurtle extends Turtle {
    public int stringToInt(String s, int defaultValue){
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e){
            System.err.println(e.getMessage());
        }
        return 0;
    }



}
