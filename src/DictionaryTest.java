import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {
    @Test
    public void testGetNom() {
        Dictionary dictionary = new Dictionary("Français-Anglais");
        assertEquals("Français-Anglais", dictionary.getName(), "Le nom du dictionnaire ne correspond pas.");
    }

    @Test
    public void testDictionairevide() {
        Dictionary dictionary = new Dictionary("Français-Anglais");
        assertTrue(dictionary.isEmpty(), "Le dictionnaire doit être vide.");
    }

    @Test
    public void testTradutionmultiple() {
        Dictionary dictionary = new Dictionary("Français-Anglais");
        dictionary.ajoutTranslation("chat", "cat");
        dictionary.ajoutTranslation("chat", "kitty");
        List<String> translations = dictionary.getMultipleTranslations("chat");

        assertTrue(translations.contains("cat"), "La liste devrait contenir 'cat'.");
        assertTrue(translations.contains("kitty"), "La liste devrait contenir 'kitty'.");
        assertEquals(2, translations.size(), "La liste devrait contenir exactement 2 traductions.");
    }
    @Test
    public void testTraductionBidirectionnelle() {
        Dictionary dictionary = new Dictionary("Bilingue");
        dictionary.ajoutTranslationBidirectionnelle("pied", "feet", "Français", "Anglais");

        List<String> translationsFromFrToEn = dictionary.getMultipleTranslations("pied");
        List<String> translationsFromEnToFr = dictionary.getMultipleTranslations("feet");

        assertTrue(translationsFromFrToEn.contains("feet"), "La liste devrait contenir 'feet'.");
        assertTrue(translationsFromEnToFr.contains("pied"), "La liste devrait contenir 'pied'.");
    }

}
