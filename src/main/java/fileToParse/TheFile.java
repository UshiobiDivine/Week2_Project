package fileToParse;

import java.util.Scanner;

/*This class returns the path to a configuration file*/

public class TheFile {

    //Constructor
    public TheFile() {
    }

    //this method the right file to be read, based on user input
    public String fileToReadFrom() {
        //the path of the files
        String prod = "src/main/resources/files/config.txt";
        String stage = "src/main/resources/files/config_ staging.txt";
        String dev = "src/main/resources/files/config_dev.txt";

        String theFile = null;

        System.out.println("\nPlease select which configuration file to open");
        System.out.println("1. Production\n2. Development\n3. Staging");

        //allows users to choose the right configuration file to open
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        //sets and returns the path of the configuration file
        switch (input.toLowerCase()) {
            case "1":
            case "production":
                theFile = prod;
                break;
            case "2":
            case "development":
                theFile = dev;
                break;
            case "3":
            case "staging":
                theFile = stage;
                break;
            default:
                System.out.println("\nInvalid entry, please enter the file name or their respective number");
                break;
        }
        return theFile;
    }
}
