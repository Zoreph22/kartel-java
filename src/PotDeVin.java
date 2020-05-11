package src;

public class PotDeVin extends Gang
{
    //Constrcuteur de la classe Boss qui hérite de la classe Jeton
    public PotDeVin(String gang){
        super(gang);
    }

    public int calculValeur(Prison prison){
        int valeur = 0;
        if(!prison.gbossInPrison(this)){
            valeur = 3;
        }
        return valeur;
    }
}