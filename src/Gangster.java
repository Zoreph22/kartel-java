package src;

public class Gangster extends Jeton
{
    private int teamsize;

    public void setTeamsize(int size){this.teamsize = size;}
    public int getTeamsize(){return this.teamsize;}

    public Gangster(String gang, int size){
        super(gang);
        setTeamsize(size);
    }
}