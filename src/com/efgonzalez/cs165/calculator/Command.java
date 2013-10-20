package com.efgonzalez.cs165.calculator;

public interface Command {
public void execute();
public void undo();
public String log(int key);
public static final int EXECUTE_KEY = 1;
public static final int UNDO_KEY = 2;
}
