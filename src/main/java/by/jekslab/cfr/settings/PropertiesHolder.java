package by.jekslab.cfr.settings;

import java.io.File;
import java.util.Map;

public class PropertiesHolder {

    private static final Map<String, String> properties;

    static {
        properties = PropertiesLoader.load(new File("src/test/resources/app.properties"));
    }

    public static String getProperty(String key) {
        return properties.get(key);
    }
}
