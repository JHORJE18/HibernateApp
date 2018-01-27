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
				mn.limpiarln();
				nuevoRegistro();
				break;
			case 2:
				mn.limpiarln();
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
				System.out.println("Nueva empresa");
				mn.limpiarln();
				guardarObjeto(mn.nuevaEmpresa());
				break;
			case 3:
				//Nuevo Item
				System.out.println("Nueva empresa");
				mn.limpiarln();
				guardarObjeto(mn.nuevaEmpresa());
				break;
			case 4:
				//Cancelar
				System.out.println("Cancelado");
				break;
		}
	}
	
	private static void guardarObjeto(Object o) {
		session.beginTransaction();

		session.save(o);
		session.getTransaction().commit();
		
		System.out.println("Objeto guardado correctamente!");
	}
}
