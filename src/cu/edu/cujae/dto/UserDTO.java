package cu.edu.cujae.dto;

public class UserDTO {
	private Integer id;
    private String username;
    private String password;
    private RolDTO rol;

    public UserDTO() {
    }

    public UserDTO(int id, String username, String password, RolDTO rol) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }
}
