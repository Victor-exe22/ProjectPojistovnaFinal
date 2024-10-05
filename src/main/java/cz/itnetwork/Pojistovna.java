package cz.itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class Pojistovna {

    /* Databáze uživatelů */
    private Databaze databaze;
    /* Scanner pro vstup od uživatele */
    private Scanner scanner = new Scanner(System.in);

    /* Konstruktor třídy Pojistovna */
    public Pojistovna() {
        databaze = new Databaze();
    }

    /* Metoda pro vypsání všech uživatelů */
    public void vypisUzivatele() {
        ArrayList<Uzivatel> uzivatele = databaze.getUzivatele();
        for (Uzivatel uzivatel : uzivatele) {
            System.out.printf("Jméno a příjmení: %s %s%n",uzivatel.getJmeno(), uzivatel.getPrijmeni());
            System.out.printf("Věk: %d%n",uzivatel.getVek());
            System.out.printf("Telefonní číslo: %d%n",uzivatel.getTelefoniCislo());
            System.out.println("--------------------------");
        }
    }

    /* Metoda pro přidání nového uživatele */
    public void pridejUzivatele() {
        System.out.println("Zadej jméno");
        String jmeno = scanner.nextLine();
        jmeno = jmeno.toLowerCase().trim();
        System.out.println("Zadejte příjmení");
        String prijmeni = scanner.nextLine();
        prijmeni = prijmeni.toLowerCase().trim();
        int vek = naparsujVek();
        long telefoniCislo = naparsujTelefon();
        databaze.pridejUzivatele(jmeno, prijmeni, vek, telefoniCislo);
    }

    /* Metoda pro vyhledání uživatele podle jména a příjmení */
    public void vyhledejUzivatele(){
        System.out.println("Napiš křestní jméno");
        String hledaneJmeno = scanner.nextLine();
        hledaneJmeno = hledaneJmeno.toLowerCase().trim();
        System.out.println("Napiš příjmení");
        String hledanePrijmeni = scanner.nextLine();
        hledanePrijmeni = hledanePrijmeni.toLowerCase().trim();
        ArrayList<Uzivatel> nalezeni = databaze.najdiUzivatele(hledaneJmeno, hledanePrijmeni);
        if (nalezeni.size() > 0) {
            System.out.println("Nalezení uživatelé: ");
            for (Uzivatel zaznam : nalezeni) {
                System.out.println(zaznam);
            }
        } else {
            System.out.println("Nebyly nalezeny žádné záznamy.");
        }
    }

    /* Metoda pro vypsání nadpisu */
    public void vypisNadpisu(){
        System.out.println("--------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("--------------------------");
    }

    /* Metoda pro vypsání dostupných akcí */
    public void vypisAkce() {
        System.out.println("Vzberte akci");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 -  Konec");
    }

    /* Metoda pro parsování věku od uživatele */
    public int naparsujVek() {
        System.out.println("Zadej svůj věk");
        int vek = 0;
        do {
            try {
                vek = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Zadej věk pouze čísly!!!");
            }
        }while (vek == 0);
        return vek;
    }

    /* Metoda pro parsování telefonního čísla od uživatele */
    public long naparsujTelefon(){
        System.out.println("Zadej svoje telefonní číslo ve tvaru 222333444");
        long telefoniCislo = 0;
        do {
            try {
                telefoniCislo = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Napiš číslo ve správném tvaru!!!");
            }
        }while (telefoniCislo == 0);
        return telefoniCislo;
    }
}
