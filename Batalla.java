import java.util.Scanner;
public class Batalla{

	public static void iniciarBatalla(Taco p1, Personaje p2){
		while(p1.getHp()>0&&p2.getHp()>0){
			System.out.println("Como quieres atacar? 1) Normal 2) Condimento 3) Ataque Especial");
			Scanner sc= new Scanner(System.in);
			switch(sc.nextInt()){
				case 1: 
					p1.atacar(p2);
					break;
				case 2:
					System.out.print("Con que habilidad quieres atacar? ");
					for(int i=0;i<p1.getHabilidades().length;i++){
						System.out.print((i+1)+" "+p1.getHabilidades()[i].getNombre()+" ["+p1.getHabilidades()[i].getPuntosEspeciales()+"] ");
					}
					System.out.println("");
					p1.atacar(p2,p1.getHabilidades()[sc.nextInt()-1]);
					break;
				case 3:
					System.out.print("Con que objeto quieres atacar? ");
					for(int i=0;i<p1.getMorral().length;i++){
						if(p1.getMorral()[i]!=null){
							System.out.print((i+1)+" "+p1.getMorral()[i].getNombre()+" ["+p1.getMorral()[i].getPuntos()+"] ");
						}else{
							System.out.print((i+1)+" Vacio " );

						}
					}
					int opcionElegida=sc.nextInt();
					if(p1.getMorral()[opcionElegida-1].getClass()==Arma.class)
						p1.atacar(p2,p1.getMochila()[opcionElegida-1]);
					else
						System.out.println("Este objeto no es para atacar");
					break;	

			}

			p2.atacar(p1);

			System.out.println(p1.toString());
			System.out.println(p2.toString());

		}
	}


}