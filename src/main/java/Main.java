import fileToParse.TheFile;
import parser.parserImplementation.ConfigurationParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        TheFile theFile = new TheFile();
        String file = theFile.fileToReadFrom();
        ConfigurationParser configParser = new ConfigurationParser(file);
        System.out.println(configParser.get("application.name"));

    }
}
