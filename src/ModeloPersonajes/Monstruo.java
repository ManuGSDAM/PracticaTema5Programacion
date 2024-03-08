package ModeloPersonajes;

public class Monstruo extends Personaje{
    public Monstruo(){
        super();
    }

    public Monstruo(String nombre, String raza){
        this.setNombre(nombre);
        raza = raza.toLowerCase();
        switch (raza){
            case "bestia":
                this.setRaza(raza);
                break;
            case "no-muerto":
                this.setRaza(raza);
                break;
            case "gigante":
                this.setRaza(raza);
                break;
            default:
                System.err.println("El tipo de monstruo introducido no es correcto, los disponibles son: bestia,no-muerto y gigante.");

        }
    }

    public int luchar(){
        return this.getAtaque();
    }

    public void defender(int ataqueRecibido, String tipoAtaque) {
        tipoAtaque = tipoAtaque.toLowerCase();
        switch (tipoAtaque){
            case "fisico":
                if(ataqueRecibido - this.getArmadura() < 0){
                    System.out.println(this.getNombre() + "(" + this.getRaza() + ")" + " tiene tanta armadura que no ha recibido daño");
                }else{
                    System.out.println(this.getNombre() + "(" + this.getRaza() + ")" + " ha recibido " + (ataqueRecibido - this.getArmadura()) + " puntos de daño.");
                    this.setVida(Math.max(this.getVida() - (ataqueRecibido - this.getArmadura()), 0));
                }
                break;
            case "magico":
                if(ataqueRecibido - this.getResistenciaMagica() < 0){
                    System.out.println(this.getNombre() + "(" + this.getRaza() + ")" + " tiene tanta resistencia mágica que no ha recibido daño");
                }else{
                    System.out.println(this.getNombre() + "(" + this.getRaza() + ")" + " ha recibido " + (ataqueRecibido - this.getResistenciaMagica()) + " puntos de daño.");
                    this.setVida(Math.max(this.getVida() - (ataqueRecibido - this.getResistenciaMagica()), 0));
                }
                break;
            default:
                System.err.println("El tipo de ataque no corresponde con magico o fisico.");
        }
        if(this.getVida() == 0)
            this.setVivoMuerto();
    }

    @Override
    public void subirNivel() {
        this.aumentarNivel();
        switch(this.getRaza()){
            case "bestia":
                this.setVida(this.getVida() + this.getNivel());
                if(Math.random() <= 0.5)
                    this.setAtaque(this.getAtaque() + (2 * this.getNivel()));
                if(Math.random() <= 0.5)
                    this.setAgilidad(this.getAgilidad() + (2 * this.getNivel()));
                if(Math.random() <= 0.5)
                    this.setArmadura(this.getArmadura() + ((this.getNivel() / 2) + (this.getNivel() % 2))); /* Para redondear sumamos el resto,
                                                                                              si sumaramos siempre +1 en los pares subiría 1 de más */
                if(Math.random() <= 0.5)
                    this.setResistenciaMagica(this.getResistenciaMagica() + ((this.getNivel() / 2) + (this.getNivel() % 2)));
                break;
            case "no-muerto":
                this.setVida(this.getVida() + ((this.getNivel() / 2) + (this.getNivel() % 2)));
                if(Math.random() <= 0.5)
                    this.setAtaque(this.getAtaque() + this.getNivel());
                if(Math.random() <= 0.5)
                    this.setAgilidad(this.getAgilidad() + ((this.getNivel() / 4) + (this.getNivel() % 4)));
                if(Math.random() <= 0.5)
                    this.setArmadura(this.getArmadura() + ((this.getNivel() / 2) + (this.getNivel() % 2)));
                if(Math.random() <= 0.5)
                    this.setResistenciaMagica(this.getResistenciaMagica() + (4 * this.getNivel()));
                break;
            case "gigante":
                this.setVida(this.getVida() + (4 * this.getNivel()));
                if(Math.random() <= 0.5)
                    this.setAtaque(this.getAtaque() + (4 * this.getNivel()));
                if(Math.random() <= 0.5)
                    this.setAgilidad(this.getAgilidad() + ((this.getNivel() / 4) + (this.getNivel() % 4)));
                if(Math.random() <= 0.5)
                    this.setArmadura(this.getArmadura() + this.getNivel());
                if(Math.random() <= 0.5)
                    this.setResistenciaMagica(this.getResistenciaMagica() + ((this.getNivel() / 4) + (this.getNivel() % 4)));
                break;
            default:
                System.err.println("Se ha intentado subir de nivel un monstruo que no es bestia, no-muerto o gigante.\n");
        }


    }

    @Override
    public String toString() {
        return super.toString();
    }
}
