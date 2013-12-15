package xvys1;

import java.nio.charset.Charset;

import xvys1.domain.TuringMachine;
import xvys1.tools.Tools;

public class App {

	// Data separators
	public static final String DELIM = "\\${1}";
	public static final String DELIM_PARTS = "\\${3}";
	public static final String DELIM_SUBPARTS = "\\${2}";

	public static void main(String[] args) {

		// Read TM
		String tmData = Tools.readFile(args[0], Charset.defaultCharset());

		// Create TM
		TuringMachine machine = TuringMachine.fromString(tmData);

		System.out.println(machine);

		System.out.println("Input data: " + machine.getTape().getTape() + "\n------------------");
		
		while (machine.isDone() == false) {
			System.out.println("Before: " + machine.getStatus());
			machine.process();
			System.out.println("After: " + machine.getStatus());
			System.out.println("-----------------------");
		}

		System.out.println("DONE! Output data = " + machine.getTape().getTape());

	}
}
