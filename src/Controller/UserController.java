package Controller;

import Entity.AdminEntity;
import Model.*;
import Entity.UserEntity;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UserController{
    //@Override
    public void insertData(String nama, String email, String password, String noTtelp,String gambar){
        AllObjectModel.userModel.insertData(new UserEntity(nama,email,password,noTtelp,gambar));
    }
    
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1:
                AllObjectModel.userModel.updateNama(data, id);
                break;
            case 2:
                AllObjectModel.userModel.updateEmail(data, id);
                break;
            case 3:
                AllObjectModel.userModel.updatePassword(data, id);
                break;
            case 4:
                AllObjectModel.userModel.updateGambar(data, id);
                break;
            case 5:
                AllObjectModel.userModel.updateNoTelp(data, id);
                break;
        }
    }
    
    public List<UserEntity> getDataUser(){
        return AllObjectModel.userModel.getUser();
    }
    
    public int login(String email, String password){
        int cek = AllObjectModel.userModel.cekLogin(email, password);
        return cek;
    }
    
    public List<UserEntity> getById(int ceklogin){
        return AllObjectModel.userModel.getUser(ceklogin);
    }
    
    public int verif(int id){
        int cek = AllObjectModel.userModel.cekVerif(id);
        return cek;
    }
    
    public DefaultTableModel daftarUser(){
        DefaultTableModel dataDaftarUser = new DefaultTableModel();
        Object[] kolom = {"ID", "EMAIL", "NAMA", "NOTELP", "STATUS"};
        dataDaftarUser.setColumnIdentifiers(kolom);
        int size = getDataUser().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[5];
            data[0] = AllObjectModel.userModel.getUser().get(i).getId();
            data[1] = AllObjectModel.userModel.getUser().get(i).getEmail();
            data[2] = AllObjectModel.userModel.getUser().get(i).getNama();
            data[3] = AllObjectModel.userModel.getUser().get(i).getnoTelp();
            data[4] = AllObjectModel.userModel.getUser().get(i).getStatus();
            dataDaftarUser.addRow(data);
        }
        return dataDaftarUser;
    }
}
