package ModeloPersonajes;

public class Cazador extends Personaje{
    CompanneroAnimal companneroAnimal;
    private class CompanneroAnimal extends Personaje{
        public CompanneroAnimal(){
            super();
        }

        public CompanneroAnimal(String nombre, String especie){
            especie = especie.toLowerCase();
            this.setNombre(nombre);
            switch (especie){
                case "canido":
                    this.setRaza(especie);
                    this.setVida((int)(Cazador.this.getVida() * 0.2));
                    this.setAgilidad((int)(Cazador.this.getAgilidad() * 0.2));
                    this.setArmadura((int)(Cazador.this.getArmadura() * 0.2));
                    this.setResistenciaMagica((int)(Cazador.this.getResistenciaMagica() * 0.2));
                    this.setAtaque((int)(Cazador.this.getAtaque() * 0.2));
                    break;
                case "felino":
                    this.setRaza(especie);
                    this.setVida((int)(Cazador.this.getVida() * 0.15));
                    this.setAgilidad((int)(Cazador.this.getAgilidad() * 0.3));
                    this.setArmadura((int)(Cazador.this.getArmadura() * 0.15));
                    this.setResistenciaMagica((int)(Cazador.this.getResistenciaMagica() * 0.15));
                    this.setAtaque((int)(Cazador.this.getAtaque() * 0.3));
                    break;
                case "rapaz":
                    this.setRaza(especie);
                    this.setVida((int)(Cazador.this.getVida() * 0.05));
                    this.setAgilidad((int)(Cazador.this.getAgilidad() * 0.35));
                    this.setArmadura((int)(Cazador.this.getArmadura() * 0.05));
                    this.setResistenciaMagica((int)(Cazador.this.getResistenciaMagica() * 0.25));
                    this.setAtaque((int)(Cazador.this.getAtaque() * 0.15));
                    break;
                default:
                    System.err.println("La especie seleccionada no existe.\n");
            }
        }

        public void subirNivel(){
            this.aumentarNivel();
            switch (this.getRaza()){
                case "canido":
                    this.setVida((int)(Math.ceil(Cazador.this.getVida() * 0.2)));
                    this.setAgilidad((int)(Math.ceil(Cazador.this.getAgilidad() * 0.2)));
                    this.setArmadura((int)(Math.ceil(Cazador.this.getArmadura() * 0.2)));
                    this.setResistenciaMagica((int)(Math.ceil(Cazador.this.getResistenciaMagica() * 0.2)));
                    this.setAtaque((int)(Math.ceil(Cazador.this.getAtaque() * 0.2)));
                    break;
                case "felino":
                    this.setVida((int)(Math.ceil(Cazador.this.getVida() * 0.15)));
                    this.setAgilidad((int)(Math.ceil(Cazador.this.getAgilidad() * 0.3)));
                    this.setArmadura((int)(Math.ceil(Cazador.this.getArmadura() * 0.15)));
                    this.setResistenciaMagica((int)(Math.ceil(Cazador.this.getResistenciaMagica() * 0.15)));
                    this.setAtaque((int)(Math.ceil(Cazador.this.getAtaque() * 0.3)));
                    break;
                case "rapaz":
                    this.setVida((int)(Math.ceil(Cazador.this.getVida() * 0.05)));
                    this.setAgilidad((int)(Math.ceil(Cazador.this.getAgilidad() * 0.35)));
                    this.setArmadura((int)(Math.ceil(Cazador.this.getArmadura() * 0.05)));
                    this.setResistenciaMagica((int)(Math.ceil(Cazador.this.getResistenciaMagica() * 0.25)));
                    this.setAtaque((int)(Math.ceil(Cazador.this.getAtaque() * 0.15)));
                    break;
            }
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
        }

        public String toString(){
            return "Compañero Animal\n" + super.toString();
        }
    }
    public Cazador(){
        super();
        this.companneroAnimal = new CompanneroAnimal();
    }

    public Cazador(String nombre, String raza, String nombreCompannero, String especiaCompannero){
        this.setNombre(nombre);
        this.setRaza(raza);
        this.companneroAnimal = new CompanneroAnimal(nombreCompannero, especiaCompannero);
    }

    public void subirNivel(){
        this.aumentarNivel();
        this.setVida(this.getVida() + (int)(Math.ceil(this.getVida() * 0.1)));
        if(Math.random() <= 0.7)
            this.setAgilidad(this.getAgilidad() + this.getNivel());
        if(Math.random() <= 0.5)
            this.setArmadura(this.getArmadura() + this.getNivel());
        if(Math.random() <= 0.5)
            this.setResistenciaMagica(this.getResistenciaMagica() + this.getNivel());
        if(Math.random() <= 0.5)
            this.setAtaque(this.getAtaque() + this.getNivel());
        this.companneroAnimal.subirNivel();
    }

    public int luchar(){
        return this.getAtaque() + this.companneroAnimal.getAtaque();
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
        return "Clase Cazador\n" + super.toString() + this.companneroAnimal.toString();
    }
}
