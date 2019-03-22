public class Condimentos{
    String nombre;
    int puntos;
    public Condimentos(String nombre, int puntos){
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