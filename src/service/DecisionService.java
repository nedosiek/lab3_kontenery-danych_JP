// Plik: src/service/DecisionService.java
package service;

import model.Decision;
import java.util.List;

public interface DecisionService {
    void addDecision(Decision decision);
    List<Decision> getDecisions();
    List<Decision> searchByComponent(String component);
    List<Decision> searchByPerson(String person);
    void saveDecision(); // metoda do zapisywania decyzji do pliku
    void loadDecision(); // metoda do ładowania decyzji z pliku
}
