/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

/**
 *
 * @author Lenovo
 */
public abstract class Vadaszgep {
    private double palyzs;
    private double tuzero;

    public double getPalyzs() {
        return palyzs;
    }

    public void setPalyzs(double palyzs) {
        this.palyzs = palyzs;
    }

    public double getTuzero() {
        return tuzero;
    }

    public void setTuzero(double tuzero) {
        this.tuzero = tuzero;
    }
    
    private boolean megsemmisült(){
        return palyzs <=0;
    }
    
}
