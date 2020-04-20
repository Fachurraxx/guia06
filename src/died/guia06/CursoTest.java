package died.guia06;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class CursoTest extends TestCase{
	
	private Alumno alumno;
	private Alumno alumno2;
	private Curso c;
	private Curso c2;
	private Curso c3;
	private Curso c4;
	private Curso c5;
	
	public void inicializar() {
		alumno = new Alumno("Ramiro",24690);
		alumno2 = new Alumno("Jose", 67234);
		c = new Curso(30,20,0);
		c2 = new Curso(30,20,10);
		c3 = new Curso(1,20,0);
		c4 = new Curso(30,20,0);
		c5 = new Curso(30,20,0);
	}
	@Test
	public void testNoCupo() {
		inicializar();
		assertTrue(c3.inscribir(alumno));
		assertFalse(c3.inscribir(alumno2));
		
	}
	@Test
	public void testNoCreditosNecesarios() {
		inicializar();
		assertTrue(c.inscribir(alumno));
		assertFalse(c2.inscribir(alumno2));
	}
	@Test
	public void testAlumnoYaInscripto() {
		inicializar();
		assertTrue(c.inscribir(alumno));
		assertFalse(c.inscribir(alumno));
	}
	@Test
	public void testAlumnoSinCupo() {
		inicializar();
		assertTrue(c.inscribir(alumno));
		assertTrue(c3.inscribir(alumno));
		assertTrue(c4.inscribir(alumno));
		assertFalse(c5.inscribir(alumno));
	
		
	}
	
	
}
