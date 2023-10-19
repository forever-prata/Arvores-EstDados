package arvores;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
	
	private class Nodo{
		private int chave;
		private Nodo dir,esq;
		
		public Nodo(int item) {
			this.chave = item;
			dir = esq = null;
		}
	}
	
	public class NodoLista {
		
		private int dado;
		private NodoLista prox;
		
		public NodoLista(int dado) {
			this.dado = dado;
			this.prox = null;
		}

		public int getDado() {
			return dado;
		}

		public void setDado(int dado) {
			this.dado = dado;
		}

		public NodoLista getProx() {
			return prox;
		}

		public void setProx(NodoLista prox) {
			this.prox = prox;
		}
		
		
	}

	
	public class ListaEncadeada {

		private NodoLista inicio;

		public ListaEncadeada() {
			inicio = null;
		}
		
		public boolean vazia() {
			return inicio == null;
		}
		
		public NodoLista getInicio() {
			return inicio;
		}
		
		public void inseririnicio(int dado) {
			NodoLista novoNodo = new NodoLista(dado);
			novoNodo.setProx(inicio);
			inicio = novoNodo;
		}
		
		public void inserirFinal (int dado) {
			NodoLista novoNodo = new NodoLista(dado);
			
			NodoLista aux = inicio;
			
			if (aux == null) {
				inseririnicio(dado);
			}else {
				
				while (aux.getProx() != null) {
					aux = aux.getProx();
				}
				
				aux.setProx(novoNodo);
			}

		}
		
		public void mostraLista() {
			if(vazia()) {
				System.out.println("Lista Vazia");
				return;
			}
			NodoLista aux = inicio;
			while(aux != null) {
				System.out.print(aux.getDado()+" ");
				aux = aux.getProx();
			}
			System.out.println();
		}
	}

	
	Nodo raiz = null;
	
	int tam = 0;
	
	public void inserir(int chave) {
		raiz = inserirDado(raiz,chave);
	}
	
	private Nodo inserirDado(Nodo raiz,int chave) {
		if(raiz == null) {
			raiz = new Nodo(chave);
			return raiz;
		}
		
		if(chave<raiz.chave) {
			raiz .esq = inserirDado(raiz.esq,chave);
		}else if (chave > raiz.chave) {
			raiz.dir = inserirDado(raiz.dir,chave);
		}
		
		return raiz;
	}
	
	public void mostrarEmOrdem() {
		mostrarOrdenado(raiz);
	}
	
	private void mostrarOrdenado(Nodo raiz) {
		if (raiz !=null) {
			mostrarOrdenado(raiz.esq);
			System.out.println(raiz.chave);
			mostrarOrdenado(raiz.dir);
		}
	}
	
	public void remover(int chave) {
		raiz = removerItem(raiz,chave);
	}
	
	private Nodo removerItem(Nodo raiz, int chave) {
		if (raiz == null) {
			return null;
		}
		if (chave < raiz.chave) {
			raiz.esq = removerItem(raiz.esq,chave);
		}else if (chave > raiz.chave) {
			raiz.dir = removerItem(raiz.dir,chave);
		}else {
			if (raiz.esq == null) {
				return raiz.dir;
			}else if(raiz.dir == null) {
				return raiz.esq;
			}else {
				Nodo sucessor = encontrarSucessor(raiz.dir);
				raiz.chave = sucessor.chave;
				raiz.dir = removerItem(raiz.dir,sucessor.chave);
			}
		}
		return raiz;
	}
	
	private Nodo encontrarSucessor(Nodo nodo) {
		while (nodo.esq != null) {
			nodo = nodo.esq;
		}
		return nodo;
	}
	
	public void mostrarDec() {
		mostarDecrescente(raiz);
	}
	
	public void mostarDecrescente(Nodo raiz) {
		if (raiz !=null) {
			mostarDecrescente(raiz.dir);
			System.out.println(raiz.chave);
			mostarDecrescente(raiz.esq);
		}
	}
	
	public void mostrarNivel() {
		if (raiz == null) {
			System.out.println("Vazio");
			return;
		}
		
		Queue<Nodo> fila = new LinkedList<>();
		
		fila.add(raiz);
		
		while (!fila.isEmpty()) {
			int tamanhoNivel = fila.size();
			for (int i = 0; i < tamanhoNivel; i++) {
				Nodo nodoAtual = fila.poll();
				if (nodoAtual != null) {
					System.out.print(nodoAtual.chave+"");
					fila.add(nodoAtual.esq);
					fila.add(nodoAtual.dir);
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	
	public void maior() {
		Nodo next = raiz.dir;
		Nodo retorno = raiz;
		while (next != null) {
			next = next.dir;
			retorno = retorno.dir;
		}
		System.out.println(retorno.chave);
	}
	
	public void menor() {
		Nodo next = raiz.esq;
		Nodo retorno = raiz;
		while (next != null) {
			next = next.esq;
			retorno = retorno.esq;
		}
		System.out.println(retorno.chave);
	}
	
	public void mostrarFolha() {
		mostrarFolha(raiz);
	}
	
	public void mostrarFolha(Nodo aux) {
		if (aux.dir == null && aux.esq == null) {
			System.out.println(aux.chave);
			return;
		}
		
		if (aux.dir != null) {
			mostrarFolha(aux.dir);
		}

		if (aux.esq != null) {
			mostrarFolha(aux.esq);
		}

	}
	
	public void ancestrais(int valor) {
		ancestrais(raiz,valor);
	}
	
	private void ancestrais(Nodo aux, int valor) {
		if (valor == aux.chave) {
			return;
		}
		
		if (valor < aux.chave) {
			System.out.println(aux.chave);
			ancestrais(aux.esq, valor);
			return;
		}
		
		if (valor > aux.chave) {
			System.out.println(aux.chave);
			ancestrais(aux.dir, valor);
			return;
		}
	}
	
	public void descendente(int valor) {
		descendente(raiz,valor);
	}
	
	private void descendente(Nodo aux, int valor) {
		aux = achar(aux,valor);
		
		if (aux !=null) {
			mostarDecrescente(aux.dir);
			mostarDecrescente(aux.esq);
			if (aux.chave != valor) {
				System.out.println(aux.chave);
			} 
		}
	}
	
	private Nodo achar(Nodo aux,int valor) {
		if (valor == aux.chave) {
			return aux;
		}
		
		if (valor < aux.chave) {
			aux = achar(aux.esq, valor);
		}
		
		if (valor > aux.chave) {
			aux = achar(aux.dir, valor);
		}
		
		return aux;
	}
	
	public void subDir(int valor) {
		subDir(raiz, valor);
	}
	
	private void subDir(Nodo aux, int valor) {
		aux = achar(aux, valor);
		
		if (aux !=null) {
			mostarDecrescente(aux.dir);
			if (aux.chave != valor) {
				System.out.println(aux.chave);
			} 
		}
	}
	
	public void subEsq(int valor) {
		subEsq(raiz, valor);
	}
	
	private void subEsq(Nodo aux, int valor) {
		aux = achar(aux, valor);
		
		if (aux !=null) {
			mostarDecrescente(aux.esq);
			if (aux.chave != valor) {
				System.out.println(aux.chave);
			} 
		}
	}
	
	public void pares() {
		mostrarPares(raiz);
	}
	
	private void mostrarPares(Nodo aux) {
		if (aux !=null) {
			mostrarPares(aux.esq);
			if ((aux.chave % 2) == 0) {
				System.out.println(aux.chave);
			}
			mostrarPares(aux.dir);
		}
	}
	
	public void tamanhoArvore() {
		calcTamanho(raiz);
		System.out.println(tam);
		tam = 0; //variavel global auxiliar
	}
	
	private void calcTamanho(Nodo aux) {
		if (aux !=null) {
			calcTamanho(aux.esq);
				tam++;
			calcTamanho(aux.dir);
		}
	}
	
	public void nivelNodo(int valor) {
		calcNiveis(raiz,valor);
		System.out.println(tam);
		tam = 0;
	}
	
	
	private Nodo calcNiveis(Nodo aux,int valor) {
		if (valor == aux.chave) {
			return aux;
		}
		
		if (valor < aux.chave) {
			aux = calcNiveis(aux.esq, valor);
			tam++;
		}
		
		if (valor > aux.chave) {
			aux = calcNiveis(aux.dir, valor);
			tam++;
		}
		return aux;
	}
	
	public void calcularAltura() {
	    int altura = calcularAltura(raiz);
	    System.out.println(altura);
	}

	private int calcularAltura(Nodo raiz) {
	    if (raiz == null) {
	        return 0;
	    } else {
	        int alturaEsquerda = calcularAltura(raiz.esq);
	        int alturaDireita = calcularAltura(raiz.dir);
	        
	        return Math.max(alturaEsquerda, alturaDireita) + 1;
	    }
	}
	
	public void inserirNaorec(int chave) {
		Nodo aux = raiz;
		Nodo inser = new Nodo(chave);
		boolean inseriu = false;
		if (raiz == null) {
		    raiz = new Nodo(chave);
		}else {
			while(!inseriu) {
				if(chave > aux.chave) {
					if (aux.dir != null) {
						aux = aux.dir;
					}else {
						aux.dir = inser;
						inseriu = true;
					}
				
				}
				if (chave < aux.chave && !inseriu) {
					if (aux.esq != null) {
						aux = aux.esq;
					}else {
						aux.esq = inser;
						inseriu = true;
					}
				}
			}
		}
	}
	
	public void virarLista() {
		ListaEncadeada out = new ListaEncadeada();
		transformaLista(raiz, out);
		out.mostraLista();
	}
	
	private void transformaLista(Nodo raiz, ListaEncadeada out) {
		if (raiz !=null) {
			transformaLista(raiz.dir, out);
			out.inserirFinal(raiz.chave);
			transformaLista(raiz.esq, out);
		}else {
			return;
		}
	}

    public boolean buscarElemento(int chave) {
        Nodo currentNode = raiz;
        while (currentNode != null) {
            if (chave == currentNode.chave) {
                return true;
            } else if (chave < currentNode.chave) {
                currentNode = currentNode.esq;
            } else {
                currentNode = currentNode.dir;
            }
        }
        return false;
    }
}
