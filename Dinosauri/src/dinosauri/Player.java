/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauri;

/**
 *
 * @author bernicchi.davide
 */
public class Player {
    Mazzo mazzo;
    Mazzo punti = new Mazzo();
    String nome = "giocatore 1";
    
    Player(Mazzo m){
        mazzo = m;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Carta giocaCarta(){
        return mazzo.giocaCarta();
    }
    
    public void addPunti(Carta carta){
        punti.addCarta(carta);
    }
    
    public int getPunti(){
        int output = 0;
        for(Carta c : punti.getCarte()){
            output += c.getPunteggio();
        }
        return output;
    }
    
    public void svuotaMazzo(){
        punti.clear();
    }
    
    public boolean fineCarte(){
        if (mazzo.getLungezza() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return mazzo.toString();
    }
}
