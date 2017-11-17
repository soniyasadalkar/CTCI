import java.util.*;

class Node{
	int data;
	Node left, right;
	Node(int key){
		data = key;
		left = right = null;
	}
}
class Tree{
	Node root;
	public static void treeToString(Node root, StringBuilder str){
		if( root == null)
			return ;
		str.append(root.data);
		if(root.left == null && root.right == null)
			return;

		str.append('(');
		treeToString(root.left, str);
		str.append(')');

		if(root.right != null){
			str.append('(');
			treeToString(root.right, str);
			str.append(')');
		}
	}
	public static void main(String[] args){
		Tree tree = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);
		/*
		Stack<Integer> s = new Stack<>();
		Queue<Node> q = new LinkedList<>();
		*/
		StringBuilder str = new StringBuilder();
		treeToString(tree.root, str);
		System.out.println(str);
	}
}
