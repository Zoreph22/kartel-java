package src; 

public class Detective extends Jeton
{
    private int position;

    public void setPosition(int position){this.position = position;}
    public int getPosition(){return this.position;}

    public void getCurrentPos(Plateau plateau){
        int i = 0;
        while(i<=42){
            if(plateau.getElemPlateau(i) instanceof Detective){
                setPosition(i);
                i = 43;
            }
            i++;
        }   
    }

    public void deplacement(int nbcase){
        
    }

    public Detective(String gang){
        super("");
    }

}