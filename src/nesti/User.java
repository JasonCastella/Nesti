package nesti;

public class User {

	private int idUser;
	private String lastName;
	private String firstName;
	private String city;
	private String email;
	private String userName;
	private String password;

	public User() {}
	
	public User(String lastName, String firstName, String city, String userName, String email, String password) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.city = city;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public void setIdUser(int idUser) {
		this.idUser=idUser;
	}
	
	public int getIdUser() {
		return idUser;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
