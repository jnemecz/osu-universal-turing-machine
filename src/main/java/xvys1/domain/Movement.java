package xvys1.domain;

/**
 * Definuje smer pohybu hlavy na pasce.
 * 
 * @author jirka
 * 
 */
public enum Movement {

	LEFT("0", -1), STAND("00", 0), RIGHT("000", +1);

	private final String code;
	private final int tapePositionChange;

	private Movement(String code, int tapePositionChange) {
		this.code = code;
		this.tapePositionChange = tapePositionChange;
	}

	public String getCode() {
		return code;
	}

	public int getTapePositionChange() {
		return tapePositionChange;
	}

	@Override
	public String toString() {
		return "Movement [name=" + this.name() + ", code=" + code
				+ ", tapePositionChange=" + tapePositionChange + "]";

	}

	public static Movement getByCode(String code) {

		if (code == null) {
			throw new IllegalArgumentException("Code cannot be null.");
		}

		code = code.trim();

		if (code.isEmpty() == true) {
			throw new IllegalArgumentException("Code cannot be empty.");
		} else if (code.equals("0")) {
			return Movement.LEFT;
		} else if (code.equals("00")) {
			return Movement.STAND;
		} else if (code.equals("000")) {
			return Movement.RIGHT;
		} else {
			throw new IllegalArgumentException("Unsupported movement code - "
					+ code + ".");
		}
	}

}
