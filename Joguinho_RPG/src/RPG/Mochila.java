package RPG;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
	private List<Item> itens;
	private double peso;

	public Mochila(double peso) throws Exception {
		verificaPesoInvalido(peso);
		this.peso = peso;
		itens = new ArrayList<Item>();
	}

	public double capacidadeRestante() {
		double pesoItens = 0.0;
		for (Item item : itens) {
			pesoItens += item.getPeso();
		}
		return (peso - pesoItens);
	}

	public boolean criaEAddItem(String nome, double peso, int efeito, String tipo) throws Exception {
		if (capacidadeRestante() >= peso) {
			Item item = new Item(nome, peso, efeito, tipo);
			addItem(item);
			return true;
		}
		return false;
	}
	public int efeitoAtaque(){
		int ataque = 0;
		for (Item item : itens) {
			if(item.getTipo().equalsIgnoreCase("arma")){
				ataque += item.getEfeito();
			}
		}
		return ataque;
	}
	public int efeitoCura(){
		int cura = 0;
		for (Item item : itens) {
			if(item.getTipo().equalsIgnoreCase("pocao")){
				cura += item.getEfeito();
			}
		}
		return cura;
		
	}
	private void addItem(Item item) {
		itens.add(item);
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	private void verificaPesoInvalido(double peso) throws Exception {
		if (peso <= 0) {
			throw new Exception("Pesoda mochila eh invalido.");
		}
	}
}
