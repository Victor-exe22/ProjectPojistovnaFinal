package cz.itnetwork;

public class Uzivatel {

    /* Jméno osoby */
    private String jmeno;
    /* Příjmení osoby */
    private String prijmeni;
    /* Věk osoby */
    private int vek;
    /* Telefonní číslo osoby */
    private long telefoniCislo;

    /* Konstruktor třídy Uzivatel */
    public Uzivatel(String jmeno, String prijmeni, int vek, long telefoniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek =  vek;
        this.telefoniCislo = telefoniCislo;
    }
    /* Getter pro jméno */
    public String getJmeno() {
        return jmeno;
    }
    /* Getter pro věk */
    public int getVek() {
        return vek;
    }

    /* Getter pro telefonní číslo */
    public long getTelefoniCislo() {
        return telefoniCislo;
    }
    /* Getter pro příjmení */
    public String getPrijmeni() {
        return prijmeni;
    }
    /* Přepsání metody toString pro formátovaný výstup */
    @Override
    public String toString(){
        return String.format("Jméno a příjmení: %s %s%nVěk: %d%nTelefonní číslo: %d%n", jmeno, prijmeni,vek,telefoniCislo);

    }

}
