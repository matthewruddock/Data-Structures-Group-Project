//Done by Danielle-Paige Grant - 1701442
public class ProcessLogQueue {

private ProcessLogNode front;
	
	public boolean isEmpty() {
		return front==null;
	}//end is empty
	
	public boolean isFull() {
		ProcessLogNode temp=new ProcessLogNode();
		if(temp==null) {
			return true;
		}else {
			return false;
		}
    	
    } 	
	
	 public void enqueue(VisitorRequest data) {
	    	if (isFull()) {
	    		System.out.println("Process Log Is Full");
	    	}else {
	    		ProcessLogNode nextItem = new ProcessLogNode(data);
	    		ProcessLogNode temp;
	    		if (isEmpty()) {
	    			front = nextItem;
	    		}else {
					temp = front;
					while (temp.getNext() != null){
						temp = temp.getNext();
					}
	    			temp.setNext(nextItem);
	    		}
	    	}
	    }// end add to front
	
	 public VisitorRequest dequeue() {
		 if (isEmpty()) {
			System.out.println("All requests are processed.");
		 }else{
		 	VisitorRequest data = front.getData();
		 	ProcessLogNode temp = front;
		 	front = front.getNext();
		 	temp = null;
		 	return data;
		 }
		 return null;
	 } // end delete from front

	 
	 public int Count(ProcessLogQueue queue) {
		 ProcessLogQueue temp = new ProcessLogQueue();
		 int count = 0;
		 while(!queue.isEmpty()) {
			 temp.enqueue(queue.dequeue());
			 count++;
		 }
		 while(!temp.isEmpty()) {
			 queue.enqueue(temp.dequeue());
		 }
		 return count;
	 }
	 
	 public void display() {
		 if (!isEmpty()){
			 ProcessLogNode temp = front;
			 while (temp != null){
				 System.out.println("Request ID: "+temp.getData().getRequestId()+" First Name: "+temp.getData().visitor.getFirstName()+" Last Name: "+temp.getData().visitor.getLastName()+" Email: "+temp.getData().visitor.getEmail()+" Place ID: "+temp.getData().place.getId()+" Attraction: "+temp.getData().place.getAttraction()+" Message: "+temp.getData().getMessage()+" Date: ");
				 temp = temp.getNext();
			 }
		 }
	 }
	 
	 public void destroy() {
		 while(!isEmpty()){
		 	dequeue();
		 }
	 }
}
