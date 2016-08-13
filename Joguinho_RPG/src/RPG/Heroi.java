package RPG;

public class Heroi {
	private String nome;
	private int hp;
	private Mochila mochila;

	public Heroi(String nome, double pesoMochila) throws Exception {
		verificaNomeInvalido(nome);
		verificaPesoInvalido(pesoMochila);
		this.nome = nome;
		this.hp = 100;
		mochila = new Mochila(pesoMochila);
	}

	private void verificaNomeInvalido(String nome) throws Exception {
		if(nome == null || nome.trim().equalsIgnoreCase("")){
			throw new Exception("Nome nao eh valido.");
		}
	}

	public int getHP() {
		System.out.println(hp);
		return hp;
	}

	public void setHP(int novoHP) {
		System.out.println(hp);
		this.hp = novoHP;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		verificaNomeInvalido(nome);
		this.nome = nome;
	}

	public Mochila getMochila() {
		return mochila;
	}

	public void setMochila(Mochila mochila) {
		this.mochila = mochila;
	}

	private void verificaPesoInvalido(double pesoMochila) throws Exception {
		if (pesoMochila <= 0) {
			throw new Exception("Peso da Mochila é invalido");
		}
	}

	public boolean criaItem(String nome, double peso, int efeito, String tipo) throws Exception {
		return mochila.criaEAddItem(nome, peso, efeito, tipo);

	}

	public String ataca(Heroi heroi) {
		heroi.setHP(heroi.getHP() - this.mochila.efeitoAtaque());

		int hpHeroi = heroi.getHP();
		
		if (hpHeroi < -10) {
			return heroi.getNome() + " desmaiou sem chances de voltar com pocao.";
		} else if (hpHeroi >= -10 && hpHeroi <= 0) {
			return heroi.getNome() + " desmaiou, mas ainda pode ser curado.";
		}
		
		return heroi.getNome() + " ainda tem " + heroi.getHP() + " de vida.";

	}

	public boolean cura() {
		if (hp >= -10) {
			this.setHP(this.hp + mochila.efeitoCura());
			return true;
		}
		return false;
	}
}