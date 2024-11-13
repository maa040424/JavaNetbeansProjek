
package belajarlagi;


public class KonversiSuhu {
    private double suhuInput;
    private String jenisKonversi;

    // Setter dan Getter untuk suhu dan jenis konversi
    public void setSuhuInput(double suhuInput) {
        this.suhuInput = suhuInput;
    }

    public double getSuhuInput() {
        return suhuInput;
    }

    public void setJenisKonversi(String jenisKonversi) {
        this.jenisKonversi = jenisKonversi;
    }

    public String getJenisKonversi() {
        return jenisKonversi;
    }

    // Metode konversi suhu berdasarkan jenis konversi yang dipilih
    public double konversiSuhu() {
        double hasil = 0.0;

        switch (jenisKonversi) {
            case "Celcius ke Fahrenheit":
                hasil = (suhuInput * 9/5) + 32;
                break;
            case "Fahrenheit ke Celcius":
                hasil = (suhuInput - 32) * 5/9;
                break;
            case "Celcius ke Reamur":
                hasil = suhuInput * 4/5;
                break;
            case "Celcius ke Kelvin":
                hasil = suhuInput + 273.15;
                break;
            default:
                throw new IllegalArgumentException("Jenis konversi tidak valid.");
        }
        return hasil;
    }
}
