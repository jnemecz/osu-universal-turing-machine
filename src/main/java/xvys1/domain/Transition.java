package xvys1.domain;

import xvys1.App;

public class Transition {

	private State inputState;
	private char inputSymbol;
	private State newState;
	private char newSymbol;
	private Movement movement;

	public State getInputState() {
		return inputState;
	}

	public void setInputState(State inputState) {
		this.inputState = inputState;
	}

	public char getInputSymbol() {
		return inputSymbol;
	}

	public void setInputSymbol(char inputSymbol) {
		this.inputSymbol = inputSymbol;
	}

	public State getNewState() {
		return newState;
	}

	public void setNewState(State newState) {
		this.newState = newState;
	}

	public char getNewSymbol() {
		return newSymbol;
	}

	public void setNewSymbol(char newSymbol) {
		this.newSymbol = newSymbol;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	@Override
	public String toString() {
		return "δ(" + this.getInputState() + "," + this.getInputSymbol() + ") = (" + this.getNewState() + ","
				+ this.getNewSymbol() + "," + this.getMovement().name() + ")";

	}

	public static Transition createFromData(String data) {

		Transition trans = new Transition();
		String[] dataSplitted = data.split(App.DELIM);
		trans.setInputState(new State(dataSplitted[0]));
		trans.setInputSymbol(dataSplitted[1].charAt(0));
		trans.setNewState(new State(dataSplitted[2]));
		trans.setNewSymbol(dataSplitted[3].charAt(0));
		trans.setMovement(Movement.getByCode(dataSplitted[4]));

		return trans;

	}

}
