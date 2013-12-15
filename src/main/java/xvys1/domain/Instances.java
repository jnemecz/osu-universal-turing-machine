package xvys1.domain;

public class Instances {

	public static TuringMachine tmSorting(String data) {
		throw new RuntimeException("Now implemented yet!");
	}

	public static TuringMachine tmIncrement(String data) {

		StringBuilder tsSB = new StringBuilder();
		tsSB.append("0").append("$$$");
		tsSB.append("00000").append("$$$");
		tsSB.append("0$#$0$#$000$$");
		tsSB.append("0$0$00$0$000$$");
		tsSB.append("0$1$00$1$000$$");
		tsSB.append("00$#$000$#$0$$");
		tsSB.append("00$0$00$0$000$$");
		tsSB.append("00$1$00$1$000$$");
		tsSB.append("000$#$0000$1$000$$");
		tsSB.append("000$0$0000$1$000$$");
		tsSB.append("000$1$000$0$0$$");
		tsSB.append("0000$#$00000$#$00$$");
		tsSB.append("0000$0$0000$0$000$$");
		tsSB.append("0000$1$000$1$000");
		tsSB.append("$$$");
		tsSB.append(data);
		
		System.out.println(tsSB.toString());

		return TuringMachine.fromString(tsSB.toString());

	}

}
