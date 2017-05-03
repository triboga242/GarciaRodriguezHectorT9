package main;

import exception.ListSizeOverflownException;
import models.MiLista;

public class prueba {

	public static void main(String[] args) throws ListSizeOverflownException {

		//Creamos la lista con el comparador descendente 
		MiLista<Integer> lista = new MiLista<Integer>((Integer a, Integer b) -> b - a);
		//Empezamos a crear el main de pruebas donde probaremos todos los metodos sobreescritos o implementados.
		System.out.println("Añadimos 100 elementos a la lista");
		for (int i = 0; i < 100; i++) {
			lista.add(i);
		}
		System.out.println("La Lista: " + lista);
		System.out.println("");
		System.out.println(
				"Intentamos agregar mas elementos, ya sea por elemento, entero o indicando el numero de indice., comprobamos tambien los nulls");

		try {
			lista.add(11);
		} catch (Exception e) {
			System.out.println("");
			System.out.println(e);
		}
		try {
			lista.add(11, 11);
		} catch (Exception e) {
			System.out.println("");
			System.out.println(e);
		}
		try {
			lista.add(1, 11);
		} catch (Exception e) {
			System.out.println("");
			System.out.println(e);
		}
		try {
			lista.add(null);
		} catch (Exception e) {
			System.out.println("");
			System.out.println(e);
		}
		System.out.println("");
		System.out.println("Tamaño de la lista: " + lista.size());
		System.out.println("");
		System.out.println("Hacemos un clear");
		lista.clear();

		System.out.println("");
		System.out.println("Tamaño de la lista: " + lista.size());

		System.out.println("");
		System.out.println("La Lista: " + lista);
		System.out.println("");
		System.out.println("Añadimos objetos desordenados y comprobamos que sigue ordenada");
		lista.add(1);
		lista.add(20);
		lista.add(10);
		lista.add(5);
		lista.add(15);
		System.out.println("La Lista: " + lista);
		System.out.println("");
		System.out.println("Ahora probamos el reverse()");
		System.out.println("La Lista reverse: " + lista.reverse());
		System.out.println("");
		System.out.println("Ahora mostramos el elemento maximo:");
		System.out.println(lista.max());
		System.out.println("");
		System.out.println("Y el elemento minimo:");
		System.out.println(lista.min());
		System.out.println("");
	}
}
