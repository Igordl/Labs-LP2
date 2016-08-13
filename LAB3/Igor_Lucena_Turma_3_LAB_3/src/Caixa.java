
/* 115210412 - Igor Dantas Lucena: LAB 3 - Turma 3 */
import java.util.Scanner;

public class Caixa {
	private Scanner entrada;
	private final String FIM_DE_LINHA;
	private Estoque estoque;
	private double valorTotal;
	private int qntProd;

	public Caixa() {
		entrada = new Scanner(System.in);
		FIM_DE_LINHA = System.lineSeparator();
		estoque = new Estoque();
	}

	public void cadastraProduto() {
		String resposta = "nao";
		System.out.println("= = = = Cadastro de Produtos = = = =");
		do {

			System.out.println();
			System.out.print("Digite o nome do produto: ");
			String nome = entrada.nextLine();

			int verificaNome = estoque.verificaProduto(nome);	 // Verifica se há  esse produto
											 					// no estoque se ja existir
																// esse  produto no 
																// estoque entra nessa condição
			if (verificaNome != -1 && !nome.equalsIgnoreCase("")) {													

				Produto produto = estoque.retornaProduto(verificaNome);
				System.out.println("Produto ja cadastrado");
				System.out.print("digite a quantidade que quer aumentar no estoque: ");
				qntProd = entrada.nextInt();
				entrada.nextLine();
				if (qntProd > 0) { // Verifica se a quantidade que deseja
									// adicionar no estoque é valida
					estoque.adicionaEstoque(qntProd, produto);
					System.out.println("==> " + produto.toString());
				} else {
					System.out.printf("Nao eh possivel cadastrar %s %s", nome, FIM_DE_LINHA);
				}

			} else if (verificaNome == -1 && !nome.equalsIgnoreCase("")) { // se não houver o mesmo produto
																			// cadastrado no sistema
																			 //entra nessa condição
																			
				estoque.aumentaArrayProduto();
				System.out.print("Digite o preco unitario do produto: ");
				double preco = entrada.nextDouble();
				entrada.nextLine();
				if (preco > 0) { // verifica se o preço do produto é valido

					System.out.print("Digite o tipo do produto: ");
					String tipo = entrada.nextLine();
					if (!tipo.equalsIgnoreCase("")) { // verifica se o tipo do
														// produto não é uma
														// string vazia
						System.out.print("Digite a quantidade no estoque: ");
						int qntEstoque = entrada.nextInt();
						entrada.nextLine();
						if (qntEstoque > 0) { // verifica se a quantidade que
												// quer adicionar no estoque é
												// valida

							Produto produto = new Produto(nome, preco, tipo, qntEstoque); // cria
																							// o
																							// produto

							estoque.append(produto); // adiciona o produto no
														// estoque

							System.out.println();
							System.out.println(qntEstoque + " " + nome + "(s) cadastrado(s) com sucesso.");
						} else {
							System.out.printf("Nao eh possivel cadastrar %s %s", nome, FIM_DE_LINHA);
						}
					} else {
						System.out.printf("Nao eh possivel cadastrar %s %s", nome, FIM_DE_LINHA);
					}
				} else {
					System.out.printf("Nao eh possivel cadastrar %s %s", nome, FIM_DE_LINHA);
				}
			} else {
				System.out.printf("Nao eh possivel cadastrar %s %s", nome, FIM_DE_LINHA);
			}

			System.out.println();
			System.out.print("Deseja cadastrar outro produto? ");
			resposta = entrada.nextLine();

		} while (resposta.equalsIgnoreCase("Sim"));

	}

	public void vendeProduto() {
		qntProd = 0;
		valorTotal = 0.0;
		String resposta = null;
		System.out.println("= = = = Venda de Produtos = = = =");
		do {

			System.out.print("Digite o nome do produto: ");
			String nomeProduto = entrada.nextLine();
			int verificaNome = estoque.verificaProduto(nomeProduto);
			if (verificaNome != -1) { // verifica se existe o produto no estoque
				Produto produto = estoque.retornaProduto(verificaNome);
				System.out.println("==> " + produto.toString());

				System.out.println();
				System.out.print("Digite a quantidade que deseja vender: ");
				qntProd = entrada.nextInt();
				System.out.println();
				if (estoque.verificaEstoque(qntProd)) { // verifica a quantidade
														// do produto no estoque
					estoque.diminuiEstoque(qntProd, produto);

					valorTotal += qntProd * estoque.retornaPrecoProduto(verificaNome);
					System.out.printf("==> Total arrecadado: R$ %.2f %s", valorTotal, FIM_DE_LINHA);

				} else if (!estoque.verificaEstoque(qntProd)) {
					System.out.println("Nao eh possivel vender pois nao ha " + nomeProduto + " suficiente");
				}
			} else {
				System.out.println("==> " + nomeProduto + " nao cadastrado no sistema");
			}
			System.out.print("Deseja vender outro produto? ");
			resposta = entrada.next();
			entrada.nextLine();
		} while (resposta.equalsIgnoreCase("sim"));
	}

	public void imprimeBalanco() {
		System.out.println("= = = = Impressao de Balanco = = = =");
		System.out.println("Produtos cadastrados: ");
		System.out.println();

		System.out.println(estoque.fazBalanco()); // retorna o balanco do
													// estoque

		System.out.println();
		System.out.printf("Total arrecadado em vendas: R$ %.2f %s", valorTotal, FIM_DE_LINHA);

		System.out.printf("Total que pode ser arrecadado: R$ %.2f %s", (estoque.calculaValorEstoque()), FIM_DE_LINHA);
		System.out.println();
	}

}
