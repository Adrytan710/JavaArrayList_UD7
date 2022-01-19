package Ejercicios;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//@author Adrián Rodriguez

public class Ej2FlujodeVentasApp {

	public static ArrayList<Integer> carrito = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		crearCarrito();
		
	}

	public static void crearCarrito() {
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cual es la cantidad de productos comprados?"));
		for (int i = 0; i < cantidad; i++) {
			int precio = Integer.parseInt(JOptionPane.showInputDialog("El precio del producto es: " + (i+1)));
			carrito.add(precio);
		}
		mostrar();
	}

	public static double iva(int producto, String ivaAplicado) {
		double precioTotal = 0;
		
		switch (ivaAplicado) {
			case "21%":
				precioTotal = producto + (producto * 0.21);
				break;
			case "4%":
				precioTotal = producto + (producto * 0.04);
				break;
			default:
				System.out.println("Has introducido un porcentaje erróneo");
				break;
			}
		return precioTotal;
	}

	public static void mostrar() {
		String ivaAplicado = JOptionPane.showInputDialog("IVA aplicado: 21% o 4%");
		
		for (int i = 0; i < carrito.size(); i++) {
			System.out.println("El producto " + (i+1) + " tiene un precio bruto de " + carrito.get(i) + " y un precio con iva de " 
								+ iva(carrito.get(i), ivaAplicado));
		}
		
		System.out.println("El número de productos comprados es: " + carrito.size());
		cambio();
	}

	public static void cambio() {
		int precioTotal = 0;
		
		for (int i = 0; i < carrito.size(); i++) {
			precioTotal = precioTotal + carrito.get(i);
		}
		
		System.out.println("El total a pagar es: " + precioTotal);
		int devolver = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto ha pagado?"));
		System.out.println("El cambio a devolver es: " + (devolver-precioTotal));
	}
}