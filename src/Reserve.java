package src;

public class Reserve {

    //Attributs de la classe reserve
    private Jeton reserve[] = new Jeton[40];

    //Méthodes get et set de l'attribut reserve
    public Jeton getElemReserve(int i){return this.reserve[i];}
    public void setElemReserve(int i, Jeton jeton){this.reserve[i]= jeton;}

    //Méthodes qui permet d'ajouter un élément dans le tableau sur une case vide
    public void placeInReserve(Jeton elem){
        for(int i=0;i<reserve.length-1;i++){
            if(this.reserve[i]==null){
                setElemReserve(i, elem);
                i = this.reserve.length-1;
            }
        }
    }

    //Méthode qui permet de calculer le score d'un joueur en fonction de ces jetons
    public int calcScore(Prison prison){
        int score = 0;
        for(int i=0;i<reserve.length-1;i++){
            if(reserve[i] != null){
                if(prison.prisonVide()){
                    if(reserve[i] instanceof PotDeVin){
                        score = score + 3;
                    }
                    if(reserve[i] instanceof Gangster){
                        Gangster tmp = (Gangster) reserve[i];
                        score = score - tmp.getTeamsize();
                    }
                }
                else{
                    if(prison.bossInPrison(reserve[i])){
                        if(reserve[i] instanceof Gangster){
                            Gangster tmp = (Gangster) reserve[i];
                            score = score + tmp.getTeamsize();
                        }
                    }
                    else{
                        if(reserve[i] instanceof PotDeVin){
                            score = score + 3;
                        }
                        if(reserve[i] instanceof Gangster){
                            Gangster tmp = (Gangster) reserve[i];
                            score = score - tmp.getTeamsize();
                        }
                    }
                }
            }
        }
        return score;
    }

    //Méthode toString 
    public String toString(){
        String mes = "";
        for(int i=0;i<=reserve.length-1;i++){
            if(reserve[i] != null)
                mes += reserve[i].getId()+" - ";
        }
        return mes;
    }
}