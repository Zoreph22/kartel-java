package src;

public class Reserve {

    //Attributs de la classe reserve
    private Gang reserve[] = new Gang[40];

    //Méthodes get et set de l'attribut reserve
    public Gang getElemReserve(int i){return this.reserve[i];}
    public void setElemReserve(int i, Gang jeton){this.reserve[i]= jeton;}

    //Méthodes qui permet d'ajouter un élément dans le tableau sur une case vide
    public void placeInReserve(Gang elem){
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
                score += reserve[i].calculValeur(prison);
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