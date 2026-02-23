/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinosauri;

/**
 *
 * @author bernicchi.davide
 */
public class Carta {
    String colore;
    int punteggio;
    
    Carta(String c){
        colore=c;
    }
    
    @Override
    public String toString(){
        return colore;
    }
    
    public int getPunteggio(){
        switch(colore){
            case "Rosso":
                return 5;
            case "Verde":
                return 3;               
            case "Giallo":
                return 1;
            default:
                return 0;
        }
    }
}
