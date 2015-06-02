/**
 * @author (Walker Smith) 
 * @version (1.1)
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
        }
    }
    
    public int size()
    {
        if(next != null)
        {
            return 1 + next.size(); 
        }
        return 1; 
    }
    
    public boolean contains(E theData)
    {
        if(theData == data)
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
        if( data == theData)
        {
            return position;
        }
        else
        {
            if(next != null)
            {
                return next.indexOf(theData, position+1);
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
      
    public E getLast()
    {
        return next == null? data : next.getLast();
    }    
}
