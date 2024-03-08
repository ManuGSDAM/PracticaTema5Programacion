package ModeloPersonajes;

public class Mago extends Personaje {
    private int puntosMagia = 10;

    public Mago(){
        super();
    }

    public Mago(String nombre, String raza){
        this.setNombre(nombre);
        this.setRaza(raza);
    }

    public void setPuntosMagia(int puntosMagia){this.puntosMagia = puntosMagia;}
    public int getPuntosMagia(){return this.puntosMagia;}

    public void subirNivel(){
        if(Math.random() <= 0.9)
            this.setPuntosMagia(this.puntosMagia + this.getNivel());
        if(Math.random() <= 0.35)
            this.setVida(this.getVida() + (int)(Math.ceil(this.getVida() * 0.5)));
        if(Math.random() <= 0.35)
            this.setArmadura(this.getArmadura() + (int)(Math.ceil(this.getArmadura() * 0.5)));
        if(Math.random() <= 0.15)
            this.setAtaque(this.getAtaque() + (int)(Math.ceil(this.getAtaque() * 0.25)));
        if(Math.random() <= 0.8)
            this.setResistenciaMagica(this.getResistenciaMagica() + this.getNivel());
        if(Math.random() <= 0.65)
            this.setAgilidad(this.getAgilidad() + this.getNivel());
    }

    public int lanzarConjuro(int conjuro, String objetivo){
        int resultado = 0;
        switch (conjuro){
            case 1:
                System.out.println(this.getNombre() + " ha usado Bola de Fuego contra "
                        + objetivo + " causandole " + this.getPuntosMagia() * 0.7 + " de daño mágico.");
                resultado = (int)(Math.ceil(this.getPuntosMagia() * 0.7));
                break;
            case 2:
                System.out.println(this.getNombre() + " ha usado Escudo arcano y ha añadido a la armadura y la resistencia mágica de "
                        + objetivo + this.getPuntosMagia() * 0.5 + " puntos.");
                resultado = (int)(Math.ceil(this.getPuntosMagia() * 0.5));
                break;
            case 3:
                System.out.println(this.getNombre() + " ha usado Céfiro y ha causado " + this.getPuntosMagia() * 0.3 + " puntos de daño mágico a " + objetivo);
                resultado = (int)(Math.ceil(this.getPuntosMagia() * 0.3));
                break;
            case 4:
                System.out.println(this.getNombre() + " ha usado Presteza mental sobre " + objetivo + " aumentando un 100% su agilidad.");
                resultado = 2; // La agilidad se multiplicará por 2 al objetivo
                break;
            default:
                System.err.println(this.getNombre() + " ha intentando lanzar un hechizo que no conoce y ha fallado.");
        }
        return resultado;
    }

    public int luchar(int conjuro){
        if(conjuro == 1 || conjuro == 3)
            return lanzarConjuro(conjuro, "enemigo");
        return 0;
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

    public int apoyar(int conjuro, String objetivo){
        if(conjuro == 2 || conjuro == 4)
            return lanzarConjuro(conjuro, objetivo);
        else System.err.println(this.getNombre() + " ha intentado usar un conjuro que no conoce o ha intentado hacer daño a un aliado(ASESINO 6_6)");
        return 0;
    }

    public String toString(){
        return "Clase Mago\n" + super.toString() + "Magia: " + puntosMagia + "\n";
    }
    
}
