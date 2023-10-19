package arvores;

import java.math.BigInteger;

public class ArvoreAVL {
	private class Nodo{
		private int dado,altd,alte,qtd;
		private Nodo dir,esq;
		
		public Nodo(int dado) {
			this.dado = dado;
			dir = esq = null;
			altd = alte = 0;
			qtd = 1;
		}
	}

	Nodo raiz;
	public ArvoreAVL() {
		raiz = null;
	}
	
	public void inserir(int dado) {
		raiz = inserirDado(raiz,dado);
	}
	
	private Nodo inserirDado(Nodo raiz , int dado) {
		if(raiz == null) {
			raiz = new Nodo(dado);
			return raiz;
		}
		if (dado == raiz.dado) {
			raiz.qtd++;
		}
		if (dado < raiz.dado) {
			raiz.esq = inserirDado(raiz.esq, dado);
			if (raiz.esq.altd > raiz.esq.alte) {
				raiz.alte = raiz.esq.altd +1;
			}else {
				raiz.alte = raiz.esq.alte +1;
			}
			raiz = balanceamento(raiz);
		}else if(dado > raiz.dado){
			raiz.dir = inserirDado(raiz.dir, dado);
			if (raiz.dir.altd > raiz.dir.alte) {
				raiz.altd = raiz.altd +1;
			}else {
				raiz.altd = raiz.dir.alte +1;
			}
			raiz = balanceamento(raiz);
		}
		return raiz;
	}
	
	private Nodo balanceamento(Nodo raiz) {
		int fb = raiz.altd - raiz.alte;
		int fbSubArv;
		if (fb == 2) {
			fbSubArv = raiz.dir.altd - raiz.dir.alte;
			if (fbSubArv >= 0) {
				raiz = rotacao_esquerda(raiz);
			}else {
				raiz.dir = rotacao_direita(raiz.dir);
				raiz = rotacao_esquerda(raiz);
			}
		}else if(fb == -2) {
			fbSubArv = raiz.esq.altd - raiz.esq.alte;
			if (fbSubArv <= 0) {
				raiz = rotacao_direita(raiz);
			}else {
				raiz.esq = rotacao_esquerda(raiz.esq);
				raiz = rotacao_direita(raiz);
			}
		}
		return raiz;
	}
	
	private Nodo rotacao_esquerda(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.dir;
		aux2 = aux1.esq;
		raiz.dir = aux2;
		aux1.esq = raiz;
		if (raiz.dir == null) {
			raiz.altd = 0;
		}else if(raiz.dir.alte > raiz.dir.altd){
			raiz.altd = raiz.dir.alte + 1;
		}else {
			raiz.altd = raiz.dir.altd +1;
		}
		if (aux1.esq.alte > aux1.esq.altd) {
			aux1.alte = aux1.esq.alte +1;
		}else {
			aux1.alte = aux1.esq.altd +1;
		}
		return aux1;
	}
	
	private Nodo rotacao_direita(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.esq;
		aux2 = aux1.dir;
		raiz.esq = aux2;
		aux1.dir = raiz;
		if (raiz.esq == null) {
			raiz.alte = 0;
		}else if (raiz.esq.alte > raiz.esq.altd) {
			raiz.alte = raiz.esq.alte +1;
		}else {
			raiz.alte = raiz.esq.altd +1;
		}
		if (aux1.dir.alte > aux1.dir.altd) {
			aux1.altd = aux1.dir.alte +1;
		}else {
			aux1.altd = aux1.dir.altd +1;
		}
		return aux1;
	}
	
	public void mostrarEmOrdem() {
		mostrandoOrdenado(raiz);
	}
	
	private void mostrandoOrdenado(Nodo raiz) {
		if (raiz != null) {
			mostrandoOrdenado(raiz.esq);
			System.out.println(raiz.dado + " quantidade = " + raiz.qtd);
			mostrandoOrdenado(raiz.dir);
		}
	}
	
