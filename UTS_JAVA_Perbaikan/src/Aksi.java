public class Aksi {
    public static void main(String[] args) {
        // Membuat objek Universitas
        Universitas uniska = new Universitas("Uniska", "Banjarmasin", "7 Juli 1981", 19502, "B");
        Universitas ulm = new Universitas("ULM", "Banjarmasin", "21 September 1958", 0, "A"); // belum searching berapa jumlahnya
        Universitas uin = new Universitas("UIN Banjarmasin", "Banjarmasin", "20 November 1964", 0, "A"); // sama kaya diatas

        // Mengisi semua atribut pada uniska
        uniska.nama = "Uniska";
        uniska.lokasi = "Banjarmasin";
        uniska.tanggalBerdiri = "7 Juli 1981";
        uniska.jumlahMahasiswa = 19502;
        uniska.akreditasi = "B";

        // Menampilkan informasi semua universitas
        System.out.println("Informasi Uniska:");
        System.out.println(uniska.getInformasi());

        System.out.println("\nInformasi ULM:");
        System.out.println(ulm.getInformasi());

        System.out.println("\nInformasi UIN Banjarmasin:");
        System.out.println(uin.getInformasi());
    } 
}
