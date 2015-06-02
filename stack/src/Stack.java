import java.util.*;
/**
 * @author (Walker Smith) 
 * @version (1.1)
 */
public class Stack<E>
{
    private ArrayList<E> stack;

    public Stack()
    {
        stack = new ArrayList<E>();
    }
    
    public boolean empty()
    {
        return stack.isEmpty();   
    }
    
    public E peek()
    {
        return stack.get(stack.size() -1);
    }
    
    public E pop()
    {
        return stack.remove(stack.size() -1);
    }
    
    public void push(E obj)
    {
        stack.add(obj);
    }
}
