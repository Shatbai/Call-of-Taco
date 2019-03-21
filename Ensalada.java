public class Ensalada extends Personaje{
    public class Ensalada(){
        super("Ensalda",250,7,15);
    }
    public void atacar(Taco taco){
        int x= Math.round(Math.random()*10);
        if(x==3){
            System.out.println("Ataque especial de Ensalada");
            taco.setHp(taco.getHp()-(ataqueE-taco.getDefensa()));
        }else{
            System.out.println("Ataque normal de Ensalada");
            enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
        }
    }

}