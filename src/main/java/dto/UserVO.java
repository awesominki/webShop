package dto;

public class UserVO {
	String userid;
	String password;
	public UserVO() {
	}
	
	public UserVO(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("userVO [userid=").append(userid).append(", password=").append(password).append("]");
		return builder.toString();
	}
	
}
