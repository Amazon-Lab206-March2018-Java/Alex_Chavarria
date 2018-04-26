package com.avvarga;

@SuppressWarnings ("serial")
public class Calculator implements java.io.Serializable {
	
	private double operandOne;
	private double operandTwo;
	private char operation;
	private double results = 0.00;
	
	public void performOperation () {
		if (operation == '+') {
			results = operandOne + operandTwo;
		}
		else if (operation == '-') {
			results = operandOne - operandTwo;
		}
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	public double getResults() {
		return results;
	}
	
	
}
