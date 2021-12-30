package Entity;

public class UserEntity extends UserEntityAbstract {
    private String gambar;
    private int status;
    
    
    //langsung menuju ke userEntity
    public UserEntity(){};
    
    //mengisi attr encap
    public int getStatus(){
    
        return status;
    }
    public String getGambar(){ return gambar; }
    
    public void setStatus(int status) { this.status = status; }
    public void setGambar(String gambar) { this.gambar = gambar; }
}