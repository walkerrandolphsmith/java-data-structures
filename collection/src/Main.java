import java.util.Iterator;


public class Main {
	public static void main (String [] args)
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
        System.out.println("****************\n");
        
        System.out.println("Passing toArray() to toArray([]T a)\n");
        
        Object[] temp = list.toArray(list.toArray());        
        for(int i = 0; i<temp.length; i++)
        {
        	System.out.println(temp[i]);
        }        
        System.out.println("****************\n");
      
        System.out.println("Using foreach\n");        
        
        for(String s : list)
        {
            System.out.println(s);
        }        
        System.out.println("****************\n");
    }    

}
