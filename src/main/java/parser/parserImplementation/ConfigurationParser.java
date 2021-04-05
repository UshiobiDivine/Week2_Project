package parser.parserImplementation;

import parser.ConfigurationParseable;

import java.util.LinkedHashMap;

public class ConfigurationParser implements ConfigurationParseable {

    private LinkedHashMap<String, String> myMap;
    private String file;
    private ConfigMap configMap;

    //Constructs an object if the file is not null, initializes a ConfigMap object with the file
    public ConfigurationParser(String file) {
        if (file != null) {
            this.file = file;
            configMap = new ConfigMap(this.file);
            myMap = configMap.theMap();
        }
    }

    //gets a value with a key from the parsed file in the map (if the file is not null)
    public String get(Object key) {
        if (file != null)
            return myMap.get(key);
        return "";
    }


    /*
    public String put(String key, String value) {
        return myMap.put(key, value);
    }

    public String remove(Object key) {
        return myMap.remove(key);
    }*/

}
