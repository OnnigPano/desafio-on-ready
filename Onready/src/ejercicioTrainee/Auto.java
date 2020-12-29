package ejercicioTrainee;

public class Auto extends Vehiculo {
	
	private int cantPuertas;

	public Auto(String marca, String modelo, double precio, int cantPuertas) {
		super(marca, modelo, precio);
		this.setCantPuertas(cantPuertas);
	}

	public int getCantPuertas() {
		return cantPuertas;
	}

	private void setCantPuertas(int cantPuertas) {
		if(cantPuertas < 2) {
			throw new IllegalArgumentException("Los autos deben tener como mínimo 2 puertas");
		}
		this.cantPuertas = cantPuertas;
	}
	
	@Override
	public String toString() {
		return "Marca: " + getMarca() +  " //  Modelo: " + getModelo() + " // " + " Puertas: " + getCantPuertas() + " //  Precio: " + getFormattedPrecio();
	}

}
