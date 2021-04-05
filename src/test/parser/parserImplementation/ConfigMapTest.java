package parser.parserImplementation;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfigMapTest {

    ConfigMap configMap = new ConfigMap("src/main/resources/files/config.txt");
    @Test
    void theMap() {
        Map<String,String> map = configMap.theMap();
        assertTrue(map.containsKey("dbname"));
        assertEquals("production", map.get("application.mode"));
    }
}