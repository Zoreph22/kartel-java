package src;

public class Kartel {
    public static void main(String[] args){
        Gangster j = new Gangster("Rouge",2);
        PotDeVin pdv = new PotDeVin("Rouge");
        System.out.println(j.getId());
        System.out.println(pdv.getId());
    }
}