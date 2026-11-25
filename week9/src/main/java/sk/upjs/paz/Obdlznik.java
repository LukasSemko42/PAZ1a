package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class Obdlznik extends Tvar{
    private double a;
    private double b;

    public Obdlznik(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void vykresliSa(WinPane pane){
        Turtle t = new Turtle();
        pane.add(t);
        t.setPosition(super.x,super.y);
        t.penUp();
        t.setDirection(-90);
        t.step(a/2);
        t.turn(90);
        t.penDown();
        t.step(b/2);
        t.turn(90);
        t.step(a);
        t.turn(90);
        t.step(b);
        t.turn(90);
        t.step(a);
        t.turn(90);
        t.step(b/2);
        pane.remove(t);
    }
    public boolean jeVnutornyBod(double x, double y){
        return x>=super.x && x<=super.x && y>=super.y && y<=super.y;
    }
}

