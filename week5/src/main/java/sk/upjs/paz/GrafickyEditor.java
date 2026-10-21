package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;

public class GrafickyEditor extends WinPane {
    private Turtle k=null;

    public GrafickyEditor() {
        this.k = new Turtle();
        this.add(k);
    }

    public void moveTurtle(int x, int y) {
        k.penUp();
        k.setPosition(x, y);
    }

    public void altMoveTurtle(int x, int y) {
        double startX = k.getX();
        double startY = k.getY();
        k.penDown();
        k.turnTowards(x, y);
        k.step(k.distanceTo(x, y));
        k.setPosition(startX, startY);
        k.penUp();
    }

    public void dragMouse(int x, int y) {
        k.penDown();
        k.moveTo(x,y);
    }

    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        if (detail.getButton() == MouseEvent.BUTTON1) {
            moveTurtle(x, y);
        }
    }

    protected void onMouseMoved(int x, int y, MouseEvent detail) {
        if (detail.isAltDown()) {
            altMoveTurtle(x, y);
        }
    }

    protected void onMouseDragged ( int x, int y, MouseEvent detail){
        if ((detail.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
            dragMouse(x, y);
        }
    }
}
