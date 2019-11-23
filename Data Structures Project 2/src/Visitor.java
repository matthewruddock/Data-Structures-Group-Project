//Done by Danielle-Paige Grant - 1701442 || Matthew Ruddock - 1700241
import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

public class Visitor extends Users{
	private String FirstName;
	private String LastName;
	private String Email;
	private String PassportNumber;
	
	private static Scanner input = new Scanner(System.in);

	static LocalDateTime myDateObj = LocalDateTime.now();  
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    static String formattedDate = myDateObj.format(myFormatObj);
	private String pname;

	//Methods
	public void viewPhrases() {
		Tree tree = new Tree();
		tree.insert(new Phrase("Mi soon come","I will be right there"));
		tree.insert(new Phrase("Mi deh pan a endz","I'm out somewhere having fun"));
		tree.insert(new Phrase("Wah gwaan?","How are you doing? or What's up?"));
		tree.insert(new Phrase("Do u ting","Go ahead or Do whatever you want to do"));
		tree.insert(new Phrase("Hol' a medz/medi","Relaxing or meditating"));

		System.out.println("______________________________________________________________________"+"\n");
		System.out.println("Today's Date and Time: "+ formattedDate+"\n"); 
		System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
		System.out.println("\t\t"+"****Come learn the good phrase dem****\n");
		tree.display();
		System.out.println("______________________________________________________________________"+"\n");
		System.out.println("\t\t\tPRESS ANY KEY TO EXIT");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void RequestByCreole(){
		PlaceLinkedList pl_list = new PlaceLinkedList();
		Place place = new Place();
		VisitorRequest VRObj = new VisitorRequest ();
		String choice = null;

		System.out.println("______________________________________________________________________"+"\n");
		System.out.println("Today's Date and Time: "+ formattedDate+"\n");
		System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
		System.out.println("\t\t    Request By Creole \n");

		System.out.println("Type the following, *Which part have di cheapest [Attraction Name]*, to see cheapest attraction."
				+ "\n\nSample attractions include “food”, “river”, “water, ATV, garden, site, fun” ");
		pname = input.nextLine();
		pname = pname.substring(28); // get characters after cheapest

		place = place.showAttraction(pname);
		
		System.out.println("Do you wish to request attraction details? Yes / No");
		choice = input.nextLine();
		if(choice.equals("Yes")) {
			RequestAttractionDetails(place);
		}else {
			System.out.println("______________________________________________________________________"+"\n");
			System.out.println("\t\t\tPRESS ANY KEY TO EXIT");
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void RequestAttractionDetails(Place place) {
		PlaceLinkedList pl_list = new PlaceLinkedList();
		VisitorRequest VRObj = new VisitorRequest();
		

		System.out.println("______________________________________________________________________"+"\n");
		System.out.println("Today's Date and Time: "+ formattedDate+"\n"); 
		System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
		System.out.println("\t\t    Request Attraction Details \n");

		System.out.println("Provide your first name: ");
		setFirstName(input.next());
		System.out.println("Provide your last name: ");
		setLastName(input.next());
		System.out.println("Provide your email: ");
		setEmail(input.next());
		System.out.println("Provide your Message: ");
		VRObj.setMessage(input.next());
		VRObj.visitor.setFirstName(getFirstName());
		VRObj.visitor.setLastName(getLastName());
		VRObj.visitor.setEmail(getEmail());
		VRObj.place.setAttraction(place.getAttraction());
		VRObj.place.setId(place.getId());
		
		
		System.out.println("______________________________________________________________________"+"\n");
		System.out.println("\n\t\t****Visitor Request****\n");
		System.out.println("Name: "+ getFirstName() + " " + getLastName() + " \n"
							+ "Email: " + getEmail() + "\n"
							+ "Attraction ID : " + place.getId() +"\n"
							+ "Attraction: " + place.getAttraction() + "\n"
							+ "Message: "+ VRObj.getMessage() +"\n"
							+ "Request ID: " + VRObj.requestID +"\n"
							+ "Date and Time: " + formattedDate);
		//As a visitor, I should be able to request additional details on an attraction offered by a place. 
		//Each request should include my first name, last name, email, attraction generated id, attraction name 
		//and message, request id, date and time (id, date and time should be system generated).
		
		VRObj.AddVisitorRequest(VRObj);
		
		System.out.println("______________________________________________________________________"+"\n");
		System.out.println("\t\t\tPRESS ANY KEY TO EXIT");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void RequestListofPlaces() throws IndexOutOfBoundsException{
		int code = 0;
		Place place = new Place();
		PlaceLinkedList pl_list = new PlaceLinkedList();
		System.out.println("______________________________________________________________________"+"\n");
		System.out.println("Today's Date and Time: "+ formattedDate+"\n"); 
		System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
		System.out.println("\t\t    Request List of Places \n");
		
		
		System.out.println("\n ​“Gimmi all a di place dem inna [Parish Name]​. \n");
		pname = input.nextLine();
		pname = pname.substring(30); //copy name after inna

		if (pname.equalsIgnoreCase("Kingston" ) || pname.equalsIgnoreCase("St.Andrew")){
			code = 1;
		}else if (pname.equalsIgnoreCase("St.Thomas")){
			code = 2;
		}else if (pname.equalsIgnoreCase("Portland")){
			code = 3;
		}else if (pname.equalsIgnoreCase("St.Mary")){
			code = 4;
		}else if (pname.equalsIgnoreCase("St.Catherine")){
			code = 5;
		}else if (pname.equalsIgnoreCase("Clarendon")){
			code = 6;
		}else if (pname.equalsIgnoreCase("Manchester")){
			code = 7;
		}else if (pname.equalsIgnoreCase("St.Ann")){
			code = 8;
		}else if (pname.equalsIgnoreCase("St.Elizabeth")){
			code = 9;
		}else if (pname.equalsIgnoreCase("St.James")){
			code = 10;
		}else if (pname.equalsIgnoreCase("Hanover")){
			code = 11;
		}else if (pname.equalsIgnoreCase("Westmoreland")){
			code = 12;
		}else if (pname.equalsIgnoreCase("Trelawny")){
			code = 13;}
		
		if (code == 0){
			System.out.println("Not a parish in Jamaica");
		}else {
			place.showPlace(code);
		}
		
		System.out.println("______________________________________________________________________"+"\n");
		System.out.println("\t\t\tPRESS ANY KEY TO EXIT");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	//Getters and Setters
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassportNumber() {
		return PassportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		PassportNumber = passportNumber;
	}
	

}
