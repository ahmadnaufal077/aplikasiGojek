package Model;

import Entity.AdminEntity;
import java.sql.*;
import Helper.KoneksiDb;
import java.sql.Connection;

public class AdminModel{
    Connection conn = KoneksiDb.getconnection();
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
        }
    }
    
    //@Override
    public void updatePassword(String password, int id){

        try {
            sql = "update admin SET password =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH PASSWORD!!!");
        }
    }
    
    //@Override
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