package main;

import arvores.ArvoreB;

public class Main {
	public static void main(String[] args) {
		ArvoreB a = new ArvoreB(3);
		a.inserir(3);
		a.inserir(4);
		System.out.println(a.Procura(4));
		System.out.println(a.Procura(2));
		a.Remove(4);
		System.out.println(a.Procura(4));
	}
}
