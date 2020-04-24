package src;

public class Gangster extends Gang{
    //Attributs teamsize qui permet de connaître la valeur d'un gangster suivent si il est solo, duo ou trio
    private int teamsize;

    //Méthodes get et set de el'attributs teamsize
    public void setTeamsize(int size){this.teamsize = size;}
    public int getTeamsize(){return this.teamsize;}

    //Constrcuteur de la classe Boss qui hérite de la classe Jeton
    public Gangster(String gang, int size){
        super(gang);
        setTeamsize(size);
    }
}