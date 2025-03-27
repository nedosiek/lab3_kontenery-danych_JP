# lab3_kontenery-danych_JP
Lab3 - data containers

## Treść programowa

Zaprojektowanie i implementacja aplikacji z wykorzystaniem kontenerów danych (tablice, kolekcje) oraz szablonów (*generics*).

# Cel zajęć

Celem zajęć jest zbudowanie aplikacji pozwalającą na interakcję z użytkownikiem z poziomu konsoli. Aplikacja będzie realizować uproszczona wizję przepływu feedbacku w firmie 
zainspirowaną koncepcjami Raya Dalio przedstawionymi w książce "[*Zasady*](https://lubimyczytac.pl/ksiazka/4899240/zasady)", gdzie głównym użytkownikiem będzie manager zarządzający firmą.

Dostępne będą dwie główne funkcjonalności:

- log decyzyjny
- notowanie informacji zwrotnej (feedback) o pracowniku

**Ogólne uwagi odnośnie aplikacji**

W zadaniu występuje wyraźny podział między logiką aplikacji a jej interfejsem. Należy zadbać o tą separację w odpowiedni sposób. Absolutnym minimum jest zaproponowanie odpowiedniego nazewnictwa pakietów i zapewnienie hermetyczności między nimi za pomocą interfejsów. Dodatkowo punktowanym rozwiązaniem jest stworzenie kilku plików JAR np. jeden zawierający wspólne klasy odpowiedzialne za interakcje z logiką za pomocą linii komend, a drugi odpowiednie klasy, serwisy, walidatory i metody persystencji.

Dodatkowo należy zadbać o "kompletność" rozwiązania. Aplikacja oceniana będzie głównie z perspektywy finalnego użytkownika. Należy więc wczuć się w jego rolę (może poprosić osobę niezaangażowaną o opinię). Polecam zwrócić szczególną uwagę na kwestie takie jak walidacja danych wejściowych i obsługa błędów (np. złe parsowanie dat, wartości numerycznych, niepoprawnych wyborów).

W zależności od projektu interfejsu dane mogą trzymane być w pamięci (np. w formie listy), serializowane na dysku, bądź w bazie danych (np. SQLite). Pierwsza opcja jest najprostsza jednak testowanie (bez automatyzacji) będzie bardziej skomplikowane ze względu na konieczność powtarzania wszystkich instrukcji. Może da się opracować sposób testujący aplikację w interaktywny sposób (np poprzez odpowiednie skryptu jak np. [tutaj](https://stackoverflow.com/questions/3448468/is-it-possible-to-make-a-bash-shell-script-interact-with-another-command-line-pr/3450013)).

## Grupa A

**Log decyzyjny**

Wartością logowania podjętych decyzji jest możliwość przeanalizowania czy były 
dobre z perspektywy czasu. W przypadku tego trybu dostępne funkcjonalności powinny wyglądać następująco:

- dodanie nowej decyzji (data, komponent, osoba, stopień ważności, opis/kontekst)
- przeglądanie podjętych decyzji
- wyszukiwanie (np, na podstawie komponentu bądź osoby)
- **Przykład:**
    
    Zespół deweloperski w firmie prowadzi research nt. doboru systemu bazodanowego do nowej aplikacji. Rozważają kilka propozycji. Po podjęciu decyzji kierownik projektu umieszcza informacje na temat podjętej decyzji (dostępne alternatywy, argumenty przemawiające za wyborem) w systemie.
