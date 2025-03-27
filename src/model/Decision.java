// Plik: src/model/Decision.java
package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Decision implements Serializable {
    private static final long serialVersionUID = 1L;
    private final LocalDate date;
    private final String component;
    private final String person;
    private final int importance;
    private final String description;

    // Konstruktor
    public Decision(LocalDate date, String component, String person, int importance, String description) {
        this.date = date;
        this.component = component;
        this.person = person;
        this.importance = importance;
        this.description = description;
    }

    // Gettery i settery
    public LocalDate getDate() {
        return date;
    }

    public String getComponent() {
        return component;
    }

    public String getPerson() {
        return person;
    }

    public int getImportance() {
        return importance;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Decyzja {" +
                "data: " + date +
                ", komponent: '" + component + '\'' +
                ", osoba: '" + person + '\'' +
                ", stopien waznosci: " + importance +
                ", opis: '" + description + '\'' +
                '}';
    }
}
