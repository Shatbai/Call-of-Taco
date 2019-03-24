import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Taco taquito;
        Boss b;
        Personaje secuaz1;
        Personaje secuaz2;
        Personaje secuaz3;
        int batalla=0;
        System.out.println("¿Qué taco quieres ser:? 1)Suadero 2)Pastor 3)Choriqueso");
        Scanner sc= new Scanner(System.in);
        switch(sc.nextInt()){
            case 1:
             taquito=new TacoSuadero();
             break;
            case 2:
                taquito=new TacoPastor();
             break;
            case 3:
                taquito=new TacoChoriqueso();
             break;
            default:
                taquito=null;
                System.out.println("Elige una opción valida!!");
                break;           
        }
        while(batalla==0){
            int x=(int) Math.floor(Math.random()*4);
            switch(x){
                case 1:
                    b=new Hamburguesa();
                 break;
                case 2:
                    b=new Ensalada();
                    secuaz1=new Jitomate();
                    secuaz2=new Lechuga();
                    secuaz3=new Pepino();
                    Batalla.iniciarBatalla(taquito,secuaz1);
                    Batalla.iniciarBatalla(taquito,secuaz2);
                    Batalla.iniciarBatalla(taquito,secuaz3);
                 break;
                case 3:
                    b=new Gringa();
                    secuaz1=new Trumpito();
                    secuaz2=new Muro();
                    Batalla.iniciarBatalla(taquito,secuaz1);
                    Batalla.iniciarBatalla(taquito,secuaz2);
                 break;
                default:
                    b=new HotDog();
                 break;           
        }

            System.out.println("Comienza batalla con "+b.getTipo());
            Batalla.iniciarBatalla(taquito,b);
            System.out.println("Quieres seguir peleando? 1)SI 2)NO");
            /*En caso de elgir seguir peleando todavía no recupera su vida, 
            ya que en la versión final deberá encontrar condimentos para 
            recuperar su vida*/
            if(sc.nextInt()==2){
                batalla=1;
            }
        }
    }
}