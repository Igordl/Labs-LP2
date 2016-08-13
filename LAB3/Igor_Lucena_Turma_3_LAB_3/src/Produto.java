/* 115210412 - Igor Dantas Lucena: LAB 3 - Turma 3 */
public class Produto {

	private String nome;
	private double preco;
	private String tipo;
	private int qntNoEstoque;

	public Produto(String nome, double preco, String tipo, int estoque) {

		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.qntNoEstoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public String getTipo() {
		return tipo;
	}

	public int getqntNoEstoque() {
		return qntNoEstoque;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setqntNoEstoque(int estoque) {
		this.qntNoEstoque = estoque;
	}

	@Override
	public String toString() {

		String precoProduto = String.format("%.2f", preco);

		String infoProduto = nome + "(" + tipo + "). R$ " + precoProduto;

		return infoProduto;
	}

}
