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
        System.out.print("\nPARTITA INIZIATA");
        boolean partita= false;
        int i=0;
        while(partita == false){
            i++;
            System.out.print("\nvincitore round " + i);
            giocoCarte();
            partita = finepartita(players);
        }            
        System.out.print("\n!!VINCITORE PARTITA: giocatore " + getVincitore(players).getNome());
    }
    
    private void  giocoCarte(){
        ArrayList<Carta> carteRound = new ArrayList<Carta>();
        boolean partita = false;
        while(partita == false){
            partita = round(players, carteRound);
        }
    }
    
    private Player getVincitore(Player[] players){
        int puntiG1=players[0].getPunti();
        int puntiG2=players[1].getPunti();
        
        if (puntiG1 == puntiG2){
            return null;
        }
        else if (puntiG1 > puntiG2){
            return players[0];
        }
        else if (puntiG1 < puntiG2){
            return players[1];
        }
        else {
            return null;
        }
    }
    
    private boolean finepartita(Player[] players){
        if (players[0].fineCarte() == true){
            if (players[1].fineCarte()== true){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    private boolean round(Player[] round, ArrayList<Carta> carteRound){
        Carta carta1 = round[0].giocaCarta();
        Carta carta2 = round[1].giocaCarta();

        int puntiCarta1 = carta1.getPunteggio();
        int puntiCarta2 = carta2.getPunteggio();
        
        carteRound.add(carta1);
        carteRound.add(carta2);
        
        
        if (puntiCarta1 == puntiCarta2){
            return false;
        }
        else if (puntiCarta1 > puntiCarta2){
            System.out.print(" giocatore " + players[0].getNome());
            addPunteggio(players[0], carteRound);
            return true;
        }
        else if (puntiCarta1 < puntiCarta2){
            System.out.print(" giocatore " + players[1].getNome());
            addPunteggio(players[1], carteRound);
            return true;
        }
        else{
            return false;
        }
    }
    
    private void addPunteggio(Player p, ArrayList<Carta> c){
        for(Carta carta : c){
            p.addPunti(carta);
        }
    }
    

    
    
}
