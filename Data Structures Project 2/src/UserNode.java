//Done by Matthew Ruddock - 1700241
public class UserNode {
	private Users data;
	private UserNode next;
	
	public UserNode() {
		data=null;
		next=null;
	}
	public UserNode(Users data, UserNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	
	//Users
	public Users getData() {
		return data;
	}
	public void setData(Users data) {
		this.data = data;
	}
	
	public UserNode getNext() {
		return next;
	}
	public void setNext(UserNode next) {
		this.next = next;
	}
	@Override
	//Users
	public String toString() {
		return "UserNode [data=" + data + ", next=" + next + "] \n";
	}
	
	public void display() {
		String disp=toString();
		System.out.println(disp );
		
	}


}
