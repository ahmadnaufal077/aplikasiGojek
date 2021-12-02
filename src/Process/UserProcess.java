package Process;

import Entity.UserEntity;
import Entity.UserTerdaftarEntity;
import Entity.LokasiEntity;
import java.util.Scanner;

public class UserProcess implements Interface {
    private static Scanner input = new Scanner(System.in);
    private static UserEntity[] user = new UserEntity[100];
    private static UserTerdaftarEntity[] userTerdaftar = new UserTerdaftarEntity[100];
    public static int jumlah = 0;
    
    public UserEntity[] getUser() {
        return user;
    }
    
    public UserTerdaftarEntity[] getUserTerdaftar() {
        return userTerdaftar;
    }
    public void insert (String nama, String umur, 
    String noTelp, String alamat) {
    user[jumlah] = new UserEntity(
    umur, nama, noTelp, alamat);
    }
    public void insert(UserEntity data, 
    int index, String id) {
    userTerdaftar[jumlah] = new UserTerdaftarEntity(data, index, id);
    jumlah = jumlah + 1;
    }
    @Override 
    public void view() {
        if (jumlah == 0) {
        System.out.println("Belum ada data terdaftar");
        } else {
        for (int i = 0; i < jumlah; i++) {
        System.out.println("==============================================");
        System.out.println("Id : " 
        + userTerdaftar[i].getId());
        System.out.println("==============================================");
        System.out.println("Nama : " + user[i].getNama() 
        + "\n Umur : " + user[i].getUmur() + "\n Alamat : " 
        + user[i].getAlamat() + "\n Notelp : " 
        + user[i].getnoTelp() + "\n Tujuan : " 
        + LokasiEntity.tujuan[userTerdaftar[i].
        getIndex()]);
        System.out.println("==============================================");
            }
        }
    }
    public void update() {
        System.out.print("Masukan Id yang mau di EDIT : ");
        String search = input.next();
        int cari = 0;
        do {
        if (cari == jumlah) {
        System.err.println("Tidak ada data");
        break;
        } else if (userTerdaftar[cari].
        getId().equals(search)) {
        int pilEdit;
        do {
        System.out.println("Pilih  data yang ingin diubah : ");
        System.out.println("1. Lihat Data");
        System.out.println("2, Alamat");
        System.out.println("3. Notelp");
        System.out.println("4. Tujuan");
        System.out.println("0. Exit");
                    
        pilEdit = input.nextInt();
        input.nextLine();
        if (pilEdit == 1) {
        System.out.println("==============================================");
        System.out.println("Id : " + userTerdaftar[cari].getId());
        System.out.println("==============================================");
        System.out.println("Nama : " + user[cari].getNama() 
        + "\n Umur : " + user[cari].getUmur() 
        + "\n Alamat : " + user[cari].getAlamat() 
        + "\n Notelp : " + user[cari].getnoTelp() 
        + "\n Tujuan : " + LokasiEntity.tujuan[userTerdaftar[cari].getIndex()]);
        System.out.println("==============================================");
        } else if (pilEdit == 2) {
            System.out.print("Ubah Alamat : ");
            String editAlamat = input.nextLine();
            user[cari].setAlamat(editAlamat);
        } else if (pilEdit == 3) {
            System.out.print("Ubah noTelp : ");
            String editnoTelp = input.nextLine();
            user[cari].setnoTelp(editnoTelp);
        } else if (pilEdit == 4) {
            System.out.println("Pilih Tujuan : ");
            for (int i = 0; i < LokasiEntity.
            tujuan.length; i++) {
            System.out.println(i + ". " + LokasiEntity.
            tujuan[i]);
        }
        System.out.println("Pilih Tujuan : ");
        int editTujuan = input.nextInt();
        userTerdaftar[cari].setIndex(editTujuan);
        }
        } while (pilEdit != 0);
        break;
        } else {
        cari = cari + 1;
        }
        } while (true);
    }
    public void delete() {
        System.out.print("Masukan Id yang akan di HAPUS : ");
        String search = input.next();
        input.nextLine();
        int cari = 0;
        do {
        if (cari == jumlah) {
        System.err.println( " Tidak Ada Data!");
        break;
        } else if (userTerdaftar[cari].getId().
        equals(search)) {
        if (cari == jumlah -1) {
        jumlah = jumlah - 1;
        } else {
        for (int i = cari; i < jumlah; i++) {
        userTerdaftar[i] = userTerdaftar[i + 1];
        user[i] = user[i + 1];
        }
        jumlah = jumlah - 1;
        }
        break;
        } else {
            cari = cari + 1;
        }
        } while(true);
    }
}