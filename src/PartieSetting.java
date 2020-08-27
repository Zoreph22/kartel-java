package src;

public class PartieSetting {

    //Variable pour stocker les settings personnaliser
    private String settingNomGang[];
    private String settingJetonGang[];
    
    //Settings de base a mettre en cas de non personnalisation
    private String nomGangBase[] = {"Rouge","Bleu","Vert","Jaune","Magenta","Orange","Gris"};
    private String jetonGangBase[] = {"boss","solo","duo","duo","trio","pdv"};

    //Variable pour faire les settings
    private String listJetonToSetting[] = {"solo","duo","trio","pdv"};
    int[] jetonNumberToSetting = new int[4];

    public int calculPlateauLength(){
        return (settingNomGang.length * settingJetonGang.length) + 1;
    }

    public String getValueSettingNomGang(int i){return this.settingNomGang[i];}
    public String[] getSettingNomGang(){return this.settingNomGang;}
    public void setsettingNomGang(int i, String name){this.settingNomGang[i]= name;}

    public String getValueSettingJetonGang(int i){return this.settingJetonGang[i];}
    public String[] getSettingJetonGang(){return this.settingJetonGang;}
    public void setsettingJetonGang(int i, String jetonName){this.settingJetonGang[i]= jetonName;}


    public int gangNumber(){
        System.out.println("Saisir le nombre de gang voulu :");
        int gangNumber = Lire.i();
        return gangNumber;
    }


    public void inputGangName(){
        int gNumber = gangNumber();
        this.settingNomGang = new String[gNumber];

        for(int i=0;i<=this.settingNomGang.length-1;i++){
            System.out.println("Saisir le nom du gang :");
            String name = Lire.S(); 
            this.setsettingNomGang(i, name);
        }
    }

    public void inputGangJeton(){
        int numberInGang = 1, x = 1;

        for(int i=0;i<=listJetonToSetting.length-1;i++){
            System.out.println("Combien voulez-vous de "+listJetonToSetting[i]+" pour chaque gang de la partie ?");
            int number = Lire.i(); 
            jetonNumberToSetting[i] = number;
        }

        for(int y=0;y<=jetonNumberToSetting.length-1;y++){
            numberInGang += jetonNumberToSetting[y];
        }
        this.settingJetonGang = new String[numberInGang];
        this.settingJetonGang[0] = "boss";

        for(int jN=0;jN<=listJetonToSetting.length-1;jN++){
            System.out.println(jN);
            for(int z=0;z<=jetonNumberToSetting[jN]-1;z++){
                this.settingJetonGang[x] = listJetonToSetting[jN];
                x+=1;
            }
        }

        for(int test=0;test<=this.settingJetonGang.length-1;test++){
            System.out.println(settingJetonGang[test]);
        }

    }

}