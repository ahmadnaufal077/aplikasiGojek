package Entity;

public class UserEntity extends BiodataEntity {
    private String umur;
    
    public UserEntity(String umur, String nama, 
    String noTelp, String alamat) {
        super (nama, noTelp, alamat);
        this.umur = umur;
    }
    public String getUmur() {
        return umur;
    }
    public void setUmur(String umur) {
        this.umur = umur;
    }
}
