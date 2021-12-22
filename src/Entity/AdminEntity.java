package Entity;

public class AdminEntity extends UserEntityAbstract {
    private String email;
    public AdminEntity(String nama, String email, String password, String noTelp){
        super(nama,password,noTelp);
        this.email = email;
    }
    
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
}
