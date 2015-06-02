import java.util.NoSuchElementException;

/**
 * Write a description of class OurQueue here.
 * 
 * @author (Walker Smith) 
 * @version (7/10/2012)
 */
public class Queue<E>
{
    DoublyLinkedList<E> queue;

    public Queue()
    {
    	queue = new DoublyLinkedList<E>();
    }

    public boolean add(E data)
    {
    	queue.append(data);
        return true;
    }
    
    public E element() throws NoSuchElementException
    {
    	E temp = queue.removeFirst();
    	if(temp == null)
    	{
    		throw new NoSuchElementException("The queue is empty.");
    	}
    	else
    	{
	    	queue.prepend(temp);
	    	return temp;
    	}
    }

    public boolean offer(E e)
    {
        return add(e);
    }
    
    public E peek()
    {
    	E temp = queue.removeFirst();
    	if(temp != null)
    	{
    		queue.prepend(temp);
    	}
	    	return temp;
    }
    
    public E poll()
    {
    	return queue.removeFirst();
    }

    public E remove() throws NoSuchElementException
    {
     	E temp = queue.removeFirst();
    	if(temp == null)
    	{
    		throw new NoSuchElementException("The queue is empty.");
    	}
    	else
    	{
	    	return temp;
    	}
    }
}
