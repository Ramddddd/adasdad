package Tugas1;

import java.util.Scanner;

class BookSystem{
    public Scanner input = new Scanner(System.in);
    int save_harga_kamar;
    private String nama;
    private String noTelp;
    private String alamat;
    private String email;
    private int[][] room = {{0, 101, 1000000},
            {0, 102,1500000},
            {0, 103, 900000}
    };


    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setNoTelp(String noTelp){
        if(noTelp.startsWith("+64") == true){
            this.noTelp = noTelp;
        } else{
            System.out.println("Masukkan no telepon awali dengan +64");
            setNoTelp(input.nextLine());
        }
    }

    public String getNoTelp(){
        return noTelp;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setEmail(String email){
        if(email.endsWith(".com") == true || email.endsWith(".ac.id") == true){
            this.email = email;
        } else{
            System.out.println("tolong masukkan Email dengan benar.");
            setEmail(input.nextLine());
        }
    }

    public String getEmail(){
        return email;
    }

    public void setRoom(int kamar, int available){
        room[kamar-1][0] = available;
    }

    public int getRoom(int kamar){
        return room[kamar][0];
    }

    public void init(){
        System.out.println("Masukkan Nama: ");
        setNama(input.nextLine());

        System.out.println("Masukkan Email: ");
        setEmail(input.nextLine());

        System.out.println("Masukkan No Telp (+64): ");
        setNoTelp(input.nextLine());

        System.out.println("Masukkan Alamat: ");
        setAlamat(input.nextLine());

    }

    public void dispPerson(){
        System.out.println("Nama: " +getNama());
        System.out.println("No Telp: " +getNoTelp());
        System.out.println("Email: " +getEmail());
        System.out.println("Alamat: " +getAlamat());
    }

    public void bookRoom(){
        System.out.println("Guest house");
        System.out.println("No  Kamar  Harga    Keterangan");
        for(int i=0;i<3;i++){
            String sf = String.format("%d.  %d  %d  %s", i+1, room[i][1], room[i][2], (getRoom(i) != 0) ? "(Sudah ditempati)" : "(Kosong)");
            System.out.println(sf);
        }
        System.out.print("Pilih kamar yang ingin anda sewa: ");
        doPayment(input.nextInt());

    }

    public void doPayment(int noRoom){
        if(room[noRoom-1][0] == 0){
            save_harga_kamar = room[noRoom-1][2];
            System.out.println("================================");
            System.out.println("Pembayaran kamar");
            dispPerson();
            System.out.println("================================");
            System.out.print("Masukkan Tunai: ");
            int uang = input.nextInt();
            if(uang == save_harga_kamar){
                System.out.println("Kamar berhasil dipesan.");
                setRoom(noRoom, 1);
            }else if(uang >= save_harga_kamar){
                String sf = String.format("Kemibalian: %d", uang - save_harga_kamar);
                System.out.println(sf);
                System.out.println("Kamar berhasil dipesan.");
                setRoom(noRoom, 1);
            }else {
                System.out.println("Pembayaran kurang.");
            }
        }else {
            System.out.println("Mohon maaf kamar sudah ditempati");
        }

        System.out.println("Ingin memesan lagi? (y/n)");
        if(input.next().charAt(0) == 'y'){
            bookRoom();
        }
    }
}

public class Tugas1 {
    public static void main(String[] args) {
        BookSystem obj = new BookSystem();
        obj.init();
        obj.bookRoom();
    }
}
