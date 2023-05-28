package com.initialproject.converters;

public class NumberConverter {
	

	public static boolean isANumber(String strNumber) {
		
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public static Double toDouble(String strNumber) {
		
		return Double.valueOf(strNumber);
	}

}
