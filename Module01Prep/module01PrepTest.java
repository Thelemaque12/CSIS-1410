package m01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class module01PrepTest {

	@Test
	void challenge1_multipleNumbers() {
		int[] array4 = {2,4,6,8};
		String expected = "*8*6*4*2*";
		String actual = module01Prep.challenge1(array4);
		assertEquals(expected, actual);
	}
	
	@Test
	void challenge1_oneNumber() {
		int[] array1 = {5};
		String expected = "*5*";
		String actual = module01Prep.challenge1(array1);
		assertEquals(expected, actual);
	}
	
	@Test
	void challenge1_emptyArray() {
		int[] emptyArray = {};
		String expected = "";
		String actual = module01Prep.challenge1(emptyArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void challenge1_multipleDigits() {
		int[] array = {20,10};
		String expected = "*10*20*";
		String actual = module01Prep.challenge1(array);
		assertEquals(expected, actual);
	}
	
	@Test
	void challenge1_null() {
		//String actual = module01Prep.challenge1(emptyArray);
		assertEquals(null, module01Prep.challenge1(null));
	}

}
