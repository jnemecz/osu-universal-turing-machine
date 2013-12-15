package xvys1.domain;

/**
 * Stav ve stavovem prostoru TS.
 * 
 * @author jirka
 */
public class State {

	private final String code;

	public State(String code) {
		boolean validated = false;
		if (code != null && code.trim().isEmpty() == false) {
			validated = code.matches("^[0]{1,}$");
		}
		if (validated == false) {
			throw new IllegalArgumentException("Code is not acceptable: " + code);
		}
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "q" + this.code.length();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
