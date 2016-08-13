/* 115210412 - Igor Dantas Lucena: LAB 3 - Turma 3 */
public class Estoque {
	private Produto[] arrayProdutos;
	private final String FIM_DE_LINHA;

	public Estoque() {
		arrayProdutos = new Produto[0];
		FIM_DE_LINHA = System.lineSeparator();
	}

	public void aumentaArrayProduto() { // aumenta o tamanho do estoque 
											//de acordo com a adição de cada produto
		Produto[] arrayAux = new Produto[(arrayProdutos.length) + 1];
		for (int i = 0; i < arrayProdutos.length; i++) {
			arrayAux[i] = arrayProdutos[i];
		}
		arrayProdutos = arrayAux;
	}

	public double calculaValorEstoque() { // calcula o valor do estoque
		double resultado = 0.0;
		if (arrayProdutos.length >= 1) {
			for (int i = 0; i < arrayProdutos.length; i++) {
				Produto produto = arrayProdutos[i];
				if (produto != null) {
					resultado += (produto.getPreco() * produto.getqntNoEstoque());
				}
			}

			return resultado;
		}
		return resultado;
	}

	public void diminuiEstoque(int qntVenda, Produto produto) { // retia a quantidade vendida do estoque
		produto.setqntNoEstoque(produto.getqntNoEstoque() - qntVenda);
	}

	public void adicionaEstoque(int qntAdiciona, Produto produto) { // adiciona uma quantidade desejada no estoque
		produto.setqntNoEstoque(produto.getqntNoEstoque() + qntAdiciona);
	}

	public void append(Produto produto) { // adiciona o produto no ultimo espaço do estoque
		arrayProdutos[arrayProdutos.length - 1] = produto;
	}

	public int verificaProduto(String nomeProduto) { // verifica a existencia do produto no estoque
		for (int i = 0; i < arrayProdutos.length; i++) {
			Produto produto = arrayProdutos[i];
			if (produto != null) {
				if (((produto.getNome()).equals(nomeProduto))) {
					return i;
				}
			}

		}
		return -1;

	}

	public boolean verificaEstoque(int qntVenda) { // verifica a quantidade do produto no estoque
		for (int i = 0; i < arrayProdutos.length; i++) {
			Produto produto = arrayProdutos[i];
			if (produto.getqntNoEstoque() >= qntVenda && qntVenda > 0) {
				return true;
			}
		}
		return false;
	}

	public String fazBalanco() { // retorna a string do balanço do estoque
		String resultado = "";

		if (arrayProdutos.length > 1) {
			for (int i = 0; i < arrayProdutos.length; i++) {
				Produto produto = arrayProdutos[i];
				if (produto != null) {
					resultado += i + 1 + ") " + produto.getNome() + " (" + produto.getTipo() + "). R$ "
							+ produto.getPreco() + " Restam: " + produto.getqntNoEstoque() + FIM_DE_LINHA;
				}
			}
		} else if (arrayProdutos.length == 1) {
			Produto produto = arrayProdutos[0];
			if (produto != null) {
				resultado += 1 + ") " + produto.getNome() + " (" + produto.getTipo() + "). R$ " + produto.getPreco()
						+ " Restam: " + produto.getqntNoEstoque() + FIM_DE_LINHA;
				return resultado;
			}
		}
		return "Nao ha produto cadastrado.";

	}

	public Produto retornaProduto(int indice) { // retorna produto desejado
		return arrayProdutos[indice];
	}

	public double retornaPrecoProduto(int indice) { // retorna o preço do
														//produto desejado
		return arrayProdutos[indice].getPreco();
	}
}