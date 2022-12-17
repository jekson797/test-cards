package by.jekslab.cfr.settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesLoader {

    private PropertiesLoader() {
    }

    public static Map<String, String> load(File propertiesSource) {
        try (BufferedReader reader = new BufferedReader(new FileReader(propertiesSource))) {
            return readProperties(reader);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static Map<String, String> readProperties(BufferedReader reader) throws IOException {
        Map<String, String> properties = new HashMap<>();

        String line;
        while((line = reader.readLine()) != null) {
            Pattern pattern = Pattern.compile("([^\\s]+)=([^\\s]+)");
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                String key = matcher.group(1);
                String value = matcher.group(2);
                properties.put(key, value);
            } else {
                throw new IllegalArgumentException("Property parsing failure. Property - " + line);
            }
        }
        return properties;
    }
}
