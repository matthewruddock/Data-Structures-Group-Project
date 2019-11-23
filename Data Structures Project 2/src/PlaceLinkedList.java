import java.util.Scanner;
//Done by Matthew Ruddock - 1700241

public class PlaceLinkedList { //For Place Class

	private PlaceNode head;
	
	public PlaceLinkedList() {
		head=null;
	}
	
	public boolean isEmpty() {
		if(head==null) 
			return true;
		
		else
			return false;	
	}
	
	public boolean isFull() {
		PlaceNode current = new PlaceNode();
		
		if(current==null)
			return true;
		else
			return false;
	}
	
	public boolean add(Place data) {// add place to back
		if(isFull())
			System.out.println("List is full, unable to add \n");
		
		else {
			PlaceNode next = new PlaceNode();
			next.setData(data);
			
			if(isEmpty()) {
				head = next;
			}
			else {
				PlaceNode current = head;
				while(current.getNext()!=null) {
					current = current.getNext();
				}
				current.setNext(next);
			}
		}
		return false;
	}
	
	
	
	public Place Retrieve(String sVal) {// search for place and return record
		if(isEmpty()) {
 			System.out.println("List is empty \n");
 		}
	 
	 else {
		 	PlaceNode current = head;

 			while(current !=null) {
 				if(current.getData().getName().equals(sVal)) {	 				
	 				return current.getData();
 				}
 				else {
 					current = current.getNext();
 				}
 			}
 		}
	return null ;
	 
 		
	}
	
	public Place remove() { //Remove a record of Place..Edit to delete
		if(isEmpty()) {
			System.out.println("List is Empty\n");
		}
		else {
			//Pine data = head.getData(); 
			PlaceNode current = head;
			PlaceNode DeleteItem = current;
			while(current!=null) {
				if(current.getNext()==null) {
					DeleteItem.setData(current.getData() ); 
					DeleteItem.setNext(current.getNext() ); 
					//current.setData(null);
					//current.setNext(null);
					
					return DeleteItem.getData();
				}
				else {
					current = current.getNext();
 				}
			}
			
		}
		
		return null;
	}
	
	public int Search(String sVal) {// search for place and return record
		if(isEmpty()) {
 			System.out.println("List is empty \n");
 			return 0;
 		}
	 
	 else {
		 	PlaceNode current = head;

 			while(current !=null) {
 				if(current.getData().getName().equals(sVal)) {	 				
	 				return 1;
 				}
 				current = current.getNext();
 			}
 		}
	return -1;
	}
	
	

	
	public void show() {// Show all the places.....
		if (isEmpty()) {
			System.out.println("List is Empty\n");
		}
		else {
			PlaceNode current = head;
			while (current !=null) {
				current.getData().display();
				current = current.getNext();
			}
		}
	}
	
	public void showRequestLOP(String sVal) {// Show all the places in a specific parish.....
		if (isEmpty()) {
			System.out.println("List is Empty\n");
		}
		else {
		 	PlaceNode current = head;

 			while(current !=null) {
 				if(current.getData().getName().equals(sVal)) {	 				
	 				current.getData().display();
 				}
 				else {
 					current = current.getNext();
 				}
 			}
 		}
	}
	
	public Place showRequestAttraction(String sVal) {
		if (isEmpty()) {
			System.out.println("List is Empty\n");
		}
		else {
		 	PlaceNode current = head;

 			while(current !=null) {
 				if(current.getData().getAttraction().equals(sVal)) {
 					return current.getData();
 				}
 				else {
 					current = current.getNext();
 				}
 			}
 		}
		return null ;
	}
	
	public void destroy() {
		PlaceNode current = new PlaceNode();
		
		while(head!=null) {
			current = head;
			head = head.getNext();
			
		}
	}

}



