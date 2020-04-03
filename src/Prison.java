package src; 

public class Prison {
    //Attribut de la classe Prison
    private Jeton prison[] = new Jeton[5];

    //Méthode qui permet de réinitialiser la classe prison
    public void initPrison(){
        prison[0] = null;
        prison[1] = null;
        prison[2] = null;
        prison[3] = null;
        prison[4] = null;
    }

    //Méthodes get et set de l'attribut prison
    public void setPrisonElem(Jeton x, int j){this.prison[j]=x;}
    public Jeton getPrisonnier(int j){return this.prison[j];}

    //Méthode pour l'ajoute d'un boss dans la prison
    public void ajoutboss(Jeton bossajout){
        for(int i=0;i<=prison.length-1;i++){
            if(prison[i]==null){
                this.setPrisonElem(bossajout,i);
                i = prison.length-1;
            }
        }
    }

    //Méthode qui permet de vérifier si la prison est vide ou pas
    public boolean prisonVide(){
        boolean bool = true;
        for(Jeton jeton : prison){
            if(jeton != null)
                bool = false;
        }
        return bool;
    }

    //Méthode pour vérifier si un élément de type jeton est du même type qu'un boss qui se trouve dans la prison
    public boolean bossInPrison(Jeton element){
        boolean bool = false;
        for(int i=0;i<prison.length;i++){
            if(prison[i] != null && i<prison.length){
                if(element.getGang()==prison[i].getGang()){
                    bool = true;
                }
            }
        }
        return bool;
    }

    //Méthode toString
    public String toString(){
        String mes = "Prison : ";
        for(int i=0;i<=prison.length-1;i++){
            if(prison[i] != null)
                mes += prison[i].getId()+" - ";
        }
        return mes;
    }

}