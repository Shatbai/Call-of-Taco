
public class TacoSuadero extends Taco{
    public TacoSuadero(){
        super("Suadero", 100,5,15,25);
        AtaqueEspecial[] especial=new AtaqueEspecial[4];
        especial[0]=new AtaqueEspecial("Carne de dudosa procedencia",40);
        especial[1]=new AtaqueEspecial("tomatazo",30);
        especial[2]=new AtaqueEspecial("",25);
        especial[3]=new AtaqueEspecial("Aceite hirviendo",20);

        super.setAtaqueEspecial(especial);
    }
    

   public void atack(Personaje enemigo){
   	System.out.println("Ataque de Tlaxcalli Pastor");
   	enemigo.setHp(enemigo.getHp()-(getAtaque()-enemigo.getDefensa()));
   }
 }
   
