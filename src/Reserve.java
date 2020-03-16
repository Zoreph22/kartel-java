package src;

public class Reserve {
    private Jeton reserve[] = new Jeton[40];

    public Jeton getElemReserve(int i){return this.reserve[i];}
    public void setElemReserve(int i, Jeton jeton){this.reserve[i]= jeton;}

    public void placeInReserve(Jeton elem){
        for(int i=0;i<reserve.length-1;i++){
            if(this.reserve[i]==null){
                setElemReserve(i, elem);
                i = this.reserve.length-1;
            }
        }
    }

    public int calculeScore(Prison prison){
        int score = 0;
        for(Jeton element : reserve){
            for(int i=0;i<4;i++){
                if(element.getGang()==prison.getPrisonnier(i).getGang()){
                    if(element instanceof Gangster){
                        Gangster tmp = (Gangster) element;
                        score = score + tmp.getTeamsize();
                    }
                }
                else{
                    if(element instanceof PotDeVin){
                        score += 3;
                    }
                    if(element instanceof Gangster){
                        Gangster tmp = (Gangster) element;
                        score = score - tmp.getTeamsize();
                    }
                }
            }
        }
        return score;
    }
}