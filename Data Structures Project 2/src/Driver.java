//Done by Matthew Ruddock - 1700241 || Danielle-Paige Grant 1701442

//ADMIN LOGIN : admin admin
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

public class Driver {
	Users UsersObj = new Users();
	Visitor VisitorObj = new Visitor();
	JTB_Admin JTB_AdminObj = new JTB_Admin ();
	VisitorRequest VRObj = new VisitorRequest ();
	
	private static int choice = 0;
	static int alive = 1; //state of main program
	private static Scanner input = new Scanner(System.in);
	
	static LocalDateTime myDateObj = LocalDateTime.now();  
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    static String formattedDate = myDateObj.format(myFormatObj);  
	
	
	//MENUS
	//VISITOR MENU
	public int menuVisitor() {
		int alive = 1; //state of main program
		while(alive==1) {
			//clear screen by printing multiple Lines
			for (int i = 0; i < 5; ++i) System.out.println();
			//Initialise choice
			choice = 0;
			System.out.println("______________________________________________________________________"+"\n");
			System.out.println("Today's Date and Time: "+ formattedDate+"\n");  
			System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
			System.out.println("\t\t\t"+"   Visitor Menu"+"\n"+"\n");
			System.out.println("1. View Phrases"+"\n");
			System.out.println("2. Request by Creole"+"\n");
			System.out.println("3. Request List of Places"+"\n");
			System.out.println("0. Exit System"+"\n");
			System.out.println("______________________________________________________________________"+"\n");
			
			
			//User Input choice of menu option
			choice = input.nextInt();
			
			
			//clear screen by printing multiple Lines
			for (int i = 0; i < 5; ++i) System.out.println();
			
			//Functions
			if(choice==1) { 
				VisitorObj.viewPhrases(); ; 
			}else if(choice==2) {
				VisitorObj.RequestByCreole();
			}
			else if(choice==3) {
				VisitorObj.RequestListofPlaces(); ;
			}
			else if(choice==0) {
				alive = 0;
				return 0;
			}
			
		}
		return 1;

	}
	//ADMIN MENU
	public int menuAdmin() {
		Place PlaceObj = new Place();
		int alive = 1; //state of main program
		while(alive==1) {
			//Initialise choice
			choice = 0;
			System.out.println("______________________________________________________________________"+"\n");
			System.out.println("Today's Date and Time: "+ formattedDate+"\n");  
			System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
			System.out.println("\t\t\t"+"   Admin Menu"+"\n"+"\n");
			System.out.println("1. View Visitors Request"+"\n");
			System.out.println("2. Process Visitors Request"+"\n");
			System.out.println("3. Process Log"+"\n");
			System.out.println("4. Add Place"+"\n");
			System.out.println("5. View Place"+"\n");
			
			System.out.println("0. Exit System"+"\n");
			System.out.println("______________________________________________________________________"+"\n");
			
			
			//User Input choice of menu option
			choice = input.nextInt();
			
			
			//clear screen by printing multiple Lines
			for (int i = 0; i < 5; ++i) System.out.println();
			
			//Functions
			if(choice==1) { 
				VRObj.ViewVisitorsRequest(); 
			}
			else if(choice==2) {
				VRObj.ProcessVisitorsRequest(); 
			}
			else if(choice==3) {
				VRObj.ProcessLog(); 
			}
			else if(choice==4) {
				JTB_Admin admin = new JTB_Admin();
				admin.addPlace().show();
				
			}
			else if(choice==5) {
				 PlaceObj.ViewPlace();
			}
			else if(choice==0) {
				alive = 0;
				return 0;
			}
			
		}
		return 1;

	}
	public static void main(String[] args) throws IOException {
		//Date and Time
	    
		Driver DriverObj = new Driver();
		Users UsersObj = new Users();
		JTB_Admin AdminObj= new JTB_Admin();
		int loginVerification = 0 ;
		alive = 1; //state of main program
		
		
		while(alive==1) {
			//Initialise choice
			choice = 0;
			System.out.println("______________________________________________________________________"+"\n");
			System.out.println("Today's Date and Time: "+ formattedDate +"\n");  
			System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
			System.out.println("\t"+"   Welcomes All Visiting and Returning Residents"+"\n"+"\n");
			System.out.println("1. Visitor"+"\n");
			System.out.println("2. Admin"+"\n");
			System.out.println("0. Exit System"+"\n");
			System.out.println("______________________________________________________________________"+"\n");
			
			
			//User Input choice of menu option
			choice = input.nextInt();
			
			
			//clear screen by printing multiple Lines
			for (int i = 0; i < 5; ++i) System.out.println();
			
			//Functions
			if(choice==1) { //Visitors
				//loginVerification = UsersObj.loginUser();
				DriverObj.menuVisitor(); 
			}
			else if(choice==2) {//Admin
				loginVerification = AdminObj.loginUser();
				if(loginVerification == 1)
					DriverObj.menuAdmin(); 
			}
			
			else if(choice==0) {
				alive = 0;
				System.exit(0);
			}
		}

	}

}
