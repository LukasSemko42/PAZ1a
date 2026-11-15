package sk.upjs.paz;

import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;


public class SmartPane extends WinPane{
    private Bod bod;

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail){
        this.bod=new Bod(x, y);
    }
}
