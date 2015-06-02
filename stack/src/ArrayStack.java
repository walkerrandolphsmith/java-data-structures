/**
 * @author (Walker Smith) 
 * @version (1.1)
 */
public class ArrayStack<E>
{
    private E[] array;
    private int index;
    
    public ArrayStack()
    {
      array = (E[]) new Object[4];
      index = 0;
    }
    
    public boolean empty()
    {
        return index == 0;   
    }
    
    public E peek()
    {
        return array[index -1];
    }
    
    public E pop()
    {
        index--;        
        return array[index]; 
        //return array[--index];
    }
    
    public void push(E obj)
    {
        array[index] = obj;
        index++;
        //array[index++];
    }
}
