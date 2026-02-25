/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauri;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author bernicchi.davide
 */
public class Tavolo extends TavoloDiGioco{
    Mazzo mazzo;
    Player[] players = {null, null};
    FileManager fm;
    
    
    
    
    Tavolo(FileManager f){
        fm = f;
    }
    
    public Player getPlayer1(){
        return players[0];
    }
    
    public Player getPlayer2(){
        return players[1];
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
        players[n] = new Player(new Mazzo(mazzo.dividi()), ""+(n+1));
    }
    
    @Override
    public String toString(){
        return players[0] + " vs " + players[1];
    } 
    
    public void iniziapartita(JTextArea pannelloTavolo){
        pannelloTavolo.setText("INIZIO PARTITA");
        boolean partita= false;
        int i=0;
        while(partita == false){
            i++;
            pannelloTavolo.setText(pannelloTavolo.getText() + "\nRound " + i + ":");
            giocoCarte(pannelloTavolo);
            partita = finepartita(players);
        }            
        pannelloTavolo.setText(pannelloTavolo.getText() + "\n!!VINCITORE PARTITA: giocatore " + getVincitore(players).getNome() + " con: " +getVincitore(players).getPunti() + " punti\n" );
    }
    
    private void  giocoCarte(JTextArea pannelloTavolo){
        ArrayList<Carta> carteRound = new ArrayList<Carta>();
        boolean partita = false;
        while(partita == false){
            partita = round(players, carteRound, pannelloTavolo);
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
    
    private boolean round(Player[] round, ArrayList<Carta> carteRound, JTextArea pannelloTavolo){
        Carta carta1 = round[0].giocaCarta();
        Carta carta2 = round[1].giocaCarta();

        int puntiCarta1 = carta1.getPunteggio();
        int puntiCarta2 = carta2.getPunteggio();
        
        carteRound.add(carta1);
        carteRound.add(carta2);
        
        
        pannelloTavolo.setText(pannelloTavolo.getText() + "<< " +carta1+ " vs " +carta2+ " >>");
        
        if (puntiCarta1 == puntiCarta2){
            pannelloTavolo.setText(pannelloTavolo.getText() + "--parita--");
            return false;
        }
        else if (puntiCarta1 > puntiCarta2){
            pannelloTavolo.setText(pannelloTavolo.getText() + "Vincitore giocatore " + players[0].getNome() + " ++" + getPuntiRound(carteRound)+" punti");
            addPunteggio(players[0], carteRound);
            return true;
        }
        else if (puntiCarta1 < puntiCarta2){
            pannelloTavolo.setText(pannelloTavolo.getText() + "incitore giocatore " + players[1].getNome() + " ++" +getPuntiRound(carteRound)+" punti");
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
    
    private int getPuntiRound(ArrayList<Carta> carte){
        int output=0;
        for(Carta c: carte){
            output+=c.getPunteggio();
        }
        return output;
    }
    
    
}
