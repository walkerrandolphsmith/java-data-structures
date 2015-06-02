import java.util.*; 
/**
 * @author (Walker Smith) 
 * @version (1.5)
 */
public class LinkedList<E> implements Collection<E>
{
    private Node<E> head;
    
    private class OurIterator implements Iterator<E>
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
    	   //Unimplemented by design
       }
    }

    public LinkedList()
    {
        head = null;
    } 
    
    public boolean add(E data)
    {
        if(head == null)
        {
            head = new Node<E>(data);
            return true;
        }
        else
        {
            return head.add(data);
        }
    }
    
	public boolean addAll(Collection<? extends E> c)
    {
      	boolean isRemoved = true;
        for(E data : c)
        {        	
        	add(data);       
        }
        return isRemoved;
    }
    
    public void clear()
    {
        removeAll(this);
    }  
    
    public boolean contains(Object data)
    {
        return head == null? false : head.contains(data);
    }
    
    public boolean containsAll(Collection<?> c)
    {
    	for(Object data : c)
    	{
    		if(!contains(data))
    		{
    			return false;
    		}    		 
    	}
        return true;
    }
    
    public boolean equals(Object obj)
    {
        return contains(obj);
    }
    
    public int hashCode()
    {
    	int hashCode = 0;
    	for(Object data : this)
    	{
    		 hashCode =+ data.hashCode();
    	}
        return hashCode;
    }
        
       public boolean isEmpty()
    {
        return head == null;
    }
    
    public Iterator<E> iterator()
    {  	
        return new OurIterator(head);
    }
    
    private Node<E> remove(Node<E> current, Object data_to_remove)
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
            }
       }
       return current;        
    }
    
    public boolean remove(Object data)
    {
        if(contains(data))
        {
           head = remove(head, data);  
           return true;
        }
        return false;
    } 
    
    public boolean removeAll(Collection<?> c)
    {
    	boolean isRemoved = true;
        for(E data : this)
        {
        	if(c.contains(data))
        	{
        		isRemoved = isRemoved &= remove(data);
        		remove(data);        		
        	}
        }
        return isRemoved;
    }
    
    public boolean retainAll(Collection<?> c)
    {
    	boolean isRemoved = true;
        for(E data : this)
        {
        	if(!c.contains(data))
        	{
        		isRemoved = isRemoved &= remove(data);
        		remove(data);        		
        	}
        }
        return isRemoved;
    }
      
    public int size()
    {
        return head == null? 0 : head.size();
    }

    public Object[] toArray()
    {
    	int index = 0;
    	Object [] array = new Object[this.size()];
    	for(E data : this)
    	{
    		array[index] = data;
    		index++;
    	}
        return array;
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
    
    public <T> T[] toArray(T[] a)
    {
    	T[] temp = Arrays.copyOf(a, this.size());
    	int index = 0;
    	for(E data : this)
    	{
    		temp[index] = (T) data;
    		index++;
    	}
        return temp;      
    }  
}

