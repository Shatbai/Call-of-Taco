public class Hamburguesa extends Personaje{
    int ataqueE=5;
    public Hamburguesa(){
        super("Hamburguesa",150,2,0);
    }
    public void atacar(Taco taco){
        int x= Math.round(Math.random()*10);
        if(x==3){
            System.out.println("Ataque especial de Hamburguesa");
            taco.setHp(taco.getHp()-(ataqueE-taco.getDefensa()));
        }else{
            System.out.println("Ataque normal de Hamburguesaa");
            enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
        }
    }


}