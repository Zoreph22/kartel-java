package src;

public class Jeton {

    public String getId(){
        //Récupération des différents id pour l'affichage des jetons
        if(this instanceof Boss){
            Boss btmp = (Boss) this;
            String l = btmp.getGang().substring(0, 1);
            return "[" + l + "]";
        }
        else if (this instanceof Gangster){
            Gangster tmp = (Gangster) this;
            return tmp.getTeamsize() + tmp.getGang().substring(0, 1);
        }
        else if (this instanceof PotDeVin){
            PotDeVin pdvtmp = (PotDeVin) this;
            String l = pdvtmp.getGang().substring(0, 1);
            return "$" + l;
        }
        else if (this instanceof Detective){
            return "<>";
        }
        else{
           return ""; 
        }
        
    }

}