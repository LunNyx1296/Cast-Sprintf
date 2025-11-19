package principal;

import TEST.objetos;

public class Ejercicio2 {

	public static void main(String[] args) {
		objetos[] inventario = { 
				new objetos("Manzana", 1.2, 5), 
				new objetos("Pera", 1.5, 4),
				new objetos("Naranja", 2.0, 3), 
				new objetos("Melón", 3.0, null), 
				new objetos("Sandía", 4.5, 2) };
			double total = 0;
			objetos productoMasCaro = null;

			for (int i = 0; i < inventario.length; i++) {
				if (inventario[i].getStock() != null) {
					if (inventario[i].getStock() % 2 != 0) {
						total += inventario[i].getPrecio();
					}

					if (inventario[i].getStock() > 5) {
						if (productoMasCaro == null || inventario[i].getPrecio() > productoMasCaro.getPrecio()) {
							productoMasCaro = inventario[i];
						}
					}
				}
			}

			System.out.println("La suma de precios con stock null es: " + total);
			if (productoMasCaro != null) {
				System.out.println("El producto más caro con stock mayor que 5 es: " + productoMasCaro.getProducto());
			} else {
				System.out.println("No hay productos con stock mayor que 5.");
			}
		}
	}