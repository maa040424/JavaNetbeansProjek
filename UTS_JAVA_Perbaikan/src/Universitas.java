public class Universitas {
    // Atribut
    public String nama;
    public String lokasi;
    public String tanggalBerdiri;
    public int jumlahMahasiswa;
    public String akreditasi;

    // Konstruktor
    public Universitas(String nama, String lokasi, String tanggalBerdiri, int jumlahMahasiswa, String akreditasi) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.tanggalBerdiri = tanggalBerdiri;
        this.jumlahMahasiswa = jumlahMahasiswa;
        this.akreditasi = akreditasi;
    }

    // Method untuk mendapatkan informasi universitas
    public String getInformasi() {
        return "Nama Universitas: " + nama + "\nLokasi: " + lokasi + "\nTanggal Berdiri: " + tanggalBerdiri +
               "\nJumlah Mahasiswa: " + jumlahMahasiswa + "\nAkreditasi: " + akreditasi;
    }

    // Method untuk memperbarui jumlah mahasiswa
    public void updateJumlahMahasiswa(int jumlahBaru) {
        if (jumlahBaru > 0) {
            this.jumlahMahasiswa = jumlahBaru;
        } else {
            System.out.println("Jumlah mahasiswa harus lebih dari 0");
        }
    }

    // Method untuk mengubah akreditasi universitas
    public void updateAkreditasi(String akreditasiBaru) {
        this.akreditasi = akreditasiBaru;
    }

    // Method untuk mendapatkan nama universitas
    public String getNama() {
        return this.nama;
    }

    // Method untuk mendapatkan lokasi universitas
    public String getLokasi() {
        return this.lokasi;
    }
}
