/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dinosauri;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bernicchi.davide
 */
public class FileManager {
    
    String file= "mazzo.txt";
    BufferedReader br ;
    
    FileManager(String f){
        file = f;
    }
    
    String[] readFile() throws FileNotFoundException, IOException{
        
        String riga;
        br = new BufferedReader(new FileReader(file));
        
        String output = "";
        
        while ((riga = br.readLine()) != null){
            output += riga + ",";
        }
        return output.split(",");
    }
}
