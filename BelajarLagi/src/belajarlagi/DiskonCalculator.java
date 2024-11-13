
package belajarlagi;




public class DiskonCalculator {
    
    // Method untuk menghitung diskon
    public double hitungDiskon(double hargaAsli, double persenDiskon) {
        return hargaAsli * persenDiskon / 100;
    }

    // Method untuk menghitung harga akhir setelah diskon
    public double hargaAkhir(double hargaAsli, double diskon) {
        return hargaAsli - diskon;
    }

    // Method untuk menghitung diskon tambahan (dari kupon)
    public double hitungDiskonKupon(double hargaAkhir, double diskonKupon) {
        return hargaAkhir * diskonKupon / 100;
    }
}
