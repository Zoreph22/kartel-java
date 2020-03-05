package src;

public class PotDeVin extends Jeton
{
    public String getId(){
        String l = getGang().substring(0, 1);
        return "$" + l;
    }

    public PotDeVin(String gang){
        super(gang);
    }
}