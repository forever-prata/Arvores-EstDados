package main;

import arvores.ArvoreAVL;
import arvores.ArvoreB;
import arvores.ArvoreBinaria;

public class ComparaBuscOrd {
	public static void main(String[] args) {
		int o = 1000;
		ArvoreAVL avl = criaAvl();
		//ArvoreBinaria abi = criaBin();
		ArvoreB ab = criaB(o);
		
		//Teste AVL
		long inicio = System.nanoTime();
		
		avl.buscar(1000000000);
		
		long fim = System.nanoTime();
		
		Double tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("AVL = "+tempoExecucao+" ms");
		
		
		//Teste Binaria
		inicio = System.nanoTime();
		
		//abi.buscarElemento(1000000000);
		
		fim = System.nanoTime();
		
		tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("Binaria = "+tempoExecucao+" ms");
		
		
		//Teste B
		inicio = System.nanoTime();
		
		ab.Procura(1000000000);
		
		fim = System.nanoTime();
		
		tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("B Ordem "+o+ " = "+tempoExecucao+" ms");
	}
	
	public static ArvoreAVL criaAvl() {
		ArvoreAVL a = new ArvoreAVL();
		
		for (int i = 0; i < 1000000; i++) {
			a.inserir(i);
		}
		
		return a;
	}
	
	public static ArvoreBinaria criaBin() {
		ArvoreBinaria a = new ArvoreBinaria();
		
		for (int i = 0; i < 1000000; i++) {
			a.inserirNaorec(i);
			System.out.println(i);
		}
		
		return a;
	}
	
	public static ArvoreB criaB(int ordem) {
		ArvoreB a = new ArvoreB(ordem);
		
		for (int i = 0; i < 1000000; i++) {
			a.inserir(i);
		}
		
		return a;
	}
}
