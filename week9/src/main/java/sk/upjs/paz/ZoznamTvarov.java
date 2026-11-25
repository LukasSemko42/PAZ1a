package sk.upjs.paz;

import sk.upjs.jpaz2.Pane;
import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;


public class ZoznamTvarov {
    Tvar[] tvary;
    private int listLen;

    public ZoznamTvarov() {
        this.tvary = new Tvar[0];
        this.listLen=0;
    }

    public void pridajTvar(Tvar t) {
        Tvar[] temp = tvary;
        Tvar[] tvary = new Tvar[temp.length+1];
        System.arraycopy(temp,0,tvary,0,temp.length);
        tvary[listLen]=t;
        listLen++;
    }

    public void nakresliVsetky(WinPane plocha) {
        Turtle t = new Turtle();
        plocha.add(t);
        for (int i = 0; i < tvary.length; i++) {
//            t.setPosition();
            tvary[i].vykresliSa(plocha);
        }
    }

    public void posun(double dx, double dy) {
        //???
    }

    public Tvar bodTvaru(double x, double y) {
        return null;
    }

    public void odstranTvar(Tvar t) {
        //???
    }
}

