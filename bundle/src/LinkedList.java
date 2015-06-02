import java.util.Iterator;
import java.util.Collection;

/**
 * Write a description of class OurLinkedList here.
 * 
 * @author (Walker Smith) 
 * @version (7/10/2012)
 */
public class LinkedList<E> implements Collection<E>
{
    protected Node<E> head;
    
    private class OurIterator implements Iterator<E>
    {
        Node<E> current;
        E data;
        LinkedList<E> theList;
        
        public OurIterator(Node<E> current, LinkedList<E> theList)
        {
            this.current = current;
            this.theList = theList;
        }
        
        public boolean hasNext()
        {
            return current != null;
        }
        
        public E next()
        {
            data = current.getData();
            current = current.getNext();
            return data;
        }
        
        public void remove()
        {
            theList.remove(data);
        }        
    }

    public LinkedList()
    {
        head = null;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void clear()
    {
        head = null;
    }
    
    public void prepend(E data)
    {
    	if(head == null)
    	{
    		head = new Node<E>(data);
    	}
    	else
    	{
    		Node<E> temp = head;
    		head = new Node<E>(data);
    		head.setNext(temp);
    	}
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
        for(E element : c)
        {
            add(element);
        }
        return c.size() > 0;
    }
    
    public int size()
    {
        return head == null? 0 : head.size();
    }
    
    @SuppressWarnings("unchecked")
	public boolean contains(Object data)
    {
        return head == null? false : head.contains((E)data);
    }
    
    public int indexOf(E data)
    {
        return head == null? -1 : head.indexOf(data);
    }
    
    public boolean retainAll(Collection<?> c)
    {
        Iterator<E> it = iterator();
        boolean flag = false;
        while(it.hasNext())
        {
            if(!c.contains(it.next()))
            {
                flag = true;
                it.remove();
            }
        }
        return flag;
    }
    
    public boolean containsAll(Collection<?> c)
    {
        Iterator<?> it = c.iterator();
        boolean flag = true;
        while(it.hasNext() && flag)
        {
            flag = contains(it.next());
        }        
        return flag;
    }
    
    public boolean equals(Object o)
    {
        if(o instanceof Collection)
        {
            Collection<?> myo = (Collection<?>)o;
            return myo.containsAll(this) && containsAll(myo);
        }
        else
        {
            return false;
        }
    }
    
    public int hashCode()
    {
        return 0;
    }
    
    @SuppressWarnings("unchecked")
	public boolean remove(Object data)
    {
        if(head != null)
        {
            if(head.getData() == data)
            {
                head = head.getNext();
                return true;
            }
            else
            {
                return head.remove((E)data);
            }
        }
        else
        {
            return false;
        }
    }
    
    public E getFirst()
    {
        return head == null? null : head.getData();
    }
    
    public E getLast()
    {
        return head == null? null : head.getLast();
    }
    
    public Iterator<E> iterator()
    {
        return new OurIterator(head, this);
    }
    
    public boolean removeAll(Collection<?> c)
    {
        boolean flag = false;
        for(Object element : c)
        {
            flag |= remove(element);
        }
        return flag;
    }
    
    @SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a)
    {
        Object[] b;
        if(size() > a.length)
        {
            b = new Object[size()];
        }
        else
        {
            b = a;
        }
        Object[] c = toArray();
        for(int index = 0; index < size(); index++)
        {
            b[index] = c[index];
        }
        return (T[])b;    
    }
    
    public Object[] toArray()
    {
        Object[] tempArray = new Object[size()];
        Iterator<E> it = iterator();
        int index = 0;
        while(it.hasNext())
        {
            tempArray[index++] = it.next();
        }
        return tempArray;
    }
    
    public static void main()
    {
        LinkedList<String> list = new LinkedList<String>();
        
        list.add("First");
        list.add("Second");
        list.add("Third");
        
        System.out.println("Using iterator\n");
        Iterator<String> it = list.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println("******************\n");
        System.out.println("Using foreach version\n");
        
        for(String s : list)
        {
            System.out.println(s);
        }        
        System.out.println("******************\n");
    }
}
