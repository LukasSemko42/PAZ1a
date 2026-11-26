package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.util.concurrent.TimeUnit;

public class Launcher {

	public static void main(String[] args) {
		WinPane plocha = new WinPane();
		ObjectInspector oi = new ObjectInspector();
		Tvar t;
		if (Math.random() < 0.5) {
			t = new Kruh(15);
		} else {
			t = new Obdlznik(50,20);
		}
//		t.vykresliSa(plocha);
//		oi.inspect(t);

//		ZoznamTvarov zt = new ZoznamTvarov();
//		oi.inspect(zt);
//		zt.pridajTvar(new Kruh(30));
//		zt.pridajTvar(new Obdlznik(50,120));
//		zt.nakresliVsetky(plocha);
//		zt.posun(50,25);
//		zt.nakresliVsetky(plocha);

		PlochaTvarov pt = new PlochaTvarov();
	}
}
