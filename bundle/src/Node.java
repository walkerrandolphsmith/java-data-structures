/**
 * Write a description of class Node here.
 * 
 * @author (Walker Smith) 
 * @version (7/10/2012)
 */
public class Node<E>
{
    private E data;
    private Node<E> next;
    private Node<E> previous;

    public Node()
    {
    }
    
    public Node(E newData)
    {
        data = newData;
        next = null;
        previous = null;
    }
    
    public E getData()
    {
        return data;
    }
    
    public void setData(E newData)
    {
        data = newData;
    }
    
    public Node<E> getNext()
    {
        return next;
    }
    
    public void setNext(Node<E> newNext)
    {
        next = newNext;
    }
    
    public Node<E> getPrevious()
    {
        return previous;
    }
    
    public void setPrevious(Node<E> newPrevious)
    {
        previous = newPrevious;
    }
    
    public void append(E newData)
    {
        if(next != null)
        {
            next.append(newData);
        }
        else 
        {
            next = new Node<E>(newData);
            next.setPrevious(this);
        }
    }
    
    public boolean add(E newData)
    {
        if(next != null)
        {
            return next.add(newData);
        }
        else 
        {
            next = new Node<E>(newData);
            next.setPrevious(this);
            return true;
        }
    }
    
    public int size()
    {
        return 1 + (next == null? 0 : next.size());
    }
    
    public boolean contains(E theData)
    {
        if(data == theData)
        {
            return true;
        }
        else
        {
            if(next != null)
            {
                return next.contains(theData);
            }
            else
            {
                return false;
            }
        }
    }
    
    public int indexOf(E theData, int position)
    {
        if(data == theData)
        {
            return position;
        }
        else
        {
            if(next != null)
            {
                return next.indexOf(theData, position + 1);
            }
            else
            {
                return -1;
            }
        }
    }
    
    public int indexOf(E theData)
    {
        return indexOf(theData, 0);
    }

    public boolean remove(E theData)
    {
	        if(next != null)
	        {
	            if(next.getData() == theData)
	            {
	                next = next.getNext();
	                if(next != null) 
	                {
	                    next.setPrevious(this);
	                }
	                return true;
	            }
	            else
	            {
	                return next.remove(theData);
	            }
	        }
	        else
	        {
	            return false;
	        }
    }
    
    public boolean removeFromEnd(E theData)
    {
        if(previous != null)
        {
            if(previous.getData() == theData)
            {
            	previous = previous.getPrevious();
                if(previous != null)
                {
                	previous.setNext(this);
                }
                return true;
            }
            else
            {
                return previous.removeFromEnd(theData);
            }
        }
        else
        {
            return false;
        }
    }
    
    public E getLast()
    {
        return next == null? data : next.getLast();
    }

}
