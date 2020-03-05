package src; 

public class Prison {
    private Boss prison[] = new Boss[5];

    public void initPrison(){
        prison[0] = null;
        prison[1] = null;
        prison[2] = null;
        prison[3] = null;
        prison[4] = null;
    }

    public void setPrisonElem(Boss x, int j){this.prison[j]=x;}
    public Jeton getPrisonnier(int j){return this.prison[j];}

    public void ajoutboss(Boss bossajout){
        for(int i=0;i<prison.length-1;i++){
            if(prison[i]==null){
                this.setPrisonElem(bossajout,i);
                i = prison.length-1;
            }
        }
    }

}