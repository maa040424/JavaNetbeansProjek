/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan01;

/**
 *
 * @author ASUS
 */
public class Kubus extends Persegi {
    public double getVolume(){
//        return getSisi() * getSisi() * getSisi();
          return getLuas() * getSisi();
    }
    public double getLuasPermukaan(){
        // 6 x sisi x sisi
        return 6 * getLuas();
    }
}
