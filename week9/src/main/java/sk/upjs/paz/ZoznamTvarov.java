package sk.upjs.paz;

import sk.upjs.jpaz2.Pane;
import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;


public class ZoznamTvarov {
    private Tvar[] tvary;

    public ZoznamTvarov() {
        this.tvary = new Tvar[0];
    }

    public void pridajTvar(Tvar t) {
        Tvar[] temp = tvary;
        tvary = new Tvar[temp.length+1];
        System.arraycopy(temp,0,tvary,0,temp.length);
        tvary[temp.length]=t;
    }

    public void nakresliVsetky(WinPane plocha) {
        for (Tvar tvar : tvary) {
            tvar.vykresliSa(plocha);
        }
    }

    public void posun(double dx, double dy) {
        for (Tvar tvar:tvary){
            double noveX=tvar.getX()+dx;
            double noveY=tvar.getY()+dy;
            tvar.setX(noveX);
            tvar.setY(noveY);
        }
    }

    public Tvar bodTvaru(double x, double y) {
        for (Tvar tvar : tvary){
            if (tvar.jeVnutornyBod(x,y)){
                return tvar;
            }
        }
        return null;
    }

    public void odstranTvar(Tvar t) {
        int index = -1;
        for (int i = 0; i < tvary.length; i++) {
            if (tvary[i] == t) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return;
        }

        Tvar[] noveTvary = new Tvar[tvary.length - 1];
        System.arraycopy(tvary, 0, noveTvary, 0, index);
        System.arraycopy(tvary, index + 1, noveTvary, index, tvary.length - index - 1);
        tvary = noveTvary;
    }
}