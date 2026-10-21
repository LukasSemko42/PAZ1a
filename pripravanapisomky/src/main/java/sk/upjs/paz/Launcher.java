package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		WinPane sandbox = new WinPane();
		ExamTurtle exam = new ExamTurtle();
		ObjectInspector oi = new ObjectInspector();

		sandbox.add(exam);
		oi.inspect(exam);
	}
}
