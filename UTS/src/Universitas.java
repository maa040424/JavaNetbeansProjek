public class Universitas {
    
    String Dosen;
    String NamaKampus;
    String Prodi;
    String Fakultas;
    String Mahasiswa;
    
    
    public Universitas(String dosen, String namaKampus, String prodi, String fakultas, String mahasiswa) {
        this.Dosen = dosen;
        this.NamaKampus = namaKampus;
        this.Prodi = prodi;
        this.Fakultas = fakultas;
        this.Mahasiswa = mahasiswa;
    }
    
    
    public String aksi() {
        return "Kampus " + NamaKampus + " memiliki prodi " + Prodi + " di fakultas " + Fakultas + " yang diampu oleh " + Dosen + " dengan mahasiswa " + Mahasiswa;
    }
    
    
    
    
   
}
