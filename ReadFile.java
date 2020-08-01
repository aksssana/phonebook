package phonebook;

import java.io.*;
import java.util.Scanner;

public class ReadFile {
    private File in;
    private String[] data;


    ReadFile(String file) {
        this.in = new File(file);
    }

    public String[] getData() {
        return data;
    }


    public void readFind() {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine() + "\n");
            }
            data = sb.toString().split("\\n");
        } catch (Exception e) {
            System.out.print("Could not read Find successfully");
            e.printStackTrace();
        }
    }

    public void readDirectoryNames() {
        try (Scanner scanner = new Scanner(in)) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                scanner.nextInt();
                sb.append(scanner.nextLine().substring(1) + "\n");
            }
            data = sb.toString().split("\\n");
        } catch (FileNotFoundException e) {
            System.out.println("Count not read Directory Names successfully");
            e.printStackTrace();
        }

    }

    public String[] readNumbers() {
        try (Scanner scanner = new Scanner(in)) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextInt() + "\n");
                scanner.nextLine();
            }
            return sb.toString().split("\\n");
        } catch (FileNotFoundException e) {
            System.out.println("Count not read Directory Numbers successfully");
            e.printStackTrace();
        }
        return null;
    }

    public static String[] readNames(String[] fullNames) {
        StringBuilder sb = new StringBuilder();
        String[] names = new String[fullNames.length];
        for (int i = 0; i < fullNames.length; i++) {
            names[i] = fullNames[i].split("\\s+")[0];
        }
        return names;
    }

    public static String[] readSurnames(String[] fullNames) {
        String[] surnames = new String[fullNames.length];
        for (int i = 0; i < fullNames.length; i++) {
            surnames[i] = fullNames[i].split("\\s+").length == 2 ? fullNames[i].split("\\s+")[1] : "";
        }
        return surnames;
    }

}