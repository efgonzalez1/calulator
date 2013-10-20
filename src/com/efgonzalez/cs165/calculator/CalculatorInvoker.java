package com.efgonzalez.cs165.calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class CalculatorInvoker {

	private Calculator c;
	private Stack<Command> undoStack = new Stack<Command>();
	private ArrayList<String> rawLog = new ArrayList<String>();
	private SaveLogStrategy strategy;

	public CalculatorInvoker(Calculator c) {
		this.c = c;
	}

	public void setStrategy(SaveLogStrategy strategy) {
		this.strategy = strategy;
	}

	public void saveLog() {
		strategy.save(rawLog);
	}

	public void undo() {
		try {
			// Get most recent command from stack and execute undo
			Command command = undoStack.pop();
			command.undo();
			// Add undo command to log
			rawLog.add(command.log(Command.UNDO_KEY));
		} catch (EmptyStackException e) {
			// Handle empty undo list
			c.setOperator(' ');
			c.setDisplay("NOTHING TO UNDO");
			// Add error message to log
			rawLog.add("Undo:   " + c.getDisplay());
		}
	}

	public void updateOperator(char operator) {
		// Create command and execute it
		Command command = new OperatorCommand(c, operator);
		command.execute();
		// Add command to undo list
		undoStack.push(command);
		// Add command to log
		rawLog.add(command.log(Command.EXECUTE_KEY));
	}

	public void updateOperand(int operand) {
		// Create command and execute it
		Command command = new NumCommand(c, operand);
		command.execute();
		// Add command to undo list
		undoStack.push(command);
		// Add command to log
		rawLog.add(command.log(Command.EXECUTE_KEY));
	}

	public void compute() {
		// Create command and execute it
		Command command = new ComputeCommand(c);
		command.execute();
		// Add command to undo list
		undoStack.push(command);
		// Add command to log
		rawLog.add(command.log(Command.EXECUTE_KEY));
	}
}
