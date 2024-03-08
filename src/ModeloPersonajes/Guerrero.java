package ModeloPersonajes;

public class Guerrero extends Personaje {
    private Boolean furia = false;

    public Guerrero(){
        super();
    }

    public Guerrero(String nombre, String raza){
        this.setNombre(nombre);
        this.setRaza(raza);
    }
    public Boolean getFuria(){return furia;}

    public void subirNivel(){
        this.aumentarNivel();

        if(Math.random() <= 0.8)
            this.setAtaque(this.getAtaque() + (this.getNivel() * 2));

        if(Math.random() <= 0.75)
            this.setVida(this.getVida() + (int)Math.ceil(this.getVida() * 0.1));

        if(Math.random() <= 0.75)
            this.setArmadura(this.getArmadura() + this.getNivel());

        if(Math.random() <= 0.2)
            this.setResistenciaMagica(this.getResistenciaMagica() + ((this.getNivel() / 2) + (this.getNivel() % 2)));

        if(Math.random() <= 0.5)
            this.setAgilidad(this.getAgilidad() + this.getNivel());
    }

    public void onOffFuria(){
        this.furia = !this.furia;
    }

    public int luchar(){
        if(this.furia)
            return getAtaque() * 2;
        else return getAtaque();
    }
    public void defender(int ataqueRecibido, String tipoAtaque) { //tipoAtaque se refiere a daño físico o mágico
        tipoAtaque = tipoAtaque.toLowerCase();
        if (tipoAtaque.equals("fisico")) {
            if (this.furia) {
                if (((ataqueRecibido * 2) - this.getArmadura()) <= 0) {
                    System.out.println(this.getNombre() + " no ha recibido daño.");
                } else {
                    System.out.println(this.getNombre() + " ha recibido " + ((ataqueRecibido * 2) - this.getArmadura()) + " puntos de daño.");
                    this.setVida(Math.max(this.getVida() - ((ataqueRecibido * 2)- this.getArmadura()), 0));;
                }
            } else {
                if ((ataqueRecibido - this.getArmadura()) <= 0) {
                    System.out.println(this.getNombre() + " no ha recibido daño.");
                } else {
                    System.out.println(this.getNombre() + " ha recibido " + (ataqueRecibido - this.getArmadura()) + " puntos de daño.");
                    this.setVida(Math.max(this.getVida() - (ataqueRecibido - this.getArmadura()), 0));
                }
            }
        } else if (tipoAtaque.equals("magico")) {
            if (this.furia) {
                if (((ataqueRecibido * 2) - this.getResistenciaMagica()) <= 0) {
                    System.out.println(this.getNombre() + " no ha recibido daño.");
                } else {
                    System.out.println(this.getNombre() + " ha recibido " + ((ataqueRecibido * 2) - this.getResistenciaMagica()) + " puntos de daño.");
                    this.setVida(Math.max(this.getVida() - ((ataqueRecibido * 2) - this.getResistenciaMagica()), 0));
                }
            } else {
                if ((ataqueRecibido - this.getResistenciaMagica()) <= 0) {
                    System.out.println(this.getNombre() + " no ha recibido daño.");
                } else {
                    System.out.println(this.getNombre() + " ha recibido " + (ataqueRecibido - this.getResistenciaMagica()));
                    this.setVida(Math.max(this.getVida() - (ataqueRecibido - this.getResistenciaMagica()), 0));
                }
            }
        }
        if(this.getVida() == 0)
            this.setVivoMuerto();
    }

    public String toString(){
        return "Clase Guerrero\n" + super.toString() + "Furia: " + this.furia + "\n";
    }

}
