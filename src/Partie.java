package src;

public class Partie {
    //Attributs de la classe Partie
    private De de = new De();
    private Prison prison = new Prison();
    private Plateau plateau = new Plateau(); 
    private Joueur joueurs[];

    //Méthode qui permet de paramétrer la partie
    public void paramPartie(){
        System.out.println("Nombre de joueur de la partie ?");
        int x = Lire.i();
        this.joueurs = new Joueur[x];
        for(int i=0;i<=this.joueurs.length-1;i++){
            System.out.println("Saisir le nom du Joueur "+(i+1));
            String nomjoueur = Lire.S(); 
            this.joueurs[i] = new Joueur(nomjoueur, new Reserve());
        }
        initPartie();
    }

    //Initialisation de certains attributs
    public void initPartie(){
        plateau.initPlateau();
        de.initDe();
    }

    //Méthode qui permet de gérer le tour de jeu d'un joueur
    public void gestionTour(Joueur joueur){
        de.lancerDe();
        int nbcase = 0;
        affEtatPartie();
        boolean ok = false;
        int face;
        do{
            ok = false;
            System.out.println("C'est à "+joueur.getNom()+" de jouer");
            face = de.getFacecourante();
            System.out.print("Résultat du dé : "+de.getFacecourante()+", ");
            System.out.print("que jouez-vous ? : ");
            while(!ok){
                try{
                    nbcase = Lire.i();
                    ok = true;
                }
                catch(NumberFormatException e){
                    System.out.println("Format Numérique Incorrect");
                    System.out.print("que jouez-vous ? : ");
                }
            }
        }while(nbcase>de.getFacecourante() || nbcase == 0);
        recupjeton(nbcase, joueur, face);
    }

    //Méthode qui permet de récupérer les jeton, de déplacer le detective et de restart le plateau
    public void recupjeton(int playcase, Joueur joueur, int facede){
        int currentpos = plateau.getDetective().getCurrentPos(plateau); 
        int nextpos = currentpos + playcase;
        if(currentpos + facede >= plateau.getPlatLength()){
            plateau.restartPlat();
            currentpos = 0;
            nextpos = currentpos + playcase;
        }
        if(plateau.getElemPlateau(nextpos) instanceof Boss){
            prison.ajoutboss(plateau.getElemPlateau(nextpos));
        }
        else{
            joueur.getReserve().placeInReserve(plateau.getElemPlateau(nextpos));
        }
        plateau.getDetective().deplacement(currentpos, playcase);
        plateau.setElemPlateau(nextpos, plateau.getDetective());
        plateau.deleteCase(currentpos);
    }

    //Méthode qui permet de gérer les différent ordre de tour de jeu ainsi que l'avancé de la partie
    public void gestionPartie(){
        int i = 0;
        do{
            if(i>=joueurs.length){
                i=0;
            }
            gestionTour(joueurs[i]);
            i++;
        }while(!prison.prisonVide());
        affEtatPartie();
        System.out.println("Partie fini");
    }

    //Méthode qui affiche l'état de la partie avec le tableau, la prison et les joueurs
    public void affEtatPartie(){
        System.out.println("***********************************************");
        System.out.println();
        System.out.println(plateau.toString());
        System.out.println();
        System.out.println(prison.toString());
        System.out.println();
        for(int i=0;i<=this.joueurs.length-1;i++){
            String aff = joueurs[i].toString(this.prison);
            System.out.println(aff);
        }
        System.out.println();
    }

}