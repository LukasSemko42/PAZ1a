package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class Obdlznik extends Tvar{
    private double a;
    private double b;

    public Obdlznik(double a, double b) {
        super(Math.random()*300,Math.random()*300);
        this.a = a;
        this.b = b;
    }

    public void vykresliSa(WinPane pane){
        Turtle t = new Turtle();
        pane.add(t);
        t.setPosition(super.getX(),super.getY());
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
    public boolean jeVnutornyBod(double x, double y) {
        return x >= getX() - a / 2 && x <= getX() + a / 2
                && y >= getY() - b / 2 && y <= getY() + b / 2;
    }
}

