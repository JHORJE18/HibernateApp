import java.util.Scanner;

import org.hibernate.Session;

public class Program {
	
	static Session session;
	static Menus mn;

	public static void main(String[] args) {
		
		session = HibernateUtilities.getSessionFactory().openSession();
				
		//Iniciamos menu
		boolean salir = false;
		mn = new Menus();
		while (!salir) {
			switch(mn.menu()) {
			case 1:
				//Nuevo registro
				mn.limpiarln();
				nuevoRegistro();
				break;
			case 2:
				//Consultar registro
				mn.limpiarln();
				recuperarRegistro();
				break;
			case 3:
				salir = true;
				break;
			}
		}
		
		mn.limpiarln();
		System.out.println("Programa finalizado!");
		mn.limpiarln();
		
		session.close();
	}
	
	private static void nuevoRegistro() {
		int seleccion = mn.menuNuevoObjeto();
		switch(seleccion) {
			case 1:
				//Nueva Empresa
				System.out.println("Nueva empresa");
				mn.limpiarln();
				guardarObjeto(mn.nuevaEmpresa());
				break;
			case 2:
				//Nuevo Pedido
				System.out.println("Nuevo pedido");
				mn.limpiarln();
				guardarObjeto(mn.nuevoPedido());
				break;
			case 3:
				//Nuevo Item
				System.out.println("Nuevo item");
				mn.limpiarln();
				guardarObjeto(mn.nuevoItem());
				break;
			case 4:
				//Cancelar
				System.out.println("Cancelado");
				break;
		}
	}

	private static void recuperarRegistro() {
		int seleccion = mn.menuRecuperar();
		switch(seleccion) {
			case 1:
				//Consultar Empresa
				int idE = mn.pedirInt("Introduce CIF de la Empresa");
				mn.limpiarln();
				Empresa e = recuperarEmpresa(idE);
				if (e != null) {
					System.out.println("Empresa llamada " + e.getNombre());
				} else {
					System.out.println("No se ha podido obtener el Item, es posible que la ID " + idE + " no exista");
				}
				break;
			case 2:
				//Consultar Pedido
				int idP = mn.pedirInt("Introduce el ID del Pedido");
				mn.limpiarln();
				Pedido p = recuperarPedido(idP);
				if (p != null) {
					System.out.println("Pedido del " + p.getFecha());
					System.out.println("Items:");
					for (int i=0; i<p.getItems().size(); i++) {
						System.out.println("Item " + (i+1) + ":" + p.getItems().get(i).getNombre());
					}
				} else {
					System.out.println("No se ha podido obtener el Item, es posible que la ID " + idP + " no exista");
				}
				break;
			case 3:
				//Consultar Item
				int idI = mn.pedirInt("Introduce el ID del Item");
				mn.limpiarln();
				Item i = recuperarItem(idI);
				if (i != null) {
					System.out.println("Item " + i.getNombre());
				} else {
					System.out.println("No se ha podido obtener el Item, es posible que la ID " + idI + " no exista");
				}
				break;
			case 4:
				//Cancelar
				System.out.println("Cancelado");
				break;
		}
	}

	//Obtener empresa
	private static Empresa recuperarEmpresa(int id) {
		session.beginTransaction();
		
		Empresa e = null;
		try {
			e = session.load(Empresa.class, id);
		} catch (Exception ex) {
			// TODO: handle exception
		}
		session.getTransaction().commit();
		
		return e;
	}
	
	//Obtener Pedido
	private static Pedido recuperarPedido(int id) {
		session.beginTransaction();
		
		Pedido e = null;
		try {
			e = session.load(Pedido.class, id);
		} catch (Exception ex) {
			// TODO: handle exception
		}
		session.getTransaction().commit();
		
		return e;
	}
	
	//Obtener Item
	private static Item recuperarItem(int id) {
		session.beginTransaction();
		
		Item e = null;
		try {
			e = session.load(Item.class, id);
		} catch (Exception ex) {
			// TODO: handle exception
		}
		session.getTransaction().commit();
		
		return e;
	}
	
	private static void guardarObjeto(Object o) {
		session.beginTransaction();

		session.save(o);
		session.getTransaction().commit();
		
		System.out.println("Objeto guardado correctamente!");
	}
}
