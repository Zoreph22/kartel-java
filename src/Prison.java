package src; 

public class Prison {
    //Attribut de la classe Prison
    private Boss prison[] = new Boss[5];

    //Méthode qui permet de réinitialiser la classe prison
    public void initPrison(){
        prison[0] = null;
        prison[1] = null;
        prison[2] = null;
        prison[3] = null;
        prison[4] = null;
    }

    //Méthodes get et set de l'attribut prison
    public void setPrisonElem(Boss x, int j){this.prison[j]=x;}
    public Jeton getPrisonnier(int j){return this.prison[j];}

    //Méthode pour l'ajoute d'un boss dans la prison
    public void ajoutboss(Boss bossajout){
        for(int i=0;i<=prison.length-1;i++){
            if(prison[i]==null){
                this.setPrisonElem(bossajout,i);
                i = prison.length-1;
            }
        }
    }

    //Méthode pour vérifier si un élément de type jeton est du même type qu'un boss qui se trouve dans la prison
    public boolean bossInPrison(Boss element){
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

    public boolean gbossInPrison(Gang element){
        boolean bool = false;
            for(Boss boss : prison){
                if(boss != null){
                    if(boss.getGang().equals(element.getGang())){
                        bool = true;
                    }
                }
            }
        return bool;
    }

    //Méthode pour savoir si la prison est pleine
    public boolean prisonPleine(){
        boolean bool = true;
        for(Boss boss : prison){
            if(boss == null){
                bool = false;
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