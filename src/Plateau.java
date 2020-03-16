package src;

public class Plateau {
    private Jeton plateau[] = new Jeton[43];
    private String lstngang[] = {"Rouge","Bleu","Vert","Jaune","Magenta","Orange","Violet"};
    private String lstpgang[] = {"boss","solo","duo1","duo2","trio","pdv"};
	public int length;
 
    public Jeton getElemPlateau(int i){return this.plateau[i];}
    public void setElemPlateau(int i, Jeton valeur){this.plateau[i]= valeur;}

    private int randnum(){
        return (int)((Math.random()*42)+1);
    }

    public void initPlateau(){
        Boss boss;
        int i = 0;
        plateau[i] = new Detective("");
        for(String ngang : lstngang){
            for(String pgang : lstpgang){
                i = randnum();
                while(plateau[i] != null){
                    i = randnum();
                }
                if(pgang.equalsIgnoreCase("boss")){
                    plateau[i] = new Boss(ngang);
                }  
                if(pgang.equalsIgnoreCase("solo")){
                    plateau[i] = new Gangster(ngang, 1);
                }  
                if(pgang.equalsIgnoreCase("duo1") || pgang.equalsIgnoreCase("duo2")){
                    plateau[i] = new Gangster(ngang, 2);
                }  
                if(pgang.equalsIgnoreCase("trio")){
                    plateau[i] = new Gangster(ngang,3);
                }  
                if(pgang.equalsIgnoreCase("pdv")){
                    plateau[i] = new PotDeVin(ngang);
                }
            }
        }
    }

    public String toString(){
        String mes = "";
        for(int i=0;i<=plateau.length-1;i++){
            if(plateau[i] != null)
                mes += plateau[i].getId()+" - ";
        }
        return mes;
    }

}