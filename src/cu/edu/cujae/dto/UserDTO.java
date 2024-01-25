package cu.edu.cujae.dto;

public class UserDTO {
	private int id;
    private String username;
    private String email;
    private String password;
    private String rol;

    public UserDTO() {
    }

	public UserDTO(int id, String username, String email, String password, String rol) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}