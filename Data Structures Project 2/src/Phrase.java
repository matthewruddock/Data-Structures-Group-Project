//Done by Matthew Ruddock - 1700241 || Jadetta Duncan - 1700066
public class Phrase {
	private String creole;
	private String english;
	
	
	//Default Constructor 
	public Phrase(String creole, String english) {
		super();
		this.creole = creole;
		this.english = english;
	}
	//Getters
	public String getCreole() {
		return creole;
	}
	public String getEnglish() {
		return english;
	}
	
	//Setters
	public void setCreole(String creole) {
		this.creole = creole;
	}
	
	public void setEnglish(String english) {
		this.english = english;
	}
	@Override
	public String toString() {
		return "Phrase [creole=" + creole + ", english=" + english + "]";
	}
	
	public void display() {
		System.out.println(this.toString() + "\n");
	}
}
