import poo.test1.Comparabil;

public class Student extends Comparabil {

    private String nume;
    private int prezenta;

    public Student(String nume, int prezenta) {
        this.nume = nume;
        this.prezenta = prezenta;
    }

    @Override
    public int comparCu(Comparabil deComparat) {
        Student s = (Student) deComparat;
        if (prezenta > s.getPrezenta()) {
            return 1;
        } else {
            if (prezenta < s.getPrezenta()) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ " + nume + " " + prezenta + "]");
        return sb.toString();
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getPrezenta() {
        return prezenta;
    }

    public void setPrezenta(int prezenta) {
        this.prezenta = prezenta;
    }
}
