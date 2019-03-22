import java.util.Scanner;
public abstract class Taco extends Personaje{
	
	private AtaqueEspecial[] especiales;
	private Condimentos[] morral;
	String nombre="Tlaxcalli";
	private int golpeF;


	public Taco(String tipo, int hp, int energia, int defensa, int ataque,int golpeF){
		super(tipo, hp, energia, defensa, ataque);
		morral= new Condimentos[10];
		this.golpeF=golpeF;
	}
	

	public AtaqueEspecial[] getespeciales(){
		return especiales;
	}

	public void setAtaqueEspecial(AtaqueEspecial[] especiales){
		this.especiales=especiales;
	}

	public Condimentos[] getMorral(){
		return morral;
	}

	public void addCondimentotoMorral(Condimentos c, int index){
		morral[index]=c;
	}

	public String dameInventario(){
		String resultado="Mochila: [";
		for(int i=0; i<morral.length; i++){
			if(morral[i]!=null){
				resultado=resultado+" Condimento: "+morral[i].getNombre()+" puntos: "+morral[i].getPuntos()+",";
			}
			else{
				resultado=resultado+"Vacío, ";
			}
		}

		resultado=resultado+"]";
		return resultado;
	}


	public String verMiAtaqueEspecial(){
		String resultado="Ataques Especiales: [";
		for(int i=0;i<especiales.length;i++){

			resultado= resultado+" Ataque Especial: "
				+especiales[i].getNombre()
				+" puntos: "+ especiales[i].getPuntosEspeciales()+",";				

		}
		resultado= resultado+"]";
		return resultado;
	}
	public void atacar(Personaje enemigo){
		System.out.println("1)GOLPE NOMAL 2)GOLPE FUERTE");
		Scanner sc= new Scanner(System.in);
		int golpe=sc.nextInt();
		switch(golpe){
			case 1:
			enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
			break;
			case 2:
			enemigo.setHp(enemigo.getHp()-(golpeF-enemigo.getDefensa())); 
		}
		
	}
	public void atacar(Personaje enemigo, Condimentos condimento){
		enemigo.setHp(enemigo.getHp()-(condimento.getPuntos()-enemigo.getDefensa()));
	}
	public void atacar(Personaje enemigo, AtaqueEspecial AE){
		enemigo.setHp(enemigo.getHp()-(AE.getPuntosEspeciales()-enemigo.getDefensa()));
	}
}

