import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Parseur {

    public static Map<String, List<String>> parse(String filePath) throws IOException {
        Map<String, List<String>> translations = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip the first line (dictionary ID)
            while ((line = reader.readLine()) != null) {
                // Vérifier que la ligne contient le séparateur avant de diviser
                if(line.contains(";")) {
                    String[] parts = line.split(";");
                    // Ajoute une vérification supplémentaire pour s'assurer que parts a au moins 2 éléments
                    if (parts.length >= 2) {
                        translations.computeIfAbsent(parts[0], k -> new ArrayList<>()).add(parts[1]);
                    } else {
                        // Gestion des lignes mal formées : loguer ou ignorer
                        System.out.println("Ligne mal formée, ignorée : " + line);
                    }
                }
            }
        }
        return translations;
    }

    @Test
    public void testParseFile() throws IOException {
        // Chemin vers le fichier dictionnaire.txt
        String pathToFile = "Dictionnaire";
        Map<String, List<String>> translations = Parseur.parse(pathToFile);

        // Assertions
        assertEquals(4, translations.size(), "Devrait contenir deux entrées.");
        assertTrue(translations.get("chat").contains("cat"), "Devrait contenir la traduction chat->cat.");
        assertTrue(translations.get("chien").contains("dog"), "Devrait contenir la traduction chien->dog.");
    }
}
