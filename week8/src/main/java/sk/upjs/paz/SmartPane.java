package sk.upjs.paz;

import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;
import java.io.File;


public class SmartPane extends WinPane{
    private Bod bod;
    private ZoznamBodov zoznam = new ZoznamBodov(new File("week8/src/main/resources/zoznambodov.txt"));

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail){
        if (detail.getButton() == MouseEvent.BUTTON1){
            this.bod=new Bod(x, y);
            zoznam.pridajBod(this.bod);
        }
        if (detail.getButton() == MouseEvent.BUTTON3){
            zoznam.ulozDoSuboru(new File("week8/src/main/resources/zoznambodov.txt"));
        }
        if (detail.getButton()==MouseEvent.BUTTON2){
            zoznam.vymaz();
            zoznam.ulozDoSuboru(new File("week8/src/main/resources/zoznambodov.txt"));
        }
    }

}
