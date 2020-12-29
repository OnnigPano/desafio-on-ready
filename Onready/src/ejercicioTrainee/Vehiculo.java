package ejercicioTrainee;

public abstract class Vehiculo {
	
	private String marca;
	private String modelo;
	private double precio;

	public Vehiculo(String marca, String modelo, double precio) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setPrecio(precio);
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	private void setPrecio(double precio) {
		if(precio < 0) {
			throw new IllegalArgumentException("El precio debe ser mayor a 0");
		}
		this.precio = precio;
	}
	
	public String getMarca() {
		return this.capitalizeFirstLetter(this.marca);
	}
	
	private void setMarca(String marca) {
		if(marca == null || marca.isBlank()) {
			throw new IllegalArgumentException("La marca no puede estar vacía ni ser null");
		}
		this.marca = marca;
	}
	
	public String getModelo() {
		return this.capitalizeFirstLetter(this.modelo);
	}
	
	private void setModelo(String modelo) {
		if(modelo == null || modelo.isBlank()) {
			throw new IllegalArgumentException("El modelo no puede estar vacío ni ser null");
		}		
		this.modelo = modelo;
	}
	
	private String capitalizeFirstLetter(String original) {
		return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
	
	public String getFormattedPrecio() {
		return Formatter.moneyFormatter(getPrecio());
	}

	@Override
	public String toString() {
		return "Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Precio: " + getFormattedPrecio();
	}
	
	

}
