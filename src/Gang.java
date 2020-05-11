package src;

public abstract class Gang extends Jeton{
    //Attributs gang transmis par héritages dans les class Boss, Gangster, PotDeVin
    private String gang;

    //Méthod get et set pour l'attributs gang
    public void setGang(final String ngang){this.gang = ngang;}
    public String getGang(){return this.gang;}

    public Gang(String gang){
        setGang(gang);
    }

    public abstract int calculValeur(Prison prison);
}