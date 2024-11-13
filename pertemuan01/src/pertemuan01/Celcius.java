/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan01;

/**
 *
 * @author ASUS
 */
public class Celcius {
    //penerapan konsep oop (Encapsulation)
    //syaratnya
    //1. Sembunyikan data
    //2. Untuk Mengakses data gunakan method accessor / mutator
    
    private double celcius;

    public double getCelcius() {
        return celcius;
    }

    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }
    
    public double getFahrenheit(){
        return 1.8 * getCelcius() + 32;
    }
    public double getKelvin(){
        return  getCelcius() + 273.15;
    }
    public double getReamur(){
        return 0.8 * getCelcius();
    }
    
    
}
