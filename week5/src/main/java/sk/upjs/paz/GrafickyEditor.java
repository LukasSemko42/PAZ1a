package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;

public class GrafickyEditor extends WinPane {
    private Turtle k;

    public GrafickyEditor(){
        this.k= new Turtle();
        this.add(k);
    }
    public void moveTurtle(int x, int y){
        k.penUp();
        k.setPosition(x,y);
        k.penDown();
    }

    public void altMoveTurtle(int x, int y){
        double startX=k.getX();
        double startY=k.getY();
        k.penDown();
        k.turnTowards(x,y);
        k.step(k.distanceTo(x,y));
        k.penUp();
        k.setPosition(startX,startY);
    }

    public void dragMouse(int x, int y){
        k.turnTowards(x,y);
        k.step(k.distanceTo(x,y));
    }

    protected void onMouseClicked(int x, int y, MouseEvent detail){
        if ((detail.getButton()==MouseEvent.BUTTON1) && (detail.isAltDown())){
            altMoveTurtle(x,y);
        } else if (detail.getButton()==MouseEvent.BUTTON1) {
            moveTurtle(x, y);
        }
    }

    protected void onMouseDragged(int x, int y, MouseEvent detail){
        if (detail.getButton()==MouseEvent.BUTTON1){
            dragMouse(x,y);
        }
    }
}
