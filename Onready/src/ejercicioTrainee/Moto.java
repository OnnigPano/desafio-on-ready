package ejercicioTrainee;

public class Moto extends Vehiculo {
	
	private int cilindrada;
	
	public Moto(String marca, String modelo, double precio, int cilindrada) {
		super(marca, modelo, precio);
		this.setCilindrada(cilindrada);
	}
	
	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if(cilindrada <= 0) {
			throw new IllegalArgumentException("La cilindrada debe ser mayor a 0");
		}
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Marca: " + getMarca() +  " //  Modelo: " + getModelo() + " // " + " Cilindrada: " + getCilindrada() + " //  Precio: " + getFormattedPrecio();
	}	

}
