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
    int lunghezza = carte.size();
    
    
    Mazzo(String[] cc){
        for (int i= 0; i<cc.length;i++){
            carte.add(new Carta(cc[i]));
        }
    }    
    Mazzo(ArrayList<Carta> cc){
        carte = cc;
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
    
    public Carta getCarta(){
        Carta output = carte.getLast();
        carte.removeLast();
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
