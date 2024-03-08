package ModeloPersonajes;

public class Paladin extends Creyente{
    public Paladin(){
        super();
    }

    public Paladin(String nombre, String raza){
        this.setNombre(nombre);
        this.setRaza(raza);
    }

    public void subirNivel(){
        this.aumentarNivel();
        if(Math.random() <= 0.7)
            this.setArmadura(this.getArmadura() + (this.getNivel() * 2));
        if(Math.random() <= 0.5)
            this.setVida(this.getVida() + (int)(Math.ceil(this.getVida() * 0.15)));
        if(Math.random() <= 0.6)
            this.setAtaque(this.getAtaque() + this.getNivel());
        if(Math.random() <= 0.15)
            this.setAgilidad(this.getAgilidad() + (int)(Math.ceil(this.getNivel() * 0.25)));
        if(Math.random() <= 0.3)
            this.setFe(this.getFe() + this.getNivel());
        if(Math.random() <= 0.5)
            this.setResistenciaMagica(this.getResistenciaMagica() + this.getNivel());
    }

    public int lanzarPlegaria(int plegaria, String objetivo){ // Habrá que modificar el método en el futuro
        int resultado = 0;
        switch (plegaria){
            case 1:
                System.out.println(this.getNombre() + " utiliza Imbuir arma sobre " + objetivo + " dandole " + (int)Math.ceil(0.8 * this.getFe()) + " puntos extras de ataque.");
                resultado = (int)Math.ceil(0.8 * this.getFe());
                break;
            case 2:
                System.out.println(this.getNombre() + " utiliza Baluarte de fe aumentando su propia armadura en " + (int)Math.ceil(0.3 * this.getFe()) + " puntos extras.");
                resultado = (int)Math.ceil(0.3 * this.getFe());
                break;
            default:
                System.err.println("Estás intentando utilizar una plegaria que no posees\nPosees:\n1)Imbuir arma.\n2)Baluarte de fe.\n");
        }
        return resultado;
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
        return "Clase Paladin\n" + super.toString();
    }
}
