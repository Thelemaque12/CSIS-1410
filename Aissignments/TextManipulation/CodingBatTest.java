package codingBat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CodingBatTest {
	codingBat cb = new codingBat();
	
	   @Test
	   void wordEndsTest_c13i() {
	       String output = cb.wordEnds("abcXY123XYijk", "XY");
	       assertEquals("c13i", output);
	   }
	  
	   @Test
	   void wordEndsTest_13() {
	       String output = cb.wordEnds("XY123XY", "XY");
	       assertEquals("13", output);
	   }
	  
	   @Test
	   void wordEndsTest_11_1() {
	       String output = cb.wordEnds("XY1XY", "XY");
	       assertEquals("11", output);
	   }
	  
	   @Test
	   void wordEndsTest_XY() {
	       String output = cb.wordEnds("XYXY", "XY");
	       assertEquals("XY", output);
	   }
	  
	   @Test
	   void wordEndsTest_EmpyString1() {
	       String output = cb.wordEnds("XY", "XY");
	       assertEquals("", output);
	   }
	  
	   @Test
	   void wordEndsTest_EmptyString2() {
	       String output = cb.wordEnds("Hi", "XY");
	       assertEquals("", output);
	   }
	  
	   @Test
	   void wordEndsTest_EmptyString3() {
	       String output = cb.wordEnds("", "XY");
	       assertEquals("", output);
	   }
	  
	   @Test
	   void wordEndsTest_cxziij() {
	       String output = cb.wordEnds("abc1xyz1i1j", "1");
	       assertEquals("cxziij", output);
	   }
	  
	   @Test
	   void wordEndsTest_cxz() {
	       String output = cb.wordEnds("abc1xyz1", "1");
	       assertEquals("cxz", output);
	   }
	  
	   @Test
	   void wordEndsTest_cxz11() {
	       String output = cb.wordEnds("abc1xyz11", "1");
	       assertEquals("cxz11", output);
	   }
	  
	   @Test
	   void wordEndsTest_11() {
	       String output = cb.wordEnds("abc1xyz1abc", "abc");
	       assertEquals("11", output);
	   }
	  
	   @Test
	   void wordEndsTest_acac() {
	       String output = cb.wordEnds("abc1xyz1abc", "b");
	       assertEquals("acac", output);
	   }
	  
	   @Test
	   void wordEndsTest_1111() {
	       String output = cb.wordEnds("abc1abc1abc", "abc");
	       assertEquals("1111", output);
	   }

}
