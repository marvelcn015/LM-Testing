package final4j.lmtesting.Component;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class ApiKeySet {
    private static Properties prop = new Properties();
    public static String OPENAI_API_KEY;
    public static String COHERE_API_KEY;
    public static String GEMINI_API_KEY;

    public static void init() {
        try (FileInputStream file = new FileInputStream("config.properties")) {
            prop.load(file);
            OPENAI_API_KEY = prop.getProperty("OPENAI_API_KEY");;
            COHERE_API_KEY = prop.getProperty("COHERE_API_KEY");
            GEMINI_API_KEY = prop.getProperty("GEMINI_API_KEY");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}

