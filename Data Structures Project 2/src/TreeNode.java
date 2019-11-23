//Done by Matthew Ruddock - 1700241

public class TreeNode {
	private Phrase data;
	private TreeNode left; //left subtree
	private TreeNode right; //right subtree
	
	//Constructor
	public TreeNode() {
		this(null);
	}
	
	public TreeNode(Phrase data) {
		this(data,null,null);
	}
	
	public TreeNode(Phrase data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	public Phrase getData() {
		return data;
	}
	public void setData(Phrase data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	

}
