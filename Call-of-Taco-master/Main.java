import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Taco taquito;
        System.out.println("¿Qué taco quieres ser:? 1)Suadero 2)Pastor 3)Choriqueso");
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();
        switch(x){
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
        Enemigo e=new Hamburguesa();
        Batalla.iniciarBatalla(taquito,e);
    }
}