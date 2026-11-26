package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class Kruh extends Tvar{
    private double polomer;

    public Kruh(double polomer) {
        super(Math.random()*300,Math.random()*300);
        this.polomer = polomer;
    }

    public void vykresliSa(WinPane pane){
        Turtle t = new Turtle();
        pane.add(t);
        t.setPosition(super.getX(),super.getY());
        t.circle(polomer);
        pane.remove(t);
    }
    public boolean jeVnutornyBod(double x, double y){
        return (Math.sqrt(Math.pow((x-super.getX()),2)+Math.pow((y-super.getY()),2))<=polomer);
    }
}