	public void remover(int chave) {
		raiz = removerItem(raiz,chave);
	}
	
	private Nodo removerItem(Nodo raiz, int chave) {
		if (raiz == null) {
			return null;
		}
		if (chave < raiz.dado) {
			raiz.esq = removerItem(raiz.esq,chave);
		}else if (chave > raiz.dado) {
			raiz.dir = removerItem(raiz.dir,chave);
		}else {
			if (raiz.qtd > 1) {
				raiz.qtd --;
				return raiz;
			}else {
				if (raiz.esq == null) {
					return raiz.dir;
				}else if(raiz.dir == null) {
					return raiz.esq;
				}else {
					Nodo sucessor = encontrarSucessor(raiz.dir);
					raiz.dado = sucessor.dado;
					raiz.dir = removerItem(raiz.dir,sucessor.dado);
				}
			}
		}
		raiz = balanceamento(raiz);
		return raiz;
	}
	
	private Nodo encontrarSucessor(Nodo nodo) {
		while (nodo.esq != null) {
			nodo = nodo.esq;
		}
		return nodo;
	}
	
	public void verificarAVL() {
		boolean aux = verifica(raiz);
		System.out.println(aux);
	}
	
	private boolean verifica(Nodo raiz) {
		if (raiz != null) {
			verifica(raiz.esq);
			if (raiz.altd - raiz.alte > 1 || raiz.altd - raiz.alte > 1) {
				return false;
			}
			verifica(raiz.dir);
		}
		return true;
	}
	
	private int contarPrimos(Nodo aux) {
	    if (aux == null) {
	        return 0;
	    }

	    int count = contarPrimos(aux.esq);
	    
	    if (isPrime(aux.dado)) {
	        count++;
	        if (aux.qtd > 1) {
				count += (aux.qtd)-1;
			}
	    }

	    count += contarPrimos(aux.dir);

	    return count;
	}

	public void contarPrimos() {
	    System.out.println(contarPrimos(raiz)); 
	}

	
	private boolean isPrime(int number) {
	    BigInteger bigInt = BigInteger.valueOf(number);
	    return bigInt.isProbablePrime(100);
	}
	
	private void mostrarNodosNoNivel(Nodo aux, int nivelAlvo, int nivelAtual) {
	    if (aux == null) {
	        return;
	    }

	    if (nivelAtual == nivelAlvo) {
	    	System.out.println(aux.dado + " quantidade = " + aux.qtd);
	    }

	    mostrarNodosNoNivel(aux.esq, nivelAlvo, nivelAtual + 1);
	    mostrarNodosNoNivel(aux.dir, nivelAlvo, nivelAtual + 1);
	}

	public void mostrarNivel(int nivelAlvo) {
	    mostrarNodosNoNivel(raiz, nivelAlvo, 0);
	}
	
	public void mostrarNivelImpar() {
	    mostrarNodosNoNivelImpar(raiz, 0);
	}
	
	private void mostrarNodosNoNivelImpar(Nodo aux, int nivelAtual) {
	    if (aux == null) {
	        return;
	    }

	    if (nivelAtual % 2 != 0) {
	    	System.out.println(aux.dado + " quantidade = " + aux.qtd);
	    }

	    mostrarNodosNoNivelImpar(aux.esq, nivelAtual + 1);
	    mostrarNodosNoNivelImpar(aux.dir, nivelAtual + 1);
	}
	

	    public boolean buscar(int chave) {
	        return buscarElemento(raiz, chave);
	    }

	    private boolean buscarElemento(Nodo raiz, int chave) {
	        if (raiz == null) {
	            return false;
	        }

	        if (chave == raiz.dado) {
	            return true;
	        } else if (chave < raiz.dado) {
	            return buscarElemento(raiz.esq, chave);
	        } else {
	            return buscarElemento(raiz.dir, chave);
	        }
	    }

}
