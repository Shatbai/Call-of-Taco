import java.util.Optional;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class MapaPlan extends Scene {
    private GridPane m1= new GridPane();
    private Button c;
    private Button perso= new Button();
    private Button vacio;
    private Button [][] casilla= new Button[10][10];
    private Main main;
    private int i,j,b1,b2,a1,a2,d1,d2;
    private Taco taquito;
    private String nom;
    private Button seguir;
    private int m=0;
    private Personaje secuaz; 
    private Boss boss;


    public MapaPlan(Taco taquito, Main main,int b1, int b2, int a1, int a2, int d1, int d2, int i, int j, Personaje secuaz, Boss boss){

       super(new GridPane(),900,900);
       this.main=main;
       this.taquito=taquito;
       this.b1=b1;
       this.b2=b2;
       this.a1=a1;
       this.a2=a2;
       this.d1=d1;
       this.d2=d2;
       this.i=i;
       this.j=j;
       this.secuaz=secuaz;
       this.boss=boss;
       nom=taquito.getTipo();
       switch (nom){
            case "Suadero":
                perso.setStyle("-fx-background-image:url('assets/tacos.jpg');");break;
            case "Pastor":
                perso.setStyle("-fx-background-image:url('assets/tacop.jpg');");break;
            default:
                perso.setStyle("-fx-background-image:url('assets/tacoch.jpg');");break;
                            }
       perso.setText(nom);
       perso.setPrefSize(90,90);
       pintar(); 
        
        super.setRoot(m1);
    }
    public void pintar(){
        for(int a=0;a<10;a++){
            for(int b=0;b<10;b++){
                c =new Button(" ");
                c.setPrefSize(90, 90);
                if(a==0&&b==0){
                   
                        casilla[a][b]=perso;
                }else{
                    casilla[a][b]=c;
                    
                }
                m1.add(casilla[a][b],a,b);
                moverse(casilla[a][b],b1,b2,a1,a2,d1,d2);
                
            }
        }
    }
    public void moverse(Button m, int b1, int b2, int a1, int a2, int d1, int d2){       
        m.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                try{
                    switch (ke.getCode()) { 
                        case UP: j--;  
                            casilla[i][j+1].setStyle("-fx-background-image:none;");
                            casilla[i][j+1].setText(" ");break;
                        case RIGHT: 
                            if(i==9&&j==9){main.setScene4();}else{i++;
                            casilla[i-1][j].setStyle("-fx-background-image:none;");
                            casilla[i-1][j].setText(" ");}break; 
                        case DOWN:  j++;
                            casilla[i][j-1].setStyle("-fx-background-image:none;");
                            casilla[i][j-1].setText(" ");break;  
                        case LEFT:  i--;
                            casilla[i+1][j].setStyle("-fx-background-image:none;");
                            casilla[i+1][j].setText(" ");break;
                            }
                    switch (nom){
                        case "Suadero":
                            casilla[i][j].setStyle("-fx-background-image:url('assets/tacos.jpg');");break;
                        case "Pastor":
                            casilla[i][j].setStyle("-fx-background-image:url('assets/tacop.jpg');");break;
                        default:
                            casilla[i][j].setStyle("-fx-background-image:url('assets/tacoch.jpg');");break;
                    }
                    casilla[i][j].setText(nom);
                    if((i==b1)&&(j==b2)){             
                        main.pelear(secuaz);
                    }
                    if((i==a1)&&(j==a2)){
                        Arma();
                    }
                    if((i==d1)&&(j==d2)){
                        Defensa();
                    }
    
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Choco con pared");
                    if(i>=10){i=9;}
                    if(i<=-1){i=0;}
                    if(j>=10){j=9;}
                    if(j<=-1){j=0;}
                    casilla[i][j].setStyle("-fx-background-image:url('assets/tacos.jpg');");
                }
            }
        }); 
    }  
    public abstract void Arma();
    public abstract void Defensa();
}