//Done by Jadetta Duncan - 1700066
import java.io.IOException;
import java.util.Scanner;

public class JTB_Admin extends Users {
	
	private Place place = new Place();
	private Scanner input;
	VisitorRequest VR = new VisitorRequest();
	
	public int loginUser(){
		input = new Scanner(System.in);
		String name=null;
		String pw = null;
		int id=0;
		//Prompt User
		System.out.println("______________________________________________________________________"+"\n"); 
		System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
		System.out.println("\t\t"+"------------LOGIN MENU------------\n");
			System.out.println("Enter Name: ");
			name = input.next();
			
			System.out.println("Enter Password: ");
			pw = input.next();
			
			if(name.equals("admin")&& pw.equals("admin"))
				id = 1;
			else {
				System.out.println("\n		*****Invalid Credentials, Please re-enter*****\n");
				System.out.println("\t\t\tPRESS ANY KEY TO EXIT");
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return id;
		
		
	}	
	
	public PlaceLinkedList addPlace() {
		return place.AddPlace();
	}
	
	public void viewPlace() {
		place.display();
	}
	public void processRequest() {
		
		VR.ProcessVisitorsRequest();
	}
	public void viewRequest() {
		VR.ProcessLog();
	}
	
}
