package main;

import arvores.ArvoreAVL;
import arvores.ArvoreB;
import arvores.ArvoreBinaria;

public class ComparaInserOrd {
	public static void main(String[] args) {
		
		ArvoreAVL avl = new ArvoreAVL();
		ArvoreBinaria abi = new ArvoreBinaria();
		int o = 100;
		ArvoreB ab = new ArvoreB(o);
		int t=1000000;
		
		
		//Teste Arvore AVL
		long inicio = System.nanoTime();
		
		for (int i = 0; i <= t; i++) {
			avl.inserir(i);
		}
		
		long fim = System.nanoTime();
		
		double tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("Tempo de Inserção AVL Ordenado"+" Tamanho : "+t+" = "+tempoExecucao+" ms");	
		
		
		//Teste Arvore Binaria
		inicio = System.nanoTime();
		
		for (int i = 0; i <= t; i++) {
			abi.inserirNaorec(i);
		}
		
		fim = System.nanoTime();
		
		tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("Tempo de Inserção Binaria Ordenado"+" Tamanho : "+t+" = "+tempoExecucao+" ms");	
		
		
		//Teste Arvore B
		inicio = System.nanoTime();
		
		for (int i = 0; i <= t; i++) {
			ab.inserir(i);
		}
		
		fim = System.nanoTime();
		
		tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("Tempo de Inserção B Ordenado"+" Tamanho : "+t+" Ordem "+o+" = "+tempoExecucao+" ms");

		
	}

}
