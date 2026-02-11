/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dinosauri;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
/**
 *
 * @author bernicchi.davide
 */
public class Dinosauri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String file= "mazzo.txt";
        FileManager fm = new FileManager(file);
        Tavolo table = new Tavolo(fm);
        
        
        table.fillMazzo();
        table.addPlayer();
        table.addPlayer();
        
        
    }
    
}
