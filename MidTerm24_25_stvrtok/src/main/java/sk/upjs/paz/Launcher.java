package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		MidtermPane pane = new MidtermPane();
		Midtermarka mt = new Midtermarka();
		pane.add(mt);

		ObjectInspector oi= new ObjectInspector();
		oi.inspect(pane);
		oi.inspect(mt);
		
	}
}
