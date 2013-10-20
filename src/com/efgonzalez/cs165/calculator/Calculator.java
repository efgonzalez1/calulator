package com.efgonzalez.cs165.calculator;

import java.util.ArrayList;

public class Calculator {
	private StringBuilder display = new StringBuilder();
	private char operator = ' ';
	private int operandA, operandB;
	private ArrayList<BtnPressedListener> btnPressedListeners = new ArrayList<BtnPressedListener>();

	public void doMath(char operator, int operandA, int operandB) {
		// Switch on operator, perform correct math, update display
		int value;
		switch (operator) {
		case '+':
			value = (operandA + operandB);
			setDisplay(value);
			break;
		case '-':
			value = (operandA - operandB);
			setDisplay(value);
			break;
		case '×':
			value = (operandA * operandB);
			setDisplay(value);
			break;
		case '÷':
			value = (operandA / operandB);
			setDisplay(value);
			break;
		}
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public StringBuilder getDisplay() {
		return display;
	}

	public void setDisplay(String d) {
		display.delete(0, display.capacity());
		display.append(d);
		fireBtnPressed();
	}

	public void setDisplay(int d) {
		display.delete(0, display.capacity());
		display.append(d);
		fireBtnPressed();
	}

	public int getOperandA() {
		return operandA;
	}

	public void setOperandA(int operandA) {
		this.operandA = operandA;
	}

	public int getOperandB() {
		return operandB;
	}

	public void setOperandB(int operandB) {
		this.operandB = operandB;
	}

	public void addBtnPressedListener(BtnPressedListener listener) {
		btnPressedListeners.add(listener);
	}

	public void removeBtnPressedListener(BtnPressedListener listener) {
		btnPressedListeners.remove(listener);
	}

	private void fireBtnPressed() {
		for (int i = 0; i < btnPressedListeners.size(); i++) {
			BtnPressedListener listener = (BtnPressedListener) btnPressedListeners
					.get(i);
			listener.btnPressed(this);
		}
	}

	public void updateUI(int operand) {
		// Called when user presses numbers
		// If user previously pressed Enter(=), display new calculation 
		if (getOperator() != '=') {
			getDisplay().append(operand);
			fireBtnPressed();
		} else {
			// Else, append entries to current calculation
			setDisplay(operand);
			setOperator(' ');
			fireBtnPressed();
		}
	}

	public void updateUI(char operator) {
		// If user presses Enter(=), update the current operator
		if (operator == '=') {
			setOperator(operator);
		} else if (getOperator() == ' ') {
			// If the user presses an operator for the first time...
			// Set the current operator to the one that they pressed and append it to the calculation
			setOperator(operator);
			getDisplay().append(operator);
			fireBtnPressed();
		} else {
			// Catch errors when user tries to..
			// A) Compute incomplete calculation such as "3x<Enter>", "5<Enter>", etc
			// B) Divide by 0
			// This is necessary to keep app from crashing and to properly run execute, undo, and log commands 
			compute();
			setOperator(operator);
			getDisplay().append(operator);
			fireBtnPressed();
		}
	}

	public void compute() {
		// Parse and compute calculation as though user pressed Enter(=)
		String operands[] = getDisplay().toString().split("\\D");
		try {
			setOperandA(Integer.parseInt(operands[0]));
		} catch (NumberFormatException e) {
			setOperandA(0);
		}
		try {
			setOperandB(Integer.parseInt(operands[1]));
		} catch (NumberFormatException e) {
			setOperandB(0);
			setOperator('+');
		} catch (IndexOutOfBoundsException e) {
			setOperandB(0);
			setOperator('+');
		}
		try {
			doMath(getOperator(), getOperandA(), getOperandB());
		} catch (ArithmeticException e) {
			setDisplay("DIVIDE BY 0 ERROR");
		}
		setOperator('=');
	}

}
