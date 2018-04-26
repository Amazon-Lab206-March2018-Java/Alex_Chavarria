package com.avvarga;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator calc = new Calculator ();
		
		calc.setOperandOne(10.5);
		calc.setOperation('+');
		calc.setOperandTwo(5.2);
		calc.performOperation();
		System.out.println(calc.getResults());
	}
}
