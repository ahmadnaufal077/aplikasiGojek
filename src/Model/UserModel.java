package Model;

import Entity.UserEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Helper.KoneksiDb;
import java.sql.Connection;

public class UserModel{
    Connection conn = KoneksiDb.getconnection();
    private String sql;
    
    public List<UserEntity> getUser(){
        List<UserEntity> arraylistUser = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
//                UserEntity userEntity = new UserEntity();
//                userEntity.setId(rs.getInt("id"));
//                userEntity.setNama(rs.getString("nama"));
//                userEntity.setEmail(rs.getString("email"));
//                userEntity.setPassword(rs.getString("password"));
//                userEntity.setnoTelp(rs.getString("noTelp"));
//                userEntity.setStatus(rs.getInt("status"));
//                userEntity.setGambar(rs.getString("gambar"));
//                arraylistUser.add(userEntity);
            }
        } catch (SQLException e) {
        }
        return arraylistUser; //mengembalikan kumpulandata yg  didpt kedlm arraylistMhs
    }
    
    public List<UserEntity> getUser(int id){
        List<UserEntity> arrUser = new ArrayList<>();
        try {
            sql = "SELECT * FROM user where id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
//                UserEntity userEntity = new UserEntity();  
//                userEntity.setId(rs.getInt("id"));
//                userEntity.setNama(rs.getString("nama"));
//                userEntity.setEmail(rs.getString("email"));
//                userEntity.setPassword(rs.getString("password"));
//                userEntity.setnoTelp(rs.getString("noTelp"));
//                userEntity.setStatus(rs.getInt("status"));
//                userEntity.setGambar(rs.getString("gambar"));
//                arrUser.add(userEntity);
            }
        }catch (SQLException e) {
        }return arrUser;
    }
    
    public void insertData(UserEntity UserEntity) {
        try {
            sql = "INSERT INTO user (nama, email, password, noTelp) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, UserEntity.getNama());
            stat.setString(2, UserEntity.getEmail());
            stat.setString(3, UserEntity.getPassword());
            stat.setString(4, UserEntity.getnoTelp());
            
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA!!!");
        }
    }
    
    public void updateNama(String nama, int id){
        try{
            sql = "update user SET nama =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA!!!");
        }
    }
    
    public void updateEmail(String email, int id){
        try{
            sql = "update user SET email =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, email);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NPM!!!");
        }
    }
    
    public void updateGambar(String gambar, int id){
        try{
            sql = "update user SET gambar =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, gambar);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH GAMBAR!!!");
        }
    }
    
    public void updatePassword(String password, int id){
        try{
            sql = "update user SET password =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH PASSWORD!!!");
        }
    }
    
    public void updateNoTelp(String noTelp, int id){
        try{
            sql = "update user SET noTelp =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NOMOR!!!");
        }
    }
    
    public int cekLogin(String email, String password){
        int cek = 0;
        try{
            sql = "SELECT * FROM user where email = ? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, email);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("id");
                String nama = rs.getString("nama");
                System.out.println("Selamat Datang " + nama);
            } else {
                cek = 0;
            }
        } catch (SQLException e){
        } return cek;
    }
    
    public int cekVerif(int id){
        int cek = 0;
        try {
            sql = "SELECT * FROM user where id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("status");
            } else {
                cek = 0;
            }
        } catch (SQLException e){
        } return cek;
    }
}