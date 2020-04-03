package src; 

public class Detective extends Jeton
{
    //Attributs de classe qui contient la position du detective
    private int position;

    //Méthode get et set pour l'attribut position
    public void setPosition(int position){this.position = position;}
    public int getPosition(){return this.position;}

    //Méthode qui retourne la position du detective sur le plateau
    public int getCurrentPos(Plateau plateau){
        int i = 0;
        while(i<=42){
            if(plateau.getElemPlateau(i) instanceof Detective){
                setPosition(i);
                i = 43;
            }
            i++;
        }   
        return getPosition();
    }

    //Méthode de modification de la position du detective vers la nouvelle position
    public void deplacement(int oldpos, int nbcase){
        setPosition(oldpos+nbcase);
    }

    //Constructeur de la classe Detective, on peut noter que la classe hérite de la classe Jeton
    public Detective(String gang){
        super("");
    }

}