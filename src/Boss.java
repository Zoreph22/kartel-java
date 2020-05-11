package src;

public class Boss extends Gang
{
    //Constrcuteur de la classe Boss qui hérite de la classe Jeton
    public Boss(String gang){
        super(gang);
    }

    public int calculValeur(Prison prison){
        return 0;
    }
}