package src;

public class Gang extends Jeton{
    //Attributs gang transmis par héritages dans les class Boss, Gangster, PotDeVin
    private String gang;

    //Méthod get et set pour l'attributs gang
    public void setGang(final String ngang){this.gang = ngang;}
    public String getGang(){return this.gang;}

    public Gang(String gang){
        setGang(gang);
    }

    public int calculValeur(Prison prison){
        int valeur = 0;
        if(prison.gbossInPrison(this)){
            if(this instanceof Gangster){
                Gangster g = (Gangster) this;
                valeur = g.getTeamsize();
            }
        }
        else{
            if(this instanceof Gangster){
                Gangster g = (Gangster) this;
                valeur = -(g.getTeamsize());
            }
            if(this instanceof PotDeVin){
                valeur = 3;
            }
        }
        return valeur;
    }

}