import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;


public class PriorityQueue<E extends Comparable<E>> extends AbstractQueue<E> implements Queue<E>
{

	 private ArrayList<E> ourList;
	 Comparator<E> comparator = null;
	
	 public PriorityQueue()
	 {
		 ourList = new ArrayList<E>();
	 }
	 
	 public PriorityQueue(Comparator<E> comp)
	 {
		 
	 }
	 
	 private int compare(E left, E right)
	 {
		if(comparator != null)
		{
			return comparator.compare(left, right);
		}
		else
		{
			return ((Comparable<E>) left).compareTo(right);
		}
	 }
		 
	private void swap(int parent, int child)
	{
		E temp = ourList.get(parent);
		ourList.set(parent, ourList.get(child));
		ourList.set(child, temp);
	}
	
	public boolean isEmpty()
	{
		if(this.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean offer(E data) 
	{
		ourList.add(data);
		int child = ourList.size() -1;
		int parent = (child -1)/2;
		
		while(parent >=0 && compare(ourList.get(parent),ourList.get(child)) > 0)
		{
			swap(parent, child);
			child = parent;
			parent = (child -1)/2;
		}
		return true;
	}

	@Override
	public E peek() 
	{
		if(!isEmpty())
		{
			return ourList.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public E poll() 
	{
		if(isEmpty())
		{
			return null;
		}
		E top = ourList.get(0);
		if(ourList.size() == 1)
		{
			ourList.remove(0);
			return top;
		}
		ourList.set(0, ourList.remove(ourList.size() -1));
		int parent = 0;
		while(true)
		{
			int leftChild = 2 * parent + 1;
			if(leftChild >= ourList.size())
			{
				break;
			}
			int rightChild = leftChild + 1;
			int minChild = leftChild;
			if(rightChild < ourList.size() && compare(ourList.get(leftChild), ourList.get(rightChild)) > 0)
			{
				minChild = rightChild;
			}
			if(compare(ourList.get(parent), ourList.get(minChild)) > 0)
			{
				swap(parent, minChild);
				parent = minChild;
			}
			else
			{
				break;
			}
		}
		return top;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return ourList.iterator();
	}

	@Override
	public int size() 
	{
		return ourList.size();
	}	
}
