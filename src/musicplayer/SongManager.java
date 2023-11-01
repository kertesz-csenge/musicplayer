/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicplayer;

import java.nio.file.Files;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class SongManager {

    public SongManager() {
        scan();

    }

    public Set<String> listFiles(String dir) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }

    public void scan() {
        try {
            for (String name : listFiles("C:\\Users\\Csenge\\Documents\\music")) {
                System.out.printf("name: %s\n", name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("folder scan complete");
    }
    
}

