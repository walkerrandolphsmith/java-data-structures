package binaryTree;

public class tester {
	
	public static void main (String [] args) 
	{
		BinarySearchTree<String> tree = (BinarySearchTree<String>) new BinarySearchTree<String>();
				
		tree.add("Walker Smith");	
		System.out.println(tree);
				
		tree.delete("Walker Smith");
		System.out.println(tree);
				
		tree.add("M");	
		tree.add("F");	
		tree.add("A");	
		tree.add("R");
		tree.add("W");	
		
		System.out.println(tree);
		
BinaryTree<String> newTree = new BinaryTree<String>("Walker", new BinaryTree<String>(), new BinaryTree<String>());
	}
}
