package Model;

import Entity.AdminEntity;
import java.sql.*;

public class AdminModel extends ModelAbstract{
    private String sql;
    
    public void insertData(AdminEntity AdminEntity){
        try {
            sql = "INSERT INTO admin (nama, email, password, noTelp) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, AdminEntity.getNama());
            stat.setString(2, AdminEntity.getEmail());
            stat.setString(3, AdminEntity.getPassword());
            stat.setString(4, AdminEntity.getnoTelp());
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL INPUT DATA!!!");
            System.out.println(e);
        }
    }
    
    @Override
    public void updatePassword(String password, int id){

        try {
            sql = "update admin SET password =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH PASSWORD!!!");
            System.out.println(e);
        }
    }
    
    @Override
    public int cekLogin(String email, String password){
        int cek = 0;
        try {
            sql = "SELECT * FROM admin where email = ? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, email);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
               cek = rs.getInt("id");
            } else {
                cek = 0;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        } return cek;
    }
    
    public void verifUser(int id){
        try {
            sql = "update user SET status = 1 WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
    
    public void deleteData(int id){
        try {
            sql = "DELETE FROM user where id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }
}