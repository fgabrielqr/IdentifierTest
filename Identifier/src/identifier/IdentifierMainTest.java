package identifier;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class IdentifierMainTest {
	
	static private ByteArrayOutputStream boOut;
	static private PrintStream psOut;
	
	@BeforeClass
	public static void beforeClassInit() {
		boOut = new ByteArrayOutputStream();
		psOut = new PrintStream(boOut);
		System.setOut(psOut);
	}
	
	@AfterClass
	public static void afterClassFinalize() {
		psOut.close();
	}
	
	@Before
	public void setUp() {
		boOut.reset();
	}
	
	//testa se o indentifcador � v�lido com os caract�res informado	
	@Test
	public void testeValido01() {
		IdentifierMain.main(new String [] {"a1"});
		String output = boOut.toString();
		
		assertEquals("V�lido", output);
	}
	
	//testa se o indentifcador � inv�lido com os caract�res informado	
	@Test
	public void testeInvalido02() {
		IdentifierMain.main(new String [] {"2b3"});
		String output = boOut.toString();
		
		assertEquals("Inv�lido", output);
	}
	
	//testa se o indentifcador � inv�lido com os caract�res informado	
	@Test
	public void testeInvalido03() {
		IdentifierMain.main(new String [] {"z-12"});
		String output = boOut.toString();
		
		assertEquals("Inv�lido", output);
	}
	
	//testa se o indentifcador � inv�lido com os caract�res informado	
	@Test
	public void testeInvalido04() {
		IdentifierMain.main(new String [] {"a1b2c3d"});
		String output = boOut.toString();
		
		assertEquals("Inv�lido", output);
	}

}
