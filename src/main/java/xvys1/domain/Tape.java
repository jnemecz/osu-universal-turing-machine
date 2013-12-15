package xvys1.domain;

public class Tape {

	private String tape;
	private final String originalTape;
	private int position = 0;

	public Tape(String tape) {
		tape = '#' + tape + '#';
		this.tape = tape;
		this.originalTape = new String(tape);
	}

	public void writeAndMove(char c, Movement movement) {
		write(c);
		this.position += movement.getTapePositionChange();
	}

	public String getTape() {
		return tape;
	}

	private void write(char newValue) {
		StringBuilder tmpTape = new StringBuilder(this.tape);
		tmpTape.setCharAt(this.position, newValue);
		this.tape = tmpTape.toString();
	}

	public char read() {
		return this.read(position);
	}

	public char read(int index) {
		return this.tape.charAt(index);
	}

	@Override
	public String toString() {
		return "Tape [originalTape = " + originalTape + ", tape=" + tape + ", position=" + position + "]";
	}

}
