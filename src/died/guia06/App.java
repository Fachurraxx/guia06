package died.guia06;

import died.guia06.util.Registro;

public class App {

	public static void main(String[] args) {
		
		Registro registro = new Registro();
		
		Curso curso1 = new Curso(001, "Died", 2020, 5,100,0);
		Curso curso2 = new Curso(000, "Paradigmas", 2019,30,50,0);
		Curso curso3 = new Curso(002, "Analisis", 2018,60,200,0);
		Curso curso4 = new Curso(003, "Fisica", 2018,60,200,0);
		Alumno alumno = new Alumno("Ramiro",24690);
		Alumno alumno2 = new Alumno("Jose", 23234);
		Alumno alumno3 = new Alumno("Martin", 20764);
		Alumno alumno4 = new Alumno("Alvaro", 29764);

		try{
		
		curso3.inscribirAlumno(alumno2);
		curso3.inscribirAlumno(alumno3);
		curso3.inscribirAlumno(alumno4);
		
		curso2.inscribirAlumno(alumno);
		curso1.inscribirAlumno(alumno);
		curso4.inscribirAlumno(alumno);
		curso3.inscribirAlumno(alumno);
		
		}catch(CursoException e) {
			System.out.println(e.getMessage());
		}
		
		curso3.imprimirInscriptosAlfabeticamente();
		curso3.imprimirInscriptosCreditos();
		curso3.imprimirInscriptosNroLibreta();
		
		
		alumno3.aprobar(curso3);
		curso3.imprimirInscriptosAlfabeticamente();
		
		System.out.println("Creditos obtenidos:" + alumno3.creditosObtenidos());
		
	}
}
