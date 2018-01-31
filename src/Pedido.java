import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	//Variables
	private int id;
	private String fecha;
	private List<Item> Items = new ArrayList<Item>();
	
	public Pedido() {
		
	}
	
	public Pedido(String fecha) {
		super();
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<Item> getItems() {
		return Items;
	}

	public void setItems(List<Item> items) {
		Items = items;
	}	

}
