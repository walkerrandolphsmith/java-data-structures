
/**
 * Write a description of class OurDoublyLinkedList here.
 * 
 * @author (Walker Smith) 
 * @version (7/10/2012)
 */
public class DoublyLinkedList<E>
{
    protected Node<E> head;
    protected Node<E> tail;

    public DoublyLinkedList()
    {
        head = tail = null;
    }
    
    public void append(E data)
    {
        if(head == null)
        {
            head = new Node<E>(data);
            tail = head;
        }
        else
        {
            Node<E> oldTail = tail;
            tail = new Node<E>(data);
            tail.setPrevious(oldTail);
            oldTail.setNext(tail);
        }
    }
    
    public void prepend(E data)
    {
        if(head == null)
        {
            head = new Node<E>(data);
            tail = head;
        }
        else
        {
            Node<E> oldHead = head;
            head = new Node<E>(data);
            head.setNext(oldHead);
            oldHead.setPrevious(head);
        }
    }
    
    public boolean removeFirst(E data)
    {
       if(head == null)
       {
    	   return false;
       }
       else
       {
    	   if(head.getData() == data)
    	   {
    		   head = head.getNext();
    		   if(head != null)
    		   {
    			   head.setPrevious(null);
    		   }
    		   else
    		   {
    			   tail = null;
    		   }
    		   return true;
    	   }
    	   else
    	   {
    		   return head.remove(data);  
    	   }
       }
    }
    
    public boolean removeLast(E data)
    {
        if(tail == null)
        {
     	   return false;
        }
        else
        {
     	   if(tail.getData() == data)
     	   {
     		   tail = tail.getPrevious();
     		   if(tail != null)
     		   {
     			   tail.setNext(null);
     		   }
     		   else
     		   {
     			   head = null;
     		   }
     		   return true;
     	   }
     	   else
     	   {
     		   return tail.removeFromEnd(data);  
     	   }
        }
     }
    
    public E removeFirst()
    {
        if(head == null)
        {
        	return null;
        }
        else
        {
        	E data = head.getData();
        	removeFirst(head.getData());
        	return data;        	
        }
    }
}
