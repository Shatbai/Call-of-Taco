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

public class Mapa2 extends Scene {
    private GridPane m1= new GridPane();
    private Button c;
    private Button perso= new Button();
    private Button vacio;
    private Button [][] casilla= new Button[10][10];
    private Main main;
    private int i;
    private int j;
    private Taco taquito;
    private String nom;
    private Button seguir;


    public Mapa2(Taco taquito, Main main){

       super(new GridPane(),900,900);
       this.main=main;
       this.taquito=taquito;
       nom=taquito.getTipo();
       switch (nom){
            case "Suadero":
                perso.setStyle("-fx-background-image:url('assets/tacos.jpg');");break;
            case "Pastor":
                perso.setStyle("-fx-background-image:url('assets/tacop.jpg');");break;
            default:
                perso.setStyle("-fx-background-image:url('assets/tacoch.jpg');");break;
                            }
       perso.setPrefSize(90,90);
       pintar();
       i=0;
       j=0;
        
        
        super.setRoot(m1);
    }
    public void pintar(){
        for(int a=0;a<10;a++){
            for(int b=0;b<10;b++){
                c =new Button();
                c.setPrefSize(90, 90);
                if(a==0&&b==0){
                   
                        casilla[a][b]=perso;
                }else{
                    casilla[a][b]=c;
                    
                }
                m1.add(casilla[a][b],a,b);
                moverse(casilla[a][b]);
                
            }
        }
    }
    public void moverse(Button m){
       
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
    
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Choco con pared");
                    if(i==10){
                        i--;
                    }
                    if(i==-1){
                        i++;
                    }if(j==10){
                        j--;
                    }if(j==-1){
                        j++;
                    }
                }
            }
        }); 
    }  
}