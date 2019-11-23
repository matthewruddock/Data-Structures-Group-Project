//Done by Danielle-Paige Grant - 1701442 || Matthew Ruddock - 1700241
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

public class VisitorRequest {
	int requestID ;
	Visitor visitor = new Visitor();
	Place place = new Place();


	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	static LocalDateTime myDateObj = LocalDateTime.now();  
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    static String Message;
    static String formattedDate = myDateObj.format(myFormatObj);
	private static Scanner input = new Scanner(System.in);


    String Status;

    public VisitorRequest(){
    	requestID = ID_GENERATOR.getAndIncrement();
	}
	
    public void setRequestId(int rid) {
    	requestID = rid;
    }
    public int getRequestId() {
    	return requestID;
    }
    
    public void setMessage(String msg) {
    	Message = msg;
    }
    public String getMessage() {
    	return Message;
    }
    	
public void AddVisitorRequest(VisitorRequest data) {
	ProcessLogQueue queue = new ProcessLogQueue();
	FileWriter RequestFile = null;
	String record;
	
	try{
		RequestFile = new FileWriter("RequestFile.txt", true);
		//Check if record exist

		data.setRequestId(ID_GENERATOR.getAndIncrement());

		//create structure for record 
		record =" "+data.getRequestId()+ "\t" + data.visitor.getFirstName() + "\t" + data.visitor.getLastName()+ "\t"
				+ data.visitor.getEmail() + "\t" + data.place.getId() + "\t" + data.place.getAttraction() + "\t"
				+ data.getMessage() + "\t" + "\t" + data.formattedDate + "\n";
		//Saves record
		RequestFile.write(record);
		queue.enqueue(data);
		RequestFile.close();

		System.out.println("\n"+"\n"+"*****Record was saved******"+"\n"+"\n");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}catch(IOException e) {
	System.err.println("Could not open file");
	}	
	
	try {
		RequestFile.close();
	} catch(IOException e) {
		e.printStackTrace();
	}
	
	}
	
	public void ViewVisitorsRequest() {
		System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
		System.out.println("\t\t\t"+"  View Visitors Request "+"\n"+"\n");
		try {
			Scanner RequestFile = new Scanner(new File("RequestFile.txt"));
			while(RequestFile.hasNext()){
				setRequestId(RequestFile.nextInt());
				visitor.setFirstName(RequestFile.next() );
				visitor.setLastName(RequestFile.next() );
				visitor.setEmail(RequestFile.next() );
				place.setId(RequestFile.nextInt() );
				place.setAttraction(RequestFile.next() );
				setMessage(RequestFile.next());
				formattedDate = RequestFile.next() + " " + RequestFile.next();
				//use to string to print out values

				display();
				
			}
			System.out.println("______________________________________________________________________"+"\n");
			System.out.println("\t\t\tPRESS ANY KEY TO EXIT");
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestFile.close();
		}catch(IOException e) {
			System.err.println("Could not open file");
		}	
	}
	
	public void ProcessVisitorsRequest() {
		System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
		System.out.println("\t\t\t"+"   Process Visitors Request  "+"\n"+"\n");

		System.out.println("\t\t\t"+"-----------------------------------------"+"\n"+"\n");
		ProcessLogQueue queue = new ProcessLogQueue();

		queue.display();

		ProcessLogStack stack = new ProcessLogStack();

		System.out.println("Would you like to process the first visitor request? 1.YES || 2.NO");
		int choice = input.nextInt();
		int total = queue.Count(queue);
		if (choice == 1) {

			stack.push(queue.dequeue());
			System.out.println("Would you like to process the another visitor request? 1.YES || 2.NO");
			choice = input.nextInt();
			while (choice != 2 && !queue.isEmpty()) {
				stack.push(queue.dequeue());
				System.out.println("Would you like to process the another visitor request? 1.YES || 2.NO");
				choice = input.nextInt();
			}
			int stackTotal = stack.Count(stack);
			System.out.println("Request exited, " + stackTotal + " of " + total + " completed");
		}
    }
	
	
	public void ProcessLog() {
		//As a Jamaica Tourist Board Administrator, I should be able to view the process log in the
		//order of most recently processed first. The process log contains the set of visitor requests
		//which have been processed.
		System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
		System.out.println("\t\t\t"+"   Process Log  "+"\n"+"\n");
		System.out.println("\t"+"-------------------------------------------"+"\n"+"\n");
		ProcessLogStack stack = new ProcessLogStack();
		stack.display();
		System.out.println("______________________________________________________________________"+"\n");
		System.out.println("\t\t\tPRESS ANY KEY TO EXIT");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void display() {
		System.out.println("RequestID: "+getRequestId()+ "\t" + "First Name: "+visitor.getFirstName() + "\t" + "Last Name: "+visitor.getLastName()+ "\t"
				+ "Email: "+visitor.getEmail() + "\t" + "PlaceId: "+place.getId() + "\t" + "Attraction: "+place.getAttraction() + "\t"
				+ "Message: "+getMessage()+ "\t" + "Date & Time: "+formattedDate + "\n");
		
	}

}
