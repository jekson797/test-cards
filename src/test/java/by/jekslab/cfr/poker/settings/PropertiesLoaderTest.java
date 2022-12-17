package by.jekslab.cfr.poker.settings;

import by.jekslab.cfr.settings.PropertiesLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

class PropertiesLoaderTest {

    @Test
    void given_ValidPropertiesFile_When_Load_Then_LoadedSuccessful() {
        File propertiesSource = new File("src/test/resources/valid.properties");
        Map<String, String> properties = PropertiesLoader.load(propertiesSource);

        Assertions.assertTrue(properties.containsKey("easy"));
        Assertions.assertEquals("value", properties.get("easy"));

        Assertions.assertTrue(properties.containsKey("complicated-property.key"));
        Assertions.assertEquals("complicated-value.1", properties.get("complicated-property.key"));
    }

    @Test
    void given_IncorrectPropertiesFile_When_Load_Then_ThrowException() {
        File propertiesSource = new File("src/test/resources/invalid.properties");
        Assertions.assertThrows(IllegalArgumentException.class, () -> PropertiesLoader.load(propertiesSource));
    }

    @Test
    void given_WrongFilePath_When_Load_Then_ThrowException() {
        File propertiesSource = new File("/wrong/path");
        Assertions.assertThrows(RuntimeException.class, () -> PropertiesLoader.load(propertiesSource));
    }
}
