package tests;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import exception.*;
import models.MiLista;

public class ListaDeLaMuerteTest {
	private MiLista<Integer> l;
	private Collection<Integer> c = new ArrayList<Integer>();
	private Integer i = 1;
	private Integer i2 = 2;

	//Añadir una coleccion
	@Test
	public void AddAllSucces() {
		for (int i = 0; i < 90; i++) {
			c.add(i);
		}
		assert (l.addAll(c));
		for (int i = 0; i < 90; i++) {
			assert (l.contains(i));
		}
		assert (l.size() == c.size());
	}
//Añadir una coleccion a partir de un indice
	@Test
	public void AddAllIndexSucces() {
		for (int i = 0; i < 40; i++) {
			c.add(i);
			l.add(i);
		}
		assert (l.addAll(c));
		assert (l.size() == 80);
	}
	//Añadir una coleccion a partir de un indice
	@Test
	public void AddAlIndexFail() {
		for (int i = 0; i < 60; i++) {
			c.add(i);
			l.add(i);
		}
		try {
			l.addAll(c);
		} catch (ListSizeOverflownException e) {
			assert (l.size() != (l.size() + c.size()));
		}
	}
	//Añadir una coleccion
	@Test
	public void AddAllFail() {
		for (int i = 0; i < 101; i++) {
			c.add(i);
		}
		try {
			l.addAll(c);
		} catch (ListSizeOverflownException e) {
			assert (l.size() != c.size());
		}
	}
//Añadir un elemento, objeto o elemento uobjeto a un indice concreto
	@Test
	public void AddSuccess() {
		assert (l.add(0));
		assert (l.add(i));
		l.add(2, i2);
		l.add(3, 2);
		assert (l.contains(1));
		assert (l.contains(i));
		assert (l.contains(i2));
		assert (l.contains(2));
		Setup();
		l.add(0);
		l.add(2);
		l.add(1);
		assert (l.get(0) == 0);
		assert (l.get(1) == 1);
	}
//añadir elemento 
	@Test
	public void AddSuccessB() {
		for (int i = 0; i < 10; i++) {
			assert (l.add(i));
		}
		for (int i = 0; i < 10; i++) {
			assert (l.get(i) == i);
		}
	}
	//añadir elemento 
	@Test
	public void AddFail() {
		for (int i = 0; i < 100; i++) {
			l.add(i);
		}
		try {
			l.add(101);
		} catch (ListSizeOverflownException e) {
			assert (l.size() == 100);
			assert (!l.contains(101));
		}

	}
	//añadir objeto 
	@Test
	public void AddObjectFail() {
		for (int i = 0; i < 10; i++) {
			l.add(i);
		}
		try {
			l.add(i);
		} catch (ListSizeOverflownException e) {
			assert (l.size() == 10);
		}

	}
//Numero maximo
	@Test
	public void MaxSucces() {
		l.add(50);
		l.add(100);
		l.add(1);
		l.add(2);
		l.add(10);
		l.add(15);
		assert (l.get(l.size() - 1) == 100);
	}
//Numero minimo
	@Test
	public void MinSucces() {
		l.add(50);
		l.add(100);
		l.add(1);
		l.add(5);
		l.add(10);
		l.add(2);
		assert (l.get(0) == 1);
	}
//Cola invertida
	public void ReverseSucces() {
		 MiLista<Integer> l2 = new MiLista<Integer>((Integer a, Integer b) -> a - b);

		 for (int i = 0; i < 10; i++) {
			l.add(i);
		}
		l2.addAll(l.reverse());
		assert (l2.size() == l.size());
		assert(l.get(9)==9);
		assert(l2.get(0)==9);
	}
	
	//Añadir una coleccion 
	@Test
	public void AddAllSuccessB() {
		ArrayList<Integer> colaAux = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			colaAux.add(i);
		}
		l.addAll(colaAux);
		for (int i = 0; i < 8; i++) {
			assert (l.get(i) == i);
		}
		assert (colaAux.size() == 8);

	}
	//añadir una coleccion 
	@Test
	public void AddAllFailB() {
		ArrayList<Integer> colaAux = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			colaAux.add(i);
		}
		try {
			l.addAll(colaAux);
		} catch (ListSizeOverflownException e) {
			assert (l.size() == 0);
		}

	}
	
//Setup
	@Before
	public void Setup() {
		l = new MiLista<Integer>((Integer a, Integer b) -> a - b);
	}
}
