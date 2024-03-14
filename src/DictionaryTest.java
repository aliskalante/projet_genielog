import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {
    @Test
    public void testGetName() {
        Dictionary dictionary = new Dictionary("Français-Anglais");
        assertEquals("Français-Anglais", dictionary.getName());
    }
}
