package binaryTree;
import binaryTree.BinaryTree.Node;

/**
 * Write a description of class BinaryTree here.
 * 
 * @author (Walker Smith) 
 * @version (7/10/2012)
 */

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>
{
	//Stores a second return value form the recursive call add()
	//Indicates whether the item has been inserted
	protected boolean addReturn;
	
	//Stores a second return value from the recursive delete method
	//That references the item that was stored in the tree
	protected E deleteReturn;
	protected boolean isRemoved;

	@Override
	public boolean add(E data) 
	{
		root = add(root, data);
		return addReturn;
	}
	
	private Node<E> add(Node<E> currentRoot, E data)
	{
		if(currentRoot == null)
		{
			addReturn = true;
			return new Node<E>(data);
		}
		else 	
		{
			int comparison = data.compareTo(currentRoot.data);
			if(comparison == 0)
			{
				addReturn = false;
				return currentRoot;
			}		
			else if(comparison < 0)
			{
				currentRoot.left = add(currentRoot.left, data);
				return currentRoot;
			}
			else
			{
				currentRoot.right = add(currentRoot.right,data);
				return currentRoot;
			}
		}
	}

	@Override
	public boolean contains(E data)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public Node<E> findMin(Node<E> root)
	{
		if(root == null || root.left == null)
		{
			return root;
		}
		else
		{
			return findMin(root.left);
		}
	}
	
	public Node<E> findMax(Node<E> root)
	{
		if(root == null || root.right == null)
		{
			return root;
		}
		else
		{
			return findMax(root.right);
		}
	}
	@Override
	public E find(E data) 
	{
		return find(root, data);
	}
	
	public E find(Node<E> currentRoot, E data)
	{
		if(currentRoot == null)
		{
			return null;
		}
		else
		{
			int comparison = data.compareTo(currentRoot.data);
			if(comparison == 0)
			{
				return currentRoot.data;
			}
			else if(comparison<0)
			{
				return find(currentRoot.left, data);
			}
			else
			{
				return find(currentRoot.right, data);
			}
		}
	}

	@Override
	public boolean remove(E data) 
	{
		root = delete(root, data);
		return isRemoved;
	}
	
	@Override
	public E delete(E data) 
	{
		root = delete(root, data);
		return deleteReturn;
	}
	
	public Node<E> delete(Node<E> currentRoot, E data)
	{
		if(currentRoot == null)
		{
			isRemoved = false;
			deleteReturn = null;
			return currentRoot;
		}
		else
		{
			int comparison = data.compareTo(currentRoot.data);
			if(comparison < 0)
			{
				currentRoot.left = delete(currentRoot.left, data);
				return currentRoot;
			}
			else if(comparison > 0)
			{
				currentRoot.right = delete(currentRoot.right, data);
				return currentRoot;
			}
			else 
			{
				isRemoved = true;
				deleteReturn = currentRoot.data;
				if(currentRoot.left == null)
				{
					return currentRoot.right;
				}
				else if(currentRoot.right == null)
				{
					return currentRoot.left;
				}
				else
				{
					if(currentRoot.left.right == null)
					{
						currentRoot.data = currentRoot.left.data;
						currentRoot.left = currentRoot.left.left;
						return currentRoot;
					}
					else
					{
						currentRoot.data = findLargestChild(currentRoot.left);
						return currentRoot;
					}
				}
			}
		}
	}
	
	private E findLargestChild(Node<E> parent)
	{
		if(parent.right.right == null)
		{
			E max = parent.right.data;
			parent.right = parent .right.left;
			return max;
		}
		else
		{
			return findLargestChild(parent.right);
		}
	}
}