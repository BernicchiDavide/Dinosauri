/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauri;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bernicchi.davide
 */
public class Tavolo {
    Mazzo mazzo;
    Player[] players = {null, null};
    FileManager fm;
    
    ArrayList<Carta> round = new ArrayList<Carta>();
    
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
    
    void fillMazzo() throws IOException{
        mazzo = new Mazzo(fm.readFile());
    }
    
    private void addPlayer(int n){
        mazzo.shuffle();
        players[n] = new Player(new Mazzo(mazzo.dividi()));
    }
    
    @Override
    public String toString(){
        return players[0] + " vs " + players[1];
    } 
    
    public void iniziapartita(){
        
    }
    
    private void giocoCarte(){
        players[0].giocaCarta();
        players[1].giocaCarta();
        round.add(players[0].giocaCarta());
        round.add(players[1].giocaCarta());
    }
    
    private Player getVincitore(Carta c1, Carta c2){
        if (c1 == c2){
            return null;
        }
        return null;
    }
    
    
}
