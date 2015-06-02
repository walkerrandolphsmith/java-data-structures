import java.util.*; 
/**
 * @author (Walker Smith) 
 * @version (1.1)
 */
public class LinkedList<E> 
{
    private Node<E> head, tail; 
    private int counter;
    
    private class OurIterator<E> implements Iterator
    {
       Node<E> current;
       
       public OurIterator(Node<E> current)
       {
           this.current = current; 
       }
       
       public boolean hasNext()
       {          
           return current != null;
       }
       
       public E next()
       {
           E data = current.getData();
           current = current.getNext();
           return data;
       }
       
       public void remove()
       {
    	   //Unimplemented 
       }
    }

    public LinkedList()
    {
        head = null;
        tail = null;
        counter = 0;
    } 
    
    public boolean addLast(E data)
    {
    	return add(data);
    }

    public boolean contains(Object data)
    {
        return head == null? false : head.contains(data);
    }
    
    public boolean equals(Object obj)
    {
        return contains(obj);
    }
     
       public boolean isEmpty()
    {
        return head == null;
    }
    
    public Iterator<E> iterator()
    {
        return new OurIterator(head);
    }
    
    public Node<E> remove(Node<E> current, Object data_to_remove)
    {
        if(current != null)
        {
            if(current.getData() == data_to_remove)
            {
                Node<E> temp = current.getNext();
                return temp;           
            }
            else
            {
                current.setNext(remove(current.getNext(), data_to_remove));
                counter--;
            }
       }
       return current;        
    }
    
    public boolean remove(Object data)
    {
        if(contains(data))
        {
           head = remove(head, data);  
        }
        return false;
    } 
    
    public E removeFirst()
    {
    	E data = head.getData();
    	remove(data);
    	return data;
    }

    public int size()
    {
        return counter;
    }
           
    public int indexOf(E data)
    {
        return head == null? -1 : head.indexOf(data);
    }
           
    public E getFirst()
    {
        return head == null? null : head.getData();
    }
    
    public E getLast()
    {
        return head == null? null : head.getLast();
    }    
    
    //*********************Queue Interface methods****************************//
    
    public boolean add(E data) 
    {
       return offer(data); 
    }
    
    public E element() throws NoSuchElementException
    {
    	if(head !=null)
    	{
    		return head.getData();
    	}
    	else
    	{
    		throw new NoSuchElementException("Queue is empty");
    	}
    }
    
    public boolean offer(E data)
    {
    	if(head == null)
        {
            head = new Node<E>(data);
            tail = head;
            counter = 1;
            return true;
        }
        else
        {
            tail.setNext(new Node<E>(data));
            tail = tail.getNext();
            counter++; 
            return true;
        }
    }
    
    public E peek()
    {
    	if(head != null)
    	{
    		return head.getData();
    	}
    	else return null;
    }
    
    public E poll()
    {
    	if(head != null)
    	{
    		return removeFirst();
    	}
    	else
    	{
    		return null;
    	}
    }
    
    public E remove() throws NoSuchElementException
    {
    	if(head != null)
    	{
    		return removeFirst();
    	}
    	else
    	{	
    		throw new NoSuchElementException("Queue is empty");
    	}
    }    
}