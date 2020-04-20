package died.guia06;
import junit.framework.TestCase;

public class AlumnoTest extends TestCase{
	
	private Alumno alumno;
	private Curso c;
	
	public void inicializar() {
		alumno = new Alumno("Ramiro",24690);
		c = new Curso(30,20,0);
		
	}
	
	public void testNoNulo() {
		inicializar();
		assertNotNull(alumno);
		assertNotNull(c);
		
		
	}
	
	public void testAprobarCurso() {
		inicializar();
		assertTrue(c.inscribir(alumno));
		assertTrue(alumno.getCursando().size() == 1);
		assertTrue(alumno.getAprobados().size() == 0);
		alumno.aprobar(c);
		assertTrue(alumno.getAprobados().size() == 1);
		assertTrue(alumno.getCursando().size() == 0);
	}
	
	public void testSumaCreditos() {
		inicializar();
		c.inscribir(alumno);
		alumno.aprobar(c);
		assertTrue(alumno.creditosObtenidos()>0);
		assertTrue(alumno.creditosObtenidos()==c.getCreditos());
		
	}

}
