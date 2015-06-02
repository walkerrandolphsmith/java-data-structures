
/**
 * @author (Walker Smith) 
 * @version (1.1)
 */
public class DoublyLinkedList<E>
{
    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList()
    {
        head = null;
        tail = null;
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
            append(data);
        }
        else
        {
            Node<E> oldhead = head;
            head = new Node<E>(data);
            head.setNext(oldhead);
            oldhead.setPrevious(head);
        }
    }
}
