package co.com.parameta.model;

public class ResponseMessage {

	private String message;
	private String age;
	private String ageVinculation;

	public ResponseMessage() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAgeVinculation() {
		return ageVinculation;
	}

	public void setAgeVinculation(String ageVinculation) {
		this.ageVinculation = ageVinculation;
	}

}
