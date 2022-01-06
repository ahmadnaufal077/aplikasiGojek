package Controller;

import Entity.AdminEntity;
import Model.*;

public class AdminController implements ControllerInterfaces {
    @Override
    public void insertData(String nama, String email, String password, String noTtelp){
        AllObjectModel.adminModel.insertData(new AdminEntity(nama,email,password,noTtelp));
    }
    public void deleteData(int id){
        AllObjectModel.adminModel.deleteData(id);
    }
    public void updatePassword(String pass, int id){
            AllObjectModel.adminModel.updatePassword(pass, id);
    }
    public void verifUser(int id){
        AllObjectModel.adminModel.verifUser(id);
    }
    @Override
    public int login(String email, String password){
        int log = AllObjectModel.adminModel.cekLogin(email, password);
        return log;
    }
}
