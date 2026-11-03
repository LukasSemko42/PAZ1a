package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		MidtermPane sandbox = new MidtermPane();
		Midtermarka m = new Midtermarka();
		sandbox.add(m);
		ObjectInspector oi = new ObjectInspector();
		oi.inspect(m);
		
	}
}
