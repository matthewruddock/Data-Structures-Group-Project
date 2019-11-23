//Done by Matthew Ruddock - 1700241 ||  Danielle-Paige Grant - 1701442
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class Place {
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(500);

	private int id; //System generated
	private String Name; 
	private String  Description;
	private String  Address;
	private int Parish_code; 
	private float Entry_cost; 
	private String Opening_hours;
	private String Contact_number;
	private String Photo;
	private String Attraction;
	
	//Default Constructor 
	public Place() {
		id = ID_GENERATOR.getAndIncrement();
		Name=""; 
		Description="";
		Address="";
		Parish_code  = 0; 
		Entry_cost=0; 
		Opening_hours ="";
		Contact_number ="";
		Photo  = "";
		Attraction ="";
		
	}
	
	//Primary Constructor
	public Place(int id, String name, String description, String address, int parish_code, float entry_cost, String opening_hours, String contact_number, String photo, String attraction) {
		this.id = id;
		Name= name; 
		Description= description;
		Address= address;
		Parish_code  = parish_code; 
		Entry_cost = entry_cost; 
		Opening_hours = opening_hours;
		Contact_number = contact_number;
		Photo  =  photo;
		Attraction = attraction;
		
	}
	
	//Copy Constructor
	public Place(Place PlaceObj) {
		id = PlaceObj.id;
		Name= PlaceObj.Name; 
		Description= PlaceObj.Description;
		Address= PlaceObj.Address;
		Parish_code  = PlaceObj.Parish_code; 
		Entry_cost= PlaceObj.Entry_cost; 
		Opening_hours = PlaceObj.Opening_hours;
		Contact_number = PlaceObj.Contact_number;
		Photo  = PlaceObj.Photo;
		Attraction = PlaceObj.Attraction;
		
	}
	
	//Methods
	
	public PlaceLinkedList AddPlace() {

		//clear screen by printing multiple Lines
		for (int i = 0; i < 10; ++i) System.out.println();

		Scanner input = new Scanner(System.in);
		FileWriter file = null;
		String line = null;
		PlaceLinkedList pl_list = new PlaceLinkedList();
		Place data = new Place();
		System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
		System.out.println("\t\t\t"+"   Add Place  "+"\n"+"\n");

		try{
			//system generated id
			file = new FileWriter("database.txt", true);
			data.setId(ID_GENERATOR.getAndIncrement());

			System.out.println(" Enter name of Place: ");
			data.setName(input.next());
			line =" "+data.getId()+" "+data.getName();

			System.out.println("\n Enter Description: ");
			data.setDescription(input.next());
			line+=" "+data.getDescription();

			System.out.println("\n Enter Address: ");
			data.setAddress(input.next());
			line+=" "+data.getAddress();

			System.out.println("\n Enter Parish Code: ");
			parish_codes();
			data.setId(input.nextInt());
			line+=" "+data.getId();

			System.out.println("\n Enter Entry Cost: ");
			data.setEntry_cost(input.nextFloat());
			line+=" "+data.getEntry_cost();

			System.out.println("\n Enter Opening hours: ");
			data.setOpening_hours(input.next());
			line+=" "+data.getOpening_hours();

			System.out.println("\n Enter Contact Number: ");
			data.setContact_number(input.next());
			line+=" "+data.getContact_number();

			System.out.println("\n Enter Photo: ");
			data.setPhoto(input.next());
			line+=" "+data.getPhoto();

			System.out.println("\n Enter Attraction: ");
			data.setAttraction(input.next());
			line+=" "+data.getAttraction()+"\n";

			file.write(line);
			file.close();

		}catch(InputMismatchException | IOException e){
			System.err.println("Wrong input type entered");
		}

		//get what you're doing here but i don't think it would be an issue
		//seeing that the parish code would distinguish if 2 places have the same name
		int flag = pl_list.Search(data.getName());
		if (flag==1)
			System.out.println("\n*****Name already exist******");
		return pl_list;
	}
	
	public void ViewPlace() {
		//As a Jamaica Tourist Board Administrator, I should be able to view all places in the system.
		//clear screen by printing multiple Lines
				for (int i = 0; i < 10; ++i) System.out.println();
				PlaceLinkedList pl_list = new PlaceLinkedList();

				
				System.out.println("\t\t"+"****The Di Good Place Dem!****"+"\n");
				System.out.println("\t\t\t"+"   View Places  "+"\n"+"\n");

		Scanner retrieve = null;
		Place place = null;
		try {
			retrieve = new Scanner(new File("database.txt"));
			while (retrieve.hasNext()) {
				id = retrieve.nextInt();
				Name = retrieve.next();
				Description = retrieve.next();
				Address = retrieve.next();
				Parish_code = retrieve.nextInt();
				Entry_cost = retrieve.nextFloat();
				Opening_hours = retrieve.next();
				Contact_number = retrieve.next();
				Photo = retrieve.next();
				Attraction = retrieve.next();
				place = new Place(id, Name, Description, Address, Parish_code, Entry_cost, Opening_hours, Contact_number, Photo, Attraction);
				//System.out.println(place);
				place.display();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error when reading file : "+e.getMessage());
		}finally {
			if (retrieve != null){
				retrieve.close();
			}
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
	
	
	
	
	//Setters and Getters 
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public int getParish_code() {
		return Parish_code;
	}
	public void setParish_code(int parish_code) {
		this.Parish_code = parish_code;
	}
	public float getEntry_cost() {
		return Entry_cost;
	}
	public void setEntry_cost(float entry_cost) {
		this.Entry_cost = entry_cost;
	}
	public String getOpening_hours() {
		return Opening_hours;
	}
	public void setOpening_hours(String opening_hours) {
		this.Opening_hours = opening_hours;
	}
	public String getContact_number() {
		return Contact_number;
	}
	public void setContact_number(String contact_number) {
		this.Contact_number = contact_number;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		this.Photo = photo;
	}
	public String getAttraction() {
		return Attraction;
	}
	public void setAttraction(String attraction) {
		this.Attraction = attraction;
	}
	public void parish_codes() {
		int [] code = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		String [] parish_name = {"Kingston & St. Andrew","St. Thomas","Portland", "St. Mary","St. Catherine","Clarendon"
				,"Manchester","St. Ann","St. Elizabeth", "St. James","Hanover","Westmoreland","Trelawny"};
		System.out.println("Code" + " | " + " Parish Name\n______________________________\n");
		for(int i=0;i<=12;i++) {
			System.out.println("  " + code[i] + "  -  " + parish_name[i] );
		}
	}

	public void display(){
		System.out.println("ID: " + getId() + " | " + "Name: " + getName() + " | " + "Description: " + getDescription() 
			+ " | " + "Parish Code: " + getParish_code() + " | " + "Entry Cost: " + getEntry_cost() + " | " 
			+ "Opening Hrs: " + getOpening_hours() + " | " + "Contract#: " + getContact_number() + " | " 
			+"Photo: " + getPhoto() + " | " + "Attraction: " + getAttraction() + "\n");
	}

	public void showPlace(int code) {
		Scanner dbfile = null;
		Place place = null;

		try {
			dbfile = new Scanner(new File("database.txt"));
			while (dbfile.hasNext()) {
				id = dbfile.nextInt();
				Name = dbfile.next();
				Description = dbfile.next();
				Address = dbfile.next();
				Parish_code = dbfile.nextInt();
				Entry_cost = dbfile.nextFloat();
				Opening_hours = dbfile.next();
				Contact_number = dbfile.next();
				Photo = dbfile.next();
				Attraction = dbfile.next();
				if (Parish_code == code) {
					place = new Place(id, Name, Description, Address, Parish_code, Entry_cost, Opening_hours, Contact_number, Photo, Attraction);
					place.display();
				}
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}finally {
			if (dbfile != null){
				dbfile.close();
			}
		}

	}

	public Place showAttraction(String pname) {
		Scanner dbfile = null;
		Place place = null;
		float lowest=10000;
		try {
			dbfile = new Scanner(new File("database.txt"));
			while (dbfile.hasNext()) {
				setId(dbfile.nextInt());
				setName(dbfile.next());
				setDescription(dbfile.next());
				setAddress(dbfile.next());
				setParish_code(dbfile.nextInt());
				setEntry_cost(dbfile.nextFloat());
				setOpening_hours(dbfile.next());
				setContact_number(dbfile.next());
				setPhoto(dbfile.next());
				setAttraction(dbfile.next());
				if (getAttraction().equals(pname)) {
					
						if (getEntry_cost()< lowest){
							lowest = Entry_cost;
							place = new Place(id, Name, Description, Address, Parish_code, Entry_cost, Opening_hours, Contact_number, Photo, Attraction);
							place.display();
							break;
						}
					}
				}
				
			
		}catch (IOException e){
			System.out.println(e.getMessage());
		}finally {
			if (dbfile != null){
				dbfile.close();
			}
		}
		return place;

	}
}
