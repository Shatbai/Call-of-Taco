public class Personaje{

	private int Hp;
	private String tipo;
	private int Ataque;
	private int Defensa;
	private int energia;

	public Personaje(String tipo, int hp,int ataque,int defensa, int energia){
		this.tipo=tipo;
		this.hp=hp;
		this.ataque=ataque;
		this.defensa=defensa;
		this.energia=energia;
	}
	
	public void setTipo(String nombre){
		this.tipo=tipo;
	}

	public String getTipo(){
		return tipo;
	}

	public void setHp(int hp){
		this.hp=hp;
	}

	public int getHp(){
		return hp;
	}

	public void setAtaque(int ataque){
		this.ataque=ataque;
	}

	public int getAtaque(){
		return ataque;
	}

	public void setDefensa(int defensa){
		this.defensa=defensa;
	}
	public int getDefensa(){
		return defensa;
	}

	public void atacar(Personaje malo){

	}

	public void defender(Personaje m){
		
	}

}
