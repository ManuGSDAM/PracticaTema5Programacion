package ModeloPersonajes;

public class Clerigo extends Creyente{
    public Clerigo(){
        super();
    }

    public Clerigo(String nombre, String raza){
        this.setNombre(nombre);
        this.setRaza(raza);
    }

    public void subirNivel(){
        this.aumentarNivel();
        if(Math.random() <= 0.2)
            this.setArmadura(this.getArmadura() + (int)(Math.ceil(this.getNivel() * 0.5)));
        if(Math.random() <= 0.2)
            this.setVida(this.getVida() + (int)(Math.ceil(this.getVida() * 0.05)));
        if(Math.random() <= 0.1)
            this.setAtaque(this.getAtaque() + (int)(Math.ceil(this.getNivel() * 0.25)));
        if(Math.random() <= 0.5)
            this.setAgilidad(this.getAgilidad() + this.getNivel());
        if(Math.random() <= 0.8)
            this.setFe(this.getFe() + (this.getNivel() * 2));
        if(Math.random() <= 0.8)
            this.setResistenciaMagica(this.getResistenciaMagica() + (this.getNivel() * 2));
    }

    public int lanzarPlegaria(int plegaria, String objetivo){
        int resultado = 0;
        switch (plegaria){
            case 1:
                System.out.println(this.getNombre() + " ha utilizado Sanación sobre " + objetivo + " restaurandole "
                        + Math.ceil(0.7 * this.getFe()) + " puntos de vida.");
                resultado = (int)Math.ceil(0.7 * this.getFe());
                break;
            case 2:
                System.out.println(this.getNombre() + " ha utilizado Rezo sagrado sobre todo el grupo restaurandoles "
                        + Math.ceil(0.35 * this.getFe()) + " puntos de vida.");
                resultado = (int)Math.ceil(0.35 * this.getFe());
                break;
            case 3:
                System.out.println(this.getNombre() + " ha utilizado Cólera divina sobre " + objetivo + " causandole "
                        + Math.ceil(0.55 * this.getFe()) + " puntos de daño.");
                resultado = (int)Math.ceil(0.55 * this.getFe());
                break;
            default:
                System.err.println(this.getNombre() + " ha intentando utilizar una plegaria que no conoce.\nPlegarias disponibles:\n" +
                        "1) Sanación\n2) Rezo sagrado\n3) Cólera divina\n");
        }
        return resultado;
    }

    public int luchar(){
        return this.getAtaque();
    }


    public int luchar(int plegaria, String objetivo){
        if(plegaria == 3)
            return lanzarPlegaria(plegaria, objetivo);
        return 0;
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

    public void apoyar(int plegaria, String objetivo){
        switch (plegaria){
            case 1:
                lanzarPlegaria(plegaria, objetivo);
                break;
            case 2:
                lanzarPlegaria(plegaria, objetivo);
                break;
            default:
                System.err.println(this.getNombre() + " ha intentado lanzar una plegaria que no conoce o ha querido hacer daño a sus aliados (ASESINO 6_6).");
        }
    }

    public String toString(){
        return "Clase Clérigo\n" + super.toString();
    }
    
}
