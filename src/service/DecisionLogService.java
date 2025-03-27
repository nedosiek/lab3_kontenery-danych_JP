// Plik: src/service/DecisionLogService.java
package service;

import model.Decision;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DecisionLogService implements DecisionService {
    private final List<Decision> decisionLog = new ArrayList<>();
    private static final String FILE_NAME = "decisions.ser";

    public DecisionLogService() {
        loadDecision();
    }

    @Override
    public void addDecision(Decision decision) {
        decisionLog.add(decision);
        saveDecision();
    }

    @Override
    public List<Decision> getDecisions() {
        return new ArrayList<>(decisionLog);
    }

    @Override
    public List<Decision> searchByComponent(String component) {
        List<Decision> results = new ArrayList<>();
        for (Decision decision : decisionLog) {
            if (decision.getComponent().equalsIgnoreCase(component)) {
                results.add(decision);
            }
        }
        return results;
    }

    @Override
    public List<Decision> searchByPerson(String person) {
        List<Decision> results = new ArrayList<>();
        for (Decision decision : decisionLog) {
            if (decision.getPerson().equalsIgnoreCase(person)) {
                results.add(decision);
            }
        }
        return results;
    }

    @Override
    public void saveDecision() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(decisionLog);
        } catch (IOException e) {
            System.out.println("Blad podczas zapisywania decyzji: " + e.getMessage());
        }
    }

    @Override
    public void loadDecision() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Decision> loadedDecisions = (List<Decision>) ois.readObject();
            decisionLog.clear();
            decisionLog.addAll(loadedDecisions);
        } catch (FileNotFoundException e) {
            System.out.println("Brak zapisanych decyzji.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Blad podczas ladowania decyzji: " + e.getMessage());
        }
    }

    // Nowa funkcja usuwania decyzji
    public boolean removeDecision(Decision decisionToRemove) {
        boolean removed = decisionLog.removeIf(decision ->
                decision.getDate().equals(decisionToRemove.getDate()) &&
                        decision.getPerson().equals(decisionToRemove.getPerson()));

        if (removed) {
            saveDecision();  // Zapisujemy zaktualizowaną listę po usunięciu
        }
        return removed;
    }

    // Nowa funkcja do usunięcia wszystkich decyzji
    public void clearAllDecisions() {
        decisionLog.clear();
        saveDecision();  // Zapisujemy pustą listę do pliku
    }
}
