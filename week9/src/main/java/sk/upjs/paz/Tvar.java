package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class Tvar {
    private double x;
    private double y;

    public Tvar(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void vykresliSa(WinPane pane){
        System.err.println("Nejde nacitat tvar");
    }

    public boolean jeVnutornyBod(double x, double y){
        System.err.println("Nejde nacitat tvar");
        return false;
    }
}
