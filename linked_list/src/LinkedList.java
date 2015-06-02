/**
 * @author (Walker Smith) 
 * @version (1.1)
 */
public class LinkedList<E>
{
    private Node<E> head;

    public LinkedList()
    {
        head = null;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void append(E data)
    {
        if(head == null)
        {
            head = new Node<E>(data);
        }
        else
        {
            head.append(data);
        }
    }
    
    public int size()
    {
        return head == null? 0 : head.size();
    }
    
    public boolean contains(E data)
    {
        return head == null? false : head.contains(data);
    }
    
    public int indexOf(E data)
    {
        return head == null? -1 : head.indexOf(data);
    }
    
    private Node<E> remove(Node<E> current, E data_to_remove)
    {
       if(current == null)
       {
           return null;
       }
       else
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
            return current; 
        }        
    }
    
    public boolean remove(E data)
    {
        if(contains(data))
        {
            head =  remove(head, data);
            return true;
        }        
        return false;
    }
    
  
    public E getFirst()
    {
        return head == null? null : head.getData();
    }
    
    public E getLast()
    {
        return head == null? null : head.getLast();
    }
}
