package com.efgonzalez.cs165.calculator;

public class OperatorCommand implements Command {
	public Calculator c;
	public char operator;
	private String display;

	public OperatorCommand(Calculator c, char operator) {
		this.c = c;
		this.operator = operator;
	}

	@Override
	public void execute() {
		// Save current calculation and execute command
		display = c.getDisplay().toString();
		c.updateUI(operator);
	}

	@Override
	public void undo() {
		// Set display with previously saved calculation and reset operator
		c.setDisplay(display);
		c.setOperator(' ');
	}

	@Override
	public String log(int key) {
		// Output log messages for specific actions
		switch (key) {
		case 1:
			return "User Entered:   " + c.getDisplay().toString().charAt(c.getDisplay().length()-1);
		case 2:
			return "Undo:   " + display.toString();
		default:
			return "Error:   Log write failure";
		}
	}

}
