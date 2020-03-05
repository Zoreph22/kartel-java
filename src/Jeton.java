package src;

public class Jeton {
    private String gang;

    public void setGang(final String ngang){this.gang = ngang;}
    public String getGang(){return this.gang;}

    public String getId(){

        if(this instanceof Boss){
            String l = getGang().substring(0, 1);
            return "[" + l + "]";
        }
        else if (this instanceof Gangster){
            Gangster tmp = (Gangster) this;
            return tmp.getTeamsize() + tmp.getGang().substring(0, 1);
        }
        else if (this instanceof PotDeVin){
            String l = getGang().substring(0, 1);
            return "$" + l;
        }
        else if (this instanceof Detective){
            return "<>";
        }
        else{
           return ""; 
        }
        
    }
    
    public Jeton(String gang){
        setGang(gang);
    }

}