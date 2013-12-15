package xvys1.tools;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Tools {

	public static String readFile(String path, Charset encoding) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(path));
			return encoding.decode(ByteBuffer.wrap(encoded)).toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static String implodeArrayList(ArrayList<?> ar, String glue) {
		String acceptingStates = ar.get(0).toString();
		for (int i = 1; i < ar.size(); i++) {
			acceptingStates += "," + ar.get(i).toString();
		}
		return acceptingStates;
	}

	public static ArrayList<String> splitMainParts(String ts, String delimeter) {

		ArrayList<String> parts = new ArrayList<String>();

		String[] splitted = ts.split(delimeter);

		for (int i = 0; i < splitted.length; i++) {
			parts.add(splitted[i].trim());
		}

		return parts;

	}

}
