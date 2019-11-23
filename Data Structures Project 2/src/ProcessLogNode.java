//Done by Danielle-Paige Grant - 1701442
public class ProcessLogNode {

	private VisitorRequest data;
	private ProcessLogNode next;
	
	public ProcessLogNode() {
		super();
	}
	
	public ProcessLogNode(VisitorRequest data) {
		super();
		this.data = data;
	}

	public VisitorRequest getData() {
		return data;
	}

	public void setData(VisitorRequest data) {
		this.data = data;
	}

	public ProcessLogNode getNext() {
		return next;
	}

	public void setNext(ProcessLogNode next) {
		this.next = next;
	}
}
