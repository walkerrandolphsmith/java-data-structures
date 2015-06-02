
/**
 * 
 * @author (Walker Smith) 
 * @version (1.1)
 */
public class List<E>
{
    E[] stuff; 
    
    public List()
    {
       this(10);
    }
    
    
	public List(int size)
    {
        stuff = (E[]) new Object[size];
    }    
    
    //O(1)
    public E get (int index)
    {
        if (index < 0 || index > stuff.length)
        {
            return null;
        }
        else
        {
            return stuff[index];
        }
    }
    
    //O(1)
    public void set (int index, E newObject)
    {
        if(index < 0 || index >= stuff.length)
        {
            return;
        }
        stuff[index] = newObject;
    }
    
    //O(1)   
    public int size()
    {
        return stuff.length;
    }
    
    //O(n)
    public boolean contains (E thisObject)
    {
        for (int i = 0; i<stuff.length; i++)
        {
            if(thisObject == stuff[i])
            {
                return true;
            }
        }
        return false;
    }
    
    //O(n)
    public int indexOf (E obj)
    {
        for (int i = 0; i < stuff.length; i++)
        {
            if(obj == stuff[i])
            {
                return i;
            }
        }
        return -1;
    }
    
    //O(n)
    public boolean isEmpty()
    {
        for(int i = 0; i<stuff.length; i++)
        {
            if(stuff[i] != null)
            {
                return false;
            }
        }
        return true;
    }  
    
    /*
     * Creates a new array with size 
     * equal to stuff.length + 1 and
     * set the new object to the last position      
    */
    
    public void add(E newObject)
    {
    	E[] newStuff = (E[]) new Object[stuff.length + 1]; 
    	
    	for(int i = 0; i < stuff.length; i++)
    	{
    		if(stuff[i] != null)
    			{
    				newStuff[i] = this.get(i);
    				newStuff[i+1] = newObject; 
    			}    		
    	}
    	stuff = newStuff;     	
    }
    
     /*
     * Checks if the last the last position is null
     * if it is null then move everything 
     * from index and above one unit.
     * Put the new object at the position index.
     * 
     * If it is not null then extend the array and move everything.
    */
    
    public void add(int index, E newObject)
    {
    	E[] newStuff = (E[]) new Object[stuff.length + 1]; 
    	
    		if(stuff[stuff.length-1] == null)
    		{
	    		for(int i = stuff.length-1; i > index; i--)
	    		{
	    			stuff[i] = stuff[i-1];
	    		}
	    		stuff[index] = newObject; 
    		}
    		//Build new array with an inserted (by index) newObject
    		else
    		{
    			for(int i = newStuff.length-1; i >= 0; i--)
    			{
    				if(i > index)
    				{
	    				newStuff[i] = stuff[i-1];
    				}
    				else
    				{
    					newStuff[i] = stuff[i];
    				}    				
    			}
    			newStuff[index] = newObject; 
    			stuff = newStuff;
    		}    	
    }
    
     /*
     *Removes the first occurrence of this object if found
     *if found return true, false otherwise
    */
    public boolean remove(E obj)
    {
    	for(int i = 0; i<stuff.length; i++)
    	{
    		if(stuff[i] == obj)
    		{
    			stuff[i] = null;
    			return true; 
    		}
    	}
        return false; 
    }
    
     /*
     * Removes the object from the list (at index) 
     * and shifts everything to the left. 
     * object in index +1 position moves to index position
     * 
     * return object at index position
    */
    public Object remove(int index)
    {
        E[] newStuff = (E[]) new Object[stuff.length -1]; 
    	
        E removedObject = stuff[index];
    	for(int i = 0; i<stuff.length-1; i++)
    	{
    		if(i >= index)
    		{
    			newStuff[i] = stuff[i+1];
    		}
    		else
    		{
    			newStuff[i] = stuff[i];
    		}
    	}
    	stuff = newStuff; 
    	   
        return removedObject;
    }
    
}

