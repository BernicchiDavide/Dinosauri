/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauri;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author bernicchi.davide
 */
public class Mazzo {
    
    ArrayList<Carta> carte = new ArrayList<Carta>();
    
    
    Mazzo(String[] cc){
        for (int i= 0; i<cc.length;i++){
            carte.add(new Carta(cc[i]));
        }
    }    
    Mazzo(ArrayList<Carta> cc){
        carte = cc;
    }    
    Mazzo(){
        
    }
    
    public int getLungezza(){
        return carte.size();
    }
    
    public ArrayList<Carta> getCarte(){
        return carte;
    }
    
    public void clear(){
        for(Carta c: carte){
            carte.removeLast();
        }
    }
    
    public void addCarta(Carta carta){
        carte.add(carta);
    }
    
    void shuffle(){
        Collections.shuffle(carte);
    }
    
    ArrayList<Carta> dividi(){
        ArrayList<Carta> output = new ArrayList<Carta>();
        if (carte.size() > 15){
            for (int i = 0; i<carte.size(); i++){
                output.add(carte.getLast());
                carte.remove(carte.size()-1);
            }
        }
        else {
            output = carte;
        }
        return output;
    }
    
    public Carta giocaCarta(){
        Carta output = carte.getLast(); //non funziona solo quando si fa partire a velocità normale
        carte.removeLast();             //se si fa il debug funziona sempre
        return output;
    }
    
    @Override
    public String toString(){
        String output="";
        for (int i = 0; i<carte.size(); i++){
            output += carte.get(i) + "\n";
        }
        return "carte: \n" + output;
    }
    
}
