package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class Kruh extends Tvar{
    private double polomer;

    public Kruh(double polomer) {
        this.polomer = polomer;
    }

    public void vykresliSa(WinPane pane){
        Turtle t = new Turtle();
        pane.add(t);
        t.setPosition(super.x,super.y);
        t.circle(polomer);
        pane.remove(t);
    }
    public boolean jeVnutornyBod(double x, double y){
        return (Math.sqrt(Math.pow((x-super.x),2)+Math.pow((y-super.y),2))<=polomer);
    }
}
