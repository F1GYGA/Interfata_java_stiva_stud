import poo.test1.util.ExceptieStivaPlina;
import poo.test1.util.StivaDeComparabile;
import java.util.Random;

public class Teste {
    public static void main(String[] args) {
        int dimensiuneMaxima = Integer.parseInt(args[0]);
        StivaDeComparabile stiva = new StivaDeComparabile(dimensiuneMaxima);
        stiva.afisareElemente();
        int contor = 0;
        Random val_random = new Random();
        while (contor < 5) {
            try{
            stiva.adaugareElement(new Student(("Student_ELTH_" + contor), val_random.nextInt(10))); // introducerer
                                                                                                    // elemente comform
                                                                                                    // cerintei
            contor++;
            }catch(ExceptieStivaPlina stivaPlina){
                System.out.println("Stiva este plina");
            }
        }
        stiva.afisareElemente();
        for (int i = 0; i < 2; i++) { // se sterge un nr de 2 elemente
            System.out.println("s-a sters elementul : " + stiva.eliminareElement()); // se apeleaza functia de stergere
        }

        stiva.afisareElemente();

        // Sectiune de sterge elemente din stiva

        for (int i = 0; i < 4; i++) { // se sterge un nr de 4 elemente
            if (stiva.verificareStiva() != 0) {
                System.out.println("s-a sters elementul : " + stiva.eliminareElement());
            } else {
                System.out.println("Stiva este goala, nu mai sunt elemente de sters");
                i = 4;
            }
        }

        stiva.afisareElemente();
        stiva.sortareElemente();
        stiva.afisareElemente();

    }
}
