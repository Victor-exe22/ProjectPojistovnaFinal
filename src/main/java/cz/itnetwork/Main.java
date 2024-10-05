package cz.itnetwork;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inicializace třídy Pojistovna
        Pojistovna pojistovna = new Pojistovna();
        // Scanner pro vstup od uživatele
        Scanner scanner = new Scanner(System.in);
        
        int ukonceniProgramu;
        int vyberAkce = 0; // Proměnná pro výběr akce
        pojistovna.vypisNadpisu(); // Výpis nadpisu

        // Hlavní cyklus pro interakci s uživatelským rozhraním
        do {
            pojistovna.vypisAkce();  // Výpis dostupných akcí
            try {
                vyberAkce = Integer.parseInt(scanner.nextLine()); // Načtení výběru akce od uživatele
            }catch (Exception e) {
                System.out.println("Použij pouze čísla!!!"); // Ošetření chyb při vstup
            }

            switch (vyberAkce) {
                case (1): {  // Přidání nového uživatele
                    int volba;
                    do {
                        pojistovna.pridejUzivatele();
                        System.out.println("Přejete si přidat dalšího uživatele? (1 = ANO/2 = NE)");
                        volba = Integer.parseInt(scanner.nextLine());
                    } while (volba == 1);
                }
                break;
                case (2): {  // Výpis všech uživatelů
                    pojistovna.vypisUzivatele();
                }
                break;
                case (3): { // Vyhledání uživatele
                    pojistovna.vyhledejUzivatele();
                }
                break;
            }
        } while (vyberAkce != 4);
    }
}