//Done by Jadetta Duncan - 1700066
public class PlaceNode {
	private Place data;
	private PlaceNode next;
	
	//Constructors
	public PlaceNode() {
		data=null;
		next=null;
	}
	public PlaceNode(Place data, PlaceNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	
	//Getters
	public Place getData() {
		return data;
	}
	public PlaceNode getNext() {
		return next;
	}
	//Setters
	public void setData(Place data) {
		this.data = data;
	}
	public void setNext(PlaceNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "PlaceNode [data=" + data + ", next=" + next + "] \n";
	}
	
	public void display() {
		String disp=toString();
		System.out.println(disp );
		
	}


}
