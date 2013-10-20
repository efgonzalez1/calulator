package com.efgonzalez.cs165.calculator;

public class ComputeCommand implements Command {
	public Calculator c;
	private String display;

	public ComputeCommand(Calculator c) {
		this.c = c;
	}

	@Override
	public void execute() {
		// Save current calculation and execute command
		display = c.getDisplay().toString();
		c.compute();
	}

	@Override
	public void undo() {
		c.setDisplay(display);
		// Set correct operator if one is found
		if (findOperatorNdx() != -1)
			c.setOperator(display.charAt(findOperatorNdx()));
		else {
			c.setOperator(' ');
		}
	}

	private int findOperatorNdx() {
		// Search through calculation string for an operator
		int ndx = display.indexOf('+');
		if (ndx == -1) {
			ndx = display.indexOf('-');
		}
		if (ndx == -1) {
			ndx = display.indexOf('×');
		}
		if (ndx == -1) {
			ndx = display.indexOf('÷');
		}
		return ndx;
	}

	public String log(int key) {
		// Output log messages for specific actions
		switch (key) {
		case 1:
			return "Computed:   " + display.toString() + " = " + c.getDisplay().toString();
		case 2:
			return "Undo:   " + display.toString();
		default:
			return "Error:   Log write failure";
		}
	}

}
