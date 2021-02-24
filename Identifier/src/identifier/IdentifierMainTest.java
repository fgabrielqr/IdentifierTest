package identifier;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IdentifierMainTest {
	
	static private ByteArrayOutputStream baOut;
	static private PrintStream psOut;
	
	public IdentifierMainTest() {
		
	}
	
	@BeforeAll
	public static void setUpClass() {
		baOut = new ByteArrayOutputStream();
		psOut = new PrintStream(baOut);
		System.setOut(psOut);
	}
	
	@AfterAll
	public static void tearDownClass() {
		psOut.close();
	}
	
	@BeforeEach
	public void setUp() {
		baOut.reset();
	}
	
	@AfterEach
	public void tearDown() {
		
	}
	
	//testa o caso de nenhum caracteres 
	@Test
	public void testeValido00() {
		IdentifierMain.main(new String [] {""});
		String output = baOut.toString();
		
		assertEquals("Inválido", output);
	}
	
	//testa se o indentifcador é válido com os caracteres informado	
	//caso for adicionado caracteres a mais ele retornará inválido	
	@Test
	public void testeValido01() {
		IdentifierMain.main(new String [] {"a1"});
		String output = baOut.toString();
		
		assertEquals("Válido", output);
	}
	
	//testa se o indentifcador é inválido com os caractéres informado	
	@Test
	public void testeInvalido02() {
		IdentifierMain.main(new String [] {"2b3"});
		String output = baOut.toString();
		
		assertEquals("Inválido", output);
	}
	
	//testa se o indentifcador é inválido com os caractéres informado	
	@Test
	public void testeInvalido03() {
		IdentifierMain.main(new String [] {"z-12"});
		String output = baOut.toString();
		
		assertEquals("Inválido", output);
	}
	
	//testa se o indentifcador é inválido com os caractéres informado	
	@Test
	public void testeInvalido04() {
		IdentifierMain.main(new String [] {"a1b2c3d"});
		String output = baOut.toString();
		
		assertEquals("Inválido", output);
	}

}
