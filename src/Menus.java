import java.util.ArrayList;
import java.util.Scanner;

public class Menus {
		
	//Menu Principal
	public int menu() {
		Scanner entrada = new Scanner(System.in);

		limpiarln();
		System.out.println("Menu Principal");
		limpiarln();
		
		System.out.println("1. Añadir registro");
		System.out.println("2. Consultar registro");
		System.out.println("3. Salir");
		int opcion = entrada.nextInt();
		
		return opcion;
	}
	
	//Menu crear
	public int menuNuevoObjeto() {
		Scanner entrada = new Scanner(System.in);

		limpiarln();
		System.out.println("Añadir registro");
		limpiarln();
		
		System.out.println("1. Nueva empresa");
		System.out.println("2. Nuevo pedido");
		System.out.println("3. Nuevo item");
		System.out.println("4. Cancelar");
		int opcion = entrada.nextInt();
		
		return opcion;
	}
	
	//Menu Recuperar
	public int menuRecuperar() {
		Scanner entrada = new Scanner(System.in);

		limpiarln();
		System.out.println("Recuperar registro");
		limpiarln();
		
		System.out.println("1. Empresa");
		System.out.println("2. Pedido");
		System.out.println("3. Item");
		System.out.println("4. Cancelar");
		int opcion = entrada.nextInt();
		
		return opcion;
	}

	
	//Nueva Empresa
	public Empresa nuevaEmpresa() {
		limpiarln();
		System.out.println("Nueva empresa");
		limpiarln();
		
		String cif = pedirTexto("Introduce el CIF de la empresa");
		
		String nombre = pedirTexto("Introduce el nombre de la empresa");
		
		int empleados = pedirInt("Introduce el número de empleados de la empresa");
		
		String direccion = pedirTexto("Introduce la dirección de la empresa");
		
		//Creamos Empresa
		Empresa e = new Empresa(cif,nombre,empleados,direccion);
		
		return e;
	}
	
	//Nuevo Pedido
	public Pedido nuevoPedido() {
		limpiarln();
		System.out.println("Nuevo Pedido");
		limpiarln();
		
		int numItems = pedirInt("Introduce el número de Items de este pedido");
		
		//Creamos items
		ArrayList<Item> listaItems = new ArrayList<Item>();
		for (int i=0; i<numItems; i++) {
			listaItems.add(nuevoItem());
		}
		
		String fecha = pedirTexto("Introduce la fecha del pedido");
		
		//Creamos Pedido
		Pedido p = new Pedido(fecha);
		
		//Añadimos Items
		p.setItems(listaItems);
		
		return p;
	}
	
	//Nuevo Item
	public Item nuevoItem() {
		limpiarln();
		System.out.println("Nuevo Item");
		limpiarln();
						
		String nombre = pedirTexto("Introduce el nombre del nuevo Item");
		
		int cantidad = pedirInt("Introduce la cantidad");
		
		//Creamos Item
		Item i = new Item(nombre,cantidad);

		return i;
		}
	
	public String pedirTexto(String msg) {
		Scanner entrada = new Scanner(System.in);

		System.out.println(msg);
		String respuesta = entrada.nextLine();
		
		return respuesta;
	}
	
	public int pedirInt(String msg) {
		Scanner entrada = new Scanner(System.in);

		System.out.println(msg);
		int num = entrada.nextInt();
		
		return num;
	}
	
	//EXTRA
		public void limpiarln() {
			String linea = "";
			for (int i=0; i< 20; i++) {
				linea += "-";
			}
			
			System.out.println(linea);
		}

}
