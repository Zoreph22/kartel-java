package src;

public class De {
    //Déclarations des attributs facecourante et du tableau d'entier permettant le fonctionnement du dé
    private int facecourante;

    //Méthodes get et set pour l'attributs facecourante
    public void setFacecourante(int valeur){this.facecourante = valeur;}
    public int getFacecourante(){return this.facecourante;}

    public int lancerDe(){
        //Méthodes permettant le lancement du dé et l'affectation de la face du dé a l'attributs facecourante
        int lancer = (int)(Math.random() * 2 + 2);
        this.facecourante = lancer;
        return this.facecourante;
    }

}