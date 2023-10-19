package main;

import arvores.ArvoreAVL;
import arvores.ArvoreB;
import arvores.ArvoreBinaria;

public class ComparaExclAleat {
	public static void main(String[] args) {
		int o = 10;
		int t=1000000;
		int[] arr = gerarEntrada(t);
		ArvoreAVL avl = criaAvl(arr);
		ArvoreBinaria abi = criaBin(arr);
		ArvoreB ab = criaB(o,arr);
		
		//Teste AVL
		long inicio = System.nanoTime();
		
		for (int i : arr) {
			avl.remover(i);
		}
		
		long fim = System.nanoTime();
		
		Double tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("AVL = "+tempoExecucao+" ms");
		
		
		//Teste Binaria
		inicio = System.nanoTime();
		
		for (int i : arr) {
			abi.remover(i);
		}
		
		fim = System.nanoTime();
		
		tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("Binaria = "+tempoExecucao+" ms");
		
		
		//Teste B
		inicio = System.nanoTime();
		
		for (int i : arr) {
			ab.Remove(i);
		}
		
		fim = System.nanoTime();
		
		tempoExecucao = (fim- inicio)/1000000.0;
		
		System.out.println("B Ordem "+o+ " = "+tempoExecucao+" ms");
	}
	public static ArvoreAVL criaAvl(int[] arr) {
		ArvoreAVL a = new ArvoreAVL();
		
		for (int i : arr) {
			a.inserir(i);
		}
		
		return a;
	}
	
	public static ArvoreBinaria criaBin(int[] arr) {
		ArvoreBinaria a = new ArvoreBinaria();
		
		for (int i : arr) {
			a.inserir(i);
		}
		
		return a;
	}
	
	public static ArvoreB criaB(int ordem, int[] arr) {
		ArvoreB a = new ArvoreB(ordem);
		
		for (int i : arr) {
			a.inserir(i);
		}
		
		return a;
	}
	
	public static int[] gerarEntrada(int tamanho) {
		int[] arr = new int[tamanho];
		
		for (int i = 0; i < tamanho; i++) {
			arr[i] = (int)(Math.random()*1000000);
		}
		return arr;
	}
}
