package ModeloPersonajes;

import java.util.Scanner;

public abstract class Personaje {
    private String nombre;
    private String raza;
    private int nivel = 1;
    private int vida = 100;
    private int ataque = 10;
    private int agilidad = 10;
    private int armadura = 10;
    private int resistenciaMagica = 10;
    private Boolean vivo = true;
    private Scanner input;

    public Personaje(){
        this.nombre = "";
        this.raza = "";
    }
    public Personaje(String nombre, String raza){
        setNombre(nombre);
        setRaza(raza);
    }

    public void setNombre(String nombre){
        while(nombre.length() < 4){
            input = new Scanner(System.in);
            System.out.println("Introduce un nombre que tenga mas de 4 caracteres.");
            nombre = input.nextLine();
        }
        if(nombre.contains(" "))
            nombre = nombre.replace(" ", "");
        this.nombre = nombre;
    }

    public void setRaza(String raza){
        raza = raza.toLowerCase();
        while(raza.equals("angel") || raza.equals("demonio") || raza.equals("ángel")){
            input = new Scanner(System.in);
            System.out.println("Las razas angel y demonio están prohibidas, elige otra");
            raza = input.nextLine();
        }
        this.raza = raza;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setResistenciaMagica(int resistenciaMagica) {
        this.resistenciaMagica = resistenciaMagica;
    }

    public void setNivel(int nivel){this.nivel = nivel;}
    public void setVivo(Boolean vivo){
        this.vivo = vivo;
    }
    public void setVivoMuerto(){this.vivo = !vivo;}



    public final String getNombre(){return nombre;}
    public final String getRaza(){return raza;}
    public final int getNivel(){return  nivel;}
    public final int getVida(){return vida;}
    public final int getAtaque(){return ataque;}
    public final int getAgilidad(){return agilidad;}
    public final int getArmadura(){return armadura;}
    public final int getResistenciaMagica(){return resistenciaMagica;}
    public final Boolean getVivo(){return vivo;}

    public abstract void subirNivel();


    public abstract int luchar();

    public abstract void defender(int ataqueRecibido, String tipoAtaque); //tipoAtaque se refiere a daño físico o mágico


    public String toString(){
        return "Nombre: " + this.nombre + "\nRaza: " + this.raza + "\nNivel: " + this.nivel + "\nVida: " + this.vida
                + "\nAtaque: " + this.ataque + "\nAgilidad: " + this.agilidad + "\nArmadura: " + this.armadura
                + "\nResistenciaMágica: " + this.resistenciaMagica + "\nVivo: " + this.vivo + "\n";
    }

    protected void aumentarNivel(){this.nivel++;}

}
