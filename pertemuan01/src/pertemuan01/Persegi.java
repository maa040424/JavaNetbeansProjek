/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan01;

/**
 *
 * @author ASUS
 */
public class Persegi {
    private double sisi;

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }
    
    public double getLuas(){
        return getSisi() * getSisi();
    }
    public double getKeliling(){
        return 4 * getSisi();
    }
}
