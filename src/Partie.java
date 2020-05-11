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
            System.out.print("Résultat du dé : "+face+", ");
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
        }while(nbcase>face || nbcase == 0);
        recupjeton(nbcase, joueur, face);
    }

    //Méthode qui permet de récupérer les jeton, de déplacer le detective et de restart le plateau
    public void recupjeton(int playcase, Joueur joueur, int facede){
        int currentpos = plateau.getDetective().CurrentPos(plateau); 
        int nextpos = currentpos + playcase;
        if(currentpos + facede >= plateau.PlatLength()){
            plateau.restartPlat();
            currentpos = 0;
            nextpos = currentpos + playcase;
        }
        if(plateau.getElemPlateau(nextpos) instanceof Boss){
            Boss b = (Boss) plateau.getElemPlateau(nextpos);
            prison.ajoutboss(b);
        }
        else{
            Gang g = (Gang) plateau.getElemPlateau(nextpos);
            joueur.getReserve().placeInReserve(g);
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
        }while(!prison.prisonPleine());
        affEtatPartie();
        System.out.println("La partie du Jeu Kartel est fini !");
        Joueur gagnant = findBestPlayer();
        System.out.println("Le gagnant de la partie est le joueur "+gagnant.getNom()+" avec un score de : "+gagnant.getReserve().calcScore(prison));
    }

    public Joueur findBestPlayer(){
        int max=0, i=0;
        for(int j=0; i<joueurs.length-1;j++){
            if(joueurs[j].getReserve().calcScore(prison) > max){
                max = joueurs[j].getReserve().calcScore(prison);
                i = j;
            }
        }
        return joueurs[i];
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