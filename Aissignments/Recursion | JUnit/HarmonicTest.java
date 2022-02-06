package recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HarmonicTest {

private final double DELTA = 1e-9;

	@Test
	void harmonic_postiveNumber_5() {
		double answer = 1 + 1/2.0 + 1/3.0 + 1/4.0 + 1/5.0;
	    assertEquals(answer, Recursion.harmonic(5), DELTA);
	}
	
	@Test
	void harmonic_postiveNumber_4() {
		 double answer = 1 + 1/2.0 + 1/3.0 + 1/4.0;
		 assertEquals(answer, Recursion.harmonic(4), DELTA);
	}
	
	@Test
	void harmonic_postiveNumber_3() {
		 double answer = 1 + 1/2.0 + 1/3.0;
		 assertEquals(answer, Recursion.harmonic(3), DELTA);
	}
	
	@Test
	void harmonic_negativeNumber_5() {
		double answer = 1 + 1/2.0 + 1/3.0 + 1/4.0 + 1/5.0;
	        	answer *= -1;
	    assertEquals(answer, Recursion.harmonic(-5), DELTA);
	}
	
	@Test
	void harmonic_negativeNumber_4() {
		double answer = 1 + 1/2.0 + 1/3.0 + 1/4.0;
	        	answer *= -1;
	    assertEquals(answer, Recursion.harmonic(-4), DELTA);
	}

}
