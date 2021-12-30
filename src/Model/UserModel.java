package Model;

import Entity.UserEntity;
import java.sql.*;
import java.util.ArrayList;

//manipulasi dta, menangani validas dari control tdk berhubungan dgn view
public class UserModel extends ModelAbstract {
    private String sql;
    
    public ArrayList<UserEntity> getUser(){ //getMhs->mengambil dta mhs dri database
        ArrayList<UserEntity> arraylistUser = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(rs.getInt("id"));
                userEntity.setNama(rs.getString("nama"));
                userEntity.setEmail(rs.getString("email"));
                userEntity.setPassword(rs.getString("password"));
                userEntity.setnoTelp(rs.getString("noTelp"));
                userEntity.setStatus(rs.getInt("status"));
                userEntity.setGambar(rs.getString("gambar"));
                arraylistUser.add(userEntity);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistUser; //mengembalikan kumpulandata yg  didpt kedlm arraylistMhs
    }
    
    public ArrayList<UserEntity> getUser(int id){
        ArrayList<UserEntity> arrUser = new ArrayList<>();
        try {
            sql = "SELECT * FROM user where id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                UserEntity userEntity = new UserEntity();
                
                userEntity.setId(rs.getInt("id"));
                userEntity.setNama(rs.getString("nama"));
                userEntity.setEmail(rs.getString("email"));
                userEntity.setPassword(rs.getString("password"));
                userEntity.setnoTelp(rs.getString("noTelp"));
                userEntity.setStatus(rs.getInt("status"));
                userEntity.setGambar(rs.getString("gambar"));
                arrUser.add(userEntity);
            }
        }catch (SQLException e) {
            //e.printStackTrace();
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
            //e.printStackTrace();
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
            //e.printStackTrace();
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
            //e.printStackTrace();
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
            //e.printStackTrace();
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
            //e.printStackTrace();
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
            //e.printStackTrace();
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
            //e.printStackTrace();
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
            //e.printStackTrace();
        } return cek;
    }
}