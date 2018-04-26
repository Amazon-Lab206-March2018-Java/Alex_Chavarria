package com.avvarga;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy ("S9",99,"Verizon","Ring Ring Ring!");
		IPhone iPhoneTen = new IPhone ("X",100,"AT&T","Zing");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		iPhoneTen.displayInfo();
		System.out.println(iPhoneTen.ring());
		System.out.println(iPhoneTen.unlock());
	}
}
