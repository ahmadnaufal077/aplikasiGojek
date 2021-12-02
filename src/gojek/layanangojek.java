package gojek;

import Process.UserProcess;
import Process.AdminProcess;
import Entity.LokasiEntity;
import java.util.Scanner;

public class layanangojek {
    
    private static Scanner input = new Scanner(System.in);
    private static AdminProcess prosesAdmin = new AdminProcess();
    private static UserProcess prosesUser = new UserProcess();
    private static int pilTujuan;
    private static int cekAdmin;
            
    public static void main(String[] args) {
        dataAdmin();
        int pil;
        do {
        System.out.println("Jumlah : " + UserProcess.jumlah);
        System.out.println("1. Login Admin");
        System.out.println("2. Lihat User Terdaftar");
        System.out.println("3. Biodata Admin ");
            
        pil = input.nextInt();
        input.nextLine();
        switch (pil) {
            case 1:
                login();
                break;
            case 2:
                prosesUser.view();
                break;
            case 3:
                prosesAdmin.view();
                break;
        }
        } while (pil != 0);
    }
    static void dataAdmin() {
        String namaAdmin[] = {"Naufal", "Delita", "Ridho"};
        String passAdmin[] = {"01", "02", "03"};
        String noTelpAdmin[] = { "081", "082", "083"};
        String alamatAdmin[] = { "Mojokerto", "Gresik", "Nganjuk"};
        prosesAdmin.insert(passAdmin, namaAdmin, 
        noTelpAdmin, alamatAdmin);
    }
    static void login() {
        System.out.println("Nama : ");
        String nama = input.next();
        System.out.println("Password : ");
        String password = input.next();
        cekAdmin = prosesAdmin.cekData(nama, password);
        System.out.println("Selamat Datang " + prosesAdmin.
        getAdmin()[cekAdmin].getNama());
        int pil;
        
        do {
        System.out.println("Jumlah : " 
        + UserProcess.jumlah);
        System.out.println("1. Daftarkan User");
        System.out.println("2. Ubah Data User");
        System.out.println("3. Lihat User Terdaftar");
        System.out.println("4. Hapus User");
        System.out.println("0. Log Out");
        pil = input.nextInt();
        input.nextLine();
        switch(pil) {
            case 1:
                insert();
                break;
            case 2:
                prosesUser.update();
                break;
            case 3:
                prosesUser.view();
                break;
            case 4:
                prosesUser.delete();
                break;
        }
        } while (pil != 0);
    }
    static void insert() {
        System.out.println("Input Nama : ");
        String nama = input.nextLine();
        System.out.println("Input Umur : ");
        String umur = input.nextLine();
        System.out.println("Input Alamat : ");
        String alamat = input.nextLine();
        System.out.println("Input noTelp : ");
        String noTelp = input.nextLine();
        
        prosesUser.insert
        (nama, umur, alamat, noTelp);
        insertTujuan();
    }
    static void insertTujuan() {
        System.out.println("Tujuan : ");
        for (int i = 0; i < LokasiEntity.tujuan.length; i++) {
            System.out.println(i + ". " + LokasiEntity.tujuan[i]);
        }
        
        System.out.println("Pilih Tujuan : ");
        pilTujuan = input.nextInt();
        System.out.println("Input Id : ");
        String Id = input.next();
        prosesUser.insert(prosesUser.getUser()
        [prosesUser.jumlah], pilTujuan, Id);
    }
}