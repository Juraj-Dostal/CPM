**Metóda CPM**
_____________________________________
Metóda CPM šluži na





________________________________________
**Popis fungovania algoritmu**:

**Najskôr možný začiatok z(A)**
  - začiatok vykonávania projektu začne v čase 0.
  - Je prvý okamih od začiatku projektu od ktorého začína činnosť A pri dodržaní relácie precedencie.
  - Z celého projektu zistíme trvanie projektu T tak, že nájdeme takú činnosť A, ktorá má najväčšiu hodnotu zo začiatku A + doba trvania A od všetkých činností. T = MAX(z(A) + p(A) | A ∈ E )
  **Algoritmus** na určenie najskôr možných začiatkov z(v):
    - elementárnych činností v digrafe → G≺≺ = (V, H, c).
    - Krok 1. Vytvor monotónne očíslovanie v1, v2, . . . , vn vrcholov digrafu → G≺≺
    - Krok 2. Každému vrcholu v ∈ V priraď dve značky z(v), x(v).Pre každé v ∈ V inicializačné polož x(v) == 0, z(v) == 0
    - Krok 3. Postupne pre k = 1,2, . . . , n − 1 urob: Pre všetky také vrcholy w z výstupnej hviezdy vrchola vk, že w != vk, urob: Ak z(w) < z(vk) + c(vk), potom z(w) == z(vk) + c(vk) a x(w) == vk.
    - Krok 4. Vypočítaj trvanie projektu T == max{z(w) + c(w) | w ∈ V, odeg(w) = 0} Trvanie projektu T je celková doba trvania projektu.

**Najneskôr nutný koniec k(A)**
  - Musíme poznať trvanie projektu T.
  - Je posledný okamihov začiatku vykonávania projektu, po ktorom sa môže činnosť A oneskoriť bez vzniku predlženia.
  **Algoritmus** na určenie najneskôr nutných koncov k(v):
    - elementárnych činností v digrafe →G≺≺ = (V, H, c).
    - Skoro podobne ako pri začiatkov
    - Krok 1. Vytvor monotónne očíslovanie v1, v2, . . . , vn vrcholov digrafu−→G≺≺ .
    - Krok 2. Každému vrcholu v ∈ V priraď dve značky k(v), y(v). Nech T je trvanie projektu. Pre každé v ∈ V inicializačne polož k(v) == T , y(v) == 0 .
    - Krok 3. Postupne pre i = n − 1, n − 2, . . . ,1 urob: Pre všetky vrcholy w výstupnej hviezdy vrchola vi také, že w != vi, urob: Ak k(vi) > k(w) − c(w), potom k(vi) == k(w) − c(w) a y(vi) == w.
      
**Časová rezerva R(A)** činnosti A je R(A) = k(A) − z(A) − p(A).

________________________________________
**Ako spustiť**:

Ku algoritmu sú dostupné aj vstupné údaje(Digrafy). V main class stači premenovať názov vstupného súboru a spustiť.

________________________________________
Tento algoritmus som programoval na predmet Algoritmická teória grafov.
Ma slúžiť na inspiráciu a odkontrolovanie si vysledkov.
