public class Condimento{
    String nombre;
    int puntos;
    public Condimento(String nombre, int puntos){
        this.nombre=nombre;
        this.puntos=puntos;
    }
    public String getNombre(){
        return "salsa";
    }
    public int getPuntos(){
        return 50;
    }
}