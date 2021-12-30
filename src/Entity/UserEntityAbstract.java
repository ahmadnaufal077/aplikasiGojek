package Entity;

//class yg belum jelas implement
public abstract class UserEntityAbstract {
    //dapatdipanggil oleh class yg sama dan anak kelas yg  mewarisinya
    protected int id;
    protected String nama, password, noTelp,email;
    
   public UserEntityAbstract(){
    }
    
    public UserEntityAbstract(String nama, String password, String noTelp){
        this.nama = nama;
        this.password = password;
        this.noTelp = noTelp;
    }
    
    //attribut encapsulation
    public int getId(){ return id; }
    public String getNama(){ return nama; }
    public String getPassword(){ return password; }
    public String getnoTelp(){ return noTelp;}
    public String getEmail(){ return email;}
    
    public void setId(int id){ this.id = id; }
    public void setNama(String nama){ this.nama = nama; }
    public void setPassword(String password){ this.password = password; }
    public void setnoTelp(String noTelp){ this.noTelp = noTelp; }
    public void setEmail(String email){ this.email = email; }
}
