package src;

public class De {
    private int de[] = new int[6];
    private int facecourante;

    public void setFaceCourante(int valeur){this.facecourante = valeur;}
    public int getFacecourante(){return this.facecourante;}

    public void initDe(){
        de[0] = 2;
        de[1] = 2;
        de[2] = 3;
        de[3] = 3;
        de[4] = 4;
        de[5] = 4;
    }

    public int lancerDe(){
        int lancer = (int)(Math.random()*6);
        return this.facecourante = this.de[lancer];
    }

}