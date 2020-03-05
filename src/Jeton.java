package src;

public class Jeton {
    private String gang;


    public void setGang(final String ngang){this.gang = ngang;}
    public String getGang(){return this.gang;}
    
    public Jeton(String gang){
        setGang(gang);
    }

}