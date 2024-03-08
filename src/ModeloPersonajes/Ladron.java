package ModeloPersonajes;

public class Ladron extends Personaje{

    public Ladron(){
        super();
    }

    public Ladron(String nombre, String raza){
        this.setNombre(nombre);
        this.setRaza(raza);
    }

    public void subirNivel(){
        this.aumentarNivel();
        if(Math.random() <= 0.4)
            this.setVida(this.getVida() + (int)(Math.ceil(this.getVida() * 0.1)));
        if(Math.random() <= 0.4)
            this.setArmadura(this.getArmadura() + this.getNivel());
        if(Math.random() <= 0.4)
            this.setResistenciaMagica(this.getResistenciaMagica() + this.getNivel());
        if(Math.random() <= 0.85)
            this.setAgilidad(this.getAgilidad() + (this.getNivel() * 2));
        if(Math.random() <= 0.6)
            this.setAtaque(this.getAtaque() + this.getNivel());
    }

    public int robar(){
        return this.getAgilidad();
    }

    public int luchar(){
        return this.getAtaque();
    }

    public void defender(int ataqueRecibido, String tipoAtaque){
        tipoAtaque = tipoAtaque.toLowerCase();
        switch (tipoAtaque) {
            case "fisico":
                if (ataqueRecibido - this.getArmadura() < 0) {
                    System.out.println(this.getNombre() + " tiene tanta armadura que no ha recibido daño");
                } else {
                    System.out.println(this.getNombre() + " ha recibido " + (ataqueRecibido - this.getArmadura()) + " puntos de daño.");
                    this.setVida(Math.max(this.getVida() - (ataqueRecibido - this.getArmadura()), 0));
                }
                break;
            case "magico":
                if (ataqueRecibido - this.getResistenciaMagica() < 0) {
                    System.out.println(this.getNombre() + " tiene tanta resistencia mágica que no ha recibido daño");
                } else {
                    System.out.println(this.getNombre() + " ha recibido " + (ataqueRecibido - this.getResistenciaMagica()) + " puntos de daño.");
                    this.setVida(Math.max(this.getVida() - (ataqueRecibido - this.getResistenciaMagica()), 0));
                }
                break;
            default:
                System.err.println("El tipo de ataque no corresponde con magico o fisico.");
        }
        if(this.getVida() == 0)
            this.setVivoMuerto();
    }

    public String toString(){
        return "Clase Ladrón\n" + super.toString() + "\n";
    }
}
