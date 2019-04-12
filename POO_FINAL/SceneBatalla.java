import java.util.Scanner;
import javafx.scene.control.TextField;
import javafx.stage.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;

public class SceneBatalla extends Scene{
    private Main main;
    private BorderPane bp=new BorderPane();
    private Label l3= new Label("");
    private Label l4;
    private VBox vb= new VBox();
    private Taco t;
    private Personaje p;
    private HBox hb= new HBox();
    private Label fin= new Label("GANASTE");
    private TextField tf;
    private int op;
    public SceneBatalla(Taco t, Personaje p, Main main){
        super (new BorderPane(),900,900);
        this.main=main;
        this.t=t;
        this.p=p;
        VBox vb = new VBox();
        Label titulo= new Label("COMIENZA LA BATALLA");
        titulo.setStyle("-fx-background-color:black;");
        titulo.setPrefSize(900,50);
        inicio();
        Label l2=t.getImg();
        Label l5= new Label("");
        Label l6= new Label("VS");
        l5.setStyle("-fx-background-image:url('assets/hamb.jpeg');");
        l5.setPrefSize(500,300);       
		vb.getChildren().addAll(l2,l6,l5);
        bp.setCenter(hb);
        bp.setLeft(vb);
        bp.setTop(titulo);
        super.setRoot(bp);
    }
    public void golpear(String o){
        switch(o){
			case "1": 
				t.atacar(p);
                imprimirVida();
			break;
			case "2":
				l3.setText("Con que habilidad quieres atacar? ");
                vb.getChildren().add(l3);
				for(int i=0;i<t.getespeciales().length;i++){
					l4= new Label((i+1)+" "+t.getespeciales()[i].getNombre()+" ["+t.getespeciales()[i].getPuntosEspeciales()+"] ");
                    vb.getChildren().add(l4);
				}
                tf=new TextField();
                vb.getChildren().add(tf);
                bp.setCenter(vb);
                setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(ke.getCode() == KeyCode.ENTER) {                                               
                    op= Integer.parseInt(tf.getText());
			            t.atacar(p,t.getespeciales()[op-1]);
                        imprimirVida();
                }   
            }
        });
				break;
			case "3":
				l3.setText("Con que objeto quieres atacar? ");
                vb.getChildren().add(l3);
				for(int i=0;i<t.getMorral().length;i++){
					if(t.getMorral()[i]!=null){
						l4= new Label((i+1)+" "+t.getMorral()[i].getNombre()+" ["+t.getMorral()[i].getPuntos()+"] ");
                        vb.getChildren().add(l4);
					}else{
						l4= new Label((i+1)+" Vacio " );
                        vb.getChildren().add(l4);
					}
				}
                tf=new TextField();
                vb.getChildren().add(tf);
                bp.setCenter(vb);
                setOnKeyPressed(new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent ke) {
                        if(ke.getCode() == KeyCode.ENTER) {                                               
                            op= Integer.parseInt(tf.getText());
			                t.atacar(p,t.getMorral()[op-1],(op-1));
                            imprimirVida();
                        }   
                    }
                });
				break;	
			default:
				l3.setText("Pierdes tu turno");

		}
            
            
    }
    public void inicio(){
        Label l1= new Label("Como quieres atacar? 1) Normal 2) Ataque Especial 3) Condimentos");
        TextField atacar= new TextField();
		hb.getChildren().addAll(l1,atacar);
        vb.getChildren().add(hb);
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(ke.getCode() == KeyCode.ENTER) {                
                    String opcion= (String) atacar.getText();
                    golpear(opcion);
                }
            }
        });
    }
    public void imprimirVida(){
        Label vida = new Label(t.toString());
        Label vidae = new Label(p.toString());
        vb.getChildren().addAll(vida, vidae);
        bp.setCenter(vb);
        
        if(p.getHp()>0&&t.getHp()>0){
            inicio();}else if(p.getHp()<=0){
            vb.getChildren().add(fin);
            bp.setCenter(vb);
            setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                    if(ke.getCode() == KeyCode.ENTER) {                                               
                        main.setScene3();
                    }   
                }
            });
            }else if(t.getHp()<=0){fin.setText("PERDISTE");
            vb.getChildren().add(fin);
            bp.setCenter(vb);
            t.setHp(100);
			//p.setHp(vida);
            //SceneBatalla(t,p,main);}
            }
    }   
}