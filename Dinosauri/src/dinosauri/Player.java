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
    
    Player(Mazzo m){
        mazzo = m;
    }
    
    @Override
    public String toString(){
        return mazzo.toString();
    }
}
