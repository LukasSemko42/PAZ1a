package sk.upjs.paz;

import sk.upjs.jpaz2.*;

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
		t.vykresliSa(plocha);
		oi.inspect(t);
	}
}
