package ui;// Plik: src/ui.Main.java
import model.Decision;
import service.DecisionService;
import service.DecisionLogService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecisionService decisionService = new DecisionLogService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Dodaj decyzje");
            System.out.println("2. Wyswietl wszystkie decyzje");
            System.out.println("3. Wyszukaj decyzje po komponencie");
            System.out.println("4. Wyszukaj decyzje po osobie");
            System.out.println("5. Usun decyzje");
            System.out.println("6. Usun wszystkie decyzje");
            System.out.println("7. Wyjdz");


            int choice = 0;
            // Obsługa błędu w przypadku podania nieprawidłowego wyboru
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Wybierz opcję: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    validInput = true;  // Jeśli wpisana wartość jest poprawna, wychodzimy z pętli
                } catch (NumberFormatException e) {
                    System.out.println("Podaj liczbę");
                }
            }


            switch (choice) {
                case 1 -> {
                    LocalDate date = null;
                    while (date == null) {
                        System.out.print("Data (YYYY-MM-DD): ");
                        try {
                            date = LocalDate.parse(scanner.nextLine());
                        } catch (DateTimeParseException e) {
                            System.out.println("Nieprawidłowy format daty. Podaj datę w formacie YYYY-MM-DD.");
                        }
                    }
                    System.out.print("Komponent: ");
                    String component = scanner.nextLine();
                    System.out.print("Osoba: ");
                    String person = scanner.nextLine();
                    System.out.print("Stopien waznosci (1-5): ");
                    int importance = Integer.parseInt(scanner.nextLine());
                    System.out.print("Opis: ");
                    String description = scanner.nextLine();

                    Decision decision = new Decision(date, component, person, importance, description);
                    decisionService.addDecision(decision);
                    System.out.println("Decyzja zostala dodana.\n");
                }
                case 2 -> {
                    System.out.println("Lista wszystkich decyzji:");
                    for (Decision decision : decisionService.getDecisions()) {
                        System.out.println(decision);
                    }
                }
                case 3 -> {
                    System.out.print("Wprowadz komponent: ");
                    String component = scanner.nextLine();
                    System.out.println("Decyzje dla komponentu: " + component);
                    var foundDecisions = decisionService.searchByComponent(component);
                    if (foundDecisions.isEmpty()){
                        System.out.println("Brak decyzji dla danego komponentu.");
                    } else{
                         for (Decision decision : foundDecisions) {
                             System.out.println(decision);
                         }
                        }
                    System.out.println();
                    }
                case 4 -> {
                    System.out.print("Wprowadz osobe: ");
                    String person = scanner.nextLine();
                    System.out.println("Decyzje dla osoby: " + person);
                    var foundDecisions = decisionService.searchByPerson(person);
                    if (foundDecisions.isEmpty()) {
                        System.out.println("Brak decyzji dla danej osoby.");
                    } else {
                        for (Decision decision : foundDecisions) {
                            System.out.println(decision);
                        }
                    }
                    System.out.println();
                }
                case 5 -> {
                    System.out.print("Wprowadz dane decyzji do usuniecia: ");
                    System.out.println("Data (YYYY-MM-DD): ");
                    LocalDate dateToRemove = LocalDate.parse(scanner.nextLine());
                    System.out.println("Osoba: ");
                    String personToRemove = scanner.nextLine();

                    Decision decisionToRemove = new Decision(dateToRemove, "", personToRemove, 0, "");
                    boolean removed = ((DecisionLogService) decisionService).removeDecision(decisionToRemove);
                    if (removed) {
                        System.out.println("Decyzja zostala usunieta.");
                    } else {
                        System.out.println("Decyzja nie zostala znaleziona.");
                    }
                    System.out.println();
                }
                case 6 -> {
                    ((DecisionLogService) decisionService).clearAllDecisions();
                    System.out.println("Wszystkie decyzje zostaly usuniete.");
                    System.out.println();
                }
                case 7 -> {
                    System.out.println("Zamykanie aplikacji.");
                    //scanner.close();
                    return;
                }
                default -> System.out.println("Niepoprawny wybor.");
            }
            System.out.println();
        }
    }
}
