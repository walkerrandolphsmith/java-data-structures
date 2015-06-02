
import java.util.NoSuchElementException;
/**
 * @author (Walker Smith) 
 * @version (1.1)
 */

public interface QueueInterface<E> 
{    
    public boolean add(E data);
 
    
    public E element() throws NoSuchElementException;
  
    
    public boolean offer(E data);
    
    
    public E peek();
    
    
    public E poll();
   
    
    public E remove() throws NoSuchElementException;    
}