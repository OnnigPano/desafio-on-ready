package ejercicioTrainee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {
	
	private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	private static Vehiculo vehiculoMasCaro = null; 
	private static Vehiculo vehiculoMasBarato = null;
	private static Vehiculo vehiculoContieneLetra = null;
	private static final String letraABuscar = "Y";
	
	public static void main(String[] args) {
		
		vehiculos.add(new Auto("Peugeot", "206", 200000, 4));
		vehiculos.add(new Moto("Honda", "Titan", 60000, 125));
		vehiculos.add(new Auto("Peugeot", "208", 250000, 5));
		vehiculos.add(new Moto("Yamaha", "YBR", 80500.50, 160));
		
		imprimirListado(vehiculos);
		
		System.out.println("=============================");
		
		vehiculoMasCaro = calcularVehiculoMasCaro(vehiculos);
		vehiculoMasBarato = calcularVehiculoMasBarato(vehiculos);
		vehiculoContieneLetra = buscarVehiculoConLetra(vehiculos);
		
		if(vehiculoMasCaro != null) {
			System.out.println("Vehiculo más caro: " + vehiculoMasCaro.getMarca() + " " + vehiculoMasCaro.getModelo());
		}
		
		if(vehiculoMasBarato != null) {
			System.out.println("Vehiculo más barato: " + vehiculoMasBarato.getMarca() + " " + vehiculoMasBarato.getModelo());
		}
		
		if(vehiculoContieneLetra != null) {
			System.out.println("Vehículo que contiene en el modelo la letra '" + letraABuscar + "' : " + 
								vehiculoContieneLetra.getMarca() + 
								" " + vehiculoContieneLetra.getModelo() + 
								" " + vehiculoContieneLetra.getFormattedPrecio());
		}
		
		System.out.println("=============================");		
		
		System.out.println("Vehiculos ordenados por precio de mayor a menor:");
		imprimirDeMayorAMenor(vehiculos);
		
	}
	
	public static void imprimirDeMayorAMenor(ArrayList<Vehiculo> vehiculos) {
		
		Collections.sort(vehiculos ,new Comparator<Vehiculo>() {
			@Override
			public int compare(Vehiculo v1, Vehiculo v2) {
				return Double.valueOf(v2.getPrecio()).compareTo(Double.valueOf(v1.getPrecio()));
			}
		});
		
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo());
		}
	}
	
	public static void imprimirListado(ArrayList<Vehiculo> vehiculos) {
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo);
		}
	}
	
	public static Vehiculo calcularVehiculoMasCaro(ArrayList<Vehiculo> vehiculos) {
		Vehiculo elMasCaro = null;
		double importeMasCaro = 0;
		
		for(int i = 0; i < vehiculos.size(); i++) {
			if(vehiculos.get(i).getPrecio() > importeMasCaro) {
				importeMasCaro = vehiculos.get(i).getPrecio();
				elMasCaro = vehiculos.get(i);
			}
		}
		return elMasCaro;
	}
	
	public static Vehiculo calcularVehiculoMasBarato(ArrayList<Vehiculo> vehiculos) {
		Vehiculo elMasBarato = null;
		double importeMasBajo = -1;
		
		for(int i = 0; i < vehiculos.size(); i++) {
			if(importeMasBajo == -1 || vehiculos.get(i).getPrecio() < importeMasBajo) {
				importeMasBajo = vehiculos.get(i).getPrecio();
				elMasBarato = vehiculos.get(i);
			} 
		}
		return elMasBarato;
	}
	
	public static Vehiculo buscarVehiculoConLetra(ArrayList<Vehiculo> vehiculos) {
		Vehiculo encontrado = null;
		int i = 0;
		while(i < vehiculos.size() && encontrado == null) {
			if(vehiculos.get(i).getModelo().contains(letraABuscar)) {
				encontrado = vehiculos.get(i);
			} else {
				i++;
			}
		}
		
		return encontrado;
	}
		
}
