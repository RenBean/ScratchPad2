package week3.day4;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GummyBearMachine {

    public static void main(String[] args) {
        GummyBears gummyBears = new GummyBears();
        Path myFilePath = Paths.get("GummyBears.json");
        ObjectMapper mapper = new ObjectMapper();
        readfile(gummyBears,myFilePath,mapper);
        System.out.println("------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Want to change your order?  [YES/NO]");
        String changeOrder = scanner.nextLine();
        if(changeOrder.equalsIgnoreCase("yes")) {
            System.out.println("What color?");
            gummyBears.setColor(scanner.nextLine());
            System.out.println("What weight?");
            gummyBears.setWeight(scanner.nextLine());
            System.out.println("What flavor?");
            gummyBears.setFlavor(scanner.nextLine());
            writeFiles(gummyBears,myFilePath,mapper);

            System.out.println("------------------------");
            System.out.println("This is what you wrote");
            readfile(gummyBears,myFilePath,mapper);
        }
    }

    private static void readfile(GummyBears gb, Path p, ObjectMapper m) {
        try {
            gb = m.readValue(Files.newInputStream(p), GummyBears.class);
            System.out.println("COLOR: "+gb.getColor());
            System.out.println("WEIGHT: "+gb.getWeight());
            System.out.println("FLAVOR: "+gb.getFlavor());
        } catch (IOException e) {
            System.out.println("Files does not exist yet...");
        }
    }

    private static void writeFiles(GummyBears gb, Path p, ObjectMapper m) {
        try {
            m.writeValue(Files.newOutputStream(p), gb);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}