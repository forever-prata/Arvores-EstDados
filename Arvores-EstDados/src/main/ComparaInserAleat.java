package main;

import arvores.ArvoreAVL;
import arvores.ArvoreB;
import arvores.ArvoreBinaria;

public class ComparaInserAleat {
	public static void main(String[] args) {
		ArvoreAVL avl = new ArvoreAVL();
		ArvoreBinaria abi = new ArvoreBinaria();
		int o = 1000;
		ArvoreB ab = new ArvoreB(o);
		int t=1000000;
		int[] arr = gerarEntrada(t);
		
		//Teste Arvore AVL
		long inicio = System.nanoTime();
		
		for (int i : arr) {
			avl.inserir(i);
		}
		
		long fim = System.nanoTime();
		
		double tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("Tempo de Inserção AVL Aleatorio"+" Tamanho : "+t+" = "+tempoExecucao+" ms");
		
		
		//Teste Arvore Binaria
		inicio = System.nanoTime();
		
		for (int i : arr) {
			abi.inserir(i);
		}
		
		fim = System.nanoTime();
		
		tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("Tempo de Inserção Binaria Aleatorio"+" Tamanho : "+t+" = "+tempoExecucao+" ms");	
		
		
		//Teste Arvore B
		inicio = System.nanoTime();
		
		for (int i : arr) {
			ab.inserir(i);
		}
		
		fim = System.nanoTime();
		
		tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("Tempo de Inserção B Aleatorio"+" Tamanho : "+t+" Ordem "+o+" = "+tempoExecucao+" ms");
	}
	
	public static int[] gerarEntrada(int tamanho) {
		int[] arr = new int[tamanho];
		
		for (int i = 0; i < tamanho; i++) {
			arr[i] = (int)(Math.random()*1000000);
		}
		return arr;
	}
}
