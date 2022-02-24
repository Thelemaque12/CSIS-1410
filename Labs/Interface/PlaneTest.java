package labInterface;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * JUnit Test to test class Plane
 * @author Jefson S
 *
 */
class PlaneTest {
	private static ByteArrayOutputStream message;
	private static PrintStream consoleOutput;
	private Plane plane = new Plane(2, "A320");
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		consoleOutput = System.out;
		message = new ByteArrayOutputStream();
		
		PrintStream newOuput = new PrintStream(message);
		System.setOut(newOuput);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.setOut(consoleOutput);
	}

	@Test
	void A320_With2Engines() {
		assertEquals("A320 with 2 engines", plane.toString());
		message.reset();
	}

	@Test
	void launch_validatedPrintMessage() {
		plane.launch();
		String expected = "Rolling until take-off" + System.lineSeparator();
		String actual = message.toString();
		assertEquals(expected, actual);
		
		message.reset();
	}

	@Test
	void land_ValidatedPrintedMessage() {
		plane.land();
		String expected = "Rolling to a stop" + System.lineSeparator();
		String actual = message.toString();
		assertEquals(expected, actual);
		
		message.reset();
	}

}
