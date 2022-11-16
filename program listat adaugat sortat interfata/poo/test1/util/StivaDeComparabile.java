package poo.test1.util;

import poo.test1.Comparabil;

public class StivaDeComparabile {

    Comparabil[] elemente;
    int nrCurentElemente;

    public StivaDeComparabile(int dimMaxStiva) {
        elemente = new Comparabil[dimMaxStiva];
        nrCurentElemente = 0;
    }

    public void afisareElemente() {
        if (nrCurentElemente == 0)
            System.out.println("Nu sunt elemente in stiva");
        else {
            for (int i = nrCurentElemente - 1; i >= 0; i--) {
                System.out.println(elemente[i] + " ");
            }
        }
    }

    public void adaugareElement(Comparabil elementDeInserat) throws ExceptieStivaPlina { //
        if (nrCurentElemente >= elemente.length) {
            throw new ExceptieStivaPlina();
        } else {

            for (int i = nrCurentElemente; i > 0; i--) { // se muta elementele la dreapta
                elemente[i] = elemente[i - 1];
            }

            elemente[0] = elementDeInserat; // se insereaza elementul de inserat
            nrCurentElemente += 1;
            System.out.println("S-a introdus elementul " + elementDeInserat + " , numar total de elemente: "
                    + nrCurentElemente);
        }
    }

    public int verificareStiva() {
        if (nrCurentElemente == 0)
            return 0;
        else
            return 1;
    }

    public Comparabil eliminareElement(){
        if (nrCurentElemente == 0) {
            throw new ExceptieStivaGoala();
        } else {
            Comparabil copieElementExtras = elemente[0];
            for (int i = 0; i < nrCurentElemente - 1; i++) { // se muta elementele la stanga
                elemente[i] = elemente[i + 1];
            }
            nrCurentElemente -= 1;
            return copieElementExtras;
        }
    }

    public void sortareElemente() throws SortareListaGoala {
        if (nrCurentElemente == 0) {
            throw new SortareListaGoala();
        } else {
            for (int i = 0; i < nrCurentElemente; i++) { // sortare descrescatoare prin metoda bubble sort
                for (int j = 0; j < nrCurentElemente - i - 1; j++) {
                    if (elemente[j].comparCu(elemente[j + 1]) > 0) {
                        Comparabil auxVar = elemente[j];
                        elemente[j] = elemente[j + 1];
                        elemente[j + 1] = auxVar;
                    }
                }
            }
            System.out.println("A avut loc sortarea stivei in mod descrescator");
        }
    }

    public Comparabil getElement(int i) {
        return elemente[i];
    }

    public String getStringElemente() {

        String listaStudenti = "";

        for (int i = 0; i < nrCurentElemente; i++) {
            listaStudenti += elemente[i];
            listaStudenti += "\r\n";
        }

        return listaStudenti;
    }

    public int getElementeCurente() {
        return nrCurentElemente;
    }

    public void setElemente(Comparabil[] elemente) {
        this.elemente = elemente;
    }

    @Override
    public String toString() {

        String sb = "";
        for (int i = nrCurentElemente - 1; i >= 0; i--) {
            sb += (elemente[i] + "\n");
        }
        System.out.println(sb);
        return sb;
    }
}