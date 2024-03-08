package ModeloPersonajes;

public abstract class Creyente extends Personaje{
    int fe = 10; // Teniendo en cuenta que en la clase Personaje todas la estadisticas menos la vida siempre parten de 10.

    public Creyente(){
        super();
    }

    public Creyente(String nombre, String raza){
        this.setNombre(nombre);
        this.setRaza(raza);
    }

    public final int getFe(){return fe;}

    public void setFe(int fe){
        this.fe = fe;
    }

    public abstract int lanzarPlegaria(int plegaria, String objetivo);

    public String toString(){
        return super.toString() + "Fe: " + this.fe + "\n";
    }

}
