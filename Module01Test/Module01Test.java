package m01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUnit class for Module01 Test
 * @author Jefson S
 *
 */

class Module01Test {

	@Test
	void challenge1_emptyString() {
		String expected = "[]"; 
		String output = Module01.challenge1("");
		assertEquals(expected, output);
	}
	
	@Test
	void challenge1_hashtagSymbol() {
		String expected = "[#]"; 
		String output = Module01.challenge1("#");
		assertEquals(expected, output);
	}
	
	@Test
	void challenge1_capitalLetter() {
		String expected = "[a]"; 
		String output = Module01.challenge1("A");
		assertEquals(expected, output);
	}
	
	@Test
	void challenge1_threeLetters() {
		String expected = "[yzx]"; 
		String output = Module01.challenge1("xyz");
		assertEquals(expected, output);
	}
	
	@Test
	void challenge1_capitalLetterAndPlusSymbols() {
		String expected = "[++c]"; 
		String output = Module01.challenge1("C++");
		assertEquals(expected, output);
	}
	
	@Test
	void challenge1_multipleLetters() {
		String expected = "bcdea"; 
		String output = Module01.challenge1("abcde");
		assertEquals(expected, output);
	}
	
	@Test
	void challenge1_multipleLettersPlusCapitalLetters() {
		String expected = "o ho ho!h"; 
		String output = Module01.challenge1("Ho Ho Ho!");
		assertEquals(expected, output);
	}

	@Test 
	void challenge2_emptyArray() {
		String expected = "(0)";
		int[] array1 = {};
		String output = Module01.challenge2(array1);
		assertEquals(expected, output);
	}

	@Test 
	void challenge2_multipleDigitsNumbers() {
		String expected = "(0)";
		int[] array2 = {10,250};
		String output = Module01.challenge2(array2);
		assertEquals(expected, output);
	}
	
	@Test 
	void challenge2_singleDigits() {
		String expected = "5-(1)";
		int[] array3 = {5};
		String output = Module01.challenge2(array3);
		assertEquals(expected, output);
	}
	
	@Test 
	void challenge2_singleDigitsDoulbeDigitNegativeNumber() {
		String expected = "5-(1)";
		int[] array4 = {-10,5,10};
		String output = Module01.challenge2(array4);
		assertEquals(expected, output);
	}
	
	@Test 
	void challenge2_singleDigitsDoulbeDigits() {
		String expected = "2-4-6-8-(4)";
		int[] array5 = {111, 2, 333, 4, 6, 555, 8, 777};
		String output = Module01.challenge2(array5);
		assertEquals(expected, output);
	}
	
	@Test 
	void challenge2_singleDigitsDoulbeDigitsNegativeNumbers2() {
		String expected = "1-3-4-(3)";
		int[] array6 = {1, -1, 22, -22, 3, -3, 4, -4};
		String output = Module01.challenge2(array6);
		assertEquals(expected, output);
	}
		
	@Test 
	void challenge2_null() {
		assertEquals(null, Module01.challenge2(null));
	}
}
