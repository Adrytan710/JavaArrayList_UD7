package Ejercicios;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

//@author Adrián Rodriguez

public class Ej1NotaMediaApp {

	public static void main(String[] args) {
		
		crearTabla();
		
	}

	public static void notas(Hashtable<String, Integer> notas) {
		int examen1[] = new int[notas.size()];
		int examen2[] = new int[notas.size()];
		int index = 0;
		
		Enumeration<String> nombres = notas.keys();
		
		while (nombres.hasMoreElements()) {
			String alumno = nombres.nextElement();
			int nota1 = Integer.parseInt(JOptionPane.showInputDialog("Nota del examen 1 de " + alumno));
			examen1[index] = nota1;
			
			int nota2 = Integer.parseInt(JOptionPane.showInputDialog("Nota del examen 2 de " + alumno));
			examen2[index] = nota2;
			
			notas.replace(alumno, calcularMedia(examen1[index], examen2[index]));
			index++;
		}
		
		mostrarNotas(notas);
	}

	public static void mostrarNotas(Hashtable<String, Integer> notas) {
		Enumeration<String> nombres = notas.keys();
		Enumeration<Integer> nota = notas.elements();
		for (int i = 0; i < notas.size(); i++) {
			System.out.println("La nota media de " + nombres.nextElement() + " es: " + nota.nextElement());
		}
	}

	public static int calcularMedia(int nota, int nota2) {
		int notaMedia = (nota + nota2) / 2;
		return notaMedia;
	}

	public static void crearTabla() {
		Hashtable<String, Integer> notas = new Hashtable<String, Integer>();
		int cantAlumnos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos alumnos hay?"));
		for (int i = 0; i < cantAlumnos; i++) {
			notas.put(JOptionPane.showInputDialog("Nombre del alumno "), 0);
		}
		notas(notas);
	}

}