package binaryTree;
import java.util.Scanner;

/**
 * Write a description of class BinaryTree here.
 * 
 * @author (Walker Smith) 
 * @version (7/10/2012)
 */
public class BinaryTree<E>
{
	protected Node<E> root;
	
	protected class Node<E>
	{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
	    
	    public Node(E newData)
	    {
	      data = newData;
	      left = null;
	      right = null;
	    }
	    
	    public String toString()
	    {
	    	return data.toString();
	    }
	}
	
	public BinaryTree()
	{
		this(null);
	}
	
	protected BinaryTree(Node<E> root)
	{
		this.root = root; 
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
	{
		root = new Node<E>(data);
		if(leftTree != null)
		{
			root.left = leftTree.root;
		}
		else
		{
			root.left = null;
		}
		if(rightTree != null)
		{
			root.right = rightTree.root;
		}
		else
		{
			root.right = null;
		}
		
	}
	
	public BinaryTree<E> getLeftSubtree()
	{
		if(root != null && root.left != null)
		{
			return new BinaryTree<E>(root.left);
		}
		else return null; 
			
	}
	
	public BinaryTree<E> getRightSubtree()
	{
		if(root != null && root.right != null)
		{
			return new BinaryTree<E>(root.right);
		}
		else return null;	
	}
	
	public E getData()
	{
		if(root != null)
		{
			return root.data;
		}
		else 
		{
			return null;
		}
	}
	
	public boolean isLeaf()
	{
		if(root.left == null && root.right == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		StringBuilder sB = new StringBuilder();
		preOrderTraverse(root, 1, sB);
		return sB.toString();
	}

	private StringBuilder preOrderTraverse(Node<E> node, int depth, StringBuilder s)
	{
		for(int i = 1; i < depth; i++)
		{
			s.append("  ");
		}
		if(node == null)
		{
			s.append("null\n");
		}
		else
		{
			s.append(node.toString() + depth);
			s.append("\n");
			preOrderTraverse(node.left, depth + 1, s);			
			preOrderTraverse(node.right, depth + 1, s);			
		}
		return s;
	}
	
	private void inOrderTraverse(Node<E> node, int depth, StringBuilder s)
	{
		
		if(node == null)
		{
			s.append("null\n");
		}
		else
		{			
			preOrderTraverse(node.left, depth + 1, s);
			s.append(node.toString());
			s.append("\n");
			preOrderTraverse(node.right, depth + 1, s);			
		}	
	}
	
	private void postOrderTraverse(Node<E> node, int depth, StringBuilder s)
	{
		if(node == null)
		{
			s.append("null\n");
		}
		else
		{			
			preOrderTraverse(node.left, depth + 1, s);
			preOrderTraverse(node.right, depth + 1, s);	
			s.append(node.toString());
			s.append("\n");
		}	
	}
	
	public static BinaryTree<String> readBinaryTree(Scanner scan)
	{
		String data = scan.next();
		if(data.equals("null"))
		{
			return null;
		}
		else
		{
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}
	
    public boolean isBinary()
    {
        if(root == null)
        {
        	return true;
        }
        else
        {
        	return getLeftSubtree().isBinary() && getRightSubtree().isBinary();
        }
    }
}
