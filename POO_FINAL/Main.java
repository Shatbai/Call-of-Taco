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
public class Main extends Application{
    private Scene intro = new Intro(this);
    private Scene perso= new Persona(this);
    private Scene mapa;
    private Scene mapa_2;
    private Stage mainStage;
    private Taco taquito;
    private SceneBatalla b;

    public static void main(String[]args){
        launch(args);
    }
    public void start(Stage primaryStage){
        mainStage=primaryStage;
        mainStage.setTitle("CALL OF TACO");
        mainStage.setScene(intro);
        intro.getStylesheets().add("Styles.css");
        mainStage.show();
    }
    public void setScene2(){
        mainStage.setScene(perso);
    }
    public void setScene3(){
        Personaje secuaz= new Jitomate(); 
        Boss boss= new Ensalada();
        mapa = new Mapa(taquito, this,0,0,secuaz,boss);
        mainStage.setScene(mapa);
    }
    public void setScene4(){
        Personaje secuaz= new Trumpito(); 
        Boss boss= new Gringa();
        mapa_2 = new Mapa2(taquito,this,0,0,secuaz,boss);
        mainStage.setScene(mapa_2);
    }
    public void setTaco(Taco taquito){
        this.taquito=taquito;
    }
    public Taco getTaquito(){
        return taquito;
    }
    public void pelear(Personaje p){
        b= new SceneBatalla(taquito,p,this);
        mainStage.setScene(b);
    }

    
}
