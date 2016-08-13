
/* 115210412 - Igor Dantas Lucena: LAB 3 - Turma 3 */
import java.util.Scanner;

public class MenuPrincipal {

	public static int opcao = 0;
	public static final int CADASTRA = 1;
	public static final int VENDE = 2;
	public static final int BALANCO = 3;
	public static final int SAIR = 4;
	static Caixa caixa = new Caixa();
	public static Scanner entrada = new Scanner(System.in);

	public static void main(String[] Args) {
		do {
			System.out.println("= = = = Bem vindo(a) ao EconomizaP2 = = = = ");
			System.out.println("Digite a opcao desejada: ");
			System.out.println();
			System.out.println("1 - Cadastrar um Produto ");
			System.out.println("2 - Vender um Produto ");
			System.out.println("3 - Imprimir Balanco ");
			System.out.println("4 - Sair");
			System.out.println();
			System.out.print("Opcao: ");

			opcao = entrada.nextInt();

			if (opcao == CADASTRA) {
				caixa.cadastraProduto();
			} else if (opcao == VENDE) {
				caixa.vendeProduto();
			} else if (opcao == BALANCO) {
				caixa.imprimeBalanco();
			}
		} while (opcao != SAIR);

	}
}
