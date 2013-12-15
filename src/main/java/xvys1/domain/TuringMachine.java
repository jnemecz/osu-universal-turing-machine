package xvys1.domain;

import java.util.ArrayList;

import xvys1.App;
import xvys1.tools.Tools;

public class TuringMachine {

	private State initialState;
	private ArrayList<State> acceptingStates;
	private ArrayList<Transition> transitions;
	private State actualState;
	private Tape tape;
	private boolean errorState = false;
	private boolean isDone = false;

	public Tape getTape() {
		return tape;
	}

	public void setTape(Tape tape) {
		this.tape = tape;
	}

	public State getActualState() {
		return actualState;
	}

	public boolean isErrorState() {
		return errorState;
	}

	public State getInitialState() {
		return initialState;
	}

	public void process() {
		process(tape.read());
	}

	public void process(char inputSymbol) {

		if (this.isDone == true) {
			throw new IllegalStateException("This machine is some of its final states.");
		} else if (this.isErrorState() == true) {
			throw new IllegalStateException("This machine is in an error state and cannot continue.");
		}

		boolean transitionFunctionFound = false;

		for (Transition transition : transitions) {

			if (transition.getInputState().equals(actualState)) {

				if (inputSymbol == transition.getInputSymbol()) {

					System.out.println("Input symbol: " + inputSymbol + ", using transition function = " + transition);

					tape.writeAndMove(transition.getNewSymbol(), transition.getMovement());

					actualState = transition.getNewState();
					transitionFunctionFound = true;
					break;

				}

			}

		}

		if (acceptingStates.contains(this.actualState) == true) {
			this.isDone = true;
		} else if (transitionFunctionFound == false) {
			this.errorState = true;
		}

	}

	public void setInitialState(State initialState) {
		this.actualState = this.initialState = initialState;
	}

	public ArrayList<State> getAcceptingStates() {
		return acceptingStates;
	}

	public void setAcceptingStates(ArrayList<State> acceptingStates) {
		this.acceptingStates = acceptingStates;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}

	public String getStatus() {
		return "actualState = " + actualState + ", tape = " + tape.getTape();
	}

	@Override
	public String toString() {

		StringBuilder trans = new StringBuilder();

		ArrayList<String> states = new ArrayList<String>();
		ArrayList<String> abInput = new ArrayList<String>();
		ArrayList<String> abOut = new ArrayList<String>();

		for (Transition t : getTransitions()) {

			String is = String.valueOf(t.getInputSymbol());
			String os = String.valueOf(t.getNewSymbol());

			if (states.contains(t.getInputState().toString()) == false) {
				states.add(t.getInputState().toString());
			}

			if (states.contains(t.getNewState().toString()) == false) {
				states.add(t.getNewState().toString());
			}

			if (abInput.contains(is) == false) {
				abInput.add(is);
			}

			if (abOut.contains(os) == false) {
				abOut.add(os);
			}

		}
		
		trans.append("Konfigurace Turingova stroje\n----------------------------\n");

		trans.append("M = ({" + Tools.implodeArrayList(states, ",") + "},{" + Tools.implodeArrayList(abInput, ",")
				+ "},{" + Tools.implodeArrayList(abOut, ",") + "},δ," + this.getInitialState() + ",{"
				+ Tools.implodeArrayList(getAcceptingStates(), ",") + "})");

		trans.append("\n\nPřechodové funkce δ:\n--------------------\n");

		for (Transition tran : transitions) {
			trans.append(tran.toString()).append("\n");
		}

		return trans.toString();

	}

	public boolean isDone() {
		return isDone;
	}

	public static TuringMachine fromString(String ts) {

		ArrayList<String> parts = Tools.splitMainParts(ts, App.DELIM_PARTS);

		// Vstupni stav
		State initialState = new State(parts.get(0));

		// Vystupni stavy
		String[] arra = parts.get(1).split(App.DELIM_SUBPARTS);
		ArrayList<State> acceptingStates = new ArrayList<State>();

		for (int i = 0; i < arra.length; i++) {
			acceptingStates.add(new State(arra[i]));
		}

		// Transition functions
		ArrayList<String> transitionsData = Tools.splitMainParts(parts.get(2), App.DELIM_SUBPARTS);
		ArrayList<Transition> transitions = new ArrayList<Transition>();

		for (int i = 0; i < transitionsData.size(); i++) {
			try {
				transitions.add(Transition.createFromData(transitionsData.get(i)));
			} catch (Exception e) {
				System.out.println(e.getMessage() + ", data = " + transitionsData.get(i));
				e.printStackTrace();

			}
		}

		// Turinguv stroj
		TuringMachine machine = new TuringMachine();
		machine.setAcceptingStates(acceptingStates);
		machine.setInitialState(initialState);
		machine.setTransitions(transitions);
		machine.setTape(new Tape(parts.get(parts.size() - 1)));

		return machine;

	}

}
