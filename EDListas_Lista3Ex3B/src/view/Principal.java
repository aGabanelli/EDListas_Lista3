package view;

import fatec.sp.gov.lib.listas.ListaGenerica;

public class Principal {

	public static void main(String[] args) throws Exception {

		ListaGenerica<Integer> L = new ListaGenerica<Integer>();

		L.addFirst(3);
		L.addLast(5);
		L.addLast(8);
		L.addLast(12);
		L.addLast(9);
		L.addLast(7);
		L.addLast(6);
		L.addLast(2);
		L.addLast(3);
		L.addLast(7);
		L.addLast(16);

		int tamanho = L.size();
		int maior1 = 0, maior2 = 0;

		for (int i = 0; i < tamanho; i++) {
			if (i == 0) {
				maior1 = L.get(i);
				maior2 = L.get(i);
			} else {
				if(L.get(i) < maior1 && L.get(i) > maior2) {
					maior2 = L.get(i);
				}
				if(L.get(i) > maior1 && maior2 < L.get(i)) {
					maior2 = maior1;
					maior1 = L.get(i);
				}
			}
		}
		System.out.println("Primeiro maior = " + maior1 + " | Segundo maior = " + maior2);
	}
}
