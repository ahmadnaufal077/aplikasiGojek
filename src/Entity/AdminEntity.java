package Entity;

public class AdminEntity extends BiodataEntity {
    private String password;
    
    public AdminEntity(String password, String nama, 
    String noTelp, String alamat) {
        super (nama, noTelp, alamat);
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
