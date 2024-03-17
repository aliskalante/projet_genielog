import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    private String name;
    private Map<String, List<String>> entries = new HashMap<>();

    public Dictionary(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isEmpty() {
        return entries.isEmpty();
    }

    public void ajoutTranslation(String fr, String en) {
        // Vérifie si le mot existe déjà dans le dictionnaire
        entries.computeIfAbsent(fr, k -> new ArrayList<>()).add(en);
    }
    public void ajoutTranslationBidirectionnelle(String mot1, String mot2, String langue1, String langue2) {
        ajoutTranslation(mot1, mot2); // De langue1 à langue2
        ajoutTranslation(mot2, mot1); // De langue2 à langue1
    }


    public List<String> getMultipleTranslations(String word) {
        return entries.getOrDefault(word, new ArrayList<>());
    }
}
