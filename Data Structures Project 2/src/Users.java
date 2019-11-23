import java.util.Scanner;
//Done by Danielle-Paige Grant - 1701442

public class Users {
	private int id;
	private String type;
	
	//Getters and Setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void display() {
		System.out.println("Users [id=" + id + ", type=" + type+"]" +"\n");
	}


}
