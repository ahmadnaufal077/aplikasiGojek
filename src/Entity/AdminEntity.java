package Entity;

public class AdminEntity extends UserEntityAbstract {
    public AdminEntity(String nama, String email, String password, String noTelp){
        super(nama,password,noTelp,email);
    }
}
