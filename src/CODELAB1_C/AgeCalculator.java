package CODELAB1_C;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

    public class AgeCalculator {

        public static void main(String[] args) {
            // Membaca input dari user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan nama bulan kelahiran (contoh: Januari): ");
            String namaBulan = scanner.nextLine();
            System.out.print("Masukkan tanggal kelahiran (contoh: 31): ");
            int tanggal = scanner.nextInt();
            System.out.print("Masukkan tahun kelahiran (contoh: 2000): ");
            int tahun = scanner.nextInt();

            // Mengonversi nama bulan menjadi angka bulan
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
            LocalDate date = LocalDate.parse(namaBulan, formatter);
            int bulan = date.getMonthValue();

            // Menghitung umur berdasarkan tanggal, bulan, dan tahun kelahiran
            LocalDate tanggalLahir = LocalDate.of(tahun, bulan, tanggal);
            LocalDate hariIni = LocalDate.now();
            long umur = ChronoUnit.YEARS.between(tanggalLahir, hariIni);

            // Menampilkan hasil penghitungan umur
            System.out.println("Umur Anda adalah " + umur + " tahun.");
        }
    }


