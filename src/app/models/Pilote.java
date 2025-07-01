package app.models;

import java.util.Arrays;

public class Pilote {
    public static final int NOMBRE_PNEUS_EN_RESERVE = 16;
    // MR Tu as oublié le mot-clé final pour indiquer que cette valeur ne changera
    // pas pour les deux premiers attributs
    private String nom;
    private String nationalite;
    private int nombrePoints;
    private int nombreCourse;
    private int nombreVictoires;
    private int nombrePodiums;
    private Pneu[] pneusEnReserve;
    private Voiture voiture;

    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoints = 0;
        this.nombreCourse = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
        // MR Il faut initialiser le tableau pneusEnReserve avec la taille
        // NOMBRE_PNEUS_EN_RESERVE
        this.pneusEnReserve = null;
        this.voiture = null;
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoints = 0;
        this.nombreCourse = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
        // MR Il faut initialiser le tableau pneusEnReserve avec la taille
        // NOMBRE_PNEUS_EN_RESERVE
        this.pneusEnReserve = null;
        this.voiture = voiture;
    }

    public boolean deposerPneuEnReserve(Pneu pneu) {
        // MR On a pas besoin d'utiliser un tableau dynamique on le met où il y a de la
        // place
        boolean reussi = false;
        Pneu[] pneus = new Pneu[pneusEnReserve.length + 1];
        for (int i = 0; i < pneusEnReserve.length; i++) {
            pneus[i] = pneusEnReserve[i];
            reussi = true;

            if (pneusEnReserve[i] != null) {
                reussi = false;
            }
        }
        pneus[pneus.length - 1] = pneu;
        pneusEnReserve = pneus;
        return reussi;
    }

    //MR Syntaxe incorrecte et code non formatté illisible
    public Pneu retirerPneuEnReserve(TypePneu type) {
    for (int i = 0; i < pneusEnReserve.length; i++) {
    Pneu pneu : pneusEnReserve[i];
    if (pneu != null && pneu.getType() == type) {
        pneusEnReserve[i] = null;
        return pneu;
    }
    }
    return null;
    }

    public int compterNombrePneusEnReserveDeType(TypePneu pneu) {
        int compteur = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            //MR Il faut vérifier si le pneu n'est pas null avant de comparer les types
            //MR Il faut mieux utiliser == pour comparer les types de pneus
            if (pneusEnReserve[i].getType().equals(pneu)) {
                compteur++;
            }
        }
        return compteur;
    }

    public int getNombrePneusEnReserve() {
        //MR Si tu utilises un tableau dynamique, c'est ok comme ça, mais ce n'est pas ce qui est demandé
        int compteur;
        compteur = pneusEnReserve.length;
        return compteur;
    }

    public Pneu[] getPneusEnReserveSansTrous() {
        int count = 0;
        for (Pneu pneu : pneusEnReserve) {
            if (pneu != null) {
                count++;
            }
            Pneu[] sansTrous = new Pneu[count];
            int index = 0;
            //MR Il faut le faire en dehors de la boucle des pneusEnReserve
            for (Pneu sansTrou : pneusEnReserve) {
                sansTrous[index++] = pneu;
            }
        }
        return sansTrous;
    }

    public String pressionMoyenneDesPneusEnReserveFormatee() {
        int pressionTotale = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                pressionTotale += pneusEnReserve[i].getPression();
            }
        }
        double moyenne = 0;
        //MR Il faut compter le nombre de pneus non null et pas utiliser la longueur du tableau pneusEnReserve
        //MR Il faut vérifier si pneusEnReserve.length n'est pas 0 pour éviter la division par zéro
        moyenne = pressionTotale / pneusEnReserve.length;
        //MR Formatage pas réalisé
        String chaineString = "";
        return chaineString;
    }

    public int supprimerPneusDePressionInferieure(double pression) {
        //MR Pourquoi faire la moyenne des pressions pour supprimer les pneus ?
        int pressionTotale = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                pressionTotale += pneusEnReserve[i].getPression();
            }
        }
        double moyenne = pressionTotale / pneusEnReserve.length;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pression < moyenne) {
                Pneu[] pneus = new Pneu[pneusEnReserve.length - 1];
                for (int k = 0; k < pneus.length; k++) {
                    int compteur = 0;
                    if (pneusEnReserve[i] != null) {
                        pneus[k] = pneusEnReserve[i];
                        compteur++;
                    }
                }
                pneusEnReserve = pneus;
            }
        }
        return compteur;

    }

    public boolean ajouterLotDePneus(Pneu[] pneu) {
        int placesLibres = 0;
        for (Pneu p : pneusEnReserve) {
            if (p == null) {
                placesLibres++;
            }
            //MR Il faut sortir de la boucle de comptage des places libres
            if (placesLibres > pneu.length) {
                return false;
            }
            int index = 0;
            for (int i = 0; i < pneu.length; i++) {
                if (pneusEnReserve[i] == null) {
                    pneusEnReserve[i] = pneu[index++];
                    index++;
                }
            }
        }
        return true;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    public int getNombreCourse() {
        return nombreCourse;
    }

    public void setNombreCourse(int nombreCourse) {
        this.nombreCourse = nombreCourse;
    }

    public int getNombreVictoires() {
        return nombreVictoires;
    }

    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }

    public int getNombrePodiums() {
        return nombrePodiums;
    }

    public void setNombrePodiums(int nombrePodiums) {
        this.nombrePodiums = nombrePodiums;
    }

    @Override
    public String toString() {
        return "Pilote [nom=" + nom + ", nationalite=" + nationalite + ", nombrePoints=" + nombrePoints
                + ", nombreCourse=" + nombreCourse + ", nombreVictoires=" + nombreVictoires + ", nombrePodiums="
                + nombrePodiums + ", pneusEnReserve=" + Arrays.toString(pneusEnReserve) + ", voiture=" + voiture + "]";
    }

}
