package Entity;

public class UserEntity extends UserEntityAbstract {
    private String email; // sudah ada pada database,shg lgsg panggil gett/sett
    private String gambar;
    private int status;
    
    
    //langsung menuju ke userEntity
    public UserEntity(){};
    
    //mengisi attr encap
    public String getEmail(){ return email; }
    public int getStatus(){ return status; }
    public String getGambar(){ return gambar; }
    
    public void setEmail(String email) { this.email = email; }
    public void setStatus(int status) { this.status = status; }
    public void setGambar(String gambar) { this.gambar = gambar; }
}