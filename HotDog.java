public class HotDog extends Personaje{
    int ataqueE=10;
    public class HotDog(){
        super("Hot Dog",50,5,1);
    }
    public void atacar(Taco taco){
        int x= Math.round(Math.random()*10);
        if(x==3){
            System.out.println("Ataque especial de Hot Dog");
            taco.setHp(taco.getHp()-(ataqueE-taco.getDefensa()));
        }else{
            System.out.println("Ataque normal de Hot Dog");
            enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
        }
    }
}