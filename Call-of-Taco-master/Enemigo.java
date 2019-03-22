public class Enemigo extends Personaje{
	private int ataqueE=0;
    public Enemigo(String nombre, int hp, int energia, int ataque, int defensa,int ataqueE){
		super(nombre,hp,energia,ataque,defensa);
        this.ataqueE=ataqueE;
	}
    public void atacar(Taco taco){
        int x=(int) Math.floor(Math.random()*10);
        if(x==3){
            System.out.println("Ataque especial de Hamburguesa");
            taco.setHp(taco.getHp()-(ataqueE-taco.getDefensa()));
        }else{
            System.out.println("Ataque normal de Hamburguesaa");
            taco.setHp(taco.getHp()-(getAtaque()-taco.getDefensa()));
        }
    }
    public void atacar(Personaje enemigo){
		enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
	}
}