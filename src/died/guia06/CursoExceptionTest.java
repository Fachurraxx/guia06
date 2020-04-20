package died.guia06;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class CursoExceptionTest extends TestCase {

	private Alumno alumno;
	private Alumno alumno2;
	private Curso c;
	private Curso c2;
	private Curso c3;
	//private Curso c4;
	//private Curso c5;
	
	public void inicializar() {
		alumno = new Alumno("Ramiro",24690);
		alumno2 = new Alumno("Jose", 67234);
		c = new Curso(30,20,0);
		c2 = new Curso(30,20,10);
		c3 = new Curso(1,20,0);
	//	c4 = new Curso(30,20,0);
		//c5 = new Curso(30,20,0);
	}
	@Test
	public void testNoCupo() {
			inicializar();
			c3.inscribirAlumno(alumno);
			c3.inscribirAlumno(alumno2);
		
		
		
	}
	/*public void testNoCreditosNecesarios() {
		inicializar();
		c.inscribirAlumno(alumno);
		c2.inscribirAlumno(alumno2);
}
}

