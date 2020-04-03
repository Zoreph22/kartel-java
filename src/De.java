package src;

public class De {
    //Déclarations des attributs facecourante et du tableau d'entier permettant le fonctionnement du dé
    private int de[] = new int[6];
    private int facecourante;

    //Méthodes get et set pour l'attributs facecourante
    public void setFacecourante(int valeur){this.facecourante = valeur;}
    public int getFacecourante(){return this.facecourante;}

    public void initDe(){
        //Initialisation du tableau pour le fonctionnement du dé
        de[0] = 2;
        de[1] = 2;
        de[2] = 3;
        de[3] = 3;
        de[4] = 4;
        de[5] = 4;
    }

    public int lancerDe(){
        //Méthodes permettant le lancement du dé et l'affectation de la face du dé a l'attributs facecourante
        int lancer = (int)(Math.random()*6);
        this.facecourante = this.de[lancer];
        return this.facecourante;
    }

}