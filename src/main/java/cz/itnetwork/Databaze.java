package cz.itnetwork;
import java.util.Scanner;
import java.util.ArrayList;

public class Databaze {

    /* Seznam uživatelů */
    private ArrayList<Uzivatel> uzivatele;

    /* Konstruktor třídy Databaze */
    public Databaze() {
        uzivatele = new ArrayList<>();


    }

    /* Metoda pro získání kopie seznamu uživatelů */
    public ArrayList<Uzivatel> getUzivatele() {
        return new ArrayList<>(uzivatele);
    }

    /* Metoda pro přidání nového uživatele */
    public void pridejUzivatele(String jmeno, String prijmeni, int vek, long telefoniCislo) {
        uzivatele.add(new Uzivatel(jmeno, prijmeni, vek, telefoniCislo));
    }

    /* Metoda pro vyhledání uživatelů podle jména a příjmení */
    public ArrayList<Uzivatel> najdiUzivatele(String hledaneJmeno, String hledanePrijmeni) {
        ArrayList<Uzivatel> nalezene = new ArrayList<>();
        for (Uzivatel uzivatel : uzivatele) {
            if (hledaneJmeno.equals(uzivatel.getJmeno()) && hledanePrijmeni.equals(uzivatel.getPrijmeni())) { nalezene.add(uzivatel);
            }
        }
        return nalezene;
    }
}
