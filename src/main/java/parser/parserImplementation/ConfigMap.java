package parser.parserImplementation;

import parser.ConfigMappable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ConfigMap implements ConfigMappable {

    private String file;
    private LinkedHashMap<String, String> map;

    //Constructs an object with an empty map object
    public ConfigMap(String file) {
        this.file = file;
        map = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, String> theMap() {

        //To read the file
        Scanner scanner;
        try {
            scanner = new Scanner(new File(file));
            //runs as long as the file has another line of input
            while (scanner.hasNextLine()) {
                String value = scanner.nextLine();
                //splits at an '=' and stores in an array
                String[] keyVal = value.split("=");

                //if the array has only one element (we have reached an [application] text)
                if (keyVal.length == 1) {
                    //gets the lines under the [application] text and splits (at '=') them into an array
                    String v = scanner.next();
                    String[] arr = v.split("=");
                    //prepends 'application.' to the first element
                    arr[0] = "application." + arr[0];

                    //makes sure it gets the right string split at '='
                    if (arr.length == 2) {
                        //loops through the array and stores
                        //the two elements as key-value pair respectively in a map
                        for (int i = 0; i < 2; i++) {
                            map.putIfAbsent(arr[0], arr[1]);
                        }
                    }
                }
                //stores the array value in a map if the are already two elements in the map
                if (keyVal.length == 2) {
                    for (int i = 0; i < 2; i++) {
                        map.putIfAbsent(keyVal[0], keyVal[1]);
                    }
                }
                //if there are no more lines of text, returns the map
                if (!(scanner.hasNext())) {
                    return map;
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error opening file or file does not exist");
            e.printStackTrace();
        }
        //if nothing is in the file
        return null;
    }
}

