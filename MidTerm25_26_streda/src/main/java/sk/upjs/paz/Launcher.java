package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		MidtermPane pane = new MidtermPane();
		Midtermarka m = new Midtermarka();

		ObjectInspector oi = new ObjectInspector();
		oi.inspect(pane);
		oi.inspect(m);
	}
}
