package src;

public class Kartel {
    public static void main(String[] args){
        Gangster j = new Gangster("Rouge",2);
        PotDeVin pdv = new PotDeVin("Rouge");
        Boss b = new Boss("Rouge");
        Detective de = new Detective("");
        System.out.println(j.getId());
        System.out.println(pdv.getId());
        System.out.println(b.getId());
        System.out.println(de.getId());

        System.out.println("----------------------------------------------------");

        Plateau p = new Plateau();
        p.initPlateau();
        p.aff();

    }
}