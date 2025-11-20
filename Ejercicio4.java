package principal;

import test.objetos;

public class Ejercicio4 {

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

			objetos[] inventarioOrdenado = new objetos[inventario.length];
			int index = 0;

			for (objetos obj : inventario) {
				if (obj.getStock() != null) {
					inventarioOrdenado[index++] = obj;
				}
			}

			for (objetos obj : inventario) {
				if (obj.getStock() == null) {
					inventarioOrdenado[index++] = obj;
				}
			}

			System.out.println("Inventario ordenado:");
			for (objetos obj : inventarioOrdenado) {
				System.out.println(obj.getProducto() + " - Stock: " + obj.getStock());
			}
			
			objetos productoMasCaroGlobal = null;
			objetos productoMasBaratoGlobal = null;
			int indiceMasCaro = -1;
			int indiceMasBarato = -1;

			for (int i = 0; i < inventario.length; i++) {
				if (inventario[i].getStock() != null) {
					if (productoMasCaroGlobal == null || inventario[i].getPrecio() > productoMasCaroGlobal.getPrecio()) {
						productoMasCaroGlobal = inventario[i];
						indiceMasCaro = i;
					}
					if (productoMasBaratoGlobal == null || inventario[i].getPrecio() < productoMasBaratoGlobal.getPrecio()) {
						productoMasBaratoGlobal = inventario[i];
						indiceMasBarato = i;
					}
				}
			}

			if (indiceMasCaro != -1 && indiceMasBarato != -1) {
				objetos temp = inventario[indiceMasCaro];
				inventario[indiceMasCaro] = inventario[indiceMasBarato];
				inventario[indiceMasBarato] = temp;
			}

			System.out.println("Inventario después del intercambio:");
			for (objetos obj : inventario) {
				System.out.println(obj.getProducto() + " - Precio: " + obj.getPrecio() + ", Stock: " + obj.getStock());
			}
		}
	}