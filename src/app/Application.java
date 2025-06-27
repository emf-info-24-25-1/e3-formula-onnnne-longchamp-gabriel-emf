package app;

import app.models.Pilote;
import app.models.TypePneu;
import app.models.Voiture;
import app.models.Pneu;

public class Application {

    public static void main(String[] args) {

        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        // ---------------------------------------------------------------------------------------
        Voiture[] voitures = new Voiture[1];
        voitures[0] = new Voiture(16, "Ferrari");
        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        // ---------------------------------------------------------------------------------------
        System.out.println(voitures[0]);
        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        // ---------------------------------------------------------------------------------------
        Pilote[] pilotes = new Pilote[1];
        pilotes[0] = new Pilote("Leclerc", "Monégasque", voitures[0], null, 16, 65, 3, 7);
        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        // ---------------------------------------------------------------------------------------
        System.out.println(pilotes[0]);
        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        // ---------------------------------------------------------------------------------------
        // deposerPneuEnReserve() 5 fois de types différents
        deposerPneuEnReserve();
        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher
        retirerPneuEnReserve(TypePneu.TENDRE_ROUGE);
        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve
        System.out.println(Pilote.getNombrePneusEnReserve());
        // getPneusEnReserveSansTrous() et afficher les pneus en réserve
        System.out.println(Pilote.getPneusEnReserveSansTrous());
        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne
        // des
        // pneus
        pressionMoyenneDesPneusEnReserveFormatee()
        System.out.println(Pilote.pressionMoyenneDesPneusEnReserveFormatee());

        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC
        System.out.println(compterNombrePneusEnReserveDeType(TypePneu.DUR_BLANC));
        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué
        Pneu[] pneu = new Pneu[3];
        pneu[0] = new Pneu("Dur_Blanc", "1.6");
        pneu[1] = new Pneu("MEDIUM_JAUNE", "1.8");
        pneu[2] = new Pneu("Tendre_rouge", "2");
        
        if (ajouterLotDePneus()) {
            System.out.println("Reussi");
        }else {
            System.out.println("Echoué");
        }

        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés
        if (Pneu.pression < 1.4) {
            retirerPneuEnReserve()
         System.out.println(retirerPneuEnReserve());
        }
        // ---------------------------------------------------------------------------------------

    }

}