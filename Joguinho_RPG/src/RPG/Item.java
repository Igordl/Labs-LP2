package RPG;

public class Item {
	private String nome;
	private double peso;
	private int efeito;
	private String tipo;
	
	public Item(String nome, double peso, int efeito, String tipo) throws Exception{
		vefificaNomeInvalido(nome);
		verificaPesoInvalido(peso);
		verificaEfeitoInvalido(efeito);
		verificaTipoInvalido(tipo);
		this.nome = nome;
		this.peso = peso;
		this.efeito = efeito;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEfeito() {
		return efeito;
	}

	public void setEfeito(int efeito) {
		this.efeito = efeito;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	private void verificaTipoInvalido(String tipo) throws Exception {
		if(tipo == null || tipo.trim().equalsIgnoreCase("")){
			throw new Exception("Tipo nao eh valido.");
		}
	}

	private void verificaEfeitoInvalido(int efeito) throws Exception {
		if(efeito <= 0){
			throw new Exception("Efeito nao eh valido.");
		}
	}

	private void verificaPesoInvalido(double peso) throws Exception {
		if(peso <= 0){
			throw new Exception("Pesoda mochila eh invalido.");
		}
	}

	private void vefificaNomeInvalido(String nome) throws Exception {
		if(nome == null || nome.trim().equalsIgnoreCase("")){
			throw new Exception("Nome nao eh valido.");
		}
	}	
	
}
