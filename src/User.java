public class User {
	String user;
	String role;
	 
	public User(String user, String role){
		this.user = user;
		this.role = role;
	}

	String getRole(){
		return role;
	}
}
