package Process;

import Entity.AdminEntity;

public class AdminProcess implements Interface {
    private static AdminEntity[] admin = new AdminEntity[100];
    private static int jumlah = 0;
    
    public AdminEntity[] getAdmin() {
        return admin;
    }
    public void insert(String[] passadmin, String[] 
        namaadmin, String[] noTelpadmin, String[] 
        alamatadmin) {
        for (int i = 0; i < namaadmin.length; i++) {
        admin[i] = new AdminEntity(passadmin
        [i],namaadmin[i], noTelpadmin[i], 
        alamatadmin[i]);
        jumlah++;
    }
    }
    @Override
    public void view() {
        for (int i = 0; i < jumlah; i++) {
        System.out.println("==============================================");
        System.out.println("Nama : " + admin[i].getNama() 
        + "\n NoTelp : " + admin[i].getnoTelp() 
        + "\n Alamat : " + admin[i].getAlamat());
        System.out.println("==============================================");
        }
    }
    public int cekData(String user, String password) {
        int loop = 0;
        for (AdminEntity prosesadmin : admin) {
        if (prosesadmin.getNama().equals(user) && 
        prosesadmin.getPassword().equals(password)) {
            break;
        } else {
            loop++;
        }
        }
        return loop;
    }
}
