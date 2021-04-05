package parser.parserImplementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationParserTest {
ConfigurationParser parser = new ConfigurationParser("src/main/resources/files/config.txt");
    @Test
    void get() {
        String p = parser.get("dbname");
        assertTrue(p.equals("sq04_db"));
    }
}