/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauri;

import java.util.ArrayList;

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
    
    ArrayList<Carta> split(){
        ArrayList<Carta> output = new ArrayList<Carta>();
        for (int i = 0; i<carte.size(); i++){
            output.add(carte.getLast());
            carte.remove(carte.size());
        }
        return output;
    }
    
    
}
