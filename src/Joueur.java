package src;

public class Joueur {
    private String nom;
    private Reserve rsve;

    public void setNom(String nom){this.nom = nom;}
    public String getNom(){return this.nom;}

    public void setReserve(Reserve reserve){this.rsve = reserve;}
    public Reserve getReserve(){return this.rsve;}

    public Joueur(String nom, Reserve reserve){
        setNom(nom);
        setReserve(reserve);
    }
}