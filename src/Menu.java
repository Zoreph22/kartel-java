package src;

public class Menu {
    private Partie partie = new Partie();
    private PartieSetting setting = new PartieSetting();
    private String textMenu;

    public void setMenu(String text){this.textMenu = text;}
    public String getMenu(){return this.textMenu;}

    public Partie getPartie(){return this.partie;}
    public PartieSetting getSetting(){return this.setting;}

    //Fonction principale de la classe menu qui permet de lancer le paramétrage de la partie
    public void menuStart(){
        inputPlayerName();
        //partieSetting();
        setting.inputGangJeton();
        this.partie.initPartie();
    }

    //Ce bout de code permet la saisie des joueurs de la partie
    public void inputPlayerName(){
        System.out.println("Nombre de joueur de la partie ?");
        int x = Lire.i();
        Joueur[] joueurs = new Joueur[x];
        for(int i=0;i<=joueurs.length-1;i++){
            System.out.println("Saisir le nom du Joueur "+(i+1));
            String nomjoueur = Lire.S(); 
            joueurs[i] = new Joueur(nomjoueur, new Reserve());
        }
        partie.setJoueurs(joueurs);
    }

    //Partie du code qui permet de faire les setting de la partie en ce qui concerne le plateau
    public void partieSetting(){
        
    }

    public String toString(){
        
        return this.getMenu();
    }
}