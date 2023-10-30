package CODELAB1_B;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * DeteksiUmur adalah sebuah kelas yang digunakan untuk menghitung usia berdasarkan
 * tahun, bulan, tanggal kelahiran yang dimasukkan oleh pengguna
 */
public class DeteksiUmur {
    private int tahunlahir;

    /**
     * Metode ini digunakan untuk mengatur tanggal lahir seseorang
     * @param tahunLahir tahun kelahiran pengguna
     */
    public void setTahunLahir(int tahunLahir) {
        this.tahunlahir = tahunLahir;
    }

    /**
     * metode ini digunakan untuk mendapatkan tanggal lahir seseorang
     * @return tahun kelahiran pengguna
     */
    public int getTahunLahir() {
        return tahunlahir;
    }

    /**
     * metode utama dari program yang memungkinkan user untuk memasukkan tahun, bulan, tanggal kelahiran
     * program ini akan menghitung dan mencetak usia dengan format tahun, bulan dan tanggal
     * @param args Argumen baris perintah yang digunakan saat menjalankan program (tidak digunakan dalam kasus ini)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeteksiUmur tahunKelahiran = new DeteksiUmur();

        System.out.println("Enter your birth year:");
        int tahunLahir = scanner.nextInt();
        tahunKelahiran.setTahunLahir(tahunLahir);

        System.out.println("Enter your birth month (1-12):");
        int bulanLahir = scanner.nextInt();

        System.out.println("Enter your birth day (1-31):");
        int tanggalLahir = scanner.nextInt();

        LocalDate birthDate = LocalDate.of(tahunLahir, bulanLahir, tanggalLahir);
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);
        int years = age.getYears();
        int months = age.getMonths();
        int days = age.getDays();

        System.out.println("tahun lahir  " + years + " years, " + months + " months, and " + days + " days.");
    }
}



