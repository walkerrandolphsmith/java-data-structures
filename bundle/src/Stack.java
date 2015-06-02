/**
 * Write a description of class OurStack here.
 * 
 * @author (Walker Smith) 
 * @version (7/10/2012)
 */
public class Stack<E>
{
    private LinkedList<E> stack;

    public Stack()
    {
    	stack = new LinkedList<E>(); 
    }
    
    public boolean empty()
    {
    	return stack.isEmpty();       
    }
  
    public E peek()
    {
    	return stack.getFirst();
    }

    public E pop()
    {
    	E temp = stack.getFirst();
    	stack.remove(temp);
    	return temp;
    }
    
    public void push(E obj)
    {
    	stack.prepend(obj);   	
    }
}
