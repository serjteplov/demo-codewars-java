package ru.serj;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (InputStream inputStream = Main.class.getResourceAsStream("/1.txt");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ) {

            File file = new File("src/main/resources/1.txt");
            char[] buf = new char[1000];
            int i = 0;
            while (i+31 < file.length()) {
                if (i+31 < file.length()) bufferedReader.read(buf, i, i + 30);
                i += 33;
                System.out.println("buf = " + new String(buf));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}