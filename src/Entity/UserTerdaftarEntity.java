package Entity;

public class UserTerdaftarEntity {
    private UserEntity userEntity;
    private int index;
    private String id;
    
    public UserTerdaftarEntity(
    UserEntity userEntity, int index, 
    String id) {
        this.userEntity = userEntity;
        this.index = index;
        this.id = id;
    }
    public UserEntity getUserEntity() {
        return userEntity;
    }
    public void setUserEntity(
        UserEntity usertaEntity) {
        this.userEntity = userEntity;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}