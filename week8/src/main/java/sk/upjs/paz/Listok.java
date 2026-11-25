package sk.upjs.paz;

public class Listok {
    private String kodMeny;
    private double kurz;

    public Listok(String mena, double kurz){
        this.kodMeny=mena;
        this.kurz=kurz;
    }

    public double getKurz() {
        return kurz;
    }

    public String getMena() {
        return kodMeny;
    }

    public String toString(){
        return "[ "+this.kodMeny+" ,"+this.kurz+" ]";
    }
}
