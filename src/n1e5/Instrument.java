package n1e5;
import java.io.Serializable;

public class Instrument implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int price;
	
	//constructors
	public Instrument(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public Instrument() {
		name = null;
		price = 0;
	}
	
	
	//methods
	public void tocar() {
		System.out.println("Està sonant un instrument");
	}
	
	//setters y getters
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Nom de l'instrument: " + name + "\nPreu: " + price;
	}
	
	

}
