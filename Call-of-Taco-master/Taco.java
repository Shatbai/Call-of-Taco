public abstract class Taco extends Personaje{
	
	private AtaqueEspecial[] especiales;
	private Condimentos[] morral;
	String nombre="Tlaxcalli";


	public Taco(String tipo, int hp, int energia, int defensa, int ataque){
		super(tipo, hp, energia, defensa, ataque);
		morral= new Condimentos[10];
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

	public void atacar(Personaje enemigo, Condimentos condimento){
		enemigo.setHp(enemigo.getHp()-(condimento.getPuntos()-enemigo.getDefensa()));
	}
	public void atacar(Personaje enemigo, AtaqueEspecial AE){
		enemigo.setHp(enemigo.getHp()-(AE.getPuntosEspeciales()-enemigo.getDefensa()));
	}
}

