package com.efgonzalez.cs165.calculator;

public class NumCommand implements Command {
	Calculator c;
	private int operand;
	private String display;

	public NumCommand(Calculator c, int operand) {
		this.c = c;
		this.operand = operand;
	}

	@Override
	public void execute() {
		// Save current calculation and execute command
		display = c.getDisplay().toString();
		c.updateUI(operand);
	}

	@Override
	public void undo() {
		// Set display with previously saved calculation
		c.setDisplay(display);
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
