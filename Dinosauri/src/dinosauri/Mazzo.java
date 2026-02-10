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
    
    ArrayList<Carta> split(){
    }
    
    
}
