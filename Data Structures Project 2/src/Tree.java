//Done by Jadetta Duncan - 1700066
public class Tree {
	private TreeNode root;
	
	//Constructor
	public Tree() {
		root = null;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	@SuppressWarnings("unused")
	public boolean isFull() {
		TreeNode temp = new TreeNode();
		if(temp == null) {
			return true;
		}else {
			temp = null;//delete temp;
			return false;
		}
	}
	
	public void insert(Phrase Phrase) {
		if(isFull()) {
			System.out.println("Tree is full");
		}else {
			TreeNode temp = new TreeNode(Phrase);
			if(isEmpty()) {
				root = temp;
			}else {
				TreeNode current = root;
				while(true) {
					//check whether temp should be inserted on the right
					if(current.getData().getCreole().compareTo(Phrase.getCreole()) > 0) {
						//check whether right subtree is empty
						if(current.getRight() == null) {
							current.setRight(temp);
							break;
						}else {
							//iterate to the next node on the right
							current = current.getRight();
						}
						
					}
					//otherwise temp should be implemented on the left
					else {
						//check whether left subtree is empty
						if(current.getLeft() == null) {
							current.setLeft(temp);
							break;
						}else {
							//iterate to the next node on the left
							current = current.getLeft();
						}
					}
				}
			}
		}
	}
	
	public int count() {
		return count(root);
	}
	
	//TODO: implement insert(Phrase) as a recursive method
	protected int count(TreeNode current) {
		int amt = 0;
		if(current == null)return amt;
		
		amt+=count(current.getLeft());
		amt+=1;
		amt+=count(current.getRight());
		return amt;
	}
	
	private int currentVisulizationIndentation = 0;
	private final int TAB_SIZE=4;
	public void visualize() {
		
		int maxIndex = count() * TAB_SIZE;
		currentVisulizationIndentation = maxIndex;
		visualize(root);
		
	}
	
	protected void visualize(TreeNode current) {
		if(current == null) return;
		
		//if(current.getLeft()!=null) {
			currentVisulizationIndentation-=TAB_SIZE;
			visualize(current.getLeft());	
		//}
		currentVisulizationIndentation+=TAB_SIZE;
		printTabSpaces();
		System.out.println(current.getData().getCreole());
//		if(current.getRight()!=null) {
			currentVisulizationIndentation-=TAB_SIZE;
			visualize(current.getRight());	
	//	}
		
		printTabSpaces();
		currentVisulizationIndentation+=TAB_SIZE;
	}
	
	protected void printTabSpaces() {
		for(int i = 0;i< currentVisulizationIndentation;i++) {
			System.out.print(" ");
		}
	}
	
	public void display() {
		int i = 1;
		displayInOrder(root, i);
		//displayPostOrder(root);
	}
	
	public void displayInOrder(TreeNode current, int i) {
		if(current == null)return;//important
		displayInOrder(current.getLeft(), i);
		System.out.println("Phrase: " + current.getData().getCreole());
		System.out.println("Translation: " + current.getData().getEnglish());
		System.out.println("\n");
		//current.getData().display(); //Root action
		displayInOrder(current.getRight(), i + 1);
	}
	
	public void displayPostOrder(TreeNode current) {
		if(current == null)return;
		//left
		displayPostOrder(current.getLeft());
		//right
		displayPostOrder(current.getRight());
		//root = action
		current.getData().display();
	}
	
	public void displayPreOrder(TreeNode current) {
		if(current == null)return;
		//root = action
		current.getData().display();
		//left
		displayPreOrder(current.getLeft());
		//right
		displayPreOrder(current.getRight());
	}
	
	public void destroy() {
		destroyInOrder(root);
	}
	
	public void destroyInOrder(TreeNode current) {
		if(current == null) return;
		TreeNode tempLeft = current.getLeft();
		TreeNode tempRight = current.getRight();
		destroyInOrder(tempLeft);
		current = null; //delete current;
		destroyInOrder(tempRight);
	}
	
	

}
