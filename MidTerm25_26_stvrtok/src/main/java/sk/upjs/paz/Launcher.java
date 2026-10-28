package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		WinPane sandbox = new WinPane();

		Midtermarka obj = new Midtermarka();
		sandbox.add(obj);

		ObjectInspector oi = new ObjectInspector();
		oi.inspect(obj);
		oi.inspect(sandbox);
		
	}
}
