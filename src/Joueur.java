package src;

public class Joueur {

    //Attributs de la classe joueur
    private String nom;
    private Reserve rsve;

    //Méthodes get et set pour l'attributs nom
    public void setNom(String nom){this.nom = nom;}
    public String getNom(){return this.nom;}

    //Méthodes get et set de l'attributs reserve qui contient une objet de type de classe Reserve
    public void setReserve(Reserve reserve){this.rsve = reserve;}
    public Reserve getReserve(){return this.rsve;}

    //Constructeur de la classe Joueur
    public Joueur(String nom, Reserve reserve){
        setNom(nom);
        setReserve(reserve);
    }

    //Méthodes toString pour l'affichage du score du joueur ainsi que la collection de jeton qu'il possède
    public String toString(Prison prison){
        return this.nom+"("+this.rsve.calcScore(prison)+") :"+this.rsve.toString();
    }
}