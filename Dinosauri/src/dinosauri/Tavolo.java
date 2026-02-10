/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauri;

import java.io.IOException;

/**
 *
 * @author bernicchi.davide
 */
public class Tavolo {
    Mazzo mazzo;
    Player[] players = {null, null};
    FileManager fm;
    
    Tavolo(FileManager f){
        fm = f;
    }
    
    public void addPlayer() throws IOException{
        if (players[0] == null){
            addPlayer(0);
        }
        else {
            addPlayer(1);
        }
    }
    
    private void addPlayer(int n) throws IOException{
        players[n] = new Player(mazzo);
    }

    private Mazzo Mazzo(String[] readFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
