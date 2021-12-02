package Entity;

public abstract class BiodataEntity {
    protected String nama, noTelp, alamat;
    
    public BiodataEntity(String nama, 
    String noTelp, String alamat) {
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getnoTelp() {
        return noTelp;
    }
    public void setnoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}