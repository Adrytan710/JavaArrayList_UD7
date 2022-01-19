package Ejercicios;
import java.util.Hashtable;
import javax.swing.JOptionPane;

//author Adri�n Rodriguez

public class Ej3StockApp {

	public static Hashtable<String,int[]> db = new Hashtable<String,int[]>();
	
	public static void main(String[] args) {
		
		basedeDatos();
		
		String opcion;
		do {
			opcion = JOptionPane.showInputDialog("�Qu� opci�n deseas realizar: mostrar / agregar / salir?");

			switch (opcion) {
				case "mostrar":
					mostarProductos();
					break;
				case "agregar":
					crearProducto();
					break;
				case "salir":
					System.exit(0);
					break;
				default:
					System.out.println("Has introducido una opci�n incorrecta");
					break;
				}
		} while (opcion != "salir");

	}

	public static void basedeDatos() {
		
		String nombres[] = {"iogurts","agua","queso","legumbres","mermelada","turron","arroz","pan","coca cola","patatas"};
		
		for (int i = 0; i < 10; i++) {
			int productos[] = new int[2];
			db.put(nombres[i], productos);
			for(int j = 0; j < 2 ; j++) {
				double random = Math.random() * (10 - 1) + 0;
				productos[j] = (int) random;
			}
		}
	}

	public static void crearProducto() {
		String nombre = JOptionPane.showInputDialog("A�ade un producto");
		int precio = Integer.parseInt(JOptionPane.showInputDialog("�Cual es su precio?"));
		int cantidad =Integer.parseInt(JOptionPane.showInputDialog("�Cuanta cantidad quieres a�adir?"));
		int productoNuevo[] = new int[2]; 
		productoNuevo[0] = precio;
		productoNuevo[1] = cantidad;
		db.put(nombre, productoNuevo);
	}

	public static void mostarProductos() {
		for (String i : db.keySet()) {
			int[] informacion = db.get(i).clone();
			System.out.println("Producto: " + i + " tiene un precio de: " + informacion[0] + " con un stock de: " + informacion[1]);
		}
		System.out.println(" ");
		System.out.println("-------");
		System.out.println(" ");
	}
}
