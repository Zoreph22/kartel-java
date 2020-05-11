package src;

public class Plateau {
    //Attributs de la classe Plateau
    private Jeton plateau[] = new Jeton[43];
    private Detective detective = new Detective();
    private String lstngang[] = {"Rouge","Bleu","Vert","Jaune","Magenta","Orange","Gris"};
    private String lstpgang[] = {"boss","solo","duo1","duo2","trio","pdv"};
 
    //Méthodes get et set des attributs
    public Jeton getElemPlateau(int i){return this.plateau[i];}
    public void setElemPlateau(int i, Jeton valeur){this.plateau[i]= valeur;}
    public int PlatLength(){return this.plateau.length;}
    public Detective getDetective(){return detective;}
    public void setDetective(Detective detective){this.detective = detective;}
    public void deleteCase(int pos){ this.plateau[pos] = null;}

    //Méthode qui génère un nombre aléatoire
    private int randnum(){
        return (int)((Math.random()*42)+1);
    }

    //Méthode pour remplir le plateau avec les jeton de façon aléatoire
    public void initPlateau(){
        int i = 0;
        plateau[i] = detective;
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

    //Méthode toString
    public String toString(){
        String mes = "";
        for(int i=0;i<=plateau.length-1;i++){
            if(plateau[i] != null)
                mes += plateau[i].getId()+" - ";
        }
        return mes;
    }

    //Méthode qui permet de remettre le tableau en ordre lorsque le detective est arrivé au bout
    public void restartPlat(){
        Jeton tempPlat[] = new Jeton[tailleExact()];
        int pos = this.getDetective().CurrentPos(this);
        int nb = 0;
        for(int i=pos;i<plateau.length;i++){
            tempPlat[nb] = plateau[i];
            nb++;
        }
        for(int j=0;j<pos;j++){
            if(plateau[j] != null){
                tempPlat[nb] = plateau[j];
                nb++;
            }
        }
        this.plateau = tempPlat;
    }

    //Méthode qui permet d'obtenir la taille du tableau
    public int tailleExact(){
        int taille = 0;
        for(Jeton jeton : plateau){
            if(jeton !=null){
                taille += 1;
            }
        }
        return taille;
    }

}