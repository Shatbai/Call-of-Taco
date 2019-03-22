public class Personaje{

	private int Hp;
	private String tipo;
	private int Ataque;
	private int Defensa;
	private int energia;

	public Personaje(String tipo, int Hp,int Ataque,int Defensa, int energia){
		this.tipo=tipo;
		this.Hp=Hp;
		this.Ataque=Ataque;
		this.Defensa=Defensa;
		this.energia=energia;
	}
	
	public void setTipo(String nombre){
		this.tipo=tipo;
	}

	public String getTipo(){
		return tipo;
	}

	public void setHp(int Hp){
		this.Hp=Hp;
	}

	public int getHp(){
		return Hp;
	}

	public void setAtaque(int Ataque){
		this.Ataque=Ataque;
	}

	public int getAtaque(){
		return Ataque;
	}

	public void setDefensa(int Defensa){
		this.Defensa=Defensa;
	}
	public int getDefensa(){
		return Defensa;
	}

	public void atacar(Personaje malo){

	}

	public void defender(Personaje m){
		
	}
	

}