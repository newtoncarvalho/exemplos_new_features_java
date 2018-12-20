package br.com.java8;

import java.util.LinkedHashMap;
import java.util.Map;

public class TesteFreq {
	public static void main(String[] args) {
		int number = 1808200288;
		System.out.println(getTheMostFrequentDigit(number));
	}
	
	public static int getTheMostFrequentDigit(int number) {

		System.out.println("number: " + number);
		
		Map<Integer, Integer> mapDigitVsFrequency = new LinkedHashMap<>();
		
		int maxFreq = -1;
		int maxFreqDigit = -1;
		
		while (true) {			
			int result = number / 10;
			int resto = number % 10;
			
//			System.out.println("result: " + result);
//			System.out.println("resto : " + resto);			
			
			number = result;
			
			Integer count = mapDigitVsFrequency.get(resto);
			
			if (count == null)
				count = 0;
			
			count += 1;
			mapDigitVsFrequency.put(resto, count);
			
			if (count > maxFreq) {
				maxFreq = count;
				maxFreqDigit = resto;
			}
			
			System.out.println("number: " + number);
			
			if (number == 0)
				break;
		}
				
		System.out.println(mapDigitVsFrequency);
		
		return maxFreqDigit;
	}
}
