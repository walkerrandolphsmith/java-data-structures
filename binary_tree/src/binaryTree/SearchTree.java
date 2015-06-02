package binaryTree;

/**
 * Write a description of class BinaryTree here.
 * 
 * @author (Walker Smith) 
 * @version (7/10/2012)
 */

public interface SearchTree<E>
{
	//Inserts data in its correct location.
	//True if insertion occurs false otherwise
	boolean add(E data);
	
	//Return true if the data is found in tree
	//False otherwise
	boolean contains(E data);
	
	//Returns reference to the node with parameter as its data
	//If node does not exist return null
	E find(E data);
	
	//Removes parameter from tree and return it
	//Return null otherwise
	E delete(E data);
	
	//Removes parameter from tree 
	//True if removal occurs false otherwise
	boolean remove(E data);

}
